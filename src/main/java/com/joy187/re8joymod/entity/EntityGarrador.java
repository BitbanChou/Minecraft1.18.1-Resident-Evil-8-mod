package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class EntityGarrador extends Ravager implements GeoEntity, VibrationSystem {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public int explosionPower = 5, attr = 0, pre = 0;
    public boolean isaoe = false;
    private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityGarrador.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityGarrador.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> PLAGA = SynchedEntityData.defineId(EntityGarrador.class,
            EntityDataSerializers.BOOLEAN);

    protected int attackTimer = 0;
    private int phaseStart;

    private static final int HEAR_MEMORY = 100;
    private static final int HEAR_RADIUS = 16;
    /** 挥爪动画 0.91667 秒。第 10 tick（0.50 秒）身体前冲到 z=-17，这一帧出伤。 */
    private static final int SLASH_HIT_TICK = 10;
    private static final int SLASH_END_TICK = 18;
    /** 转圈动画 1.25 秒。boss 骨骼在 0.1667–0.9167 秒转到 -360。 */
    private static final int SPIN_END_TICK = 25;
    private static final float SPIN_HIT_START = 0.1667F;
    private static final float SPIN_HIT_END = 0.9167F;
    /** 冲撞动画 0.6 秒。0.15 秒前倾到位后才位移。 */
    private static final int CHARGE_MOVE_START = 3;
    private static final int CHARGE_END_TICK = 12;
    private static final int COMBO_COOLDOWN = -15;

    /** 连招结束后摇/硬直窗口（tick）。期间冻结 AI、不推进攻击、优先播 recover 动画。 */
    private static final int RECOVER_TICKS = 30;
    private int recoverTimer = 0;

    /** 受击硬直（可选）：单次伤害 >= 该值时触发短暂硬直，并打断当前连招。 */
    private static final float STUN_MIN_DAMAGE = 6.0F;
    private static final int STUN_TICKS = 8;
    private int stunTicks = 0;

    private final DynamicGameEventListener<VibrationSystem.Listener> dynamicGameEventListener;
    private final VibrationSystem.User vibrationUser;
    private final VibrationSystem.Data vibrationData = new VibrationSystem.Data();
    private int listenTicks;
    private int heavyArmorFactor = 1;
    private float spinBaseYaw;
    @Nullable
    private BlockPos investigatePos;
    @Nullable
    private LivingEntity queuedTarget;
    @Nullable
    private BlockPos queuedPos;
    private final Set<UUID> spinHit = new HashSet<>();
    private final Set<UUID> chargeHit = new HashSet<>();

    public EntityGarrador(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.vibrationUser = new HearingUser();
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new VibrationSystem.Listener(this));
        this.xpReward = 120;
        this.isNonBoss();
        this.isSunSensitive();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }

    protected boolean isSunSensitive() {
        return true;
    }

    public void aiStep() {
        super.aiStep();
        Random ran = new Random();
        int co = ran.nextInt(4);
        if (co == 1 && this.attr != 2 && this.attr != 3) {
            for (int i = 0; i < 30; i++) {
                float deltaOmega = 1.0f * i;
                Vec3 pos = new Vec3(this.position().x + 1 * Math.sin(0 + deltaOmega), this.position().y + 0.1f * this.random.nextFloat(), this.position().z + 1 * Math.cos(0 + deltaOmega));
                this.level().addParticle(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 0, 0, 0);
            }
        }

        if (this.entityData.get(STATE) == 3) {
            this.defend();
        }
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 150.0D).
                add(Attributes.MOVEMENT_SPEED, 0.27D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.40D).
                add(Attributes.ATTACK_DAMAGE, 8.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    private float getAttackDamage() {
        return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if (co == 0) return SoundEvents.RAVAGER_AMBIENT;
        return SoundEvents.RAVAGER_ROAR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if (co == 0) return SoundEvents.RAVAGER_HURT;
        return SoundInit.ENTITY_HESEN_HURT2.get();
    }

    public int getInvulnerableTicks() {
        return 200;
    }

    protected float getStandingEyeHeight(PoseStack.Pose p_213348_1_, EntityDimensions p_213348_2_) {
        return 1.5F;
    }

    public void setInvulnerableTicks(int p_82215_1_) {
        //this.entityData.set(DATA_ID_INV, p_82215_1_);
    }

    public void readAdditionalSaveData(CompoundTag p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        if (p_70037_1_.contains("PlagaIntact")) {
            this.setPlagaIntact(p_70037_1_.getBoolean("PlagaIntact"));
        }
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("PlagaIntact", this.isPlagaIntact());
    }

    public void setCustomName(@Nullable Component p_200203_1_) {
        super.setCustomName(p_200203_1_);
        this.bossInfo.setName(this.getDisplayName());
    }

    protected void customServerAiStep() {
        super.customServerAiStep();

        Random ran = new Random();
        if (this.getHealth() < 200.F) {
            this.level().addParticle(ParticleTypes.SMOKE, this.position().x + this.random.nextGaussian() * (double) 0.3F, this.position().y + this.random.nextGaussian() * (double) 0.3F, this.position().z + this.random.nextGaussian() * (double) 0.3F, 0.0D, 0.0D, 0.0D);
        }

        if (this.getHealth() >= 20.0F && this.getHealth() <= 30.0F) {
            for (int i = 0; i < 5; i++)
                this.heal(1.0F * ran.nextFloat());
        }

        if (this.getHealth() >= 60.0F && this.getHealth() <= 65.0F) {
            for (int i = 0; i < 4; i++)
                this.heal(2F * ran.nextFloat());
        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    private void defend() {
        if (this.isAlive()) {
            Vec3 vec3 = this.getBoundingBox().getCenter();

            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 10; i++) {
                    float deltaOmega = 1.0f * i;
                    Vec3 pos = new Vec3(vec3.x + 3 * Math.sin(0 + deltaOmega), vec3.y + j, vec3.z + 3 * Math.cos(0 + deltaOmega));
                    this.level().addParticle(ParticleInit.DEFEND_PARTICLE.get(), pos.x, pos.y, pos.z, 0, 0, 0);
                }
            }

            this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }
    }

    public void makeInvulnerable() {
        this.setInvulnerableTicks(220);
        this.bossInfo.setProgress(0.0F);
        this.setHealth(this.getMaxHealth() / 3.0F);
    }

    public boolean isNonBoss() {
        return false;
    }

    public void startSeenByPlayer(ServerPlayer p_184178_1_) {
        super.startSeenByPlayer(p_184178_1_);
        this.bossInfo.addPlayer(p_184178_1_);
    }

    public void stopSeenByPlayer(ServerPlayer p_184203_1_) {
        super.stopSeenByPlayer(p_184203_1_);
        this.bossInfo.removePlayer(p_184203_1_);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        int atk = this.entityData.get(STATE);
        // 攻击中：让攻击控制器独占骨骼
        if (atk == 1 || atk == 2 || atk == 3 || atk == 4) {
            return PlayState.STOP;
        }
        // recover 后摇优先于 walk/idle
        if (this.getDefendingState() == 1) {
            event.setAndContinue(RawAnimation.begin().thenLoop("animation.garrador.recover"));
            return PlayState.CONTINUE;
        }

        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.chief2.walk"));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay("animation.chief2.idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        AnimationController<?> attackController =
                new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
                        .triggerableAnim("slash", RawAnimation.begin().thenPlay("animation.chief2.attack"))
                        .triggerableAnim("heavy", RawAnimation.begin().thenPlay("animation.chief2.attack2"))
                        .triggerableAnim("charge", RawAnimation.begin().thenPlay("animation.garrador.charge"));
        data.add(attackController);
        data.add(new AnimationController<>(this, "controller", 8, this::predicate));
        data.add(new AnimationController<>(this, "plaga", 4, state -> {
            if (!this.isPlagaIntact()) {
                return PlayState.STOP;
            }
            state.setAndContinue(RawAnimation.begin().thenLoop("animation.garrador.plaga"));
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    /** Trigger one-shot attack animation via GeckoLib triggerAnim. */
    protected void startAttackAnim(int state) {
        if (state == 1) {
            this.triggerAnim("controller1", "slash");
        } else if (state == 2) {
            this.triggerAnim("controller1", "heavy");
        } else if (state == 4) {
            this.triggerAnim("controller1", "charge");
        }
    }


    public void setAttackingState(int time) {
        int prev = this.entityData.get(STATE);
        this.entityData.set(STATE, time);
        if ((time == 1 || time == 2 || time == 4) && prev != time) {
            this.startAttackAnim(time);
        }
    }

    public int getDefendingState() {
        return this.entityData.get(DEFENDSTATE);
    }

    public void setDefendingState(int time) {
        this.entityData.set(DEFENDSTATE, time);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DEFENDSTATE, 0);
        this.entityData.define(PLAGA, true);
    }

    public boolean isPlagaIntact() {
        return this.entityData.get(PLAGA);
    }

    public void setPlagaIntact(boolean intact) {
        this.entityData.set(PLAGA, intact);
    }

    @Override
    protected void updateControlFlags() {
        if (this.isAttacking() || this.recoverTimer > 0 || this.stunTicks > 0) {
            this.goalSelector.setControlFlag(Goal.Flag.MOVE, false);
            this.goalSelector.setControlFlag(Goal.Flag.JUMP, false);
            this.goalSelector.setControlFlag(Goal.Flag.LOOK, false);
            this.goalSelector.setControlFlag(Goal.Flag.TARGET, true);
            return;
        }
        super.updateControlFlags();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (this.isAttacking()) {
            return false;
        }
        return super.doHurtTarget(entity);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean backPlaga = !this.level().isClientSide && this.isPlagaIntact()
                && source.getEntity() instanceof LivingEntity living && living != this && this.isBackHit(living);
        MobEffectInstance resistance = null;
        if (backPlaga) {
            resistance = this.getEffect(MobEffects.DAMAGE_RESISTANCE);
            if (resistance != null) {
                this.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            }
            amount = this.getMaxHealth() * 0.3F;
        }
        float before = this.getHealth();
        boolean hurt = super.hurt(source, amount);
        if (!hurt && resistance != null) {
            this.addEffect(new MobEffectInstance(resistance));
        }
        if (hurt && backPlaga) {
            this.setPlagaIntact(false);
            float want = this.getMaxHealth() * 0.3F;
            if (before - this.getHealth() < want - 0.5F) {
                this.setHealth(Math.max(0.0F, before - want));
                if (this.getHealth() <= 0.0F) {
                    this.die(source);
                }
            }
        }

        // 受击硬直（可选）：打断攻击 + 短暂冻结，保留击退位移
        if (hurt && !this.level().isClientSide && amount >= STUN_MIN_DAMAGE) {
            this.stunTicks = Math.max(this.stunTicks, STUN_TICKS);
            if (this.isAttacking()) {
                this.setAttackingState(0);
                this.attackTimer = COMBO_COOLDOWN;
                this.spinHit.clear();
                this.chargeHit.clear();
                this.stopAttackAnims();
            }
        }

        if (hurt && !this.level().isClientSide && source.getEntity() instanceof LivingEntity living) {
            this.noticeEntity(living, living.blockPosition());
        }
        return hurt;
    }

    private boolean isBackHit(Entity attacker) {
        Vec3 look = this.getLookAngle();
        Vec3 to = attacker.position().subtract(this.position());
        to = new Vec3(to.x, 0.0D, to.z);
        if (to.lengthSqr() < 1.0E-4D) {
            return false;
        }
        Vec3 flatLook = new Vec3(look.x, 0.0D, look.z);
        if (flatLook.lengthSqr() < 1.0E-4D) {
            return false;
        }
        return flatLook.normalize().dot(to.normalize()) < -0.5D;
    }

    private static final Predicate<Entity> PIGEON_AREA = (entity) -> {
        return entity.isAlive() && !(entity instanceof EntityGarrador);
    };

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) {
            return;
        }
        VibrationSystem.Ticker.tick(this.level(), this.vibrationData, this.vibrationUser);

        // 受击硬直：冻结 AI、不推进攻击，但保留击退位移（不清零 delta）
        if (this.stunTicks > 0) {
            --this.stunTicks;
            this.getNavigation().stop();
            this.setSpeed(0.0F);
            this.tickHearing();
            return;
        }

        // recover 后摇：冻结水平移动、只转头、不推进攻击
        if (this.recoverTimer > 0) {
            --this.recoverTimer;
            this.setDefendingState(1);
            this.getNavigation().stop();
            this.setSpeed(0.0F);
            Vec3 motion = this.getDeltaMovement();
            this.setDeltaMovement(0.0D, motion.y, 0.0D);
            LivingEntity recoverTarget = this.getTarget();
            if (recoverTarget != null) {
                this.lookAt(recoverTarget, 30.0F, 30.0F);
            }
            if (this.recoverTimer == 0) {
                this.setDefendingState(0);
            }
            this.tickHearing();
            return;
        }
        // 防御粒子状态（STATE==3）在 aiStep 中处理，这里不动

        this.tickHearing();
        this.tickAttack();
    }

    private boolean isAttacking() {
        return this.getAttckingState() != 0;
    }

    private boolean canHear(LivingEntity living) {
        if (living == this || !living.isAlive() || !living.attackable() || living instanceof EntityGarrador) {
            return false;
        }
        return !(living instanceof Player player) || !player.isSpectator();
    }

    private void noticeEntity(LivingEntity living, BlockPos pos) {
        if (!this.canHear(living)) {
            return;
        }
        this.listenTicks = HEAR_MEMORY;
        if (this.isAttacking()) {
            this.queuedTarget = living;
            this.queuedPos = pos;
            return;
        }
        this.queuedTarget = null;
        this.queuedPos = null;
        this.investigatePos = null;
        this.setTarget(living);
        this.getNavigation().moveTo(living, 1.15D);
    }

    private void noticePosition(BlockPos pos) {
        if (this.getTarget() != null || this.queuedTarget != null) {
            return;
        }
        if (this.isAttacking()) {
            this.queuedPos = pos;
            return;
        }
        this.investigatePos = pos;
        this.listenTicks = 80;
        this.getNavigation().moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 1.05D);
    }

    private void tickHearing() {
        if (this.listenTicks > 0) {
            --this.listenTicks;
        }
        if (!this.isAttacking()) {
            if (this.queuedTarget != null) {
                LivingEntity queued = this.queuedTarget;
                BlockPos pos = this.queuedPos != null ? this.queuedPos : queued.blockPosition();
                this.queuedTarget = null;
                this.queuedPos = null;
                this.noticeEntity(queued, pos);
            } else if (this.queuedPos != null && this.getTarget() == null) {
                BlockPos pos = this.queuedPos;
                this.queuedPos = null;
                this.noticePosition(pos);
            }
        }

        LivingEntity target = this.getTarget();
        if (target != null && !this.canHear(target)) {
            this.setTarget(null);
            target = null;
        }
        if (target != null && this.listenTicks <= 0 && !this.isAttacking()) {
            double reach = (this.getBbWidth() + target.getBbWidth()) * 0.5D + 2.0D;
            if (this.distanceToSqr(target) > reach * reach) {
                this.setTarget(null);
            } else {
                this.listenTicks = 40;
            }
        }
        if (!this.isAttacking() && this.getTarget() != null) {
            this.lookAt(this.getTarget(), 30.0F, 30.0F);
        }
        if (!this.isAttacking() && this.getTarget() == null && this.investigatePos != null) {
            if (this.listenTicks <= 0 || this.distanceToSqr(Vec3.atCenterOf(this.investigatePos)) < 4.0D) {
                this.tryGrabNearby();
            } else if (this.getNavigation().isDone()) {
                BlockPos pos = this.investigatePos;
                this.getNavigation().moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 1.05D);
            }
        }
    }

    private void tryGrabNearby() {
        AABB box = this.getBoundingBox().inflate(2.0D);
        LivingEntity found = null;
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, box, this::canHear)) {
            found = living;
            break;
        }
        this.investigatePos = null;
        this.listenTicks = 0;
        if (found != null) {
            this.noticeEntity(found, found.blockPosition());
        } else {
            this.getNavigation().stop();
        }
    }

    private boolean inAttackRange(LivingEntity target) {
        // 收紧到更贴近体型的接触距离（约 2.0~2.5 格），避免远距离就挥
        double reach = (this.getBbWidth() + target.getBbWidth()) * 0.5D + 1.5D;
        return this.distanceToSqr(target) <= reach * reach;
    }

    private boolean wantsHeavy() {
        float health = this.getHealth();
        return health < 5.0F || health > 135.0F
                || (health > 90.0F && health < 101.0F)
                || (health > 66.0F && health < 81.0F)
                || (health > 26.0F && health < 39.0F)
                || (health > 10.0F && health < 18.0F);
    }

    private void holdStill(boolean lockFacing) {
        this.getNavigation().stop();
        this.setSpeed(0.0F);
        Vec3 motion = this.getDeltaMovement();
        this.setDeltaMovement(0.0D, motion.y, 0.0D);
        if (lockFacing) {
            this.setYRot(this.spinBaseYaw);
            this.setYBodyRot(this.spinBaseYaw);
            this.setYHeadRot(this.spinBaseYaw);
        }
    }

    /** 进入 recover 后摇窗口。 */
    private void startRecover() {
        this.recoverTimer = RECOVER_TICKS;
        this.setDefendingState(1);
        this.getNavigation().stop();
        this.setSpeed(0.0F);
    }

    /** 立即结束当前连招并进入 recover（用于目标死亡/丢失中断）。 */
    private void abortComboAndRecover() {
        this.setAttackingState(0);
        this.attackTimer = COMBO_COOLDOWN;
        this.spinHit.clear();
        this.chargeHit.clear();
        this.stopAttackAnims();
        this.startRecover();
    }

    private void tickAttack() {
        LivingEntity target = this.getTarget();

        // 攻击中但目标已失效 → 立即中断连招，进入 recover，不再"打空气"
        if (this.isAttacking() && (target == null || !this.canHear(target))) {
            this.abortComboAndRecover();
            return;
        }

        boolean audible = target != null && this.canHear(target)
                && (target.getSoundSource() == SoundSource.HOSTILE
                || target.getSoundSource() == SoundSource.PLAYERS
                || target.getSoundSource() == SoundSource.NEUTRAL);

        if (!this.isAttacking()) {
            if (this.attackTimer < 0) {
                if (audible) {
                    ++this.attackTimer;
                }
                return;
            }
            if (!(audible && this.inAttackRange(target))) {
                return;
            }
        }

        ++this.attackTimer;
        if (this.attackTimer == 1) {
            this.phaseStart = this.attackTimer;
            this.spinBaseYaw = this.getYRot();
            this.spinHit.clear();
            this.chargeHit.clear();
            this.setAttackingState(1);
        }
        int state = this.getAttckingState();
        int elapsed = this.attackTimer - this.phaseStart;

        if (state == 1) {
            this.holdStill(true);
            if (elapsed == SLASH_HIT_TICK) {
                this.tickSlash();
            }
            if (elapsed < SLASH_END_TICK) {
                return;
            }
            this.beginFollowUp();
            if (!this.isAttacking()) {
                return;
            }
            state = this.getAttckingState();
            elapsed = 0;
        }

        if (state == 2) {
            this.holdStill(true);
            this.tickSpin(elapsed / 20.0F);
            if (elapsed >= SPIN_END_TICK) {
                this.finishCombo();
            }
            return;
        }

        if (state == 4) {
            if (elapsed >= CHARGE_MOVE_START && elapsed < CHARGE_END_TICK) {
                this.tickCharge();
            } else {
                this.holdStill(true);
            }
            if (elapsed >= CHARGE_END_TICK) {
                this.finishCombo();
            }
        }
    }

    /** 挥爪结束后立刻接转圈或冲撞，中间不再把状态清零，避免插进待机。 */
    private void beginFollowUp() {
        if (this.getTarget() == null || !this.canHear(this.getTarget())) {
            this.abortComboAndRecover();
            return;
        }
        this.phaseStart = this.attackTimer;
        this.spinHit.clear();
        this.chargeHit.clear();
        if (this.wantsHeavy()) {
            this.heavyArmorFactor = this.random.nextInt(2) + 1;
            this.spinBaseYaw = this.getYRot();
            this.setAttackingState(2);
            this.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, SPIN_END_TICK, 10, true, true));
        } else {
            this.lookAt(this.getTarget(), 180.0F, 180.0F);
            this.spinBaseYaw = this.getYRot();
            this.setAttackingState(4);
        }
    }

    private void finishCombo() {
        this.setAttackingState(0);
        this.attackTimer = COMBO_COOLDOWN;
        this.spinHit.clear();
        this.chargeHit.clear();
        this.stopAttackAnims();
        this.startRecover();
    }

    /** 出伤对准前冲的那一帧：身前约 70°、1 到 4.5 格，不再用四周 6 格的方块。 */
    private void tickSlash() {
        Vec3 look = this.getLookAngle();
        Vec3 forward = new Vec3(look.x, 0.0D, look.z);
        if (forward.lengthSqr() < 1.0E-4D) {
            return;
        }
        forward = forward.normalize();
        AABB box = this.getBoundingBox().inflate(4.5D, 1.2D, 4.5D);
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, box, PIGEON_AREA)) {
            double dy = living.getY() - this.getY();
            if (dy > 2.5D || dy < -2.0D) {
                continue;
            }
            double dx = living.getX() - this.getX();
            double dz = living.getZ() - this.getZ();
            double dist = Math.sqrt(dx * dx + dz * dz);
            if (dist < 0.8D || dist > 4.5D) {
                continue;
            }
            Vec3 toward = new Vec3(dx / dist, 0.0D, dz / dist);
            if (forward.dot(toward) < Math.cos(Math.toRadians(70.0D))) {
                continue;
            }
            living.hurt(this.damageSources().mobAttack(this), living.getMaxHealth() * 0.15F + this.getAttackDamage());
        }
    }

    private void tickCharge() {
        Vec3 before = this.position();
        float yaw = this.spinBaseYaw * ((float) Math.PI / 180F);
        this.move(MoverType.SELF, new Vec3(-Mth.sin(yaw) * 0.42D, 0.0D, Mth.cos(yaw) * 0.42D));
        this.setYRot(this.spinBaseYaw);
        this.setYBodyRot(this.spinBaseYaw);
        this.setYHeadRot(this.spinBaseYaw);
        Vec3 delta = this.position().subtract(before);
        if (delta.lengthSqr() < 1.0E-6D) {
            return;
        }
        double myVolume = boxVolume(this.getBoundingBox());
        AABB box = this.getBoundingBox().inflate(0.35D);
        for (Entity entity : this.level().getEntities(this, box, candidate -> candidate.isAlive() && candidate.isPushable())) {
            if (boxVolume(entity.getBoundingBox()) >= myVolume) {
                continue;
            }
            entity.setPos(entity.getX() + delta.x, entity.getY() + delta.y, entity.getZ() + delta.z);
            entity.setDeltaMovement(delta.x, entity.getDeltaMovement().y, delta.z);
            entity.hurtMarked = true;
            if (entity instanceof LivingEntity living && this.chargeHit.add(living.getUUID())) {
                living.hurt(this.damageSources().mobAttack(this), this.getAttackDamage());
            }
        }
    }

    private static double boxVolume(AABB box) {
        return box.getXsize() * box.getYsize() * box.getZsize();
    }

    private void tickSpin(float animTime) {
        if (animTime < SPIN_HIT_START || animTime > SPIN_HIT_END) {
            return;
        }
        float facingDeg = this.spinBaseYaw - spinBoneYaw(animTime);
        float facingRad = facingDeg * ((float) Math.PI / 180F);
        Vec3 forward = new Vec3(-Mth.sin(facingRad), 0.0D, Mth.cos(facingRad));
        if (this.level() instanceof ServerLevel server) {
            for (int i = -3; i <= 3; ++i) {
                float arc = facingRad + i * 8.0F * ((float) Math.PI / 180F);
                double px = this.getX() - Mth.sin(arc) * 2.6D;
                double pz = this.getZ() + Mth.cos(arc) * 2.6D;
                server.sendParticles(ParticleTypes.SWEEP_ATTACK, px, this.getY() + 1.2D, pz, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                server.sendParticles(ParticleTypes.CRIT, px, this.getY() + 0.2D, pz, 1, 0.05D, 0.02D, 0.05D, 0.02D);
            }
        }
        AABB box = this.getBoundingBox().inflate(3.6D, 1.2D, 3.6D);
        for (LivingEntity living : this.level().getEntitiesOfClass(LivingEntity.class, box, PIGEON_AREA)) {
            if (!this.spinHit.add(living.getUUID())) {
                continue;
            }
            double dy = living.getY() - this.getY();
            if (dy > 2.0D || dy < -2.0D) {
                this.spinHit.remove(living.getUUID());
                continue;
            }
            double dx = living.getX() - this.getX();
            double dz = living.getZ() - this.getZ();
            double dist = Math.sqrt(dx * dx + dz * dz);
            if (dist < 1.2D || dist > 3.6D) {
                this.spinHit.remove(living.getUUID());
                continue;
            }
            Vec3 toward = new Vec3(dx / dist, 0.0D, dz / dist);
            if (forward.dot(toward) < Math.cos(Math.toRadians(55.0D))) {
                this.spinHit.remove(living.getUUID());
                continue;
            }
            this.applyHeavyHit(living);
        }
    }

    private void applyHeavyHit(LivingEntity living) {
        if (living instanceof Player player && player.getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)) {
            disableShield(player, 150);
            return;
        }
        float damage = living.getArmorValue() * this.heavyArmorFactor + living.getMaxHealth() * 0.2F;
        living.hurt(this.damageSources().mobAttack(this), damage);
    }

    private static float spinBoneYaw(float time) {
        float[] times = {0.1667F, 0.4167F, 0.6667F, 0.8333F, 0.9167F};
        float[] yaws = {0.0F, -90.0F, -225.0F, -302.5F, -360.0F};
        if (time <= times[0]) {
            return 0.0F;
        }
        if (time >= times[times.length - 1]) {
            return -360.0F;
        }
        for (int i = 1; i < times.length; ++i) {
            if (time <= times[i]) {
                float delta = (time - times[i - 1]) / (times[i] - times[i - 1]);
                return yaws[i - 1] + (yaws[i] - yaws[i - 1]) * delta;
            }
        }
        return -360.0F;
    }

    private void onVibration(BlockPos pos, @Nullable Entity direct, @Nullable Entity projectileOwner) {
        Entity cause = projectileOwner != null ? projectileOwner : direct;
        if (cause instanceof Projectile projectile && projectile.getOwner() != null) {
            cause = projectile.getOwner();
        }
        if (cause == this || cause instanceof EntityGarrador) {
            return;
        }
        if (cause instanceof LivingEntity living) {
            this.noticeEntity(living, pos);
        } else {
            this.noticePosition(pos);
        }
    }

    @Override
    public VibrationSystem.Data getVibrationData() {
        return this.vibrationData;
    }

    @Override
    public VibrationSystem.User getVibrationUser() {
        return this.vibrationUser;
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> consumer) {
        if (this.level() instanceof ServerLevel server) {
            consumer.accept(this.dynamicGameEventListener, server);
        }
    }

    private class HearingUser implements VibrationSystem.User {
        private final PositionSource positionSource = new EntityPositionSource(EntityGarrador.this, EntityGarrador.this.getEyeHeight());

        @Override
        public int getListenerRadius() {
            return HEAR_RADIUS;
        }

        @Override
        public PositionSource getPositionSource() {
            return this.positionSource;
        }

        @Override
        public boolean canReceiveVibration(ServerLevel level, BlockPos pos, GameEvent event, GameEvent.Context context) {
            if (EntityGarrador.this.isDeadOrDying() || EntityGarrador.this.isRemoved()) {
                return false;
            }
            Entity source = context == null ? null : context.sourceEntity();
            return source != EntityGarrador.this && !(source instanceof EntityGarrador);
        }

        @Override
        public void onReceiveVibration(ServerLevel level, BlockPos pos, GameEvent event, @Nullable Entity direct, @Nullable Entity projectileOwner, float distance) {
            EntityGarrador.this.onVibration(pos, direct, projectileOwner);
        }
    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        ((Player) livingEntity).getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(4 + livingEntity.getRandom().nextInt(2), livingEntity, (p_220009_1_) -> {
            p_220009_1_.broadcastBreakEvent(livingEntity.getUsedItemHand());
        });
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte) 30);
    }

    protected void stopAttackAnims() {
        // 获取 controller1 并直接停止它
        this.getAnimatableInstanceCache()
                .getManagerForId(this.getId())
                .getAnimationControllers()
                .get("controller1")
                .stop();
    }
}
