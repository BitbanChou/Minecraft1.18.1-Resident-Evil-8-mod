package com.joy187.re8joymod.entity;

import com.joy187.re8joymod.entity.variant.PlagasVillagerVariant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;


public class EntityPlagasVillager extends EntityLycan{

    public EntityPlagasVillager(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 30.0D).
                add(Attributes.MOVEMENT_SPEED, 0.27D).
                add(Attributes.ATTACK_DAMAGE, 6D);
    }

    public PlagasVillagerVariant getVariant2() {
        return PlagasVillagerVariant.byId(this.getTypeVariant() & 255);
    }



}
