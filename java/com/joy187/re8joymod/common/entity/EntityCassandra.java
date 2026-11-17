package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Random;


public class EntityCassandra extends EntityFrank1 {
    public EntityCassandra(EntityType<? extends EntityFrank1> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 32;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).
                add(Attributes.MOVEMENT_SPEED, 0.29D).
                add(Attributes.FOLLOW_RANGE, 18.0D).
                add(Attributes.ARMOR, 8D).
                add(Attributes.ARMOR_TOUGHNESS, 8.0D).
                add(Attributes.ATTACK_DAMAGE, 9.0D);
    }

    public boolean doHurtTarget(Entity p_70652_1_) {
        boolean flag = super.doHurtTarget(p_70652_1_);
        if (flag && this.getMainHandItem().isEmpty() && p_70652_1_ instanceof LivingEntity) {
            float f = this.level.getCurrentDifficultyAt(this.blockPosition()).getEffectiveDifficulty();
            if(((LivingEntity) p_70652_1_).getHealth()>15.0f)
                ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.WEAKNESS, 20 * (int)f));
            else
                ((LivingEntity)p_70652_1_).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 40 * (int)f));

        }

        return flag;
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

}