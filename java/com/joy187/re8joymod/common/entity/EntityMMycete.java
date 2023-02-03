package com.joy187.re8joymod.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.ZoglinEntity;
import net.minecraft.world.World;

public class EntityMMycete extends EntityMycete{
    public EntityMMycete(EntityType<? extends EntityMycete> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 200;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 5000.0D).
                add(Attributes.MOVEMENT_SPEED, 0.15D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.99D).
                add(Attributes.ARMOR, 80.0D).
                add(Attributes.ARMOR_TOUGHNESS, 100.0D).
                add(Attributes.ATTACK_DAMAGE, 100000000.0D);
    }

}
