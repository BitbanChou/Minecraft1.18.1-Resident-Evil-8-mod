package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class EntityAda extends RavagerEntity {
    public EntityAda(EntityType<? extends RavagerEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 105;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 35.0D).
                add(Attributes.MOVEMENT_SPEED, 0.3D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 4D).
                add(Attributes.ARMOR_TOUGHNESS, 6.0D).
                add(Attributes.ATTACK_DAMAGE, 6.0D);
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglinEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityEthan.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityChris.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityHeisen.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda1.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda2.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, EntityMiranda4.class, true));

    }

    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if(((LivingEntity) p_70652_1_).getHealth()>15.0f)
                ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.HARM, 20 * (int)f));
            else
                ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 40 * (int)f));

        }

        return flag;
    }

    @Override
    public void customServerAiStep()
    {

        if(this.getHealth() >= 10.0F && this.getHealth()<=20.0F)
        {
            this.addEffect(new EffectInstance(Effects.REGENERATION, 20,1,false,true));
        }
        else if(this.getHealth()<8.0F){
            this.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 20,1,false,true));
            this.addEffect(new EffectInstance(Effects.INVISIBILITY, 20,0,false,false));
        }
        super.customServerAiStep();

    }

    @Override
    protected SoundEvent getAmbientSound() {

        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_ADA_AMBIENT1.get();
        }
        else if(co==1){
            return SoundInit.ENTITY_ADA_AMBIENT2.get();
        }
        return SoundInit.ENTITY_ADA_AMBIENT3.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SLIME_BLOCK_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==1){
            return SoundInit.ENTITY_ADA_DEATH.get();
        }
        return SoundInit.ENTITY_BELA_DEATH.get();
    }

}