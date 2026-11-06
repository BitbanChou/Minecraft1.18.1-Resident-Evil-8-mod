package com.joy187.re8joymod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityRegenerator2 extends EntityRegenerator{

    public EntityRegenerator2(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 75;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 25.0D).
                add(Attributes.MOVEMENT_SPEED, 0.26D).
                add(Attributes.FOLLOW_RANGE, 24.0D).
                add(Attributes.ARMOR, 2D).
                add(Attributes.ARMOR_TOUGHNESS, 2D).
                add(Attributes.ATTACK_DAMAGE, 8D);
    }

}
