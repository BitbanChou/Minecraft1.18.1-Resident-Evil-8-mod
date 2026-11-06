package com.joy187.re8joymod.entity;

import java.util.Random;

import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public class EntityDaniela extends EntityBela implements GeoEntity {
	
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public EntityDaniela(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
        this.xpReward = 30;
	}
	
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 30.0D).
                add(Attributes.MOVEMENT_SPEED, 0.32D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 8D).
                add(Attributes.ARMOR_TOUGHNESS, 8.0D).
                add(Attributes.ATTACK_DAMAGE, 7.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundInit.ENTITY_DANIELA_AMBIENT1.get();
        return SoundInit.ENTITY_DANIELA_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {

        return SoundInit.ENTITY_DANIELA_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_DANIELA_DEATH.get();
    }

    protected void customServerAiStep() {
        Random ran = new Random();
        if(this.getHealth() >= 8.0F && this.getHealth()<=20.0F)
        {
            for(int i=0;i<4;i++)
                this.heal(1.2F*ran.nextFloat());
        }

        super.customServerAiStep();
    }
    
    
    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if(((LivingEntity) p_70652_1_).getHealth()>15.0f)
                ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20 * (int)f));
            else
                ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40 * (int)f));

        }

        return flag;
    }
}
