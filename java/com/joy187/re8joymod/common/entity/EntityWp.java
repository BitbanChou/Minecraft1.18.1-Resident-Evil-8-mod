package com.joy187.re8joymod.common.entity;

import com.joy187.re8joymod.common.init.EntityInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class EntityWp extends EntityBp{
    public EntityWp(EntityType<? extends PigEntity> entityIn, World worldIn) {
        super(entityIn, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.26D);
    }

    public PigEntity getBreedOffspring(ServerWorld worldIn, AgeableEntity ageable) {
        Random ran = new Random();
        int co=ran.nextInt(4);
        if(co==1) return EntityInit.WP.get().create(worldIn);
        return EntityInit.BP.get().create(worldIn);
    }

}
