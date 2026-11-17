package com.joy187.re8joymod.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityLycan1 extends EntityLycan{
    public EntityLycan1(EntityType<? extends EntityLycan> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 20;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 75.0D).
                add(Attributes.MOVEMENT_SPEED, 0.28D).
                add(Attributes.ARMOR, 8D).
                add(Attributes.ARMOR_TOUGHNESS, 10D).
                add(Attributes.ATTACK_DAMAGE, 10.5D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0f));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new JumpGoal() {
            @Override
            public boolean canUse() {
                return false;
            }
        });
        this.goalSelector.addGoal(4,new LeapAtTargetGoal(this, 0.5f));

        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
//        super.addBehaviourGoals();
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
    }

    protected void customServerAiStep() {

        super.customServerAiStep();

        BlockPos blockpos = new BlockPos(this.position().x, this.position().y, this.position().z);
        FluidState fluidstate = this.level.getFluidState(blockpos);
        BlockState blockstate0 = this.level.getBlockState(blockpos.below());
        BlockState blockstate = this.level.getBlockState(blockpos.below().below().below().below());
        if(fluidstate.is(FluidTags.WATER) && this.getHealth() >= 74.99F && this.getHealth()<=75.0F)
        {
            this.remove();
        }
        if(blockstate0.is(Blocks.AIR) && blockstate.is(Blocks.AIR) && this.getHealth() >= 74.99F && this.getHealth()<=75.0F) {
            this.remove();
        }
    }
}
