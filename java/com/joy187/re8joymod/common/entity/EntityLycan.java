package com.joy187.re8joymod.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.fluid.FluidState;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityLycan extends EntityFrank1{
    public EntityLycan(EntityType<? extends EntityFrank1> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 8;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 35.0D).
                add(Attributes.MOVEMENT_SPEED, 0.32D).
                add(Attributes.ATTACK_DAMAGE, 5.0D);
    }

    public boolean doHurtTarget(Entity entityIn) {
        boolean flag = super.doHurtTarget(entityIn);
        if (flag && this.getMainHandItem().isEmpty() && entityIn instanceof LivingEntity) {
            float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity)entityIn).addEffect(new EffectInstance(Effects.WEAKNESS, 100 * (int)f));
        }
        return flag;
    }

    protected void customServerAiStep() {

        super.customServerAiStep();

        BlockPos blockpos = new BlockPos(this.position().x, this.position().y, this.position().z);
        FluidState fluidstate = this.level.getFluidState(blockpos);
        BlockState blockstate0 = this.level.getBlockState(blockpos.below());
        BlockState blockstate = this.level.getBlockState(blockpos.below().below().below().below());
        if(fluidstate.is(FluidTags.WATER) && this.getHealth() >= 34.99F && this.getHealth()<=35.0F)
        {
            this.remove();
        }
        if(blockstate0.is(Blocks.AIR) && blockstate.is(Blocks.AIR) && this.getHealth() >= 34.99F && this.getHealth()<=35.0F) {
            this.remove();
        }
    }
}
