package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.entity.variant.PlagasZombieVariant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;


public class EntityPlagasZombie extends EntityLycan{

    public EntityPlagasZombie(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 32.0D).
                add(Attributes.MOVEMENT_SPEED, 0.265D).
                add(Attributes.ATTACK_DAMAGE, 6.5D);
    }

    public PlagasZombieVariant getVariant2() {
        return PlagasZombieVariant.byId(this.getTypeVariant() & 255);
    }

}
