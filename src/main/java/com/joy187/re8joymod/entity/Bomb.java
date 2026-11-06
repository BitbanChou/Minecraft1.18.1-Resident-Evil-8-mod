package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Explosion.BlockInteraction;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Bomb extends PathfinderMob implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);


    private static final EntityDataAccessor<Boolean> IS_SMALL;
    private LivingEntity owner;
    private int oldSwell;
    private int swell;
    private int maxSwell = 40;

    public Bomb(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_SMALL, false);
    }

    public static Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.MAX_HEALTH, 2.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    public boolean canBeAffected(MobEffectInstance p_21197_) {
        return false;
    }

    public void tick() {
        this.oldSwell = this.swell++;
        if (this.swell >= this.maxSwell) {
            this.swell = this.maxSwell;
        }

        super.tick();
        if (this.tickCount == 1) {
            //this.playSound((SoundEvent)IllageAndSpillageSoundEvents.ENTITY_FREAKAGER_SHIVER.get(), 1.0F, 1.0F);
        }

        if (this.tickCount == 33) {
            //this.playSound((SoundEvent)IllageAndSpillageSoundEvents.ENTITY_FREAKAGER_SKULLBOMB_EXPLODE.get(), 3.0F, 1.0F);
        }

        if (this.tickCount >= 40) {
            this.explode();
        }

        if (this.onGround()) {
            this.setDeltaMovement((-0.5D + this.random.nextDouble()) * 0.6D, 0.3D, (-0.5D + this.random.nextDouble()) * 0.6D);
        }

    }

    public float getSwelling(float p_32321_) {
        return Mth.lerp(p_32321_, (float)this.oldSwell, (float)this.swell) / (float)(this.maxSwell - 2);
    }

    private void explode() {
        if (!this.level().isClientSide) {
            float f = this.isSmall() ? 1.5F : 2.5F;
            this.dead = true;
            this.level().explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), f, Level.ExplosionInteraction.NONE);
            if (!this.isSmall()) {
                Bomb s1 = (Bomb)(EntityInit.BOMB.get()).create(this.level());

                assert s1 != null;

                s1.setPos(this.getX(), this.getY() + 0.25D, this.getZ());
                s1.setSmall(true);
                s1.setDeltaMovement(-0.3D, 0.3D, -0.3D);
                s1.setOwner(this.getOwner());
                this.level().addFreshEntity(s1);
                Bomb s2 = (Bomb)(EntityInit.BOMB.get()).create(this.level());

                assert s2 != null;

                s2.setPos(this.getX(), this.getY() + 0.25D, this.getZ());
                s2.setSmall(true);
                s2.setDeltaMovement(-0.3D, 0.3D, 0.3D);
                s1.setOwner(this.getOwner());
                this.level().addFreshEntity(s2);
                Bomb s3 = (Bomb)(EntityInit.BOMB.get()).create(this.level());

                assert s3 != null;

                s3.setPos(this.getX(), this.getY() + 0.25D, this.getZ());
                s3.setSmall(true);
                s3.setDeltaMovement(0.3D, 0.3D, -0.3D);
                s1.setOwner(this.getOwner());
                this.level().addFreshEntity(s3);
                Bomb s4 = (Bomb)(EntityInit.BOMB.get()).create(this.level());

                assert s4 != null;

                s4.setPos(this.getX(), this.getY() + 0.25D, this.getZ());
                s4.setSmall(true);
                s4.setDeltaMovement(0.3D, 0.3D, 0.3D);
                s1.setOwner(this.getOwner());
                this.level().addFreshEntity(s4);
            }

            this.discard();
        }

    }

    public void aiStep() {
        if (this.level().isClientSide) {
            for(int i = 0; i < 2; ++i) {
                double d0 = (-0.5D + this.random.nextGaussian()) / 12.0D;
                double d1 = (-0.5D + this.random.nextGaussian()) / 12.0D;
                double d2 = (-0.5D + this.random.nextGaussian()) / 12.0D;
                this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX(1.0D), this.getRandomY() + 0.25D, this.getRandomZ(1.0D), d0, d1, d2);
            }
        }

        super.aiStep();
    }

    public boolean isSmall() {
        return (Boolean)this.entityData.get(IS_SMALL);
    }

    public void setSmall(boolean small) {
        this.entityData.set(IS_SMALL, small);
    }

    public LivingEntity getOwner() {
        return this.owner;
    }

    public void setOwner(LivingEntity owner) {
        this.owner = owner;
    }

    public boolean hurt(DamageSource p_21016_, float p_21017_) {
        return p_21016_ != damageSources().fellOutOfWorld() ? false : super.hurt(p_21016_, p_21017_);
    }

    public void die(DamageSource p_21014_) {
        this.deathTime = 19;
        super.die(p_21014_);
    }

    static {
        IS_SMALL = SynchedEntityData.defineId(Bomb.class, EntityDataSerializers.BOOLEAN);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }
}
