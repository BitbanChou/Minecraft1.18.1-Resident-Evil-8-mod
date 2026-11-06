package com.joy187.re8joymod.entity;

import java.util.Random;

import com.joy187.re8joymod.init.SoundInit;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityMoreau4 extends Guardian {
    public EntityMoreau4(EntityType<? extends Guardian> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 350;
    }


    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 300.0D).
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