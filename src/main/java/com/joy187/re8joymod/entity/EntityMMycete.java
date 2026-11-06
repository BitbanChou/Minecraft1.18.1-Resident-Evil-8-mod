package com.joy187.re8joymod.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;


public class EntityMMycete extends EntityMycete{

    public EntityMMycete(EntityType<? extends EntityMycete> type, Level worldIn) {
        super(type, worldIn);
        this.xpReward = 1050;
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 5000.0D).
                add(Attributes.MOVEMENT_SPEED, 0.15D).
                add(Attributes.KNOCKBACK_RESISTANCE, 0.99D).
                add(Attributes.ARMOR, 80.0D).
                add(Attributes.ARMOR_TOUGHNESS, 100.0D).
                add(Attributes.ATTACK_DAMAGE, 100000000.0D);
    }

    @Override
    public boolean hurt(DamageSource p_37849_, float p_37850_)
    {
        if (!level().isClientSide()) {
            boolean isHurt = true;
            if (p_37849_ != damageSources().fellOutOfWorld() && p_37850_ > 4.0F) {
                this.hurt(p_37849_,1F);
            }
            //System.out.println(isHurt);
            if(isHurt)
                return super.hurt(p_37849_,Math.min(p_37850_,this.getMaxHealth()*0.9f));
        }
        return false;
    }

}