/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.level.Level
 */
package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;


import java.util.EnumSet;

import static com.joy187.re8joymod.entity.Klee.PIGEON_AREA;

public class EntityHonghong extends PathfinderMob implements GeoEntity {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);


    protected static final EntityDataAccessor<Integer> ATTACK_TYPE = SynchedEntityData.defineId(EntityHonghong.class, EntityDataSerializers.INT);
//    private static final EntityDataAccessor<Optional<BlockState>> BLOCK_STATE = SynchedEntityData.defineId(EntityHonghong.class, EntityDataSerializers.BLOCK_STATE);
    protected static final EntityDataAccessor<BlockPos> DATA_START_POS = SynchedEntityData.defineId(EntityHonghong.class, EntityDataSerializers.BLOCK_POS);

    public EntityHonghong(Level worldIn) {
        this(null, worldIn);
    }

    public EntityHonghong(EntityType<? extends PathfinderMob> type, Level worldIn) {
        super(type, worldIn);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.ATTACK_DAMAGE, 5.0)
                .add(Attributes.ATTACK_KNOCKBACK, 10.0)
                .add(Attributes.ATTACK_SPEED, 1.2f)
                .add(Attributes.MOVEMENT_SPEED, 0.45f)
                .add(Attributes.FOLLOW_RANGE, 50.0)
                .add(Attributes.ARMOR, 10.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, (Goal)new FloatGoal((Mob)this));
        this.goalSelector.addGoal(1, (Goal)new LookAtTargetGoal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK_TYPE, 0);
        this.entityData.define(DATA_START_POS, BlockPos.ZERO);
        //this.getEntityData().define(BLOCK_STATE, Optional.of(Blocks.DIRT.defaultBlockState()));
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        this.setAttackType(compound.getInt("attackType"));
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("attackType", this.getAttackType());
    }

    public int getAttackType() {
        return this.entityData.get(ATTACK_TYPE);
    }

    public void setAttackType(int attackType) {
        this.entityData.set(ATTACK_TYPE, attackType);
    }

    public void setStartPos(BlockPos p_31960_) {
        this.entityData.set(DATA_START_POS, p_31960_);
    }

//    public void setBlock(BlockState block) {
//        this.getEntityData().set(BLOCK_STATE, Optional.of(block));
//    }

    public BlockPos getStartPos() {
        return this.entityData.get(DATA_START_POS);
    }

    public void die(DamageSource p_21014_) {
        this.deathTime = 10;
        super.die(p_21014_);
    }

    private void explode() {
        this.playSound(SoundEvents.FIREWORK_ROCKET_BLAST_FAR, 3.0F, 1.0F);
        if (!this.level().isClientSide) {
            this.dead = true;
            for (LivingEntity lvt : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), PIGEON_AREA)) {
                double d00 = lvt.getX() - this.getX();
                double d10 = lvt.getZ() - this.getZ();
                double d20 = Math.max(d00 * d00 + d10 * d10, 0.001D);
                if(lvt instanceof Klee || lvt instanceof EntityHonghong){
                    lvt.heal(4);
                }
                else{
                    lvt.push(d00 / d20 * 1.1D, 0.2D, d10 / d20 * 1.1D);
                    lvt.setSecondsOnFire(50);
                    lvt.hurt(damageSources().mobAttack(this), ((LivingEntity)lvt).getMaxHealth()*0.1F+lvt.getArmorValue()*2);
                }
            }
            this.discard();
        }

    }


    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);
        if(this.tickCount%8==0)
            SparklingParticle();
        if(this.tickCount>=120){
            this.explode();
            this.discard();
        }
        if (!this.level().isClientSide && this.getTarget() != null) {
            LivingEntity target = this.getTarget();
            if (this.getAttackType() == 0) {
                if (this.tickCount < 80 && this.tickCount % 20 == 0) {
                    EntityHonghong enderEye = new EntityHonghong(EntityInit.FIRE_ENTITY.get(), this.level());
                    enderEye.setPos(this.position().x,this.position().y+0.5F,this.position().z);
                    enderEye.setTarget(this.getTarget());
                    enderEye.setAttackType(1);
                    this.level().addFreshEntity(enderEye);
                    this.setDeltaMovement(this.getRandom().nextDouble() / 2.0, this.getRandom().nextDouble() / 2.0, this.getRandom().nextDouble() / 2.0);
                    SparklingParticle();
                }
                if (this.tickCount >= 90) {
                    this.explode();
                    this.discard();
                }
            }
            if (this.getAttackType() == 1) {
                this.setDeltaMovement((target.getX() - this.getX()) / 8.0, (target.getY() - this.getY()) / 8.0, (target.getZ() - this.getZ()) / 8.0);
                if (this.distanceTo(target) <= 1.0f) {
                    target.hurt(damageSources().mobAttack(this), (float)(Attributes.ATTACK_DAMAGE.getDefaultValue()+8*random.nextFloat()));
                    target.setSecondsOnFire(40);
                    ((ServerLevel)this.level()).sendParticles(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 2, 0.2, 0.2, 0.2, 0.0);
                    this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0f, 1.0f);
                    this.discard();
                }
                else{
                    if(this.distanceToSqr(target)>2.0D && this.tickCount%10==0)
                    {
                        //this.parentEntity.setAttackingState(2);
                        Vec3 vec3 = this.position().add(0.0D, (double)1.6F, 0.0D);
                        Vec3 vec31 = target.getEyePosition().subtract(vec3);
                        Vec3 vec32 = vec31.normalize();

                        for(int i = 1; i < Mth.floor(vec31.length()) + 7; ++i) {
                            Vec3 vec33 = vec3.add(vec32.scale((double)i));
                            ((ServerLevel)this.level()).sendParticles(ParticleTypes.FLAME, vec33.x, vec33.y, vec33.z, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                        }

                        this.playSound(SoundEvents.FIREWORK_ROCKET_SHOOT, 3.0F, 1.0F);
                        target.hurt(damageSources().sonicBoom(this), 0.5f+this.getMaxHealth()*0.1F);
                    }
                }
            }
        }

    }

    private void SparklingParticle() {
        if (this.level().isClientSide) {
            BlockState block = level().getBlockState(getOnPos().below());
            for (int i1 = 0; i1 < 20 + random.nextInt(12); i1++) {
                double motionX = random.nextGaussian() * 0.07D;
                double motionY = random.nextGaussian() * 0.07D;
                double motionZ = random.nextGaussian() * 0.07D;
                float angle = (0.01745329251F * this.rotOffs) + i1;
                double extraX = 4F * Mth.sin((float) (Math.PI + angle));
                double extraY = 0.3F;
                double extraZ = 4F * Mth.cos(angle);
                //this.level().addParticle(ParticleTypes.GLOW, this.getRandomX(0.6D), this.getRandomY(), this.getRandomZ(0.6D) , motionX, motionY, motionZ);
                this.level().addParticle(ParticleTypes.FLAME, this.getX() + extraX, this.getY() + extraY, this.getZ() + extraZ , motionX, motionY, motionZ);
            }
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return factory;
    }

    class LookAtTargetGoal extends Goal {
        public LookAtTargetGoal() {
            this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE, Flag.JUMP));
        }

        public boolean canUse() {
            return EntityHonghong.this.getTarget() != null;
        }

        public boolean canContinueToUse() {
            return EntityHonghong.this.getTarget() != null;
        }

        public void tick() {
            EntityHonghong.this.navigation.stop();
            if (EntityHonghong.this.getTarget() != null) {
                EntityHonghong.this.getLookControl().setLookAt(EntityHonghong.this.getTarget(), 80.0f, 80.0f);
            }
        }
    }

//    public BlockState getBlockState() {
//        Optional bsOp = this.getEntityData().get(BLOCK_STATE);
//        if(bsOp.isPresent())
//            return this.getEntityData().get(BLOCK_STATE).get();
//        //return bsOp.orElse(null);
//        return Blocks.GRASS_BLOCK.defaultBlockState();
//    }

}

