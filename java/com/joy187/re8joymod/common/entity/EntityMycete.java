package com.joy187.re8joymod.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.ZoglinEntity;
import net.minecraft.world.World;

public class EntityMycete extends ZoglinEntity {
    public EntityMycete(EntityType<? extends ZoglinEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 150;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 500.0D).
                add(Attributes.MOVEMENT_SPEED, 0.05D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.90D).
                add(Attributes.ARMOR, 20.0D).
                add(Attributes.ARMOR_TOUGHNESS, 30.0D).
                add(Attributes.ATTACK_DAMAGE, 100000.0D);
    }



}
