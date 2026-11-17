package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class HeisenCarEntity extends HorseEntity {
    public MovementInput input;

    public HeisenCarEntity(EntityType<? extends HeisenCarEntity> p_i50250_1_, World p_i50250_2_) {
        super(p_i50250_1_, p_i50250_2_);
    }

//    public HeisenCarEntity(World worldIn, double x, double y, double z) {
//        //this(EntityInit.HEISENCAR.get(), worldIn);
//        this.setPos(x, y, z);
//        this.setDeltaMovement(Vector3d.ZERO);
//        this.xo = x;
//        this.yo = y;
//        this.zo = z;
//    }
    public void aiStep() {
        super.aiStep();
        this.hurt(this.level.getEntities(this, this.getBoundingBox().inflate(1.0D), EntityPredicates.NO_CREATIVE_OR_SPECTATOR));

    }


    protected void registerGoals() {
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.addBehaviourGoals();
    }


    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.JUMP_STRENGTH,0.2D);
    }

    public boolean canBeControlledByRider() {
        Entity entity = this.getControllingPassenger();
        if (!(entity instanceof PlayerEntity)) {
            return false;
        } else {
            PlayerEntity playerentity = (PlayerEntity)entity;
            return true;
        }
    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {

        this.doPlayerRide(p_230254_1_);
        return ActionResultType.sidedSuccess(this.level.isClientSide);
    }

    public void travel(Vector3d p_213352_1_) {
        if (this.isAlive()) {
            if (this.isVehicle() && this.canBeControlledByRider()) {
                LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
                this.yRot = livingentity.yRot;
                this.yRotO = this.yRot;
                this.xRot = livingentity.xRot * 0.5F;
                this.setRot(this.yRot, this.xRot);
                this.yBodyRot = this.yRot;
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                    this.gallopSoundCounter = 0;
                }

                if (this.onGround && this.playerJumpPendingScale == 0.0F && this.isStanding()) {
                    f = 0.0F;
                    f1 = 0.0F;
                }

                if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
                    double d0 = this.getCustomJump() * (double)this.playerJumpPendingScale * (double)this.getBlockJumpFactor();
                    double d1;
                    if (this.hasEffect(Effects.JUMP)) {
                        d1 = d0 + (double)((float)(this.getEffect(Effects.JUMP).getAmplifier() + 1) * 0.1F);
                    } else {
                        d1 = d0;
                    }

                    Vector3d vector3d = this.getDeltaMovement();
                    this.setDeltaMovement(vector3d.x, d1, vector3d.z);
                    this.setIsJumping(true);
                    if(this.isJumping){
                          this.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 20, 1,true,true));
                          this.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 20, 1,true,true));
                          this.addEffect(new EffectInstance(Effects.HEAL, 20, 3));
//                          livingentity.addEffect(new EffectInstance(Effects.HEAL, 20, 4));

                          this.level.explode((Entity)null, this.getX()+5-random.nextInt(2), this.getY()+1, this.getZ()+5-random.nextInt(2), (float)1, true, Explosion.Mode.DESTROY);
                          this.level.explode((Entity)null, this.getX()-5+random.nextInt(2), this.getY()+1, this.getZ()-5+random.nextInt(2), (float)1, true, Explosion.Mode.DESTROY);
                          this.level.explode((Entity)null, this.getX()+5-random.nextInt(2), this.getY()+1, this.getZ()-5+random.nextInt(2), (float)1, true, Explosion.Mode.DESTROY);
                          this.level.explode((Entity)null, this.getX()-5+random.nextInt(2), this.getY()+1, this.getZ()+5-random.nextInt(2), (float)1, true, Explosion.Mode.DESTROY);

                          //                        System.out.println("yes");
                    }
                    this.hasImpulse = true;
                    net.minecraftforge.common.ForgeHooks.onLivingJump(this);
//                    if (f1 > 0.0F) {
//                        float f2 = MathHelper.sin(this.yRot * ((float)Math.PI / 180F));
//                        float f3 = MathHelper.cos(this.yRot * ((float)Math.PI / 180F));
//                        this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double)(0.4F * f3 * this.playerJumpPendingScale)));
//                    }

                    this.playerJumpPendingScale = 0.0F;
                }

                this.flyingSpeed = this.getSpeed() * 0.1F;
                if (this.isControlledByLocalInstance()) {
                    this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
                    super.travel(new Vector3d((double)f, p_213352_1_.y, (double)f1));
                } else if (livingentity instanceof PlayerEntity) {
                    this.setDeltaMovement(Vector3d.ZERO);
                }

                if (this.onGround) {
                    this.playerJumpPendingScale = 0.0F;
                    this.setIsJumping(false);
                }

                this.calculateEntityAnimation(this, false);
            } else {
                this.flyingSpeed = 0.02F;
                super.travel(p_213352_1_);
            }
        }
    }

    protected void playGallopSound(SoundType p_190680_1_) {
        super.playGallopSound(p_190680_1_);
//        if (this.random.nextInt(2) > -1) {
            this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), p_190680_1_.getVolume() * 0.6F, p_190680_1_.getPitch());
//        }

        ItemStack stack = this.inventory.getItem(1);
        if (isArmor(stack)) stack.onHorseArmorTick(level, this);
    }

    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return SoundInit.ENTITY_HEISENCAR_ROLLING.get();
    }

    protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundInit.ENTITY_HEISENCAR_FIRING.get();
    }

    protected SoundEvent getAngrySound() {
        super.getAngrySound();
        return SoundInit.ENTITY_HEISENCAR_ROLLING.get();
    }

    @Nullable
    protected SoundEvent getEatingSound() {
        return SoundInit.ENTITY_HEISENCAR_ROLLING.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        super.getHurtSound(p_184601_1_);
        return SoundInit.ENTITY_HEISENCAR_ROLLING.get();
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        if (!p_180429_2_.getMaterial().isLiquid()) {
            BlockState blockstate = this.level.getBlockState(p_180429_1_.above());
            SoundType soundtype = p_180429_2_.getSoundType(level, p_180429_1_, this);
            if (blockstate.is(Blocks.SNOW)) {
                soundtype = blockstate.getSoundType(level, p_180429_1_, this);
            }

            if (this.isVehicle() && this.canGallop) {
                ++this.gallopSoundCounter;
                if (this.gallopSoundCounter > 5 && this.gallopSoundCounter % 3 == 0) {
                    this.playGallopSound(soundtype);
                } else if (this.gallopSoundCounter <= 5) {
                    this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
                }
            } else if (soundtype == SoundType.WOOD) {
                this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
            } else {
                this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
            }

        }
    }

    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        if (p_225503_1_ > 1.0F) {
            this.playSound(SoundInit.ENTITY_HEISENCAR_ROLLING.get(), 0.4F, 1.0F);
        }

        int i = this.calculateFallDamage(p_225503_1_, p_225503_2_);
        if (i <= 0) {
            return false;
        } else {
            this.hurt(DamageSource.FALL, (float)i);
            if (this.isVehicle()) {
                for(Entity entity : this.getIndirectPassengers()) {
                    entity.hurt(DamageSource.FALL, (float)i);
                }
            }

            this.playBlockFallSound();
            return true;
        }
    }

    protected void playJumpSound() {
        this.playSound(SoundInit.ENTITY_HEISENCAR_FIRING.get(), 0.4F, 1.0F);
    }

    public float getSteeringSpeed() {
        return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 1.15F;
    }

    public boolean canJump() {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void onPlayerJump(int p_110206_1_) {
//            if (p_110206_1_ < 0) {
//                p_110206_1_ = 0;
//            }
//
//            if (p_110206_1_ >= 0) {
//                this.playerJumpPendingScale = 1.0F;
//
//            } else {
                this.playerJumpPendingScale = 0.4F + 0.4F * (float)p_110206_1_ / 90.0F;
//            }
    }

    private void hurt(List<Entity> p_70971_1_) {
        for(Entity entity : p_70971_1_) {
            if (entity instanceof LivingEntity) {
                if(!(entity instanceof PlayerEntity)) {
                    entity.hurt(DamageSource.mobAttack(this), 8.0F);
                    this.doEnchantDamageEffects(this, entity);
                    if(random.nextInt(10)>8)
                    {
                        this.heal(random.nextFloat()*2);
                    }
//                    double d0 = (this.getBoundingBox().minX + this.getBoundingBox().maxX) / 2.0D;
//                    double d1 = (this.getBoundingBox().minZ + this.getBoundingBox().maxZ) / 2.0D;
//                    double d2 = entity.getX() - d0;
//                    double d3 = entity.getZ() - d1;
//                    double d4 = Math.max(d2 * d2 + d3 * d3, 0.1D);
//                    entity.push(d2 / d4 * 4.0D, (double)0.5F, d3 / d4 * 4.0D);
                }
            }
        }

    }

}
