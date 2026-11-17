package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.PotionInit;
import com.joy187.re8joymod.init.SoundInit;
import com.joy187.re8joymod.util.CommonFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EntitySaddler extends Monster implements GeoEntity {

    // ==================== 状态常量 ====================
    public static final int STATE_IDLE = 0;
    public static final int STATE_ATTACK = 1;     // 扔药水(3) / 尖刺(5)
    public static final int STATE_ATTACK2 = 2;    // 抓取(4)
    public static final int STATE_ATTACK3 = 3;    // 黑浪推击(6) - 替换了原来的 STAGGER(3)
    public static final int STATE_STAGGER = 4;    // 硬直 (替换了原来的 RECOVER)

    // ==================== 硬直参数（已放宽，降低输出惩罚）====================
    private static final int STAGGER_DURATION = 30;
    private static final int SKILLS_PER_STAGGER_CHECK = 6;   // 4 -> 6，硬直触发更稀疏
    private static final float STAGGER_CHANCE = 0.25F;       // 0.35 -> 0.25

    // ==================== 技能节奏参数（缩短循环间隔）====================
    public static final int SKILL_TOTAL_TICKS = 40;          // 50 -> 40，单轮技能总长
    public static final int SKILL_COOLDOWN = 12;             // 30 -> 12，技能后冷却
    public static final double MAX_SKILL_RANGE = 32.0D;      // 超距不再空挥技能，交给导航接近
    /** animation.saddler.attack2 length ≈ 1.08333s */
    private static final double GRAB_ANIM_SECONDS = 1.08333D;
    private static final int GRAB_CATCH_START = 8;
    private static final int GRAB_CATCH_END = 12;
    private static final int GRAB_BITE_TICK = CommonFunctions.animSecondsToLastTick(GRAB_ANIM_SECONDS);
    private static final int GRAB_HOLD_TICKS = CommonFunctions.animHoldTicks(GRAB_ANIM_SECONDS);

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(
            this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS))
            .setDarkenScreen(true);

    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntitySaddler.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(EntitySaddler.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> STAGGER_STATE = SynchedEntityData.defineId(EntitySaddler.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Float> LOCK_X = SynchedEntityData.defineId(EntitySaddler.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Float> LOCK_Y = SynchedEntityData.defineId(EntitySaddler.class, EntityDataSerializers.FLOAT);
    public static final EntityDataAccessor<Float> LOCK_Z = SynchedEntityData.defineId(EntitySaddler.class, EntityDataSerializers.FLOAT);

    public int explosionPower = 5, attr = 0, pre = 0;
    public boolean grabbed = false;
    /** 实体侧抓取倒数，避免 AttackGoal 中断导致秒放无伤 */
    private int grabTicksLeft = 0;

    private int skillCount = 0;
    private int staggerTicks = 0;
    private int skillCooldown = 0;

    public boolean isGrabHolding() {
        // 仅以实体侧倒数为准，避免 grabbed 残留导致永久“抓取中”
        return this.grabTicksLeft > 0;
    }

    public EntitySaddler(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 200;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 200.0D).
                add(Attributes.MOVEMENT_SPEED, 0.24D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.75D).
                add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p) ->
            p.getMobType() != MobType.ILLAGER && p.attackable() && !(p instanceof EntitySaddler);

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AttackGoal(this));
        // ★ 新增近战兜底：技能全 miss 时，贴脸仍会触发 doHurtTarget 保底一刀
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));

        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, AbstractVillager.class, 8.0F));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, IronGolem.class, 8.0F));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EntityRe8Dimi.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    // ★ 新增：近战兜底伤害出口，配合 MeleeAttackGoal 使用
    @Override
    public boolean doHurtTarget(Entity target) {
        // 1. 获取基础攻击力
        float dmg = (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);

        // 2. 如果目标是生物，计算体型压制倍率
        if (target instanceof LivingEntity livingTarget) {
            float sizeMult = CommonFunctions.getSizeDamageMultiplier(this, livingTarget);
            // 玩家默认返回 1.0，怪物按比例返回 1.0 ~ 2.0
            dmg *= sizeMult;
        }

        // 3. 结算伤害
        boolean hit = target.hurt(this.damageSources().mobAttack(this), dmg);

//        if (hit) {
//            this.doHandSwap(HandSwap.SWAP);
//        }
        return hit;
    }

    // ==================== 投掷物免疫 ====================
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!level().isClientSide()) {
            Entity direct = source.getDirectEntity();
            if (direct instanceof Projectile || source.is(net.minecraft.tags.DamageTypeTags.IS_PROJECTILE)) {
                this.level().playSound(null, this.blockPosition(), SoundEvents.SHIELD_BLOCK,
                        this.getSoundSource(), 1.0F, 0.8F);
                return false;
            }
            if (this.staggerTicks > 0) {
                return super.hurt(source, amount * 0.5F);
            }
            if (source.getEntity() instanceof EntityFaceEater) {
                return super.hurt(source, 1);
            }
            return super.hurt(source, amount);
        }
        return false;
    }

    // ==================== 主 AI ====================
    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (this.skillCooldown > 0) this.skillCooldown--;

        // 抓取维持（与 Goal 解耦）
        if (this.grabTicksLeft > 0) {
            this.getNavigation().stop();
            this.attr = Math.max(this.attr, GRAB_HOLD_TICKS - this.grabTicksLeft);
            int left = CommonFunctions.tickGrabHold(this, this.grabTicksLeft, this.getTarget());
            if (left == CommonFunctions.GRAB_ESCAPED) {
                this.grabTicksLeft = 0;
                this.grabbed = false;
                CommonFunctions.releaseGrabPassengers(this);
                this.setAttackingState(STATE_IDLE);
                this.beginStagger(); // 玩家挣脱 → 硬直
            } else {
                this.grabTicksLeft = left;
                if (left <= 0) {
                    this.grabbed = false;
                    if (this.getAttckingState() == STATE_ATTACK2) {
                        this.setAttackingState(STATE_IDLE);
                    }
                }
            }
        }

        // ---- 1. 硬直拦截 ----
        if (this.staggerTicks > 0) {
            this.staggerTicks--;
            this.getNavigation().stop();
            this.setDeltaMovement(0, Math.min(0, this.getDeltaMovement().y), 0);
            if (this.staggerTicks == 0) {
                this.entityData.set(STAGGER_STATE, 0);
                this.setAttackingState(STATE_IDLE); // 移除 recover，直接回到 idle
            }
            this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
            return;
        }

        // ---- 2. 常驻逻辑 ----
        if (this.getHealth() < 200.F) {
            this.level().addParticle(ParticleTypes.SMOKE,
                    this.position().x + this.random.nextGaussian() * 0.3F,
                    this.position().y + this.random.nextGaussian() * 0.3F,
                    this.position().z + this.random.nextGaussian() * 0.3F,
                    0.0D, 0.0D, 0.0D);
            if (this.hasEffect(MobEffects.JUMP)) {
                this.addEffect(new MobEffectInstance(MobEffects.JUMP, 600, 1, false, false));
            }
        }
        if (this.getHealth() >= 20.0F && this.getHealth() <= 30.0F) {
            for (int i = 0; i < 5; i++) this.heal(1.0F * this.random.nextFloat());
        }
        if (this.getHealth() >= 60.0F && this.getHealth() <= 65.0F) {
            for (int i = 0; i < 4; i++) this.heal(2F * this.random.nextFloat());
        }
        if (this.getHealth() <= 10.0F) {
            this.convertTo(EntityInit.SADDLER2.get(), true);
            return;
        }

        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    // ==================== 硬直逻辑 ====================
    public boolean isStaggered() {
        return this.staggerTicks > 0;
    }

    @Override
    public boolean isPushable() {
        return !this.isStaggered() && super.isPushable();
    }

    @Override
    public void push(Entity entity) {
        if (this.isStaggered()) {
            return;
        }
        super.push(entity);
    }

    public void onSkillFinished() {
        if (this.level().isClientSide || this.isStaggered()) return;

        this.skillCount++;
        if (this.skillCount >= SKILLS_PER_STAGGER_CHECK) {
            this.skillCount = 0;
            if (this.random.nextFloat() < STAGGER_CHANCE) {
                this.beginStagger();
            }
        }
    }

    public void beginStagger() {
        if (this.isStaggered()) return;
        this.staggerTicks = STAGGER_DURATION;
        this.entityData.set(STAGGER_STATE, 1);
        this.setAttackingState(STATE_STAGGER);
        this.triggerStateAnim(STATE_STAGGER);
        this.getNavigation().stop();
        this.setDeltaMovement(Vec3.ZERO);
        this.level().playSound(null, this.blockPosition(), SoundEvents.RAVAGER_STUNNED, SoundSource.HOSTILE, 1.1F, 0.85F);
    }

    // ==================== 动画控制器 ====================
    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.entityData.get(STATE) != STATE_IDLE) {
            return PlayState.STOP;
        }
        if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.saddler.death"));
            return PlayState.CONTINUE;
        }
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.saddler.walk"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.saddler.idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "controller", 0, this::predicate));
        // 删除了 recover，新增了 attack3
        AnimationController<?> attackController = new AnimationController<>(this, "controller1", 3, state -> PlayState.STOP)
                .triggerableAnim("attack", RawAnimation.begin().thenPlay("animation.saddler.attack"))
                .triggerableAnim("attack2", RawAnimation.begin().thenPlay("animation.saddler.attack2"))
                .triggerableAnim("attack3", RawAnimation.begin().thenPlay("animation.saddler.attack3"))
                .triggerableAnim("stagger", RawAnimation.begin().thenPlay("animation.saddler.stagger"));
        data.add(attackController);
    }

    private void triggerStateAnim(int state) {
        String name = switch (state) {
            case STATE_ATTACK -> "attack";
            case STATE_ATTACK2 -> "attack2";
            case STATE_ATTACK3 -> "attack3";
            case STATE_STAGGER -> "stagger";
            default -> null;
        };
        if (name != null) {
            this.triggerAnim("controller1", name);
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    // ==================== 状态存取 ====================
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DEFENDSTATE, 0);
        this.entityData.define(STAGGER_STATE, 0);
        this.entityData.define(LOCK_X, 0f);
        this.entityData.define(LOCK_Y, 0f);
        this.entityData.define(LOCK_Z, 0f);
    }

    public int getAttckingState() { return this.entityData.get(STATE); }
    public void setAttackingState(int time) { this.entityData.set(STATE, time); }
    public int getDefendingState() { return this.entityData.get(DEFENDSTATE); }
    public void setDefendingState(int time) { this.entityData.set(DEFENDSTATE, time); }

    public Vec3 getLockPoint() {
        return new Vec3(this.entityData.get(LOCK_X), this.entityData.get(LOCK_Y), this.entityData.get(LOCK_Z));
    }
    public void setLockPoint(Vec3 p) {
        this.entityData.set(LOCK_X, (float) p.x);
        this.entityData.set(LOCK_Y, (float) p.y);
        this.entityData.set(LOCK_Z, (float) p.z);
    }

    // ==================== AttackGoal ====================
    static class AttackGoal extends Goal {
        private final EntitySaddler parentEntity;
        private int attackTimer = 0;
        private int activeSkill = 0;
        private Vec3 lockPoint = null;

        public AttackGoal(EntitySaddler ghast) {
            this.parentEntity = ghast;
            this.setFlags(java.util.EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity target = this.parentEntity.getTarget();
            if (target == null || !target.isAlive()) return false;
            if (this.parentEntity.isStaggered()) return false;
            if (this.parentEntity.skillCooldown > 0) return false;
            // ★ 新增距离限制：目标超出技能射程时不起手空挥，交由 MeleeAttackGoal / 导航接近
            if (this.parentEntity.distanceTo(target) > MAX_SKILL_RANGE) return false;
            return true;
        }

        @Override
        public boolean canContinueToUse() {
            return this.activeSkill != 0
                    || this.parentEntity.isGrabHolding()
                    || this.canUse();
        }

        public void start() {
            super.start();
            this.parentEntity.setAggressive(true);
            this.attackTimer = 0;
            this.activeSkill = 0;
        }

        @Override
        public void stop() {
            super.stop();
            this.parentEntity.setAggressive(false);
            // 抓取由实体侧 grabTicksLeft 结算，Goal 中断不再秒放
            if (!this.parentEntity.isGrabHolding()) {
                this.parentEntity.setAttackingState(STATE_IDLE);
            }
            this.attackTimer = -1;
            this.activeSkill = 0;
        }

        public void tick() {
            if (this.parentEntity.isStaggered()) {
                this.parentEntity.getNavigation().stop();
                return;
            }

            LivingEntity target = this.parentEntity.getTarget();
            boolean hasTarget = target != null && target.isAlive();

            // 抓取中即使丢目标/视线也继续维持，交给实体侧倒数咬击
            if (this.parentEntity.isGrabHolding()) {
                ++this.attackTimer;
                this.parentEntity.attr = this.attackTimer;
                if (hasTarget) {
                    this.parentEntity.lookAt(target, 30.0F, 30.0F);
                    CommonFunctions.keepGrab(this.parentEntity, target);
                }
                return;
            }

            // 实体侧已清掉攻击 state（例如抓取结算完毕），Goal 同步收招
            if (this.activeSkill != 0
                    && this.parentEntity.getAttckingState() == STATE_IDLE
                    && this.attackTimer > GRAB_CATCH_END) {
                this.parentEntity.grabbed = false;
                this.attackTimer = -5;
                this.activeSkill = 0;
                this.parentEntity.skillCooldown = SKILL_COOLDOWN;
                this.parentEntity.onSkillFinished();
                return;
            }

            // 目标丢失：回 idle（进行中的非抓取技能直接中止）
            if (!hasTarget) {
                if (this.activeSkill != 0 || this.parentEntity.getAttckingState() != STATE_IDLE) {
                    this.parentEntity.setAttackingState(STATE_IDLE);
                    this.activeSkill = 0;
                    this.attackTimer = 0;
                    this.parentEntity.grabbed = false;
                }
                return;
            }

            // 丢视线：技能进行中继续推完；未起手则追击
            if (!this.parentEntity.hasLineOfSight(target)) {
                if (this.activeSkill == 0) {
                    this.parentEntity.getNavigation().moveTo(target, 0.8D);
                    return;
                }
                // fall through：继续推进当前技能到 SKILL_TOTAL_TICKS
            }

            ++this.attackTimer;
            this.parentEntity.lookAt(target, 30.0F, 30.0F);

            // ---- 起手选技能 ----
            if (this.attackTimer == 1) {
                this.parentEntity.getNavigation().stop();
                this.activeSkill = pickSkill(target);
                this.lockPoint = target.position();
                this.parentEntity.setLockPoint(this.lockPoint);

                if (this.activeSkill == 4) { // 抓取
                    this.parentEntity.setAttackingState(STATE_ATTACK2);
                    this.parentEntity.triggerStateAnim(STATE_ATTACK2);
                    this.parentEntity.getNavigation().moveTo(target, 0.35D);
                } else if (this.activeSkill == 3 || this.activeSkill == 5) { // 扔药水 / 尖刺
                    this.parentEntity.setAttackingState(STATE_ATTACK);
                    this.parentEntity.triggerStateAnim(STATE_ATTACK);
                } else if (this.activeSkill == 6) { // 黑浪推击
                    this.parentEntity.setAttackingState(STATE_ATTACK3);
                    this.parentEntity.triggerStateAnim(STATE_ATTACK3);
                }
            }

            // ---- 技能执行 ----
            if (this.activeSkill == 3) tickPotionThrow(target);
            else if (this.activeSkill == 4) tickGrab(target);
            else if (this.activeSkill == 5) tickTentacleSpike(target);
            else if (this.activeSkill == 6) tickBlackWave(target);

            // ---- 结束 ----
            if (this.attackTimer >= SKILL_TOTAL_TICKS && !this.parentEntity.isGrabHolding()) {
                this.parentEntity.setAttackingState(STATE_IDLE);
                this.attackTimer = -5;
                this.activeSkill = 0;
                this.parentEntity.skillCooldown = SKILL_COOLDOWN; // 技能间隔冷却（30 -> 12）
                this.parentEntity.onSkillFinished();
            }
        }

        private int pickSkill(LivingEntity target) {
            double dist = this.parentEntity.distanceTo(target);
            int r = this.parentEntity.random.nextInt(100);

            // 技能池：抓取、药水、尖刺、黑浪
            if (dist < 4.5D) {
                if (r < 40) return 4; // 近战抓取
                if (r < 80) return 6; // 贴脸黑浪推击
                return 5;             // 近战尖刺
            } else {
                if (r < 40) return 3; // 远程药水
                if (r < 80) return 6; // 中距离黑浪
                return 5;             // 中距离尖刺
            }
        }

        // ---- 黑浪推击 (Skill 6) ----
        private void tickBlackWave(LivingEntity target) {
            // ★ 起手延迟 20 -> 12，缩短玩家走位窗口
            if (this.attackTimer == 12) {
                Level level = this.parentEntity.level();
                Vec3 eyePos = this.parentEntity.position().add(0, 1.0, 0); // 从胸口生成

                // ★ 实时计算 Boss -> 目标的方位角
                Vec3 toTarget = target.position().add(0, target.getBbHeight() * 0.5, 0).subtract(eyePos);
                float yaw = (float) Mth.atan2(toTarget.z, toTarget.x) * Mth.RAD_TO_DEG - 90.0F;

                // 1. 生成黑浪实体（作为视觉效果和第一段伤害）
                EntityBlackWave.shock(level, this.parentEntity, eyePos, yaw, 8.0F);

                level.playSound(null, this.parentEntity.blockPosition(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.HOSTILE, 1.5F, 0.8F);

                // 2. 物理推击逻辑：检测前方 8 格、120度扇形内的所有敌对实体
                double range = 8.0D;
                double angle = Math.toRadians(60); // 左右各60度，共120度扇形
                for (LivingEntity living : level.getEntitiesOfClass(LivingEntity.class, this.parentEntity.getBoundingBox().inflate(range),
                        (e) -> e != this.parentEntity && e.isAlive() && !e.isAlliedTo(this.parentEntity))) {

                    // 计算实体与 Boss 的相对方向
                    Vec3 diff = living.position().subtract(this.parentEntity.position());
                    double distSqr = diff.horizontalDistanceSqr();
                    if (distSqr > range * range) continue;

                    // 检查是否在施法正前方
                    Vec3 look = this.parentEntity.getLookAngle();
                    Vec3 diffNormalized = new Vec3(diff.x, 0, diff.z).normalize();
                    double dot = look.dot(diffNormalized);
                    if (dot > Math.cos(angle)) {
                        // 施加推力（远离 Boss），水平速度 1.5，垂直速度 0.4（击飞）
                        Vec3 pushDir = diffNormalized.scale(1.5D);
                        living.push(pushDir.x, 0.4D, pushDir.z);
                        // 清除无敌帧并造成 10% 最大生命值的真实伤害
                        living.invulnerableTime = 0;
                        living.hurt(living.damageSources().mobAttack(this.parentEntity), living.getMaxHealth() * 0.1F);
                    }
                }
            }

            if (this.attackTimer == 20) {
                Level level = this.parentEntity.level();
                Vec3 eyePos = this.parentEntity.position().add(0, 1.0, 0); // 从胸口生成

                // ★ 实时计算 Boss -> 目标的方位角
                Vec3 toTarget = target.position().add(0, target.getBbHeight() * 0.5, 0).subtract(eyePos);
                float yaw = (float) Mth.atan2(toTarget.z, toTarget.x) * Mth.RAD_TO_DEG - 90.0F;

                // 1. 生成黑浪实体（作为视觉效果和第一段伤害）
                EntityBlackWave.shock(level, this.parentEntity, eyePos, yaw, 8.0F);

                level.playSound(null, this.parentEntity.blockPosition(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.HOSTILE, 1.5F, 0.8F);
            }

            if (this.attackTimer == 25) {
                Level level = this.parentEntity.level();
                Vec3 eyePos = this.parentEntity.position().add(0, 1.0, 0); // 从胸口生成

                // ★ 实时计算 Boss -> 目标的方位角
                Vec3 toTarget = target.position().add(0, target.getBbHeight() * 0.5, 0).subtract(eyePos);
                float yaw = (float) Mth.atan2(toTarget.z, toTarget.x) * Mth.RAD_TO_DEG - 90.0F;

                // 1. 生成黑浪实体（作为视觉效果和第一段伤害）
                EntityBlackWave.shock(level, this.parentEntity, eyePos, yaw, 8.0F);

                level.playSound(null, this.parentEntity.blockPosition(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.HOSTILE, 1.5F, 0.8F);
            }
        }

        // ---- 扔药水 ----
        private void tickPotionThrow(LivingEntity target) {
            // ★ 起手延迟 25/30 -> 15/20；目标点改为「实时位置 + 速度预判」，scatter 收紧
            if (this.attackTimer == 15 || this.attackTimer == 20) {
                Vec3 aim = predictAimPoint(target);

                if (this.attackTimer == 15) {
                    throwPoisonPotionAt(aim.add(0, 0.9, 0));
                } else {
                    Vec3 scatter = new Vec3(
                            (this.parentEntity.random.nextDouble() - 0.5D) * 2.0D,
                            0.9D,
                            (this.parentEntity.random.nextDouble() - 0.5D) * 2.0D);
                    throwPoisonPotionAt(aim.add(scatter));
                }
            }
        }

        // 预判瞄准点：取预测位置与实时位置的中间值，降低预判误差；目标丢失回退 lockPoint
        private Vec3 predictAimPoint(LivingEntity target) {
            if (target == null || !target.isAlive()) {
                return this.lockPoint != null ? this.lockPoint : this.parentEntity.position();
            }
            double dist = this.parentEntity.distanceTo(target);
            int flightTicks = (int) (dist / 0.4);
            Vec3 targetPos = target.position();
            Vec3 targetVel = target.getDeltaMovement();
            Vec3 predicted = targetPos.add(targetVel.x * flightTicks, 0, targetVel.z * flightTicks);
            return predicted.lerp(targetPos, 0.5);
        }

        private void throwPoisonPotionAt(Vec3 to) {
            Vec3 from = this.parentEntity.position().add(0, 1.6, 0);
            Vec3 dir = to.subtract(from).normalize();
            ThrownPotion potion = new ThrownPotion(this.parentEntity.level(), this.parentEntity);
            potion.setItem(makePoisonPotion());
            potion.setPos(from.x, from.y, from.z);
            potion.shoot(dir.x, dir.y + 0.15, dir.z, 1.1F, 1.0F);
            this.parentEntity.level().addFreshEntity(potion);
        }

        // ---- 抓取（对齐 animation.saddler.attack2 ≈ 1.083s，末帧结算 30% 最大生命） ----
        private void tickGrab(LivingEntity target) {
            this.parentEntity.attr = this.attackTimer;

            if (this.attackTimer < GRAB_CATCH_START) {
                if (this.parentEntity.distanceToSqr(target) > 12.25D) {
                    this.parentEntity.getNavigation().moveTo(target, 0.35D);
                } else {
                    this.parentEntity.getNavigation().stop();
                }
                return;
            }

            this.parentEntity.getNavigation().stop();

            // 动画前段抓取窗口；抓住后由实体侧倒数到动画末帧咬击
            if (this.attackTimer >= GRAB_CATCH_START && this.attackTimer <= GRAB_CATCH_END) {
                if (!this.parentEntity.grabbed
                        && this.parentEntity.distanceToSqr(target) <= 12.25D
                        && CommonFunctions.tryStartGrab(this.parentEntity, target, 3.5F)) {
                    this.parentEntity.grabbed = true;
                    // 从当前帧数到动画末帧的剩余时长
                    this.parentEntity.grabTicksLeft = Math.max(1, GRAB_BITE_TICK - this.attackTimer + 1);
                    EntityFaceEater e = new EntityFaceEater(EntityInit.FE.get(), this.parentEntity.level());
                    e.copyPosition(target);
                    e.setTarget(this.parentEntity.getTarget());
                    this.parentEntity.level().addFreshEntity(e);
                }
            }

            if (this.parentEntity.grabbed) {
                CommonFunctions.keepGrab(this.parentEntity, target);
            }

            // 没抓到时，动画末帧近战兜底
            if (this.attackTimer == GRAB_BITE_TICK
                    && !this.parentEntity.grabbed
                    && this.parentEntity.grabTicksLeft <= 0
                    && this.parentEntity.distanceToSqr(target) <= 16.0D) {
                target.invulnerableTime = 0;
                float dmg = (float) this.parentEntity.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.8F;
                target.hurt(target.damageSources().mobAttack(this.parentEntity), dmg);
                Vec3 kb = target.position().subtract(this.parentEntity.position()).normalize().multiply(0.6, 0, 0.6);
                target.setDeltaMovement(target.getDeltaMovement().add(kb.x, 0.15, kb.z));
            }
        }

        // ---- 尖刺 ----
        private void tickTentacleSpike(LivingEntity target) {
            // ★ 起手延迟 20 -> 12；中心点实时取目标位置；3 柱 2.2 -> 5 柱 2.8
            if (this.attackTimer == 12) {
                Level level = this.parentEntity.level();
                Vec3 c = (target != null && target.isAlive())
                        ? target.position()
                        : (this.lockPoint != null ? this.lockPoint : this.parentEntity.position());

                Vec3 p0 = EntityMyceliumSpike.ground(level, c.x, c.y, c.z);
                EntityMyceliumSpike.rise(level, this.parentEntity, p0, 8.0F, 0);

                int n = 5;
                double radius = 2.8;
                for (int i = 0; i < n; i++) {
                    double a = Math.PI * 2 * i / n + this.parentEntity.random.nextDouble() * 0.4;
                    double x = c.x + Math.cos(a) * radius;
                    double z = c.z + Math.sin(a) * radius;
                    Vec3 p = EntityMyceliumSpike.ground(level, x, c.y, z);
                    EntityMyceliumSpike.rise(level, this.parentEntity, p, 6.0F, 3 + i * 2);
                }
            }
        }

        private static ItemStack makePoisonPotion() {
            ItemStack st = new ItemStack(Items.SPLASH_POTION);
            PotionUtils.setPotion(st, PotionInit.DEADLY_POTION.get()); // 改用伤害药水，确保有直接伤害
            return st;
        }
    }

    // ==================== Boss 血条 ====================
    public void startSeenByPlayer(ServerPlayer p) {
        super.startSeenByPlayer(p);
        this.bossInfo.addPlayer(p);
    }

    public void stopSeenByPlayer(ServerPlayer p) {
        super.startSeenByPlayer(p);
        this.bossInfo.removePlayer(p);
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        int co = this.random.nextInt(3);
        if (co == 0) return SoundInit.ENTITY_SADDLER_AMBIENT1.get();
        if (co == 1) return SoundInit.ENTITY_SADDLER_AMBIENT2.get();
        return SoundEvents.RAVAGER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) { return SoundEvents.SLIME_HURT; }
    protected SoundEvent getDeathSound() { return SoundInit.ENTITY_SADDLER_DEATH.get(); }

    // ==================== 骑乘 ====================
    @Override
    public void positionRider(@NotNull Entity passenger, MoveFunction moveFunction) {
        if (!this.isGrabHolding()) {
            super.positionRider(passenger, moveFunction);
            return;
        }
        double raiseUp = CommonFunctions.grabRaiseUp(this.attr, 10);
        float pullIn = CommonFunctions.grabPullIn(this.attr, 15);
        if (!CommonFunctions.positionGrabbedPassenger(this, passenger, raiseUp, pullIn, true, false)) {
            super.positionRider(passenger, moveFunction);
        }
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengers().isEmpty();
    }
}
