package com.joy187.re8joymod.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.world.World;

public class EntityLycana extends SkeletonEntity {

    public EntityLycana(EntityType<? extends SkeletonEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 10;
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).
                add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

}
