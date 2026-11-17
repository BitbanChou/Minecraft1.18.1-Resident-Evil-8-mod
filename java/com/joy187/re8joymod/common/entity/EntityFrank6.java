package com.joy187.re8joymod.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.fluid.FluidState;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityFrank6 extends EntityFrank3{
    public EntityFrank6(EntityType<? extends EntityFrank3> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 40;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 80.0D).
                add(Attributes.MOVEMENT_SPEED, 0.25D).
                add(Attributes.ATTACK_DAMAGE, 10.5D).
                add(Attributes.ARMOR, 5.0D).
                add(Attributes.ARMOR_TOUGHNESS, 10.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D);
    }

    protected void customServerAiStep() {

        super.customServerAiStep();

        BlockPos blockpos = new BlockPos(this.position().x, this.position().y, this.position().z);
        FluidState fluidstate = this.level.getFluidState(blockpos);
        BlockState blockstate0 = this.level.getBlockState(blockpos.below());
        BlockState blockstate = this.level.getBlockState(blockpos.below().below().below().below());
        if(fluidstate.is(FluidTags.WATER) && this.getHealth() >= 79.99F && this.getHealth()<=80.0F)
        {
            this.remove();
        }
        if(blockstate0.is(Blocks.AIR) && blockstate.is(Blocks.AIR) && this.getHealth() >= 79.99F && this.getHealth()<=80.0F) {
            this.remove();
        }
    }
}
