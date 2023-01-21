package com.joy187.re8joymod.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class EntityFrank5 extends RavagerEntity {
    public EntityFrank5(EntityType<? extends RavagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 50;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).
                add(Attributes.MOVEMENT_SPEED, 0.27D).
                add(Attributes.ATTACK_DAMAGE, 13.4D).
                add(Attributes.ARMOR, 8.0D).
                add(Attributes.ARMOR_TOUGHNESS, 10.0D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.85D);
    }

    class AttackGoal extends MeleeAttackGoal {
        public AttackGoal() {
            super(EntityFrank5.this, 1.0D, true);
        }

        protected double getAttackReachSqr(LivingEntity p_179512_1_) {
            float f = EntityFrank5.this.getBbWidth() - 0.1F;
            return (double)(f * 2.0F * f * 3.5F + p_179512_1_.getBbWidth());
        }
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(4, new EntityFrank5.AttackGoal());
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.6D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this, AbstractRaiderEntity.class)).setAlertOthers());
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));

    }

    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 60 * (int)f));
        }

        return flag;
    }

    protected void customServerAiStep() {

        super.customServerAiStep();

        BlockPos blockpos = new BlockPos(this.position().x, this.position().y, this.position().z);
        FluidState fluidstate = this.level.getFluidState(blockpos);
        BlockState blockstate0 = this.level.getBlockState(blockpos.below());
        BlockState blockstate = this.level.getBlockState(blockpos.below().below().below().below());
        if(fluidstate.is(FluidTags.WATER) && this.getHealth() >= 99.99F && this.getHealth()<=100.0F)
        {
            this.remove();
        }
        if(blockstate0.is(Blocks.AIR) && blockstate.is(Blocks.AIR) && this.getHealth() >= 99.99F && this.getHealth()<=100.0F) {
            this.remove();
        }
    }

}
