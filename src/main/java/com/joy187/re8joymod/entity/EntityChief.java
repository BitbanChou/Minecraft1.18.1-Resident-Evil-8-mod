package com.joy187.re8joymod.entity;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EffectInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.init.SoundInit;
import com.joy187.re8joymod.util.CommonFunctions;
import com.mojang.blaze3d.vertex.PoseStack.Pose;

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
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
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

public class EntityChief extends Ravager implements GeoEntity {

    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    // ===== 动画名 =====
    private static final String ANIM_WALK = "animation.chief2.walk";
    private static final String ANIM_IDLE = "animation.chief2.idle";
    private static final String ANIM_ATK1 = "animation.chief2.attack";    // 触手突刺（原地）
    private static final String ANIM_ATK2 = "animation.chief2.attack2";   // 抓取
    private static final String ANIM_ATK3 = "animation.chief2.kick";      // 横扫/踢
    private static final String ANIM_RECOVER = "animation.chief2.recover"; // 硬直/后摇
    /** animation.chief2.attack2 length = 1.0s */
    private static final double GRAB_ANIM_SECONDS = 1.0D;
    private static final int GRAB_START_TIMER = 18;
    private static final int GRAB_HOLD_TICKS = CommonFunctions.animHoldTicks(GRAB_ANIM_SECONDS);
    private static final int GRAB_CATCH_RANGE_SQR = 16; // 4 blocks
    /** 实体侧抓取倒数：与 AttackGoal 解耦，避免 Goal 中断导致秒放无伤 */
    private int grabTicksLeft = 0;

    // ===== 基础 =====
    private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(
            this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    public int explosionPower = 5, attr = 0, pre = 0;
    public boolean isaoe = false;

    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityChief.class,
            EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntityChief.class,
            EntityDataSerializers.INT);

    // ===== 硬直 / recover =====
    private static final int STUN_TICKS = 30;      // 1.5 秒硬直（触手突刺后）
    private int stunTicks = 0;
    private static final int RECOVER_TICKS = 20;   // 1 秒后摇（抓取/横扫后）
    private int recoverTimer = 0;

    // ===== 出招计数 → 强制硬直 =====
    private int attacksSinceStun = 0;
    private int nextStunThreshold = 3;

    // ===== 触手突刺：连击计数 =====
    private int thrustCount = 0;      // 本次突刺已生成几波
    private int thrustMax = 2;        // 1 或 2 波（随机）

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p) ->
            p.getMobType() != MobType.UNDEAD && p.attackable();

    public EntityChief(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 150;
        this.isNonBoss();
        this.isSunSensitive();
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }

    protected boolean isSunSensitive() { return true; }

    // ==================== 属性 ====================

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 200.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.29D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.50D)
                .add(Attributes.ATTACK_DAMAGE, 9.0D);
    }

    // ==================== Goals ====================

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.8D) {
            @Override
            public boolean canUse() {
                return EntityChief.this.getAttckingState() == 0
                        && EntityChief.this.recoverTimer <= 0
                        && EntityChief.this.stunTicks <= 0
                        && super.canUse();
            }
            @Override
            public boolean canContinueToUse() {
                return EntityChief.this.getAttckingState() == 0
                        && EntityChief.this.recoverTimer <= 0
                        && EntityChief.this.stunTicks <= 0
                        && super.canContinueToUse();
            }
        });
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, AbstractVillager.class, 8.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, IronGolem.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityRe8Dimi.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    // ==================== 状态存取 ====================

    public int getAttckingState() { return this.entityData.get(STATE); }

    public void setAttackingState(int time) {
        int prev = this.entityData.get(STATE);
        this.entityData.set(STATE, time);
        if (time != prev) {
            if (time == 1) this.triggerAnim("controller1", "atk1");
            else if (time == 2) this.triggerAnim("controller1", "atk2");
            else if (time == 3) this.triggerAnim("controller1", "atk3");
        }
    }

    public int getDefendingState() { return this.entityData.get(DEFENDSTATE); }
    public void setDefendingState(int time) { this.entityData.set(DEFENDSTATE, time); }

    public int getStunTicks() { return this.stunTicks; }

    @Override
    public boolean isPushable() {
        return this.stunTicks <= 0 && this.recoverTimer <= 0 && super.isPushable();
    }

    @Override
    public void push(Entity entity) {
        if (this.stunTicks > 0 || this.recoverTimer > 0) {
            return;
        }
        super.push(entity);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DEFENDSTATE, 0);
    }

    // ==================== NBT ====================

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (this.hasCustomName()) this.bossInfo.setName(this.getDisplayName());
    }

    public void addAdditionalSaveData(CompoundTag tag) { super.addAdditionalSaveData(tag); }

    public void setCustomName(@Nullable Component name) {
        super.setCustomName(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    // ==================== BossBar ====================

    public boolean isNonBoss() { return false; }

    public void startSeenByPlayer(ServerPlayer p) {
        super.startSeenByPlayer(p);
        this.bossInfo.addPlayer(p);
    }

    public void stopSeenByPlayer(ServerPlayer p) {
        super.stopSeenByPlayer(p);
        this.bossInfo.removePlayer(p);
    }

    // ==================== 声音 ====================

    @Override
    protected SoundEvent getAmbientSound() {
        int co = this.random.nextInt(3);
        if (co == 0) return SoundInit.ENTITY_CHIEF_AMBIENT1.get();
        if (co == 1) return SoundInit.ENTITY_CHIEF_AMBIENT2.get();
        return SoundEvents.RAVAGER_ROAR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource src) {
        return this.random.nextInt(2) == 0 ? SoundEvents.RAVAGER_HURT : SoundInit.ENTITY_HESEN_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() { return SoundInit.ENTITY_CHIEF_DEATH.get(); }

    protected float getStandingEyeHeight(Pose pose, EntityDimensions dims) { return 1.5F; }

    // ==================== AI Step ====================

    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide && this.grabTicksLeft > 0) {
            this.getNavigation().stop();
            this.attr = Math.max(this.attr, GRAB_HOLD_TICKS - this.grabTicksLeft);
            int left = CommonFunctions.tickGrabHold(this, this.grabTicksLeft, this.getTarget());
            if (left == CommonFunctions.GRAB_ESCAPED) {
                // 玩家挣脱：无伤放开，Boss 进硬直
                this.grabTicksLeft = 0;
                CommonFunctions.releaseGrabPassengers(this);
                this.setAttackingState(0);
                this.stunTicks = STUN_TICKS;
                this.triggerAnim("controller1", "recover");
                this.playSound(SoundEvents.RAVAGER_STUNNED, 1.0F, 0.8F);
            } else {
                this.grabTicksLeft = left;
                if (this.grabTicksLeft <= 0 && this.getAttckingState() == 2) {
                    // 未挣脱：末 tick 已咬击，进入后摇
                    this.setAttackingState(0);
                    this.recoverTimer = RECOVER_TICKS;
                    this.triggerAnim("controller1", "recover");
                }
            }
        }
        Random ran = new Random();
        int co = ran.nextInt(4);
        if (co == 1 && this.attr != 2 && this.attr != 3) {
            for (int i = 0; i < 30; i++) {
                float deltaOmega = 1.0f * i;
                Vec3 pos = new Vec3(this.position().x + Math.sin(deltaOmega),
                        this.position().y + 0.1f * this.random.nextFloat(),
                        this.position().z + Math.cos(deltaOmega));
                this.level().addParticle(ParticleInit.FLAME_PARTICLE.get(), pos.x, pos.y, pos.z,
                        this.random.nextGaussian() * 0.07, this.random.nextGaussian() * 0.07, this.random.nextGaussian() * 0.07);
            }
        }
        if (this.entityData.get(STATE) == 3) this.defend();
    }

    public boolean isGrabHolding() {
        return this.grabTicksLeft > 0;
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        Random ran = new Random();
        if (this.getHealth() < 200F) {
            this.level().addParticle(ParticleTypes.SMOKE,
                    this.position().x + this.random.nextGaussian() * 0.3F,
                    this.position().y + this.random.nextGaussian() * 0.3F,
                    this.position().z + this.random.nextGaussian() * 0.3F, 0, 0, 0);
        }
        if (this.getHealth() >= 20F && this.getHealth() <= 30F) {
            for (int i = 0; i < 5; i++) this.heal(1.0F * ran.nextFloat());
        }
        if (this.getHealth() >= 60F && this.getHealth() <= 65F) {
            for (int i = 0; i < 4; i++) this.heal(2F * ran.nextFloat());
        }
        if (this.getHealth() <= 10.0F) {
            this.convertTo(EntityInit.CHIEF2.get(), true);
        }
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    private void defend() {
        if (!this.isAlive()) return;
        Vec3 c = this.getBoundingBox().getCenter();
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 10; i++) {
                float d = 1.0f * i;
                Vec3 p = new Vec3(c.x + 3 * Math.sin(d), c.y + j, c.z + 3 * Math.cos(d));
                this.level().addParticle(ParticleInit.DEFEND_PARTICLE.get(), p.x, p.y, p.z, 0, 0, 0);
            }
        this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
    }

    // ==================== 动画控制器（triggerableAnim） ====================

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
                .triggerableAnim("atk1", RawAnimation.begin().thenPlay(ANIM_ATK1))
                .triggerableAnim("atk2", RawAnimation.begin().thenPlay(ANIM_ATK2))
                .triggerableAnim("atk3", RawAnimation.begin().thenPlay(ANIM_ATK3))
                .triggerableAnim("recover", RawAnimation.begin().thenPlay(ANIM_RECOVER)));
        data.add(new AnimationController(this, "controller", 4, this::predicate));
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.stunTicks > 0 || this.recoverTimer > 0) return PlayState.STOP;
        if (this.getAttckingState() != 0) return PlayState.STOP;
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenLoop(ANIM_WALK));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenLoop(ANIM_IDLE));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return this.factory; }

    // ==================== tick ====================

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) return;

        // 硬直优先
        if (this.stunTicks > 0) {
            --this.stunTicks;
            this.getNavigation().stop();
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.1, 1, 0.1));
            if (this.getAttckingState() != 0) this.setAttackingState(0);
            // ★ 添加这行：硬直期间每 tick 散发灰烬/眩晕粒子
            CommonFunctions.spawnStunParticles(this);
            return;
        }

        // recover 后摇
        if (this.recoverTimer > 0) {
            --this.recoverTimer;
            this.getNavigation().stop();
            this.setDeltaMovement(0, this.getDeltaMovement().y, 0);
            if (this.getAttckingState() != 0) this.setAttackingState(0);
            return;
        }
    }

    // ==================== 体型压制普攻 ====================
    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if (entityIn instanceof LivingEntity target) {
            float sizeMult = CommonFunctions.getSizeDamageMultiplier(this, target);

            // 如果倍率 > 1，额外补一发真实伤害（不影响原版击退和动画）
            if (sizeMult > 1.0F) {
                float baseDamage = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
                float extraDamage = baseDamage * (sizeMult - 1.0F);
                target.hurt(target.damageSources().mobAttack(this), extraDamage);
            }
        }
        return super.doHurtTarget(entityIn);
    }

    @Override
    protected void updateControlFlags() {
        if (this.stunTicks > 0 || this.recoverTimer > 0) {
            this.goalSelector.setControlFlag(Goal.Flag.MOVE, false);
            this.goalSelector.setControlFlag(Goal.Flag.JUMP, false);
            this.goalSelector.setControlFlag(Goal.Flag.LOOK, false);
            return;
        }
        boolean flag = this.getTarget() != null && this.hasLineOfSight(this.getTarget());
        this.goalSelector.setControlFlag(Goal.Flag.LOOK, flag);
        super.updateControlFlags();
    }

    // ==================== 受击硬直 ====================

    @Override
    public boolean hurt(DamageSource source, float amount) {
        // 1. 计算减伤后的最终伤害（调用你刚写好的公共工具类）
        float finalDamage = CommonFunctions.applyNonPlayerReduction(this, source, amount);

        // 2. 扣血（传入 finalDamage）
        boolean hurt = super.hurt(source, amount);
        if (hurt && !this.level().isClientSide) {
            if (amount >= 6.0F && this.random.nextInt(5) == 0 && this.getAttckingState() == 0) {
                this.stunTicks = STUN_TICKS;
                this.triggerAnim("controller1", "recover");
            }
        }
        return hurt;
    }

    // ==================== AttackGoal ====================

    public static final Predicate<Entity> PIGEON_AREA = (entity) ->
            entity.isAlive() && !(entity instanceof EntityChief);

    static class AttackGoal extends Goal {
        private final EntityChief parentEntity;
        protected int attackTimer = 0;

        public AttackGoal(EntityChief ghast) { this.parentEntity = ghast; }

        public boolean canUse() { return this.parentEntity.getTarget() != null; }

        @Override
        public boolean canContinueToUse() {
            // 抓取/出招中途不要因瞬时空目标把 Goal 掐断
            return this.parentEntity.isGrabHolding()
                    || this.parentEntity.getAttckingState() != 0
                    || this.canUse();
        }

        public void start() { super.start(); this.parentEntity.setAggressive(true); }

        @Override
        public void stop() {
            super.stop();
            this.parentEntity.setAggressive(false);
            // 实体侧 grabTicksLeft 负责咬击；Goal 中断不再秒放
            if (!this.parentEntity.isGrabHolding()) {
                this.parentEntity.setAttackingState(0);
            }
            this.attackTimer = -1;
        }

        public void tick() {
            // 硬直 / recover 不推进
            if (this.parentEntity.getStunTicks() > 0 || this.parentEntity.recoverTimer > 0) {
                this.parentEntity.setAttackingState(0);
                return;
            }

            LivingEntity livingentity = this.parentEntity.getTarget();
            boolean hasTarget = livingentity != null && livingentity.isAlive();
            int state = this.parentEntity.getAttckingState();

            // 抓取由实体侧收尾；目标死了也不强行打断
            if (this.parentEntity.isGrabHolding()) {
                if (hasTarget) {
                    this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
                    CommonFunctions.keepGrab(this.parentEntity, livingentity);
                }
                return;
            }

            // 目标已死/丢失：立刻回 idle，避免 state!=0 永久卡住
            if (!hasTarget) {
                CommonFunctions.abortAttackToIdle(
                        this.parentEntity::getAttckingState,
                        this.parentEntity::setAttackingState,
                        t -> this.attackTimer = t,
                        this.attackTimer);
                return;
            }

            boolean los = this.parentEntity.hasLineOfSight(livingentity);
            // 已出招：即使丢视线也继续推进到收招；未出招且无视线则只追击
            if (!los && state == 0 && this.attackTimer < 18) {
                this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
                this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
                return;
            }

            ++this.attackTimer;
            Random rand = new Random();

            // ===== 选招 =====
            if (this.attackTimer == 1) {
                this.parentEntity.getNavigation().moveTo(livingentity, 1.2D);
            } else if (this.attackTimer == 18 && state == 0) {
                int roll = rand.nextInt(100);
                if (roll < 40) {
                    this.parentEntity.getNavigation().stop();
                    this.parentEntity.setDeltaMovement(0, this.parentEntity.getDeltaMovement().y, 0);
                    this.parentEntity.setAttackingState(1);
                    this.parentEntity.thrustCount = 0;
                    this.parentEntity.thrustMax = (rand.nextInt(100) < 30) ? 2 : 1;
                } else if (roll < 75) {
                    this.parentEntity.getNavigation().moveTo(livingentity, 1.5D);
                    this.parentEntity.setAttackingState(2);
                } else {
                    this.parentEntity.getNavigation().stop();
                    this.parentEntity.setDeltaMovement(0, this.parentEntity.getDeltaMovement().y, 0);
                    this.parentEntity.setAttackingState(3);
                }
            }

            state = this.parentEntity.getAttckingState();

            // ===== STATE 1：触手突刺 =====
            if (state == 1) {
                this.parentEntity.getNavigation().stop();
                this.parentEntity.setDeltaMovement(0, this.parentEntity.getDeltaMovement().y, 0);
                this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);

                if (this.attackTimer >= 18 && this.attackTimer <= 30 && (this.attackTimer - 18) % 6 == 0) {
                    this.parentEntity.spawnThrustSpikes(livingentity);
                }

                if (this.attackTimer >= 34) {
                    this.parentEntity.setAttackingState(0);
                    this.parentEntity.stunTicks = STUN_TICKS;
                    this.parentEntity.triggerAnim("controller1", "recover");
                    this.parentEntity.playSound(SoundEvents.RAVAGER_STUNNED, 1.0F, 0.8F);
                    this.attackTimer = -5;

                    this.parentEntity.attacksSinceStun++;
                    if (this.parentEntity.attacksSinceStun >= this.parentEntity.nextStunThreshold) {
                        this.parentEntity.attacksSinceStun = 0;
                        this.parentEntity.nextStunThreshold = 3 + rand.nextInt(3);
                    }
                }
            }

            // ===== STATE 2：抓取 =====
            if (state == 2) {
                this.parentEntity.getNavigation().stop();
                this.parentEntity.attr = Math.max(0, this.attackTimer - GRAB_START_TIMER);
                if (!this.parentEntity.isGrabHolding()
                        && this.parentEntity.distanceToSqr(livingentity) <= GRAB_CATCH_RANGE_SQR
                        && CommonFunctions.tryStartGrab(this.parentEntity, livingentity, 2.5F)) {
                    this.parentEntity.grabTicksLeft = GRAB_HOLD_TICKS;
                    this.parentEntity.attr = 0;
                }
                if (this.parentEntity.isGrabHolding()) {
                    CommonFunctions.keepGrab(this.parentEntity, livingentity);
                } else if (this.attackTimer >= GRAB_START_TIMER + GRAB_HOLD_TICKS) {
                    this.parentEntity.setAttackingState(0);
                    this.parentEntity.recoverTimer = RECOVER_TICKS;
                    this.parentEntity.triggerAnim("controller1", "recover");
                    this.attackTimer = -5;
                }
            }

            // ===== STATE 3：横扫/踢 =====
            if (state == 3) {
                this.parentEntity.getNavigation().stop();
                this.parentEntity.setDeltaMovement(0, this.parentEntity.getDeltaMovement().y, 0);
                if (this.attackTimer == 25) {
                    for (LivingEntity lvt : this.parentEntity.level().getEntitiesOfClass(LivingEntity.class,
                            this.parentEntity.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                        double dx = lvt.getX() - this.parentEntity.getX();
                        double dz = lvt.getZ() - this.parentEntity.getZ();
                        double dist = Math.max(Math.sqrt(dx * dx + dz * dz), 0.001D);
                        lvt.push(dx / dist * 2.0D, 0.2D, dz / dist * 2.0D);
                        lvt.hurt(this.parentEntity.damageSources().mobAttack(this.parentEntity),
                                lvt.getMaxHealth() * 0.1F);
                    }
                }
                if (this.attackTimer >= 34) {
                    this.parentEntity.setAttackingState(0);
                    this.parentEntity.recoverTimer = RECOVER_TICKS;
                    this.parentEntity.triggerAnim("controller1", "recover");
                    this.attackTimer = -5;
                }
            }

            this.parentEntity.lookAt(livingentity, 30.0F, 30.0F);
        }
    }

    // ==================== 触手突刺：生成地刺 ====================

    public void spawnThrustSpikes(LivingEntity target) {
        if (this.level().isClientSide || target == null) return;

        // 目标脚下 + 周围 3 个点
        Vec3 base = target.position();
        Vec3 ground = EntityMyceliumSpike.ground(this.level(), base.x, base.y, base.z);
        EntityMyceliumSpike.rise(this.level(), this, ground, 8.0F, 0);

        // 左右各一个
        Vec3 left = target.position().add(
                Math.cos(Math.toRadians(this.getYRot() + 90)) * 1.2,
                0,
                Math.sin(Math.toRadians(this.getYRot() + 90)) * 1.2);
        EntityMyceliumSpike.rise(this.level(), this, EntityMyceliumSpike.ground(this.level(), left.x, left.y, left.z), 6.0F, 2);

        Vec3 right = target.position().add(
                Math.cos(Math.toRadians(this.getYRot() - 90)) * 1.2,
                0,
                Math.sin(Math.toRadians(this.getYRot() - 90)) * 1.2);
        EntityMyceliumSpike.rise(this.level(), this, EntityMyceliumSpike.ground(this.level(), right.x, right.y, right.z), 6.0F, 4);

        this.playSound(SoundEvents.POINTED_DRIPSTONE_LAND, 1.0F, 0.5F);
    }

    // ==================== 抓取固定 ====================

    @Override
    public void positionRider(Entity passenger, MoveFunction moveFunction) {
        if (!this.isGrabHolding() && this.getAttckingState() != 2) {
            super.positionRider(passenger, moveFunction);
            return;
        }
        double raiseUp = CommonFunctions.grabRaiseUp(this.attr, 10);
        float pullIn = CommonFunctions.grabPullIn(this.attr, 15);
        CommonFunctions.positionGrabbedPassenger(this, passenger, raiseUp, pullIn, true, false);
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengers().isEmpty();
    }

    // ==================== 原有辅助方法 ====================

    private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks, float damage, float hpdamage, float airborne) {
        double minY = this.getY() - 2.0;
        double maxY = this.getY() + (double) mxy;
        float angle = (float) Math.PI / 180 * this.yBodyRot;
        float f = Mth.cos((float) (this.getYRot() * ((float) Math.PI / 180)));
        float f1 = Mth.sin((float) (this.getYRot() * ((float) Math.PI / 180)));
        double extraX = (float) distance * Mth.sin((float) ((float) (Math.PI + (double) angle)));
        double extraZ = (float) distance * Mth.cos((float) angle);
        double px = this.getX() + extraX + (double) (f * math);
        double pz = this.getZ() + extraZ + (double) (f1 * math);

        net.minecraft.world.phys.AABB selection = new net.minecraft.world.phys.AABB(px - 1, minY, pz - 1, px + 1, maxY, pz + 1);
        List<LivingEntity> hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
        for (LivingEntity entity : hit) {
            if (this.isAlliedTo(entity) || entity instanceof EntityHeisen || entity == this) continue;
            if (entity instanceof Player && ((Player) entity).getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK) && shieldbreakticks > 0) {
                this.disableShield(entity, shieldbreakticks);
            } else {
                boolean flag = entity.hurt(this.damageSources().mobAttack(this),
                        (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double) damage + (double) (entity.getMaxHealth() * hpdamage)));
                if (flag) entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, airborne, 0.0));
            }
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
}
