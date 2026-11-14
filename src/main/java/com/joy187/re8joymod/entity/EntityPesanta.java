package com.joy187.re8joymod.entity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;

public class EntityPesanta extends Monster implements GeoEntity {

    private static final Predicate<Entity> PES_AREA = entity -> entity.isAlive() && !(entity instanceof EntityPesanta);

    // ===== 状态机 =====
    private static final int STATE_IDLE = 0;
    private static final int STATE_CLAW = 1;
    private static final int STATE_TRAP = 2;
    private static final int STATE_MIRAGE = 3;
    private static final int STATE_CLONE = 4;
    private static final int STATE_SPIKE = 5;

    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityPesanta.class, EntityDataSerializers.INT);

    // ===== 技能判定帧 =====
    private static final int CLAW_HIT_TICK = 10;
    private static final int TRAP_PLACE_TICK = 12;
    private static final int MIRAGE_TRIGGER_TICK = 8;
    private static final int CLONE_SPAWN_TICK = 15;
    private static final int SPIKE_FIRE_TICK = 10;
    private static final int ATTACK_END_TICK = 30;

    // ===== 分身冲锋相关 =====
    private static final String PHANTOM_TAG = "pesanta_phantom";
    private static final int CLONE_LIFETIME = 100;
    private static final float CLONE_EXPLODE_DAMAGE = 8.0F;
    private final List<Integer> phantomIds = new ArrayList<>();
    private final Map<Integer, Integer> phantomLifeMap = new HashMap<>();

    // ===== 计时器 =====
    private int attackTimer = 0;
    private int cooldownTimer = 0;

    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntityPesanta(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 120;
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F); // 避免在岩浆旁卡死
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 120.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.6D)
                .add(Attributes.FOLLOW_RANGE, 50.0D)
                .add(Attributes.ARMOR, 10.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 5.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int state) {
        this.entityData.set(STATE, state);
        if (state != 0) {
            this.triggerAnim("controller1", getAnimNameByState(state));
        }
    }

    private String getAnimNameByState(int state) {
        switch (state) {
            case STATE_CLAW: return "claw";
            case STATE_TRAP: return "trap";
            case STATE_MIRAGE: return "mirage";
            case STATE_CLONE: return "clone";
            case STATE_SPIKE: return "spike";
            default: return "";
        }
    }

    // ==================== Goals ====================
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PesantaAttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.4D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

        // 目标选择器
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(EntityPesanta.class));
        // 主动攻击玩家
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        // 主动攻击铁傀儡 (这就是你要的)
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        // 主动攻击村民
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
    }

    // ==================== 动画控制器 ====================
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "controller1", 5, state -> PlayState.STOP)
                .triggerableAnim("claw", RawAnimation.begin().thenPlay("animation.pesanta.claw"))
                .triggerableAnim("trap", RawAnimation.begin().thenPlay("animation.pesanta.trap"))
                .triggerableAnim("mirage", RawAnimation.begin().thenPlay("animation.pesanta.mirage"))
                .triggerableAnim("clone", RawAnimation.begin().thenPlay("animation.pesanta.clone"))
                .triggerableAnim("spike", RawAnimation.begin().thenPlay("animation.pesanta.spike")));
        data.add(new AnimationController<>(this, "controller", 6, this::predicate));
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.getAttckingState() != 0) return PlayState.CONTINUE;
        if (this.isDeadOrDying()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.pesanta.death"));
            return PlayState.CONTINUE;
        }
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenLoop("animation.pesanta.walk"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenLoop("animation.pesanta.idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    // ==================== 分身冲锋逻辑 ====================
    public void spawnChargingPhantoms() {
        if (this.level().isClientSide) return;
        this.discardPhantoms();

        LivingEntity target = this.getTarget();
        if (target == null) return;

        for (int i = 0; i < 2; i++) {
            EntityVerdugo phantom = new EntityVerdugo(EntityInit.VERDUGO.get(), this.level());
            phantom.setNoAi(true);
            phantom.setInvulnerable(true);
            phantom.setSilent(true);
            phantom.setNoGravity(true);
            phantom.noPhysics = true;
            phantom.setPersistenceRequired();
            phantom.addTag(PHANTOM_TAG);
            phantom.setGlowingTag(true);
            phantom.setTarget(null);

            double angle = this.getYRot() + (i == 0 ? 45 : -45);
            double rad = Math.toRadians(angle);
            double px = this.getX() - Math.sin(rad) * 2.0D;
            double pz = this.getZ() + Math.cos(rad) * 2.0D;
            phantom.setPos(px, this.getY(), pz);

            this.level().addFreshEntity(phantom);
            this.phantomIds.add(phantom.getId());
            this.phantomLifeMap.put(phantom.getId(), CLONE_LIFETIME);
        }
        this.playSound(SoundEvents.ILLUSIONER_MIRROR_MOVE, 1.5F, 0.8F);

        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(10.0D))) {
            if (living instanceof Player player && !player.isCreative()) {
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 1));
            }
        }
    }

    public void tickPhantoms() {
        if (this.level().isClientSide || this.phantomIds.isEmpty()) return;

        LivingEntity target = this.getTarget();
        if (target == null) {
            this.discardPhantoms();
            return;
        }

        Iterator<Integer> it = this.phantomIds.iterator();
        while (it.hasNext()) {
            int id = it.next();
            Entity e = this.level().getEntity(id);
            if (!(e instanceof EntityVerdugo) || !e.isAlive()) {
                it.remove();
                this.phantomLifeMap.remove(id);
                continue;
            }

            int life = this.phantomLifeMap.getOrDefault(id, CLONE_LIFETIME) - 1;
            this.phantomLifeMap.put(id, life);

            if (life <= 0) {
                e.discard();
                it.remove();
                this.phantomLifeMap.remove(id);
                continue;
            }

            Vec3 to = target.position().subtract(e.position());
            Vec3 flat = new Vec3(to.x, 0, to.z);
            double dist = flat.length();

            if (dist < 1.8D) {
                this.explodePhantom(e, target);
                e.discard();
                it.remove();
                this.phantomLifeMap.remove(id);
                continue;
            }

            if (dist > 0.1D) {
                Vec3 dir = flat.normalize().scale(0.6D);
                e.setDeltaMovement(dir.x, 0, dir.z);
                e.hurtMarked = true;
            }
            e.setYRot((float) (Math.toDegrees(Math.atan2(flat.z, flat.x)) - 90.0F));
        }
    }

    private void explodePhantom(Entity phantom, LivingEntity target) {
        AABB box = new AABB(phantom.position(), phantom.position()).inflate(1.5D);
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, box)) {
            if (living == this || living.isAlliedTo(this) || living.getTags().contains(PHANTOM_TAG)) continue;
            living.hurt(this.damageSources().mobAttack(this), CLONE_EXPLODE_DAMAGE);
            living.addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 100, 1));
            living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
        }
        if (this.level() instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.EXPLOSION, phantom.getX(), phantom.getY() + 0.5, phantom.getZ(), 1, 0, 0, 0, 0);
            server.sendParticles(ParticleInit.MUCUS_PARTICLE.get(), phantom.getX(), phantom.getY() + 0.5, phantom.getZ(), 20, 0.5, 0.5, 0.5, 0.1);
        }
        this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0F, 0.8F);
    }

    public void discardPhantoms() {
        for (int id : this.phantomIds) {
            Entity e = this.level().getEntity(id);
            if (e != null && e.getTags().contains(PHANTOM_TAG)) {
                e.discard();
            }
        }
        this.phantomIds.clear();
        this.phantomLifeMap.clear();
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.tickPhantoms();
        }
    }

    @Override
    public void remove(RemovalReason reason) {
        this.discardPhantoms();
        super.remove(reason);
    }

    // ==================== AttackGoal ====================
    static class PesantaAttackGoal extends Goal {
        private final EntityPesanta pesanta;

        public PesantaAttackGoal(EntityPesanta mob) {
            this.pesanta = mob;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return this.pesanta.getTarget() != null && this.pesanta.getAttckingState() == STATE_IDLE;
        }

        @Override
        public void start() {
            this.pesanta.setAggressive(true);
        }

        @Override
        public void stop() {
            this.pesanta.setAggressive(false);
            this.pesanta.setAttackingState(STATE_IDLE);
            this.pesanta.attackTimer = 0;
            this.pesanta.cooldownTimer = 0;
        }

        @Override
        public void tick() {
            LivingEntity target = this.pesanta.getTarget();
            if (target == null || !target.isAlive()) return;

            this.pesanta.lookAt(target, 30.0F, 30.0F);

            // 如果没有在攻击
            if (this.pesanta.getAttckingState() == STATE_IDLE) {
                if (this.pesanta.cooldownTimer > 0) {
                    this.pesanta.cooldownTimer--;
                    this.pesanta.getNavigation().moveTo(target, 1.15D);
                    return;
                }

                double dist = this.pesanta.distanceTo(target);
                // 如果距离远，先走过去
                if (dist > 12.0D) {
                    this.pesanta.getNavigation().moveTo(target, 1.2D);
                    return;
                }

                // 如果距离很近，且没在冷却，开始选招
                int roll = this.pesanta.getRandom().nextInt(100);
                if (roll < 20 && dist <= 3.0D) {
                    this.pesanta.setAttackingState(STATE_CLAW);
                } else if (roll < 40) {
                    this.pesanta.setAttackingState(STATE_TRAP);
                } else if (roll < 60) {
                    this.pesanta.setAttackingState(STATE_SPIKE);
                } else if (roll < 75) {
                    this.pesanta.setAttackingState(STATE_MIRAGE);
                } else {
                    this.pesanta.setAttackingState(STATE_CLONE);
                }
                this.pesanta.attackTimer = 0;
                return;
            }

            // 在攻击中
            this.pesanta.attackTimer++;
            int elapsed = this.pesanta.attackTimer;
            int state = this.pesanta.getAttckingState();

            switch (state) {
                case STATE_CLAW: this.tickClaw(target, elapsed); break;
                case STATE_TRAP: this.tickTrap(elapsed); break;
                case STATE_MIRAGE: this.tickMirage(target, elapsed); break;
                case STATE_CLONE: this.tickClone(elapsed); break;
                case STATE_SPIKE: this.tickSpike(target, elapsed); break;
            }

            if (elapsed >= ATTACK_END_TICK) {
                this.pesanta.setAttackingState(STATE_IDLE);
                this.pesanta.cooldownTimer = 10;
            }
        }

        private void tickClaw(LivingEntity target, int elapsed) {
            this.pesanta.getNavigation().stop();
            this.pesanta.setDeltaMovement(0, this.pesanta.getDeltaMovement().y, 0);
            if (elapsed == CLAW_HIT_TICK) {
                float damage = (float) this.pesanta.getAttributeValue(Attributes.ATTACK_DAMAGE) * 2.0F;
                AABB box = this.pesanta.getBoundingBox().inflate(3.0D, 1.5D, 3.0D);
                for (LivingEntity living : this.pesanta.level().getEntitiesOfClass(LivingEntity.class, box, PES_AREA)) {
                    living.hurt(this.pesanta.damageSources().mobAttack(this.pesanta), damage);
                    living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
                }
                this.pesanta.playSound(SoundEvents.RAVAGER_ATTACK, 1.2F, 0.8F);
            }
        }

        private void tickTrap(int elapsed) {
            this.pesanta.getNavigation().stop();
            if (elapsed == TRAP_PLACE_TICK) {
                if (!this.pesanta.level().isClientSide) {
                    BlockPos pos = this.pesanta.blockPosition();
                    if (this.pesanta.level().getBlockState(pos).canBeReplaced()) {
                        this.pesanta.level().setBlockAndUpdate(pos, BlockInit.MINE.get().defaultBlockState());
                    }
                }
                this.pesanta.playSound(SoundEvents.SLIME_SQUISH, 1.0F, 0.5F);
            }
        }

        private void tickMirage(LivingEntity target, int elapsed) {
            this.pesanta.getNavigation().stop();
            if (elapsed == MIRAGE_TRIGGER_TICK) {
                AABB box = this.pesanta.getBoundingBox().inflate(8.0D);
                for (LivingEntity living : this.pesanta.level().getEntitiesOfClass(LivingEntity.class, box, PES_AREA)) {
                    living.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 1));
                    living.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 2));
                    living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1));
                }
                this.pesanta.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 0, false, false));
                this.pesanta.playSound(SoundEvents.WITCH_DRINK, 1.2F, 0.7F);
            }
        }

        private void tickClone(int elapsed) {
            this.pesanta.getNavigation().stop();
            if (elapsed == 1) {
                LivingEntity target = this.pesanta.getTarget();
                if (target != null) {
                    Vec3 dirAway = this.pesanta.position().subtract(target.position()).normalize().scale(1.2D);
                    this.pesanta.setDeltaMovement(dirAway.x, 0.6D, dirAway.z);
                    this.pesanta.hasImpulse = true;
                    this.pesanta.playSound(SoundEvents.RAVAGER_ROAR, 1.0F, 1.2F);
                }
            }
            if (elapsed == CLONE_SPAWN_TICK) {
                this.pesanta.spawnChargingPhantoms();
            }
        }

        private void tickSpike(LivingEntity target, int elapsed) {
            this.pesanta.getNavigation().stop();
            this.pesanta.setDeltaMovement(0, this.pesanta.getDeltaMovement().y, 0);
            if (elapsed == SPIKE_FIRE_TICK) {
                if (!this.pesanta.level().isClientSide) {
                    Vec3 groundPos = EntityMyceliumSpike.ground(this.pesanta.level(), target.getX(), target.getY(), target.getZ());
                    EntityMyceliumSpike.rise(this.pesanta.level(), this.pesanta, groundPos, (float) this.pesanta.getAttributeValue(Attributes.ATTACK_DAMAGE), 10);
                    target.addEffect(new MobEffectInstance(EffectInit.EROSION.get(), 100, 1));
                }
                this.pesanta.playSound(SoundEvents.ARROW_SHOOT, 1.5F, 0.5F);
            }
        }
    }
}
