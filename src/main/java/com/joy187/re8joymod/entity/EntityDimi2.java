package com.joy187.re8joymod.entity;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
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

/**
 * Dimitrescu fly-form — no longer extends WitherBoss (wither AI overwrote travel).
 *
 * Combat states (synced):
 * 0 idle/fly chase
 * 2 claw flurry        -> animation.dimi2.attack2  (~4.0s)
 * 3 sonic/blade spray  -> animation.dimi2.attack3  (~5.75s)
 * 4 fly breath         -> animation.dimi2.breath   (~1.8s)
 * 5 sky dive           -> animation.dimi2.dive     (~2.4s)
 * 6 aerial loop        -> animation.dimi2.flyup    (~7.2s)  real path, not bone-only
 */
public class EntityDimi2 extends Monster implements GeoEntity {
    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    private static final EntityDataAccessor<Integer> STATE =
            SynchedEntityData.defineId(EntityDimi2.class, EntityDataSerializers.INT);

    public static final int STATE_IDLE = 0;
    public static final int STATE_ATTACK2 = 2;
    public static final int STATE_ATTACK3 = 3;
    public static final int STATE_BREATH = 4;
    public static final int STATE_DIVE = 5;
    public static final int STATE_FLYUP = 6;

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR =
            e -> e.getMobType() != MobType.UNDEAD && e.attackable();

    public EntityDimi2(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.xpReward = 70;
        this.moveControl = new FlyingMoveControl(this, 18, true);
        this.setNoGravity(true);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 350.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.45D)
                .add(Attributes.FLYING_SPEED, 0.85D)
                .add(Attributes.FOLLOW_RANGE, 40.0D)
                .add(Attributes.ARMOR, 9.0D)
                .add(Attributes.ATTACK_DAMAGE, 12.0D);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        FlyingPathNavigation nav = new FlyingPathNavigation(this, level) {
            @Override
            public boolean isStableDestination(BlockPos pos) {
                // Allow true aerial waypoints — requiring floor blocked flyup/dive paths.
                return true;
            }
        };
        nav.setCanOpenDoors(false);
        nav.setCanFloat(true);
        nav.setCanPassDoors(true);
        return nav;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new DimiCombatGoal(this));
        this.goalSelector.addGoal(2, new AerialHoverGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 12.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, STATE_IDLE);
    }

    public int getCombatState() {
        return this.entityData.get(STATE);
    }

    public void setCombatState(int state) {
        this.entityData.set(STATE, state);
    }

    /** Legacy accessors used elsewhere / older code. */
    public void setPuGong(int attacking) {
        this.setCombatState(attacking);
    }

    public int isPuGong() {
        return this.getCombatState();
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() || this.isControlledByLocalInstance()) {
            if (this.isInWater()) {
                this.moveRelative(0.02F, travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.8D));
            } else if (this.isInLava()) {
                this.moveRelative(0.02F, travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
            } else {
                float friction = 0.91F;
                this.moveRelative(0.05F, travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().scale(friction));
            }
        }
        this.calculateEntityAnimation(false);
    }

    @Override
    public boolean causeFallDamage(float distance, float multiplier, DamageSource source) {
        return false;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
        // flying boss — never accumulate fall
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.fallDistance = 0.0F;
        // Soft hover so she never sinks while idle.
        if (this.getCombatState() == STATE_IDLE && this.getDeltaMovement().y < -0.08D) {
            this.setDeltaMovement(this.getDeltaMovement().x, -0.02D, this.getDeltaMovement().z);
        }
    }

    private void flyToward(Vec3 dest, double speed) {
        Vec3 to = dest.subtract(this.position());
        if (to.lengthSqr() < 1.0E-4) {
            return;
        }
        Vec3 n = to.normalize().scale(speed);
        this.setDeltaMovement(this.getDeltaMovement().scale(0.35D).add(n));
        this.hasImpulse = true;
        this.move(MoverType.SELF, this.getDeltaMovement());
    }

    private void lookAtTarget(LivingEntity target) {
        this.getLookControl().setLookAt(target, 40.0F, 40.0F);
        double dx = target.getX() - this.getX();
        double dz = target.getZ() - this.getZ();
        this.setYRot((float) (Mth.atan2(dz, dx) * (180F / Math.PI)) - 90.0F);
        this.yBodyRot = this.getYRot();
    }

    private boolean inFrontCone(LivingEntity entity, float halfAngleDeg) {
        Vec3 look = this.getLookAngle();
        Vec3 lookFlat = new Vec3(look.x, 0.0, look.z);
        if (lookFlat.lengthSqr() < 1.0E-6) {
            return true;
        }
        lookFlat = lookFlat.normalize();
        Vec3 to = entity.position().subtract(this.position());
        Vec3 toFlat = new Vec3(to.x, 0.0, to.z);
        if (toFlat.lengthSqr() < 1.0E-6) {
            return true;
        }
        return lookFlat.dot(toFlat.normalize()) >= Math.cos(Math.toRadians(halfAngleDeg));
    }

    private void dealConeHit(LivingEntity prefer, float damage, float range, float halfAngle) {
        AABB box = this.getBoundingBox().inflate(range);
        for (LivingEntity e : this.level().getEntitiesOfClass(LivingEntity.class, box, LIVING_ENTITY_SELECTOR)) {
            if (e == this || this.isAlliedTo(e)) {
                continue;
            }
            if (this.distanceTo(e) > range + 0.5F) {
                continue;
            }
            if (!this.inFrontCone(e, halfAngle)) {
                continue;
            }
            e.hurt(this.damageSources().mobAttack(this), damage);
            if (e == prefer || e instanceof Player) {
                Vec3 push = this.getLookAngle();
                e.knockback(0.55F, -push.x, -push.z);
            }
        }
    }

    private void spawnFlyBreath(LivingEntity target) {
        this.playSound(SoundEvents.BEE_LOOP_AGGRESSIVE, 1.4F, 0.75F + this.random.nextFloat() * 0.3F);
        this.playSound(SoundEvents.ENDER_DRAGON_GROWL, 0.65F, 1.35F);
        Vec3 mouth = this.position().add(0.0, this.getBbHeight() * 0.55, 0.0).add(this.getLookAngle().scale(2.8));
        Vec3 dir = target.position().add(0.0, target.getBbHeight() * 0.4, 0.0).subtract(mouth);
        if (dir.lengthSqr() < 1.0E-4) {
            dir = this.getLookAngle();
        }
        dir = dir.normalize();

        if (this.level() instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.SMOKE, mouth.x, mouth.y, mouth.z, 10, 0.35, 0.25, 0.35, 0.02);
        }

        for (int i = 0; i < 5; i++) {
            double ox = (this.random.nextDouble() - 0.5) * 1.4;
            double oy = (this.random.nextDouble() - 0.5) * 0.9;
            double oz = (this.random.nextDouble() - 0.5) * 1.4;
            EntityFly fly = EntityFly.createBreathSwarm(this.level(), target,
                    mouth.x + ox, mouth.y + oy, mouth.z + oz, 80 + this.random.nextInt(40));
            fly.setDeltaMovement(dir.x * 1.05 + ox * 0.04, dir.y * 1.05 + 0.06, dir.z * 1.05 + oz * 0.04);
            fly.hasImpulse = true;
            this.level().addFreshEntity(fly);
        }
    }

    private void fireBladeVolley(LivingEntity target) {
        this.playSound(SoundEvents.ENDER_DRAGON_GROWL, 2.0F, 1.0F);
        this.playSound(SoundEvents.SCULK_SHRIEKER_SHRIEK, 1.5F, 0.55F);
        Vec3 direction = target.position().add(0.0, 1.0, 0.0).subtract(this.position().add(0.0, 2.0, 0.0)).normalize();
        Vec3 spawn = this.position().add(0.0, this.getBbHeight() * 0.5, 0.0);
        for (int i = -3; i <= 3; i++) {
            EntityMoreauProjectile blade = new EntityMoreauProjectile(this.level(), this);
            blade.setPos(spawn.x + i * 0.35, spawn.y, spawn.z + i * 0.35);
            blade.shoot(direction.x, direction.y, direction.z, 2.2F, 2.5F);
            this.level().addFreshEntity(blade);
        }
        if (this.level() instanceof ServerLevel server) {
            DustParticleOptions dust = new DustParticleOptions(Vec3.fromRGB24(16384394).toVector3f(), 1.0F);
            server.sendParticles(dust, target.getX(), target.getY() + 1.0, target.getZ(), 8, 1.5, 0.8, 1.5, 0.05);
        }
    }

    /**
     * Dive land impact — mirrors EntityElg.blockSmashAttack:
     * radial ground smash, flying debris, shield break, screen shake.
     */
    private void impactAoE(LivingEntity target) {
        this.playSound(SoundEvents.GENERIC_EXPLODE, 1.4F, 0.7F);
        this.playSound(SoundEvents.WARDEN_SONIC_BOOM, 0.8F, 0.6F);

        // Expanding smash ring around body facing (same pattern as Elg).
        for (int l = 1; l < 10; l++) {
            this.blockSmashAttack(l, 4.0F, 1.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, -1.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, 2.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, -2.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, 3.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, -3.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, 4.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, -4.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, 5.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, -5.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, 6.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, -6.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, 7.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, -7.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, 8.5F, 120, 1.35F, 0.12F, 1.0F);
            this.blockSmashAttack(l, 4.0F, -8.5F, 120, 1.35F, 0.12F, 1.0F);
        }

        EntityCameraShake.ScreenShake(this.level(), this.position(), 32.0F, 0.18F, 0, 55);

        if (target != null && target.isAlive()) {
            target.hurt(this.damageSources().mobAttack(this), 22.0F);
            target.setDeltaMovement(target.getDeltaMovement().add(0.0, 1.1, 0.0));
            target.knockback(1.5F, this.getX() - target.getX(), this.getZ() - target.getZ());
        }

        if (this.level() instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.CLOUD, this.getX(), this.getY(), this.getZ(), 50, 3.0, 0.5, 3.0, 0.06);
            server.sendParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY() + 0.5, this.getZ(), 3, 1.2, 0.3, 1.2, 0);
            server.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, this.getX(), this.getY(), this.getZ(), 18, 2.0, 0.4, 2.0, 0.02);
        }
    }

    /** Port of EntityElg#blockSmashAttack — toss debris + hit living in a column. */
    private void blockSmashAttack(int distance, float mxy, float math, int shieldbreakticks,
                                  float damage, float hpdamage, float airborne) {
        int hitY = Mth.floor(this.getBoundingBox().minY - 0.5);
        double minY = this.getY() - 2.0;
        double maxY = this.getY() + (double) mxy;
        float angle = (float) Math.PI / 180F * this.yBodyRot;
        float f = Mth.cos(this.getYRot() * ((float) Math.PI / 180F));
        float f1 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F));
        double extraX = (float) distance * Mth.sin((float) (Math.PI + (double) angle));
        double extraZ = (float) distance * Mth.cos(angle);
        double px = this.getX() + extraX + (double) (f * math);
        double pz = this.getZ() + extraZ + (double) (f1 * math);
        int hitX = Mth.floor(px);
        int hitZ = Mth.floor(pz);
        BlockPos pos = new BlockPos(hitX, hitY, hitZ);
        BlockPos abovePos = pos.above();
        BlockState block = this.level().getBlockState(pos);
        BlockState blockAbove = this.level().getBlockState(abovePos);

        if (block.getBlock() != Blocks.AIR && !block.hasBlockEntity() && !blockAbove.blocksMotion()) {
            EntityFallingBlock fallingBlockEntity = new EntityFallingBlock(
                    this.level(), hitX + 0.5, hitY + 1.0, hitZ + 0.5, block, 10);
            fallingBlockEntity.push(0.0, 0.25 + this.getRandom().nextGaussian() * 0.18, 0.0);
            this.level().addFreshEntity(fallingBlockEntity);
        }

        AABB selection = new AABB(px - 0.55, minY, pz - 0.55, px + 0.55, maxY, pz + 0.55);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, selection)) {
            if (this.isAlliedTo(entity) || entity == this) {
                continue;
            }
            if (entity instanceof Player player
                    && player.getUseItem().canPerformAction(ToolActions.SHIELD_BLOCK)
                    && shieldbreakticks > 0) {
                disableShield(player, shieldbreakticks);
            } else {
                float dmg = (float) (this.getAttributeValue(Attributes.ATTACK_DAMAGE) * (double) damage
                        + (double) (entity.getMaxHealth() * hpdamage));
                if (entity.hurt(this.damageSources().mobAttack(this), dmg)) {
                    entity.setDeltaMovement(entity.getDeltaMovement().add(0.0, airborne + 0.45, 0.0));
                    entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1, false, true));
                }
            }
        }
    }

    private static void disableShield(LivingEntity livingEntity, int ticks) {
        if (!(livingEntity instanceof Player player)) {
            return;
        }
        player.getCooldowns().addCooldown(livingEntity.getUseItem().getItem(), ticks);
        livingEntity.getUseItem().hurtAndBreak(5 + livingEntity.getRandom().nextInt(2), livingEntity,
                e -> e.broadcastBreakEvent(livingEntity.getUsedItemHand()));
        livingEntity.stopUsingItem();
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte) 30);
    }

    public void spawnFlames(double x, double z, double maxY, double y, float yaw, int warmup) {
        BlockPos blockpos = this.blockPosition();
        boolean flag = false;
        double d0 = 0.0D;
        do {
            BlockPos blockpos1 = blockpos.below();
            BlockState blockstate = this.level().getBlockState(blockpos1);
            if (blockstate.isFaceSturdy(this.level(), blockpos1, Direction.UP)) {
                if (!this.level().isEmptyBlock(blockpos)) {
                    BlockState blockstate1 = this.level().getBlockState(blockpos);
                    VoxelShape voxelshape = blockstate1.getCollisionShape(this.level(), blockpos);
                    if (!voxelshape.isEmpty()) {
                        d0 = voxelshape.max(Direction.Axis.Y);
                    }
                }
                flag = true;
                break;
            }
            blockpos = blockpos.below();
        } while (blockpos.getY() >= Mth.floor(maxY) - 1);

        if (flag) {
            LargeFireball fang = new LargeFireball(this.level(), this, x, (double) blockpos.getY() + d0, z, 2);
            fang.setSecondsOnFire(this.tickCount);
            this.level().addFreshEntity(fang);
        }
    }

    private <E extends GeoAnimatable> PlayState predicateMove(AnimationState<E> event) {
        if (this.getCombatState() != STATE_IDLE) {
            return PlayState.STOP;
        }
        if (event.isMoving() || this.getDeltaMovement().horizontalDistanceSqr() > 0.01) {
            event.setAndContinue(RawAnimation.begin().thenLoop("animation.dimi2.fly"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenLoop("animation.dimi2.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicateCombat(AnimationState<E> event) {
        if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
            return PlayState.STOP;
        }
        return switch (this.getCombatState()) {
            case STATE_ATTACK2 -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.attack2"));
                yield PlayState.CONTINUE;
            }
            case STATE_ATTACK3 -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.attack3"));
                yield PlayState.CONTINUE;
            }
            case STATE_BREATH -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.breath"));
                yield PlayState.CONTINUE;
            }
            case STATE_DIVE -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.dive"));
                yield PlayState.CONTINUE;
            }
            case STATE_FLYUP -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.dimi2.flyup"));
                yield PlayState.CONTINUE;
            }
            default -> PlayState.STOP;
        };
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 0, this::predicateMove));
        data.add(new AnimationController<>(this, "combat", 0, this::predicateCombat));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if (co == 0) {
            return SoundInit.ENTITY_DIMI_DEATH1.get();
        } else if (co == 1) {
            return SoundInit.ENTITY_DIMI_DEATH2.get();
        }
        return SoundEvents.BEE_DEATH;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        if (ran.nextInt(2) == 0) {
            return SoundInit.ENTITY_DIMI_AMBIENT1.get();
        }
        return SoundInit.ENTITY_DIMI_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        if (ran.nextInt(2) == 0) {
            return SoundInit.ENTITY_DIMI_HURT1.get();
        }
        return SoundInit.ENTITY_DIMI_HURT2.get();
    }

    /** Hover / chase while idle — real FlyingPathNavigation, not wither AI. */
    static class AerialHoverGoal extends Goal {
        private final EntityDimi2 mob;

        AerialHoverGoal(EntityDimi2 mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return this.mob.getCombatState() == STATE_IDLE && this.mob.getTarget() != null;
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse();
        }

        @Override
        public void tick() {
            LivingEntity target = this.mob.getTarget();
            if (target == null) {
                return;
            }
            double hoverY = target.getY() + 4.0D + Math.sin(this.mob.tickCount * 0.07D) * 0.8D;
            this.mob.getNavigation().moveTo(target.getX(), hoverY, target.getZ(), 1.25D);
            this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
        }
    }

    /**
     * Timed combat goal: each skill length matches its GeckoLib animation,
     * and displacement is applied in-world (not bone-only).
     */
    static class DimiCombatGoal extends Goal {
        private final EntityDimi2 dimi;
        private int timer;
        private int chosen;
        private int cooldown;
        private Vec3 diveAim = Vec3.ZERO;
        private double soarY;
        private double flyupAngle;

        DimiCombatGoal(EntityDimi2 dimi) {
            this.dimi = dimi;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return this.dimi.getTarget() != null && this.dimi.getTarget().isAlive();
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse() || this.dimi.getCombatState() != STATE_IDLE;
        }

        @Override
        public void start() {
            this.timer = 0;
            this.chosen = STATE_IDLE;
            this.cooldown = 20;
            this.dimi.setAggressive(true);
        }

        @Override
        public void stop() {
            this.dimi.setAggressive(false);
            this.dimi.setCombatState(STATE_IDLE);
            this.timer = 0;
            this.chosen = STATE_IDLE;
            this.dimi.getNavigation().stop();
        }

        @Override
        public void tick() {
            LivingEntity target = this.dimi.getTarget();
            if (target == null) {
                this.dimi.setCombatState(STATE_IDLE);
                return;
            }

            if (this.chosen != STATE_IDLE) {
                ++this.timer;
                this.dimi.lookAtTarget(target);
                this.runSkill(target);
                return;
            }

            if (this.cooldown > 0) {
                --this.cooldown;
                return;
            }

            double dist = this.dimi.distanceTo(target);
            if (dist > 28.0D) {
                return;
            }

            // Prefer flyup path when mid/low HP for spectacle.
            float hpRatio = this.dimi.getHealth() / this.dimi.getMaxHealth();
            int roll = this.dimi.getRandom().nextInt(100);
            if (hpRatio < 0.55F && roll < 18) {
                this.begin(STATE_FLYUP);
            } else if (roll < 22) {
                this.begin(STATE_DIVE);
            } else if (roll < 42) {
                this.begin(STATE_BREATH);
            } else if (roll < 62) {
                this.begin(STATE_ATTACK3);
            } else {
                this.begin(STATE_ATTACK2);
            }
        }

        private void begin(int state) {
            this.chosen = state;
            this.timer = 0;
            this.dimi.setCombatState(state);
            this.dimi.getNavigation().stop();
            LivingEntity t = this.dimi.getTarget();
            if (t != null) {
                this.diveAim = t.position();
                this.soarY = Math.max(this.dimi.getY(), t.getY()) + 9.0D;
            } else {
                this.soarY = this.dimi.getY() + 9.0D;
            }
            this.flyupAngle = this.dimi.getYRot() * ((float) Math.PI / 180F);
            this.dimi.playSound(SoundEvents.ENDER_DRAGON_FLAP, 1.5F, 0.9F);
        }

        private void finish() {
            this.chosen = STATE_IDLE;
            this.timer = 0;
            this.dimi.setCombatState(STATE_IDLE);
            this.cooldown = 25 + this.dimi.getRandom().nextInt(20);
            this.dimi.setDeltaMovement(this.dimi.getDeltaMovement().multiply(0.2, 0.2, 0.2));
        }

        private void runSkill(LivingEntity target) {
            switch (this.chosen) {
                case STATE_ATTACK2 -> this.tickAttack2(target);
                case STATE_ATTACK3 -> this.tickAttack3(target);
                case STATE_BREATH -> this.tickBreath(target);
                case STATE_DIVE -> this.tickDive(target);
                case STATE_FLYUP -> this.tickFlyup(target);
                default -> this.finish();
            }
        }

        /** attack2 ~4.0s = 80 ticks — claw flurry with forward hops. */
        private void tickAttack2(LivingEntity target) {
            if (this.timer <= 10) {
                this.dimi.flyToward(target.position().add(0.0, 2.0, 0.0), 0.35D);
            }
            if (this.timer == 18 || this.timer == 36 || this.timer == 54) {
                this.dimi.flyToward(target.position().add(0.0, 1.5, 0.0), 0.7D);
                this.dimi.dealConeHit(target, 10.0F, 6.0F, 70.0F);
                this.dimi.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1.5F, 0.6F);
                this.dimi.level().playSound(null, this.dimi.blockPosition(), SoundEvents.SCULK_VEIN_PLACE, SoundSource.HOSTILE, 1.5F, 1.0F);
            }
            if (this.timer == 54) {
                this.dimi.spawnFlames(this.dimi.getX(), this.dimi.getZ(), this.dimi.getY() + 4, this.dimi.getY(), 0, 0);
            }
            if (this.timer >= 80) {
                this.finish();
            }
        }

        /** attack3 ~5.75s ≈ 115 ticks — wind-up then blade spray. */
        private void tickAttack3(LivingEntity target) {
            if (this.timer <= 25) {
                // Back up slightly while winding up.
                Vec3 away = this.dimi.position().subtract(target.position());
                if (away.lengthSqr() > 0.01) {
                    this.dimi.flyToward(this.dimi.position().add(away.normalize().scale(2.0)), 0.25D);
                }
            }
            if (this.timer == 40 || this.timer == 72) {
                this.dimi.fireBladeVolley(target);
            }
            if (this.timer >= 115) {
                this.finish();
            }
        }

        /** breath ~1.8s = 36 ticks — hover and spray flies. */
        private void tickBreath(LivingEntity target) {
            // Hold position roughly; slight hover.
            this.dimi.setDeltaMovement(this.dimi.getDeltaMovement().multiply(0.5, 0.5, 0.5).add(0.0, 0.02, 0.0));
            if (this.timer == 10 || this.timer == 18 || this.timer == 26) {
                this.dimi.spawnFlyBreath(target);
            }
            if (this.timer >= 36) {
                this.finish();
            }
        }

        /**
         * dive ~2.4s = 48 ticks:
         * 0-16 climb (matches anim lift), 17-40 dive along real path, ~40 impact.
         */
        private void tickDive(LivingEntity target) {
            if (this.timer <= 16) {
                this.diveAim = target.position();
                Vec3 climb = new Vec3(target.getX(), this.soarY, target.getZ());
                this.dimi.flyToward(climb, 0.75D);
            } else if (this.timer <= 40) {
                this.diveAim = target.position().add(0.0, 0.5, 0.0);
                this.dimi.flyToward(this.diveAim, 1.25D);
                if (this.dimi.distanceTo(target) < 3.5D) {
                    this.dimi.impactAoE(target);
                    this.finish();
                }
            } else {
                if (this.timer == 41) {
                    this.dimi.impactAoE(target);
                }
                if (this.timer >= 48) {
                    this.finish();
                }
            }
        }

        /**
         * flyup ~7.2s ≈ 144 ticks — real helical climb+circle matching the spectacle anim.
         * Bone offsets alone never moved the entity; this drives world position.
         */
        private void tickFlyup(LivingEntity target) {
            this.flyupAngle += 0.12D;
            double radius = 6.0D + Math.sin(this.timer * 0.05D) * 2.0D;
            double height = this.soarY + Math.sin(this.timer * 0.04D) * 2.5D + this.timer * 0.04D;
            double cx = target.getX() + Math.cos(this.flyupAngle) * radius;
            double cz = target.getZ() + Math.sin(this.flyupAngle) * radius;
            this.dimi.flyToward(new Vec3(cx, height, cz), 0.85D);

            if (this.timer == 40 || this.timer == 80 || this.timer == 120) {
                this.dimi.dealConeHit(target, 8.0F, 8.0F, 100.0F);
                this.dimi.spawnFlyBreath(target);
            }
            if (this.timer >= 144) {
                // Drop back to hover height near target.
                this.dimi.flyToward(target.position().add(0.0, 4.0, 0.0), 0.9D);
                this.finish();
            }
        }
    }
}
