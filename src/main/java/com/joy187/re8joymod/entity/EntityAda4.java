package com.joy187.re8joymod.entity;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
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

/**
 * Ada4 combat states:
 * 0 idle / walk
 * 1 attack — left/right punches (animation.ada4.attack)
 * 2 attack2 — double kick + backflip retreat (animation.ada4.attack2)
 * 3 shoot — back off then fire; 20% spider-web shot (animation.ada4.shoot)
 * 4 gun_vault — signature gun hook to high ground (animation.ada4.gun_vault)
 */
public class EntityAda4 extends EntityChris {
    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public static final int STATE_IDLE = 0;
    public static final int STATE_ATTACK = 1;
    public static final int STATE_ATTACK2 = 2;
    public static final int STATE_SHOOT = 3;
    public static final int STATE_GUN_VAULT = 4;

    private static final double MELEE_RANGE = 2.8D;
    private static final double SHOOT_MIN = 5.0D;
    private static final double SHOOT_MAX = 16.0D;

    private int vaultCooldown;
    private int meleeIndex;

    private static final Predicate<Entity> ADA_AREA = Entity::isAlive;

    public EntityAda4(EntityType<? extends IronGolem> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 105;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.FOLLOW_RANGE, 18.0D)
                .add(Attributes.ARMOR, 4D)
                .add(Attributes.ARMOR_TOUGHNESS, 6.0D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new Ada4CombatGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda2.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.vaultCooldown > 0) {
            --this.vaultCooldown;
        }
        if (this.getHealth() >= 10.0F && this.getHealth() <= 20.0F) {
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 1, false, true));
        } else if (this.getHealth() < 8.0F) {
            this.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, 1, false, true));
            this.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 20, 0, false, false));
        }
    }

    private boolean isInFrontCone(LivingEntity entity, float halfAngleDeg) {
        Vec3 look = this.getLookAngle();
        Vec3 lookFlat = new Vec3(look.x, 0.0, look.z);
        if (lookFlat.lengthSqr() < 1.0E-6) {
            return true;
        }
        lookFlat = lookFlat.normalize();
        Vec3 to = entity.position().add(0.0, entity.getBbHeight() * 0.5, 0.0)
                .subtract(this.position().add(0.0, this.getBbHeight() * 0.5, 0.0));
        Vec3 toFlat = new Vec3(to.x, 0.0, to.z);
        if (toFlat.lengthSqr() < 1.0E-6) {
            return true;
        }
        toFlat = toFlat.normalize();
        return lookFlat.dot(toFlat) >= Math.cos(Math.toRadians(halfAngleDeg));
    }

    private void dealMeleeHit(LivingEntity target, float damage, float range) {
        AABB box = this.getBoundingBox().inflate(range);
        for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, box)) {
            if (entity == this || this.isAlliedTo(entity)) {
                continue;
            }
            if (this.distanceTo(entity) > range + 0.5F) {
                continue;
            }
            if (!this.isInFrontCone(entity, 70.0F)) {
                continue;
            }
            entity.hurt(this.damageSources().mobAttack(this), damage);
            if (entity == target || entity instanceof Player) {
                Vec3 push = this.getLookAngle();
                entity.knockback(0.4F, -push.x, -push.z);
            }
        }
    }

    private Vec3 awayFrom(LivingEntity target) {
        Vec3 away = this.position().subtract(target.position());
        if (away.lengthSqr() < 0.01) {
            away = this.getLookAngle().scale(-1.0);
        }
        return new Vec3(away.x, 0.0, away.z).normalize();
    }

    private void leapAlong(Vec3 dir, double horizontal, double upward) {
        Vec3 n = new Vec3(dir.x, 0.0, dir.z);
        if (n.lengthSqr() < 1.0E-6) {
            return;
        }
        n = n.normalize();
        this.setDeltaMovement(n.x * horizontal, upward, n.z * horizontal);
        this.hasImpulse = true;
        this.hurtMarked = true;
    }

    private void moveAlong(Vec3 dir, double speed) {
        Vec3 n = new Vec3(dir.x, 0.0, dir.z);
        if (n.lengthSqr() < 1.0E-6) {
            return;
        }
        n = n.normalize().scale(speed);
        this.move(MoverType.SELF, n);
        this.setDeltaMovement(n.x, this.getDeltaMovement().y, n.z);
        this.hasImpulse = true;
    }

    private void fireBullet() {
        EntityBOWShoot bullet = new EntityBOWShoot(this.level(), this);
        bullet.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, 2.6F, 0.7F);
        bullet.damage = 6.0D;
        this.level().addFreshEntity(bullet);
        this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getEyeY(), this.getZ(), 0.0, 0.0, 0.0);
        this.playSound(SoundInit.M1851.get(), 1.2F, 1.3F);
    }

    /** 20% spider-web shot: slow target and plant cobweb at their feet. */
    private void fireWebShot(LivingEntity target) {
        EntityBOWShoot bullet = new EntityBOWShoot(this.level(), this);
        bullet.shootFromRotation(this, this.getXRot(), this.getYRot(), 0.0F, 1.8F, 1.2F);
        bullet.damage = 2.5D;
        this.level().addFreshEntity(bullet);

        BlockPos at = target.blockPosition();
        if (this.level().getBlockState(at).isAir()) {
            this.level().setBlock(at, Blocks.COBWEB.defaultBlockState(), 3);
        } else if (this.level().getBlockState(at.above()).isAir()) {
            this.level().setBlock(at.above(), Blocks.COBWEB.defaultBlockState(), 3);
        }
        target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 2, false, true));
        target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 60, 1, false, true));
        this.playSound(SoundEvents.SPIDER_AMBIENT, 1.0F, 1.4F);
        this.playSound(SoundInit.M1851.get(), 0.8F, 0.7F);
    }

    private void fireOrWeb(LivingEntity target) {
        if (this.getRandom().nextFloat() < 0.20F) {
            this.fireWebShot(target);
        } else {
            this.fireBullet();
        }
    }

    /** Signature move: fire gun-hook then land on nearby high ground. */
    private void performGunVault(LivingEntity target) {
        Vec3 away = this.awayFrom(target).add(0.0, 0.85, 0.0).normalize();
        GrapplehookEntity hook = new GrapplehookEntity(this.level(), this);
        hook.shoot(away.x, away.y, away.z, 1.9F, 0.8F);
        hook.damage = 1.5D;
        this.level().addFreshEntity(hook);
        this.playSound(SoundInit.M1851.get(), 1.0F, 0.85F);
        this.leapAlong(away, 0.9D, 0.85D);
    }

    private void teleportToHighGround(LivingEntity target, double horizontal) {
        Vec3 away = this.awayFrom(target);
        // Prefer lateral high ground around Ada rather than pure back-line.
        double yaw = Math.atan2(away.z, away.x) + (this.getRandom().nextBoolean() ? 0.7 : -0.7);
        Vec3 side = new Vec3(Math.cos(yaw), 0.0, Math.sin(yaw)).normalize();
        Vec3 dest = this.position().add(side.scale(horizontal));

        int bestY = Integer.MIN_VALUE;
        BlockPos best = null;
        for (int r = 3; r <= 8; r++) {
            for (int a = 0; a < 8; a++) {
                double ang = yaw + (a * Math.PI / 4.0);
                double x = this.getX() + Math.cos(ang) * r;
                double z = this.getZ() + Math.sin(ang) * r;
                int groundY = this.level().getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) Math.floor(x), (int) Math.floor(z));
                // Prefer positions clearly above current footing.
                if (groundY > this.getY() + 2.0 && groundY > bestY) {
                    bestY = groundY;
                    best = BlockPos.containing(x, groundY, z);
                }
            }
        }
        if (best == null) {
            int groundY = this.level().getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    (int) Math.floor(dest.x), (int) Math.floor(dest.z));
            best = BlockPos.containing(dest.x, Math.max(groundY, this.getY() + 3.0), dest.z);
            bestY = best.getY();
        }
        this.getNavigation().stop();
        this.teleportTo(best.getX() + 0.5, bestY + 0.1, best.getZ() + 0.5);
        this.setDeltaMovement(0.0, 0.15, 0.0);
        this.hasImpulse = true;
        this.resetFallDistance();
        this.playSound(SoundEvents.ENDERMAN_TELEPORT, 0.7F, 1.4F);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if (co < 2) {
            for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), ADA_AREA)) {
                if (lvt instanceof EntityLeon && co == 1) {
                    return SoundInit.ENTITY_ADA_ADA4LEON.get();
                }
            }
        }
        if (co == 0) {
            return SoundInit.ENTITY_ADA_ADA4D2.get();
        } else if (co == 1) {
            return SoundInit.ENTITY_ADA_ADA4D.get();
        }
        return SoundInit.ENTITY_ADA_ADA4.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SLIME_BLOCK_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        if (ran.nextInt(2) == 1) {
            return SoundInit.ENTITY_ADA_DEATH.get();
        }
        return SoundInit.ENTITY_ADA_ADA4LEON.get();
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (this.getAttckingState() != STATE_IDLE) {
            return PlayState.STOP;
        }
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.walk"));
            return PlayState.CONTINUE;
        }
        event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.idle"));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicateCombat(AnimationState<E> event) {
        if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
            return PlayState.STOP;
        }
        int state = this.getAttckingState();
        switch (state) {
            case STATE_ATTACK -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.attack"));
                return PlayState.CONTINUE;
            }
            case STATE_ATTACK2 -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.attack2"));
                return PlayState.CONTINUE;
            }
            case STATE_SHOOT -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.shoot"));
                return PlayState.CONTINUE;
            }
            case STATE_GUN_VAULT -> {
                event.setAndContinue(RawAnimation.begin().thenPlay("animation.ada4.gun_vault"));
                return PlayState.CONTINUE;
            }
            default -> {
                return PlayState.STOP;
            }
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 0, this::predicate));
        data.add(new AnimationController<>(this, "combat", 0, this::predicateCombat));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    static class Ada4CombatGoal extends Goal {
        private final EntityAda4 ada;
        private int timer;
        private int chosenState;

        Ada4CombatGoal(EntityAda4 ada) {
            this.ada = ada;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return this.ada.getTarget() != null && this.ada.getTarget().isAlive();
        }

        @Override
        public boolean canContinueToUse() {
            return this.canUse() || this.ada.getAttckingState() != STATE_IDLE;
        }

        @Override
        public void start() {
            this.timer = 0;
            this.chosenState = STATE_IDLE;
            this.ada.setAggressive(true);
        }

        @Override
        public void stop() {
            this.ada.setAggressive(false);
            this.ada.setAttackingState(STATE_IDLE);
            this.timer = 0;
            this.chosenState = STATE_IDLE;
        }

        @Override
        public void tick() {
            LivingEntity target = this.ada.getTarget();
            if (target == null) {
                this.ada.setAttackingState(STATE_IDLE);
                return;
            }

            this.ada.getLookControl().setLookAt(target, 30.0F, 30.0F);
            double dist = this.ada.distanceTo(target);

            if (this.chosenState != STATE_IDLE) {
                ++this.timer;
                this.runSkill(target, dist);
                return;
            }

            // Signature gun vault — modest chance when off cooldown.
            if (this.ada.vaultCooldown <= 0 && this.ada.getRandom().nextFloat() < 0.12F) {
                this.beginSkill(STATE_GUN_VAULT);
                return;
            }

            if (dist > MELEE_RANGE) {
                this.ada.getNavigation().moveTo(target, 1.45D);
                if (dist >= SHOOT_MIN && dist <= SHOOT_MAX && this.ada.getRandom().nextInt(14) == 0) {
                    this.beginSkill(STATE_SHOOT);
                } else if (dist > SHOOT_MAX && this.ada.getRandom().nextInt(40) == 0) {
                    // Too far: vault up then re-engage from high ground.
                    this.beginSkill(STATE_GUN_VAULT);
                }
                return;
            }

            this.ada.getNavigation().stop();
            int pick = this.ada.meleeIndex % 3;
            this.ada.meleeIndex++;
            if (pick == 0) {
                this.beginSkill(STATE_ATTACK);
            } else if (pick == 1) {
                this.beginSkill(STATE_ATTACK2);
            } else if (this.ada.getRandom().nextFloat() < 0.35F) {
                this.beginSkill(STATE_SHOOT);
            } else {
                this.beginSkill(STATE_ATTACK);
            }
        }

        private void beginSkill(int state) {
            this.chosenState = state;
            this.timer = 0;
            this.ada.setAttackingState(state);
        }

        private void finishSkill() {
            this.chosenState = STATE_IDLE;
            this.timer = 0;
            this.ada.setAttackingState(STATE_IDLE);
        }

        private void runSkill(LivingEntity target, double dist) {
            switch (this.chosenState) {
                case STATE_ATTACK -> this.tickAttack(target);
                case STATE_ATTACK2 -> this.tickAttack2(target);
                case STATE_SHOOT -> this.tickShoot(target);
                case STATE_GUN_VAULT -> this.tickGunVault(target);
                default -> this.finishSkill();
            }
        }

        /** Left / right / left / right punches — synced to attack (~1.2s). */
        private void tickAttack(LivingEntity target) {
            double dist = this.ada.distanceTo(target);
            if (dist > MELEE_RANGE + 1.6D) {
                this.finishSkill();
                return;
            }
            if (this.timer == 5 || this.timer == 14) {
                if (dist <= MELEE_RANGE + 0.4D) {
                    this.ada.dealMeleeHit(target, 5.5F, 2.5F);
                }
            }
            if (this.timer == 9 || this.timer == 19) {
                if (dist <= MELEE_RANGE + 0.4D) {
                    this.ada.dealMeleeHit(target, 6.0F, 2.5F);
                }
            }
            if (this.timer >= 24) {
                this.finishSkill();
            }
        }

        /** Double kick then backflip away — synced to attack2 (~1.6s). */
        private void tickAttack2(LivingEntity target) {
            double dist = this.ada.distanceTo(target);
            if (this.timer == 8 || this.timer == 10) {
                if (dist <= MELEE_RANGE + 0.6D) {
                    this.ada.dealMeleeHit(target, 7.5F, 2.8F);
                }
            }
            if (this.timer == 14) {
                this.ada.leapAlong(this.ada.awayFrom(target), 1.15D, 0.65D);
            }
            if (this.timer >= 16 && this.timer <= 22) {
                this.ada.moveAlong(this.ada.awayFrom(target), 0.55D);
            }
            if (this.timer == 24 && this.ada.distanceTo(target) < 5.0D) {
                Vec3 away = this.ada.awayFrom(target);
                Vec3 dest = this.ada.position().add(away.scale(6.5D));
                int gy = this.ada.level().getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                        (int) Math.floor(dest.x), (int) Math.floor(dest.z));
                this.ada.teleportTo(dest.x, gy + 0.1D, dest.z);
                this.ada.resetFallDistance();
            }
            if (this.timer >= 32) {
                this.finishSkill();
            }
        }

        /** Back away, then shoot (20% web). Synced to shoot (~1.25s). */
        private void tickShoot(LivingEntity target) {
            this.ada.getNavigation().stop();
            if (this.timer <= 8) {
                this.ada.moveAlong(this.ada.awayFrom(target), 0.55D);
                this.ada.leapAlong(this.ada.awayFrom(target), 0.35D, 0.12D);
            }
            if (this.timer == 14) {
                this.ada.fireOrWeb(target);
            }
            if (this.timer >= 25) {
                this.finishSkill();
            }
        }

        /** Gun vault to relative high ground — synced to gun_vault (~1.5s). */
        private void tickGunVault(LivingEntity target) {
            this.ada.getNavigation().stop();
            if (this.timer == 6) {
                this.ada.performGunVault(target);
            }
            if (this.timer == 14) {
                this.ada.teleportToHighGround(target, 7.0D);
            }
            if (this.timer == 20) {
                this.ada.vaultCooldown = 20 * 10;
            }
            if (this.timer >= 30) {
                this.finishSkill();
            }
        }
    }
}
