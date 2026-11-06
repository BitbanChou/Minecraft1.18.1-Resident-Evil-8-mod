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
 *  net.minecraft.world.damagesource.damageSources()
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

import java.util.EnumSet;
import java.util.Optional;

import com.joy187.re8joymod.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class FireEntity extends PathfinderMob {
    protected static final EntityDataAccessor<Integer> ATTACK_TYPE = SynchedEntityData.defineId(FireEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Optional<BlockState>> BLOCK_STATE = SynchedEntityData.defineId(FireEntity.class, EntityDataSerializers.OPTIONAL_BLOCK_STATE);
    protected static final EntityDataAccessor<BlockPos> DATA_START_POS = SynchedEntityData.defineId(FireEntity.class,EntityDataSerializers.BLOCK_POS);

    public FireEntity(Level worldIn) {
        this(null, worldIn);
    }

    public FireEntity(EntityType<? extends PathfinderMob> type, Level worldIn) {
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
        this.entityData.define(DATA_START_POS,BlockPos.ZERO);
        this.getEntityData().define(BLOCK_STATE, Optional.of(Blocks.DIRT.defaultBlockState()));
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

    public void setBlock(BlockState block) {
        this.getEntityData().set(BLOCK_STATE, Optional.of(block));
    }

    public BlockPos getStartPos() {
        return this.entityData.get(DATA_START_POS);
    }


    public BlockState getBlock() {
        Optional bsOp = this.getEntityData().get(BLOCK_STATE);
        if(bsOp.isPresent())
            return this.getEntityData().get(BLOCK_STATE).get();
        return Blocks.GRASS_BLOCK.defaultBlockState();
    }

//    public boolean hurt(DamageSource damageSource, float amount) {
//        if (damageSource.equals(damageSources().fellOutOfWorld())) {
//            return super.hurt(damageSource, amount);
//        }
//        else if(damageSource.getEntity()!=null){
//            if(damageSource.getEntity() instanceof Projectile){
//                return super.hurt(damageSource, amount/4);
//            }
//            else if(damageSource.equals(damageSources().mobAttack(((LivingEntity)damageSource.getEntity())))){
//                return super.hurt(damageSource, amount/3);
//            }
//        }
//        return false;
//    }

    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);
        if (!this.level().isClientSide && this.getTarget() != null) {
            LivingEntity target = this.getTarget();
            if (this.getAttackType() == 0) {
                if (this.tickCount < 120 && this.tickCount % 20 == 0) {
                    FireEntity enderEye = new FireEntity(EntityInit.FIREENTITY.get(), this.level());
                    enderEye.setPos(this.position());
                    enderEye.setTarget(this.getTarget());
                    enderEye.setAttackType(1);
                    this.level().addFreshEntity(enderEye);
                    this.setDeltaMovement(this.getRandom().nextDouble() / 2.0, this.getRandom().nextDouble() / 2.0, this.getRandom().nextDouble() / 2.0);
                }
                if (this.tickCount >= 150) {
                    this.discard();
                }
            }
            if (this.getAttackType() == 1) {
                this.setDeltaMovement((target.getX() - this.getX()) / 8.0, (target.getY() - this.getY()) / 8.0, (target.getZ() - this.getZ()) / 8.0);
                if (this.distanceTo(target) <= 1.0f) {
                    target.hurt(damageSources().mobAttack(this), (float)(Attributes.ATTACK_DAMAGE.getDefaultValue()+8*random.nextFloat()));
                    ((ServerLevel)this.level()).sendParticles(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 2, 0.2, 0.2, 0.2, 0.0);
                    this.playSound(SoundEvents.GENERIC_EXPLODE, 1.0f, 1.0f);
                    this.discard();
                }
            }
        }
    }

    class LookAtTargetGoal extends Goal {
        public LookAtTargetGoal() {
            this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE, Flag.JUMP));
        }

        public boolean canUse() {
            return FireEntity.this.getTarget() != null;
        }

        public boolean canContinueToUse() {
            return FireEntity.this.getTarget() != null;
        }

        public void tick() {
            FireEntity.this.navigation.stop();
            if (FireEntity.this.getTarget() != null) {
                FireEntity.this.getLookControl().setLookAt(FireEntity.this.getTarget(), 80.0f, 80.0f);
            }
        }
    }

    public BlockState getBlockState() {
        Optional bsOp = this.getEntityData().get(BLOCK_STATE);
        if(bsOp.isPresent())
            return this.getEntityData().get(BLOCK_STATE).get();
        //return bsOp.orElse(null);
        return Blocks.GRASS_BLOCK.defaultBlockState();
    }

}

