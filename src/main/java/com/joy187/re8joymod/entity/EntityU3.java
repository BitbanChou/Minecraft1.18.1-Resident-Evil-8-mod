package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.BlockInit;
import com.joy187.re8joymod.init.EntityInit;
import com.joy187.re8joymod.init.ParticleInit;
import com.joy187.re8joymod.util.CommonFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class EntityU3 extends EntityBeibaby {

    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);
    private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(
            this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS))
            .setDarkenScreen(true);

    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(
            EntityU3.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DEFENDSTATE = SynchedEntityData.defineId(
            EntityU3.class, EntityDataSerializers.INT);

    private int attr = 0, attackTimer = 0;
    private boolean zuan = false;
    /** animation.u3.attack2 length = 1.5s，用作近战抓取结算对齐 */
    private static final double GRAB_ANIM_SECONDS = 1.5D;
    private static final int GRAB_CATCH_TIMER = 10;
    private static final int GRAB_BITE_TIMER = CommonFunctions.animSecondsToLastTick(GRAB_ANIM_SECONDS); // relative from attack start offset
    private static final int GRAB_HOLD_TICKS = CommonFunctions.animHoldTicks(GRAB_ANIM_SECONDS);
    private int grabTicksLeft = 0;
    /** 玩家挣脱抓取后的硬直剩余 tick */
    private int grabEscapeStunTicks = 0;
    private static final int GRAB_ESCAPE_STUN = 30;

    // ===== 遁地 =====
    private int zuanTimer = 0;
    private static final int ZUAN_DURATION = 60;
    private Vec3 zuanArena = Vec3.ZERO;
    // ==============

    // ===== 远程冷却 =====
    private int rangedCooldown = 0;
    // ======================

    public static final AnimationState attackAnimationState = new AnimationState();
    public static final AnimationState attackAnimationState2 = new AnimationState();
    public static final AnimationState attackAnimationState3 = new AnimationState();
    public static final AnimationState tailClawAnimationState = new AnimationState();

    public EntityU3(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
        this.attackTimer = 0;
        this.zuan = false;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 250.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.FOLLOW_RANGE, 28.0D)
                .add(Attributes.ARMOR, 5.0D)
                .add(Attributes.ARMOR_TOUGHNESS, 6.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
    }

    private <E extends GeoAnimatable> PlayState predicate(software.bernie.geckolib.core.animation.AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.walk"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.idle"));
        return PlayState.CONTINUE;
    }

    public static <T extends EntityU3 & GeoAnimatable> AnimationController<T> genericAttackAnimation(
            T animatable, RawAnimation attackAnimation) {
        return new AnimationController<>(animatable, "Attack", 0, event -> {
            if (attackAnimationState.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.attack"));
                return PlayState.CONTINUE;
            }
            if (attackAnimationState2.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.attack2"));
                return PlayState.CONTINUE;
            }
            if (attackAnimationState3.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.attack3"));
                return PlayState.CONTINUE;
            }
            if (tailClawAnimationState.isStarted() && !(animatable.dead || animatable.getHealth() < 0.01 || animatable.isDeadOrDying())) {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.u3.tailClaw"));
                return PlayState.CONTINUE;
            }
            event.getController().forceAnimationReset();
            return PlayState.CONTINUE;
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController(this, "controller", 0, this::predicate));
        data.add(genericAttackAnimation(this, null));
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        return ran.nextInt(2) == 0 ? SoundEvents.RAVAGER_CELEBRATE : SoundEvents.RAVAGER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.RAVAGER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_ROAR;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
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
    }

    public boolean isNonBoss() {
        return false;
    }

    public void startSeenByPlayer(ServerPlayer p) {
        super.startSeenByPlayer(p);
        this.bossInfo.addPlayer(p);
    }

    public void stopSeenByPlayer(ServerPlayer p) {
        super.stopSeenByPlayer(p);
        this.bossInfo.removePlayer(p);
    }

    private static final Predicate<Entity> U3_AREA = (entity) ->
            entity.isAlive() && !(entity instanceof EntityU3);

    public boolean isGrabHolding() {
        return this.grabTicksLeft > 0;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.rangedCooldown > 0) this.rangedCooldown--;

        if (!this.level().isClientSide && this.grabEscapeStunTicks > 0) {
            --this.grabEscapeStunTicks;
            this.getNavigation().stop();
            this.setDeltaMovement(0, this.getDeltaMovement().y, 0);
            return;
        }

        if (!this.level().isClientSide && this.grabTicksLeft > 0) {
            this.getNavigation().stop();
            this.attr = Math.max(this.attr, GRAB_HOLD_TICKS - this.grabTicksLeft);
            int left = CommonFunctions.tickGrabHold(this, this.grabTicksLeft, this.getTarget());
            if (left == CommonFunctions.GRAB_ESCAPED) {
                this.grabTicksLeft = 0;
                CommonFunctions.releaseGrabPassengers(this);
                this.resetCombatToIdle();
                this.grabEscapeStunTicks = GRAB_ESCAPE_STUN;
            } else {
                this.grabTicksLeft = left;
                if (this.grabTicksLeft <= 0 && this.getAttckingState() == 2) {
                    this.setAttackingState(0);
                }
            }
        }

        if (!(this instanceof EntityElg)) {
            LivingEntity livingentity = this.getTarget();

            // ===== 钻地期间（独立于 target，目标丢失也能出地） =====
            if (this.zuan) {
                this.zuanTimer++;
                this.setDeltaMovement(0, 0, 0);
                if (this.tickCount % 3 == 0) {
                    this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(),
                            this.zuanArena.x, this.zuanArena.y, this.zuanArena.z, 0, 0.1, 0);
                }
                // 3 秒到 或 目标丢失 → 出地
                if (this.zuanTimer >= ZUAN_DURATION || livingentity == null) {
                    this.breakOut(livingentity);
                }
                if (livingentity != null) {
                    this.lookAt(livingentity, 30.0F, 30.0F);
                }
                return;
            }
            // ==================================================

            boolean hasTarget = livingentity != null && livingentity.isAlive();

            // 目标丢失且未在抓取：强制回 idle，避免 attackTimer 冻住导致永久卡招
            if (!hasTarget && !this.isGrabHolding()) {
                if (this.getAttckingState() != 0 || this.attackTimer > 0) {
                    this.resetCombatToIdle();
                }
                return;
            }

            // ===== 能量光球（仅 idle 时远距离优先） =====
            if (hasTarget && !this.level().isClientSide
                    && this.getAttckingState() == 0
                    && this.attackTimer <= 0
                    && this.distanceTo(livingentity) > 8.0F
                    && this.hasLineOfSight(livingentity)
                    && this.rangedCooldown <= 0) {
                this.fireEnergyOrb(livingentity);
                this.rangedCooldown = 80;
                this.lookAt(livingentity, 30.0F, 30.0F);
                return;
            }
            // ==================================

            boolean los = hasTarget && this.hasLineOfSight(livingentity);
            int state = this.getAttckingState();
            // 已出招/进行中：无视线也继续推进到收招；仅 idle 起步需要视线
            if (!los && state == 0 && this.attackTimer <= 0) {
                if (hasTarget) {
                    this.getNavigation().moveTo(livingentity, 1.2D);
                    this.lookAt(livingentity, 30.0F, 30.0F);
                }
                return;
            }

            if (hasTarget) {
                this.setAggressive(true);
                this.lookAt(livingentity, 30.0F, 30.0F);
            }
            Random rand = new Random();
            this.attr = this.attackTimer;

            // ===== 钻地：仅 idle 起步 =====
            if (los && this.attackTimer == 0 && state == 0 && rand.nextInt(100) < 20 && !this.zuan) {
                Vec3 arena = this.findGround(this.getX(), this.getY(), this.getZ());
                int minY = this.level().getMinBuildHeight() + 5;
                if (arena != null && arena.y - 3.2D > minY) {
                    this.zuanArena = arena;
                    this.zuan = true;
                    this.zuanTimer = 0;
                    this.noPhysics = true;
                    this.setInvulnerable(true);
                    this.teleportTo(arena.x, arena.y - 3.2D, arena.z);
                    this.setDeltaMovement(0, 0, 0);
                    this.setAttackingState(3);
                    tailClawAnimationState.start(this.tickCount);
                    this.getNavigation().stop();
                    return;
                }
            }
            // ==================================

            ++this.attackTimer;

            if (this.attackTimer == 5 && state == 0) {
                int k = rand.nextInt(6);
                if (k > 4) {
                    this.setAttackingState(3);
                    tailClawAnimationState.start(this.tickCount);
                    this.getNavigation().stop();
                } else if (k < 2) {
                    this.getNavigation().stop();
                    this.setAttackingState(2);
                    attackAnimationState2.start(this.tickCount);
                } else {
                    if (hasTarget) {
                        this.getNavigation().moveTo(livingentity, 1.5D);
                    }
                    this.setAttackingState(1);
                    attackAnimationState.start(this.tickCount);
                }
            }

            state = this.getAttckingState();

            // 尾巴钳击判定
            if (this.attackTimer == 12 && state == 3) {
                Vec3 look = this.getViewVector(1.0F);
                for (LivingEntity lvt : this.level().getEntitiesOfClass(
                        LivingEntity.class, this.getBoundingBox().inflate(3.0D), U3_AREA)) {
                    Vec3 to = lvt.position().subtract(this.position());
                    if (to.lengthSqr() < 1.0E-4) continue;
                    if (to.normalize().dot(look) < 0.5) continue;
                    lvt.hurt(damageSources().mobAttack(this),
                            (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5F);
                    lvt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 6));
                    lvt.addEffect(new MobEffectInstance(MobEffects.JUMP, 30, 128));
                    Vec3 pull = this.position().subtract(lvt.position()).normalize().scale(0.6);
                    lvt.push(pull.x, 0.2, pull.z);
                }
            }

            if (this.attackTimer == 12 && state == 1) {
                for (int l = 1; l < 10; l++) {
                    this.blockSmashAttack(l, 3F, 1.5F, 60, 3F, 0.15F, 1.0F);
                    this.blockSmashAttack(l, 3F, -1.5F, 60, 3F, 0.15F, 1.0F);
                    this.blockSmashAttack(l, 3F, 2.5F, 60, 3F, 0.15F, 1.0F);
                    this.blockSmashAttack(l, 3F, -2.5F, 60, 3F, 0.15F, 1.0F);
                    this.blockSmashAttack(l, 3F, 3.5F, 60, 3F, 0.15F, 1.0F);
                    this.blockSmashAttack(l, 3F, -3.5F, 60, 3F, 0.15F, 1.0F);
                    this.blockSmashAttack(l, 3F, 4.5F, 60, 3F, 0.15F, 1.0F);
                    this.blockSmashAttack(l, 3F, -4.5F, 60, 3F, 0.15F, 1.0F);
                }
            }

            if (this.attackTimer == 13 && state == 1) {
                for (int l = 1; l < 3; l++) {
                    this.blockSmashAttack(l, 3F, 1.5F, 10, this.getHealth() * 0.015f, 0.15F, 1.0F);
                    this.blockSmashAttack(l, 3F, -1.5F, 60, this.getHealth() * 0.015f, 0.15F, 1.0F);
                    this.blockSmashAttack(l, 3F, 2.5F, 10, this.getHealth() * 0.015f, 0.15F, 1.0F);
                }
            }

            // STATE 2：抓取
            if (state == 2) {
                this.getNavigation().stop();
                int grabProgress = Math.max(0, this.attackTimer - 5);
                this.attr = grabProgress;
                if (hasTarget && this.attackTimer == GRAB_CATCH_TIMER && !this.isGrabHolding()
                        && this.distanceToSqr(livingentity) <= 16.0D
                        && CommonFunctions.tryStartGrab(this, livingentity, 3.0F)) {
                    this.grabTicksLeft = Math.max(1, GRAB_BITE_TIMER - grabProgress + 1);
                }
                if (hasTarget && this.isGrabHolding()) {
                    CommonFunctions.keepGrab(this, livingentity);
                }
            }

            if (this.attackTimer >= 50 && !this.isGrabHolding()) {
                this.resetCombatToIdle();
            }
        }
    }

    // ===== 出地：teleport 到 arena，恢复 noPhysics =====
    private void breakOut(LivingEntity target) {
        this.teleportTo(this.zuanArena.x, this.zuanArena.y, this.zuanArena.z);
        this.noPhysics = false;
        this.setInvulnerable(false);
        this.resetFallDistance();
        this.setDeltaMovement(0, 0.6, 0);

        Vec3 dir = target != null
                ? new Vec3(target.getX() - this.zuanArena.x, 0, target.getZ() - this.zuanArena.z).normalize()
                : this.getViewVector(1.0F);
        for (LivingEntity e : this.level().getEntitiesOfClass(
                LivingEntity.class, this.getBoundingBox().inflate(2.5), U3_AREA)) {
            e.hurt(damageSources().mobAttack(this),
                    (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5F);
            e.push(dir.x * 2, 0.5, dir.z * 2);
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 6));
            e.addEffect(new MobEffectInstance(MobEffects.JUMP, 30, 128));
        }
        if (this.level() instanceof ServerLevel sl) {
            sl.sendParticles(ParticleTypes.EXPLOSION,
                    this.zuanArena.x, this.zuanArena.y, this.zuanArena.z, 1, 0, 0, 0, 0);
            sl.sendParticles(ParticleTypes.CLOUD,
                    this.zuanArena.x, this.zuanArena.y, this.zuanArena.z, 20, 0.5, 0.2, 0.5, 0.1);
        }
        this.zuan = false;
        this.zuanTimer = 0;
        this.attackTimer = -10;
        this.setAttackingState(0);
        tailClawAnimationState.stop();
    }

    private void resetCombatToIdle() {
        this.setAttackingState(0);
        this.attackTimer = -10;
        attackAnimationState.stop();
        attackAnimationState2.stop();
        attackAnimationState3.stop();
        tailClawAnimationState.stop();
        this.attr = 0;
    }
    // ==================================================

    // ===== 扫地面：返回 null 表示没有安全地面 =====
    private Vec3 findGround(double x, double y, double z) {
        BlockPos base = BlockPos.containing(x, y, z);
        int minY = this.level().getMinBuildHeight() + 5;
        for (int dy = 0; dy <= 64; dy++) {
            BlockPos pos = base.below(dy);
            if (pos.getY() <= minY) break;
            if (this.level().getBlockState(pos).blocksMotion()) {
                BlockPos above1 = pos.above();
                BlockPos above2 = pos.above(2);
                boolean above1Air = !this.level().getBlockState(above1).blocksMotion();
                boolean above2Air = !this.level().getBlockState(above2).blocksMotion();
                if (above1Air && above2Air) {
                    return new Vec3(x, pos.getY() + 1.0, z);
                }
            }
        }
        return null;
    }
    // ==================================================

    // ===== 能量光球 =====
    private void fireEnergyOrb(LivingEntity target) {
        // 远程只播动画，不长期占用攻击 state，避免无视线时卡在 state=4
        this.getNavigation().stop();
        attackAnimationState2.start(this.tickCount);

        Vec3 eye = this.getEyePosition();
        FireEntity orb = new FireEntity(EntityInit.FIREENTITY.get(), this.level());
        orb.setPos(eye.x, eye.y, eye.z);
        orb.setTarget(target);
        orb.setAttackType(1);
        orb.setBlock(Blocks.STONE.defaultBlockState());
        this.level().addFreshEntity(orb);

        Vec3 side = this.getViewVector(1.0F).cross(new Vec3(0, 1, 0)).normalize().scale(1.2);
        for (int i = -1; i <= 1; i += 2) {
            FireEntity sideOrb = new FireEntity(EntityInit.FIREENTITY.get(), this.level());
            sideOrb.setPos(eye.x + side.x * i, eye.y - 0.5, eye.z + side.z * i);
            sideOrb.setTarget(target);
            sideOrb.setAttackType(1);
            this.level().addFreshEntity(sideOrb);
        }
    }
    // ======================

    @Override
    public void positionRider(@NotNull Entity passenger, MoveFunction moveFunction) {
        if (!this.isGrabHolding() && this.getAttckingState() != 2) {
            super.positionRider(passenger, moveFunction);
            return;
        }
        double raiseUp = CommonFunctions.grabRaiseUp(this.attr, 10);
        float pullIn = CommonFunctions.grabPullIn(this.attr, 15);
        CommonFunctions.positionGrabbedPassenger(this, passenger, raiseUp, pullIn, true, true);
    }

    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengers().isEmpty();
    }

    private void roar() {
        if (this.isAlive()) {
            Vec3 vec3 = this.getBoundingBox().getCenter();
            for (int i = 0; i < 10; i++) {
                float deltaOmega = 1.0f * i;
                Vec3 pos = new Vec3(vec3.x + Math.sin(deltaOmega), vec3.y, vec3.z + Math.cos(deltaOmega));
                this.level().addParticle(ParticleInit.MUCUS_PARTICLE.get(), pos.x, pos.y, pos.z, 0, 0, 0);
            }
            this.level().gameEvent(this, GameEvent.ENTITY_ROAR, this.getEyePosition());
        }
    }

    private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks,
                                  float damage, float hpdamage, float airborne) {
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double minY = this.getY() - 2.0;
        double maxY = this.getY() + mxy;
        float angle = (float) Math.PI / 180 * this.yBodyRot;
        float f = Mth.cos(this.getYRot() * ((float) Math.PI / 180));
        float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180));
        double extraX = distance * Mth.sin((float) (Math.PI + angle));
        double extraZ = distance * Mth.cos(angle);
        double px = this.getX() + extraX + f * math;
        double pz = this.getZ() + extraZ + f1 * math;
        int hitX = Mth.floor(px);
        int hitZ = Mth.floor(pz);
        BlockPos pos = new BlockPos(hitX, hitY, hitZ);
        BlockPos abovePos = pos.above();
        BlockState block = this.level().getBlockState(pos);
        BlockState blockAbove = this.level().getBlockState(abovePos);
        if (block.getBlock() != Blocks.AIR && !block.hasBlockEntity() && !blockAbove.blocksMotion()) {
            EntityFallingBlock falling = new EntityFallingBlock(this.level(),
                    hitX + 0.5, hitY + 1.0, hitZ + 0.5,
                    BlockInit.FACT_IRON_BLOCK.get().defaultBlockState(), 10);
            falling.push(0.0, 0.2 + this.getRandom().nextGaussian() * 0.15, 0.0);
            this.level().addFreshEntity(falling);
        }
        AABB selection = new AABB(px - 0.5, minY, pz - 0.5, px + 0.5, maxY, pz + 0.5);
        List<LivingEntity> hit = this.level().getEntitiesOfClass(LivingEntity.class, selection);
        for (LivingEntity entity : hit) {
            if (this.isAlliedTo(entity) || entity instanceof EntityHeisen || entity == this) continue;
            if (entity instanceof Player player
                    && player.getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)
                    && shieldbreakticks > 0) {
                disableShield(player, shieldbreakticks);
            }
            boolean flag = entity.hurt(damageSources().mobAttack(this),
                    (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * damage
                            + entity.getMaxHealth() * hpdamage));
            if (flag)
                entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, airborne + 0.5, 0.0));
        }
    }

    public static void disableShield(LivingEntity livingEntity, int ticks) {
        if (!(livingEntity instanceof Player player)) return;
        player.getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(6 + livingEntity.getRandom().nextInt(2),
                livingEntity, p -> p.broadcastBreakEvent(livingEntity.getUsedItemHand()));
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte) 30);
    }
}
