package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.entity.variant.ArmaduraVariant;
import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
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

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;


public class EntityArmadura extends Ravager implements GeoEntity {
    private static final float MELEE_RANGE = 3.2F;
    private static final float SLASH_RANGE = 3.5F;
    private static final float SLASH_HALF_ANGLE = 60.0F;
    private static final double CHARGE_SPEED = 1.55D;
    private static final int ATTACK_COOLDOWN = 35;

    private final AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

    public EntityArmadura(EntityType<? extends Ravager> type, Level worldIn) {
        super(type, worldIn);
    }

    public static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(EntityArmadura.class,
            EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(EntityArmadura.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(EntityArmadura.class, EntityDataSerializers.BYTE);

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 35.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.12D)
                .add(Attributes.ARMOR, 3.5D)
                .add(Attributes.ATTACK_DAMAGE, 16.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypeTags.IS_FIRE) || super.isInvulnerableTo(source);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(1, new AttackGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    protected String animWalk() {
        return "animation.armadura.walk";
    }

    protected String animIdle() {
        return "animation.armadura.idle";
    }

    protected String animAttack() {
        return "animation.armadura.attack";
    }

    protected String animAttack2() {
        return "animation.armadura.attack2";
    }

    protected String animSpecialAttack() {
        return null;
    }

    protected <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay(this.animWalk()));
            return PlayState.CONTINUE;
        }

        event.setAndContinue(RawAnimation.begin().thenPlay(this.animIdle()));
        return PlayState.CONTINUE;
    }

    protected <E extends GeoAnimatable> PlayState predicate1(AnimationState<E> event) {
        if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
            return PlayState.STOP;
        }
        int state = this.entityData.get(STATE);
        if (state == 1) {
            event.setAndContinue(RawAnimation.begin().thenPlay(this.animAttack()));
            return PlayState.CONTINUE;
        }
        if (state == 2) {
            event.setAndContinue(RawAnimation.begin().thenPlay(this.animAttack2()));
            return PlayState.CONTINUE;
        }
        if (state == 3 && this.animSpecialAttack() != null) {
            event.setAndContinue(RawAnimation.begin().thenPlay(this.animSpecialAttack()));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    /** 1 = normal slash, 2 = heavy slash, 3 = special (subclass). */
    protected int pickAttackState() {
        float hp = this.getHealth();
        float max = this.getMaxHealth();
        if (hp >= max * 0.85F || hp <= max * 0.25F || (hp >= max * 0.45F && hp <= max * 0.6F)) {
            return 2;
        }
        return 1;
    }

    /**
     * Full attack clip length in ticks (20 tps).
     * Must match animation_length: attack/attack2=1.5s→30, tenta=1.6s→32.
     */
    protected int attackDurationTicks(int state) {
        return state == 3 ? 32 : 30;
    }

    /**
     * Damage frame measured from attack start (STATE set at timer=1).
     * Aligns with anim peaks: attack2≈0.9s→18, attack/tenta≈1.0s→20.
     */
    protected int attackHitTick(int state) {
        if (state == 2) {
            return 18;
        }
        if (state == 1 || state == 3) {
            return 20;
        }
        return -1;
    }

    protected void onAttackHit(LivingEntity target, int state, float baseDamage) {
        if (state == 2) {
            this.dealSlashHit(target, baseDamage * 1.25F, SLASH_RANGE, SLASH_HALF_ANGLE);
            this.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1.2F, 0.85F);
        } else if (state == 1) {
            this.dealSlashHit(target, baseDamage, SLASH_RANGE, SLASH_HALF_ANGLE);
            this.playSound(SoundEvents.PLAYER_ATTACK_SWEEP, 1.1F, 0.9F);
        }
    }

    protected void onAttackFinished(int state) {
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "controller",
                8, this::predicate));
        // Keep attack blend short so damage frames stay visually synced
        data.add(new AnimationController<>(this, "controller1",
                1, this::predicate1));
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (this.getHealth() > 1.0F && this.getHealth() < 6.0F && (this.random.nextFloat() < 0.25)) {
            EntityPlagasVillager e = new EntityPlagasVillager(EntityInit.PLAGASARMADURA.get(), this.level());
            e.copyPosition(this);
            this.discard();
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);
            this.level().addFreshEntity(e);
        }
    }

    public int getAttckingState() {
        return this.entityData.get(STATE);
    }

    public void setAttackingState(int time) {
        this.entityData.set(STATE, time);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(STATE, 0);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(DATA_FLAGS_ID, (byte) 0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    protected static final Predicate<Entity> ARMA_AREA = entity ->
            entity.isAlive() && !(entity instanceof EntityArmadura);

    protected boolean inFrontCone(LivingEntity entity, float halfAngleDeg) {
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

    protected void dealSlashHit(LivingEntity prefer, float damage, float range, float halfAngle) {
        AABB box = this.getBoundingBox().inflate(range);
        for (LivingEntity e : this.level().getEntitiesOfClass(LivingEntity.class, box, ARMA_AREA)) {
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
                e.knockback(0.65F, -push.x, -push.z);
            }
        }
        this.spawnSlashParticles();
    }

    protected void spawnSlashParticles() {
        if (!(this.level() instanceof ServerLevel server)) {
            return;
        }
        float yawRad = this.getYRot() * ((float) Math.PI / 180.0F);
        double baseY = this.getY() + 1.05D;
        for (int i = 0; i <= 12; i++) {
            float offsetDeg = -SLASH_HALF_ANGLE + (SLASH_HALF_ANGLE * 2.0F * i / 12.0F);
            float rad = yawRad + offsetDeg * ((float) Math.PI / 180.0F);
            for (float r : new float[]{1.5F, 2.25F, 3.0F}) {
                double x = this.getX() - Mth.sin(rad) * r;
                double z = this.getZ() + Mth.cos(rad) * r;
                server.sendParticles(ParticleTypes.SWEEP_ATTACK, x, baseY, z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                if (i % 2 == 0) {
                    server.sendParticles(ParticleTypes.CRIT, x, baseY + 0.1D, z, 1, 0.05D, 0.05D, 0.05D, 0.02D);
                }
            }
        }
    }

    static class AttackGoal extends Goal {
        private final EntityArmadura parentEntity;
        private int attackTimer = 0;

        public AttackGoal(EntityArmadura mob) {
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
            this.parentEntity.getNavigation().stop();
            this.attackTimer = 0;
        }

        @Override
        public void tick() {
            LivingEntity target = this.parentEntity.getTarget();
            if (target == null) {
                return;
            }

            this.parentEntity.getLookControl().setLookAt(target, 30.0F, 30.0F);
            double dist = this.parentEntity.distanceTo(target);
            boolean inMelee = dist <= MELEE_RANGE;

            if (this.attackTimer > 0) {
                this.parentEntity.getNavigation().stop();
                this.tickAttack(target);
                return;
            }

            if (!this.parentEntity.hasLineOfSight(target)) {
                this.parentEntity.getNavigation().moveTo(target, CHARGE_SPEED);
                this.parentEntity.setAttackingState(0);
                if (this.attackTimer < 0) {
                    this.attackTimer++;
                }
                return;
            }

            if (!inMelee) {
                this.parentEntity.getNavigation().moveTo(target, CHARGE_SPEED);
                this.parentEntity.setAttackingState(0);
                if (this.attackTimer < 0) {
                    this.attackTimer++;
                }
                return;
            }

            this.parentEntity.getNavigation().stop();
            if (this.attackTimer < 0) {
                this.attackTimer++;
            } else {
                this.attackTimer = 1;
                this.parentEntity.setAttackingState(this.parentEntity.pickAttackState());
            }
        }

        private void tickAttack(LivingEntity target) {
            float baseDamage = (float) this.parentEntity.getAttributeValue(Attributes.ATTACK_DAMAGE);
            int state = this.parentEntity.getAttckingState();
            int hitTick = this.parentEntity.attackHitTick(state);

            if (hitTick > 0 && this.attackTimer == hitTick) {
                this.parentEntity.onAttackHit(target, state, baseDamage);
            }

            int duration = this.parentEntity.attackDurationTicks(state);
            if (this.attackTimer >= duration) {
                this.parentEntity.onAttackFinished(state);
                this.parentEntity.setAttackingState(0);
                this.attackTimer = -ATTACK_COOLDOWN;
            } else {
                this.attackTimer++;
            }
        }
    }

    public ArmaduraVariant getVariant2() {
        return ArmaduraVariant.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(ArmaduraVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        ArmaduraVariant variant = Util.getRandom(ArmaduraVariant.values(), this.random);
        if (variant.getId() == 1) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(60.0D);
            this.getAttribute(Attributes.ARMOR).setBaseValue(6.0D);
        }
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.METAL_PLACE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.METAL_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.METAL_BREAK;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockstate) {
        this.playSound(SoundEvents.METAL_STEP, 0.15F, 1.0F);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    protected void tickDeath() {
        setDeltaMovement(Vec3.ZERO);
        setYRot(yRotO);
        setYHeadRot(yHeadRotO);

        if (deathTime >= getMaxDeathTime()) {
            remove(RemovalReason.KILLED);
        }

        deathTime++;
    }

    public int getMaxDeathTime() {
        return 60;
    }
}
