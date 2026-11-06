package com.joy187.re8joymod.entity;

import java.util.Random;

import com.joy187.re8joymod.init.EffectInit;
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

public class EntityCassandra extends EntityBela implements GeoEntity {

    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public EntityCassandra(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
        this.xpReward = 30;
	}
	
    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 40.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 8D).
                add(Attributes.ARMOR_TOUGHNESS, 8.0D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundInit.ENTITY_CASSANDRA_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundInit.ENTITY_CASSANDRA_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_CASSANDRA_DEATH1.get();
        }
        return SoundInit.ENTITY_CASSANDRA_DEATH2.get();
    }
    
    
    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level().getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if(((LivingEntity) p_70652_1_).getHealth()>15.0f)
                ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20 * (int)f));
            else
                ((LivingEntity)p_70652_1_).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40 * (int)f));

        }

        return flag;
    }
	
}
