package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class EntityDoll3 extends CaveSpiderEntity {
    public EntityDoll3(EntityType<? extends CaveSpiderEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 22;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0D).
                add(Attributes.MOVEMENT_SPEED, 0.34D).
                add(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    public boolean doHurtTarget(Entity p_70652_1_) {
        if (super.doHurtTarget(p_70652_1_)) {
            if (p_70652_1_ instanceof LivingEntity) {
                int i = 0;
                if (this.level.getDifficulty() == Difficulty.NORMAL) {
                    i = 7;
                } else if (this.level.getDifficulty() == Difficulty.HARD) {
                    i = 15;
                }

                if (i > 0) {
                    ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.BLINDNESS, i * 20, 0));
                }
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.ENTITY_DOLL_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.ENTITY_DOLL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_DOLL_HURT.get();
    }

    protected void customServerAiStep() {

        super.customServerAiStep();

        BlockPos blockpos = new BlockPos(this.position().x, this.position().y, this.position().z);
        FluidState fluidstate = this.level.getFluidState(blockpos);
        BlockState blockstate0 = this.level.getBlockState(blockpos.below());
        BlockState blockstate = this.level.getBlockState(blockpos.below().below().below().below());
        if(fluidstate.is(FluidTags.WATER) && this.getHealth() >= 29.99F && this.getHealth()<=30.0F)
        {
            this.remove();
        }
        if(blockstate0.is(Blocks.AIR) && blockstate.is(Blocks.AIR) && this.getHealth() >= 29.99F && this.getHealth()<=30.0F) {
            this.remove();
        }
    }
}
