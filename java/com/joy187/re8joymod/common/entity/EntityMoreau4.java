package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.SoundInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Random;

public class EntityMoreau4 extends GuardianEntity {
    public EntityMoreau4(EntityType<? extends GuardianEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 350;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 300.0D).
                add(Attributes.MOVEMENT_SPEED, 0.6D).
                add(Attributes.FOLLOW_RANGE, 28.0D).
                add(Attributes.ATTACK_DAMAGE, 10D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundInit.ENTITY_MOREAU_AMBIENT1.get();
        return SoundInit.ENTITY_MOREAU_AMBIENT2.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        Random ran = new Random();
        int co = ran.nextInt(2);
        if(co==0) return SoundInit.ENTITY_MOREAU_HURT1.get();
        return SoundInit.ENTITY_MOREAU_HURT2.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundInit.ENTITY_MOREAU_DEATH.get();
    }

}
