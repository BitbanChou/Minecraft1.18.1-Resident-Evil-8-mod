package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class EntityDimi2 extends WitherEntity {
    public EntityDimi2(EntityType<? extends WitherEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 300;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 350.0D).
                add(Attributes.MOVEMENT_SPEED, 0.85D).
                add(Attributes.FOLLOW_RANGE, 30.0D).
                add(Attributes.ARMOR, 9.0D);
    }

    @Override
    protected SoundEvent getDeathSound() {
        Random ran = new Random();
        int co = ran.nextInt(3);
        if(co==0)
        {
            return SoundInit.ENTITY_DIMI_DEATH1.get();
        }
        else if(co==1) return SoundInit.ENTITY_DIMI_DEATH2.get();
        return SoundEvents.BEE_DEATH;
    }

    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_DIMI_AMBIENT1.get();
        }
        return  SoundInit.ENTITY_DIMI_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0)
        {
            return SoundInit.ENTITY_DIMI_HURT1.get();
        }
        return SoundInit.ENTITY_DIMI_HURT2.get();
    }


}
