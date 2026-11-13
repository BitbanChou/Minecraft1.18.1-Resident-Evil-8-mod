package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.items.ItemCombatKnife;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.function.Predicate;

public class EntityVerdugo extends Ravager implements GeoEntity {
    private static final Predicate<Entity> VER_AREA = entity -> entity.isAlive() && !(entity instanceof EntityVerdugo);

    /** attack / attack2 动画均为 1.52 秒。 */
    private static final int ATTACK_END = 30;
    /** 尾巴突刺：约 0.32 秒甩到最前。 */
    private static final int TAIL_HIT_TICK = 6;
    /** 扑击落地：约 0.88 秒。 */
    private static final int POUNCE_HIT_TICK = 18;
    private static final int COMBO_COOLDOWN = -10;

    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityVerdugo.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityVerdugo.class, EntityDataSerializers.INT);

    private int attr;
    private int attackTimer;
    private int phaseStart;
    private boolean pounceHit;

    public EntityVerdugo(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 70;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.4D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this, Raider.class)).setAlertOthers());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.4D)
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.ARMOR, 10.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 5.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 9.0D);
    }

    private float getAttackDamage() {
        return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public void aiStep() {
        super.aiStep();
        if (!this.isAlive()) {
            return;
        }

        if (this.horizontalCollision && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
            boolean flag = false;
            AABB aabb = this.getBoundingBox().inflate(0.2D);
            for (BlockPos blockpos : BlockPos.betweenClosed(
                    Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ),
                    Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof LeavesBlock) {
                    flag = this.level().destroyBlock(blockpos, true, this) || flag;
                }
            }
            if (!flag && this.onGround()) {
                this.jumpFromGround();
            }
        }

        if (this.getHealth() < this.getMaxHealth() * 0.5F
                && this.getHealth() > this.getMaxHealth() * 0.4F
                && !this.hasEffect(MobEffects.INVISIBILITY)) {
            this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200));
        }
        if (this.entityData.get(STATE) == 2) {
            this.roar();
        }
        if (this.entityData.get(DEFENDSTATE) == 1) {
            this.defend();
        }
    }

    private void roar() {
        if (!this.isAlive()) {
            return;
        }
        Vec3 vec3 = this.getBoundingBox().getCenter();
        for (int i = 0; i < 10; i++) {
            float deltaOmega = 1.0f * i;
            Vec3 pos = new Vec3(vec3.x + Math.sin(deltaOmega), vec3.y, vec3.z + Math.cos(deltaOmega));
            this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), pos.x, pos.y, pos.z, 0, 0, 0);
        }
        this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
    }

    private void defend() {
        if (!this.isAlive()) {
            return;
        }
        Vec3 vec3 = this.getBoundingBox().getCenter();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 10; i++) {
                float deltaOmega = 1.0f * i;
                Vec3 pos = new Vec3(vec3.x + Math.sin(deltaOmega), vec3.y + j, vec3.z + Math.cos(deltaOmega));
                this.level().addParticle(ParticleInit.DEFEND_PARTICLE.get(), pos.x, pos.y, pos.z, 0, 0, 0);
            }
        }
        this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        int atk = this.entityData.get(STATE);
        if (atk == 1 || atk == 2 || atk == 3) {
            return PlayState.STOP;
        }
        if (this.isDeadOrDying()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.verdugo.death"));
            return PlayState.CONTINUE;
        }
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenLoop("animation.verdugo.walk"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenLoop("animation.verdugo.idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        AnimationController<?> attackController =
                new AnimationController<>(this, "controller1", 5, state -> PlayState.STOP)
                        .triggerableAnim("slash", RawAnimation.begin().thenPlay("animation.verdugo.attack"))
                        .triggerableAnim("heavy", RawAnimation.begin().thenPlay("animation.verdugo.attack2"));
        data.add(attackController);
        data.add(new AnimationController<>(this, "controller", 6, this::predicate));
    }

    public int getDefendingState() {
        return this.entityData.get(DEFENDSTATE);
    }

    public void setDefendingState(int time) {
        this.entityData.set(DEFENDSTATE, time);
    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    protected void startAttackAnim(int state) {
        if (state == 1) {
            this.triggerAnim("controller1", "slash");
        } else if (state == 2) {
            this.triggerAnim("controller1", "heavy");
        }
    }

    public void setAttackingState(int time) {
        int prev = this.entityData.get(STATE);
        this.entityData.set(STATE, time);
        if ((time == 1 || time == 2) && prev != time) {
            this.startAttackAnim(time);
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DEFENDSTATE, 0);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    private boolean isAttacking() {
        return this.getAttckingState() != 0;
    }

    /** 抓投/扑击：打断刀盾格挡后仍造成全额伤害，无法弹反。 */
    private void hurtUnparryable(LivingEntity target, float damage) {
        if (target instanceof Player player && isKnifeOrShieldBlocking(player)) {
            player.stopUsingItem();
        }
        target.hurt(this.damageSources().mobAttack(this), damage);
    }

    /** 尾巴突刺：可被刀盾弹反（弹反成功则破盾硬直，否则吃高伤）。 */
    private void hurtTailThrust(LivingEntity target, float damage) {
        if (target instanceof Player player && isKnifeOrShieldBlocking(player)) {
            disableShield(player, 80);
            return;
        }
        target.hurt(this.damageSources().mobAttack(this), damage);
    }

    private static boolean isKnifeOrShieldBlocking(Player player) {
        if (!player.isUsingItem()) {
            return false;
        }
        var stack = player.getUseItem();
        return stack.getItem() instanceof ItemCombatKnife
                || stack.getItem() instanceof ShieldItem
                || stack.canPerformAction(ToolActions.SHIELD_BLOCK);
    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        if (!(livingEntity instanceof Player player)) {
            return;
        }
        player.getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(3 + livingEntity.getRandom().nextInt(2), livingEntity, e -> {
            e.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte) 30);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        // 脚本化攻击接管伤害，避免 Ravager 撕咬叠伤
        return false;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean hurt = super.hurt(source, amount);
        if (hurt && !this.level().isClientSide && source.getEntity() instanceof LivingEntity living && living != this) {
            if (this.getTarget() == null) {
                this.setTarget(living);
            }
        }
        return hurt;
    }

    /** 液氮罐爆炸：减速并造成最大生命 20% 伤害。 */
    public void onLiquidNitrogenBurst() {
        if (this.level().isClientSide || !this.isAlive()) {
            return;
        }
        this.hurt(this.damageSources().magic(), this.getMaxHealth() * 0.2F);
        this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10 * 20, 2, false, true));
        this.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10 * 20, 1, false, true));
        if (this.isAttacking()) {
            this.setAttackingState(0);
            this.attackTimer = COMBO_COOLDOWN;
            this.attr = 0;
            this.setDefendingState(1);
        }
    }

    static class AttackGoal extends Goal {
        private final EntityVerdugo parentEntity;

        public AttackGoal(EntityVerdugo mob) {
            this.parentEntity = mob;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return this.parentEntity.getTarget() != null;
        }

        @Override
        public void start() {
            this.parentEntity.setAggressive(true);
        }

        @Override
        public void stop() {
            this.parentEntity.setAggressive(false);
            this.parentEntity.setAttackingState(0);
            this.parentEntity.setDefendingState(0);
            this.parentEntity.attr = 0;
            this.parentEntity.attackTimer = -1;
        }

        @Override
        public void tick() {
            LivingEntity target = this.parentEntity.getTarget();
            if (target == null || !target.isAlive()) {
                return;
            }
            this.parentEntity.lookAt(target, 30.0F, 30.0F);

            if (this.parentEntity.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                this.parentEntity.setDefendingState(0);
                if (!this.parentEntity.isAttacking()) {
                    return;
                }
            }

            if (!this.parentEntity.isAttacking()) {
                if (this.parentEntity.attackTimer < 0) {
                    ++this.parentEntity.attackTimer;
                    this.parentEntity.getNavigation().moveTo(target, 1.15D);
                    return;
                }
                double dist = this.parentEntity.distanceTo(target);
                if (dist > 12.0D) {
                    this.parentEntity.getNavigation().moveTo(target, 1.2D);
                    return;
                }
                this.beginAttack(target, dist);
                return;
            }

            ++this.parentEntity.attackTimer;
            int elapsed = this.parentEntity.attackTimer - this.parentEntity.phaseStart;
            int state = this.parentEntity.getAttckingState();

            if (state == 2) {
                this.tickTailThrust(target, elapsed);
            } else if (state == 1) {
                this.tickPounce(target, elapsed);
            }

            if (elapsed >= ATTACK_END) {
                this.finishAttack();
            }
        }

        private void beginAttack(LivingEntity target, double dist) {
            this.parentEntity.getNavigation().stop();
            this.parentEntity.phaseStart = 1;
            this.parentEntity.attackTimer = 1;
            this.parentEntity.pounceHit = false;

            // 近距离优先尾巴突刺；稍远或血量窗口则扑击抓投
            boolean preferPounce = dist > 4.5D
                    || ((this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.75F
                    && this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.90F)
                    || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.40F
                    && this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.60F)
                    || (this.parentEntity.getHealth() >= this.parentEntity.getMaxHealth() * 0.10F
                    && this.parentEntity.getHealth() <= this.parentEntity.getMaxHealth() * 0.30F));

            if (preferPounce && dist <= 10.0D) {
                this.parentEntity.setAttackingState(1);
                this.parentEntity.attr = 1;
                Vec3 to = target.position().subtract(this.parentEntity.position());
                Vec3 flat = new Vec3(to.x, 0.0D, to.z);
                if (flat.lengthSqr() > 1.0E-4D) {
                    flat = flat.normalize();
                    this.parentEntity.setDeltaMovement(flat.x * 1.15D, 0.55D, flat.z * 1.15D);
                    this.parentEntity.hasImpulse = true;
                }
            } else {
                this.parentEntity.setAttackingState(2);
                this.parentEntity.attr = 2;
            }
        }

        private void tickTailThrust(LivingEntity target, int elapsed) {
            this.parentEntity.getNavigation().stop();
            if (elapsed == TAIL_HIT_TICK) {
                float damage = this.parentEntity.getAttackDamage() * 1.8F + target.getMaxHealth() * 0.12F;
                AABB box = this.parentEntity.getBoundingBox().inflate(2.8D, 1.0D, 2.8D);
                Vec3 look = this.parentEntity.getLookAngle();
                Vec3 forward = new Vec3(look.x, 0.0D, look.z);
                if (forward.lengthSqr() > 1.0E-4D) {
                    forward = forward.normalize();
                }
                for (LivingEntity living : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, box, VER_AREA)) {
                    double dx = living.getX() - this.parentEntity.getX();
                    double dz = living.getZ() - this.parentEntity.getZ();
                    double dist = Math.sqrt(dx * dx + dz * dz);
                    if (dist > 4.0D) {
                        continue;
                    }
                    if (forward.lengthSqr() > 1.0E-4D) {
                        Vec3 toward = new Vec3(dx / Math.max(dist, 0.001D), 0.0D, dz / Math.max(dist, 0.001D));
                        if (forward.dot(toward) < Math.cos(Math.toRadians(75.0D))) {
                            continue;
                        }
                    }
                    this.parentEntity.hurtTailThrust(living, damage);
                    this.parentEntity.heal(1.5F);
                }
                this.parentEntity.playSound(SoundEvents.RAVAGER_ATTACK, 1.0F, 1.2F);
            }
        }

        private void tickPounce(LivingEntity target, int elapsed) {
            if (elapsed >= 4 && elapsed <= 14) {
                Vec3 to = target.position().subtract(this.parentEntity.position());
                Vec3 flat = new Vec3(to.x, 0.0D, to.z);
                if (flat.lengthSqr() > 0.25D) {
                    flat = flat.normalize().scale(0.35D);
                    Vec3 motion = this.parentEntity.getDeltaMovement();
                    this.parentEntity.setDeltaMovement(flat.x, motion.y, flat.z);
                }
            }
            if (!this.parentEntity.pounceHit && elapsed >= POUNCE_HIT_TICK) {
                this.parentEntity.pounceHit = true;
                float damage = this.parentEntity.getAttackDamage() * 1.35F + target.getMaxHealth() * 0.08F;
                AABB box = this.parentEntity.getBoundingBox().inflate(2.2D, 1.2D, 2.2D);
                for (LivingEntity living : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class, box, VER_AREA)) {
                    this.parentEntity.hurtUnparryable(living, damage);
                    living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1));
                    if (living instanceof Player player) {
                        Vec3 pull = this.parentEntity.position().subtract(player.position()).normalize().scale(0.45D);
                        player.setDeltaMovement(pull.x, 0.25D, pull.z);
                        player.hurtMarked = true;
                    }
                    this.parentEntity.heal(2.0F);
                }
                this.parentEntity.playSound(SoundEvents.RAVAGER_ATTACK, 1.0F, 0.85F);
            }
        }

        private void finishAttack() {
            this.parentEntity.setAttackingState(0);
            this.parentEntity.attackTimer = COMBO_COOLDOWN;
            this.parentEntity.attr = 0;
            this.parentEntity.pounceHit = false;
            this.parentEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30, 1, true, true));
            this.parentEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30, 4, true, true));
            this.parentEntity.setDefendingState(1);
        }
    }
}
