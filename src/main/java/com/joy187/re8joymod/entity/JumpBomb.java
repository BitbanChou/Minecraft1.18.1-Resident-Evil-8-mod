package com.joy187.re8joymod.entity;


import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
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


public class JumpBomb extends PathfinderMob implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);


    private static final EntityDataAccessor<Boolean> GOOPY;
    private LivingEntity owner;
    private int oldSwell;
    private int swell;
    private int maxSwell = 30;
    private int jumpTicks;
    private boolean isSwell;

    public JumpBomb(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(GOOPY, false);
    }

    public boolean getGoopy() {
        return (Boolean)this.entityData.get(GOOPY);
    }

    public void setGoopy() {
        this.entityData.set(GOOPY, true);
    }

    public static Builder prepareAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.0D)
                .add(Attributes.MAX_HEALTH, 6.0D)
                .add(Attributes.ATTACK_DAMAGE, 0.0D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    public boolean canBeAffected(MobEffectInstance p_21197_) {
        return false;
    }

    public void tick() {
        if (this.jumpTicks >= 100) {
            this.isSwell = true;
        }

        if (this.isSwell) {
            this.oldSwell = this.swell++;
            if (this.swell == 1) {
                this.playSound(SoundEvents.TNT_PRIMED, 1.0F, 0.5F);
            }

            if (this.swell >= this.maxSwell) {
                this.swell = this.maxSwell;
                this.explode();
            }
        }

        if (this.tickCount > 20) {
            if (this.onGround()) {
                ++this.jumpTicks;
            }

            if (this.getTarget() != null) {
                this.getLookControl().setLookAt(this.getTarget(), 30.0F, 30.0F);
                if (this.jumpTicks % 20 == 0 && this.onGround()) {
                    this.playSound(SoundEvents.MAGMA_CUBE_JUMP, 1.0F, 1.0F);
                    if (!this.level().isClientSide) {
                        this.setDeltaMovement((this.getTarget().getX() - this.getX()) * 0.4D * 0.16D, 0.5D, (this.getTarget().getZ() - this.getZ()) * 0.4D * 0.16D);
                    }
                }
            }
        }

        super.tick();
    }

    protected boolean shouldDespawnInPeaceful() {
        return this.getOwner() instanceof Monster;
    }

    public float getSwelling(float p_32321_) {
        return Mth.lerp(p_32321_, (float)this.oldSwell, (float)this.swell) / (float)(this.maxSwell - 2);
    }

    private void explode() {
        this.playSound(SoundEvents.FIREWORK_ROCKET_BLAST_FAR, 3.0F, 1.0F);
        if (!this.level().isClientSide) {
            this.dead = true;
            this.level().explode(this.getOwner(), this.getX(), this.getY(), this.getZ(), 4, Level.ExplosionInteraction.NONE);
            double throwSpeed = 0.15D;
            for(int i = 0; i < 4; ++i) {
                    Bomb s1 = (EntityInit.BOMB.get()).create(this.level());

                    assert s1 != null;

                    s1.setPos(this.getX(), this.getY() + 0.25D, this.getZ());
                    s1.setOwner(this);
                    if (i == 0) {
                        s1.setDeltaMovement(-throwSpeed, 0.1D, -throwSpeed);
                    } else if (i == 1) {
                        s1.setDeltaMovement(-throwSpeed, 0.1D, throwSpeed);
                    } else if (i == 2) {
                        s1.setDeltaMovement(throwSpeed, 0.1D, -throwSpeed);
                    } else {
                        s1.setDeltaMovement(throwSpeed, 0.13D, throwSpeed);
                    }

                    this.level().addFreshEntity(s1);
            }
            this.discard();
        }

    }

    public void aiStep() {
        if (this.level().isClientSide && this.tickCount >= 60) {
            for(int i = 0; i < 2; ++i) {
                double d0 = (-0.5D + this.random.nextGaussian()) / 12.0D;
                double d1 = (-0.5D + this.random.nextGaussian()) / 12.0D;
                double d2 = (-0.5D + this.random.nextGaussian()) / 12.0D;
                this.level().addParticle(ParticleTypes.SMOKE, this.getRandomX(1.0D), this.getRandomY() + 0.25D, this.getRandomZ(1.0D), d0, d1, d2);
            }
        }

        super.aiStep();
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
        GOOPY = SynchedEntityData.defineId(JumpBomb.class, EntityDataSerializers.BOOLEAN);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {

    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

}