package com.joy187.re8joymod.items;

import com.joy187.re8joymod.init.EffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

import java.util.Random;


public class SickleItem extends SwordItem {
    public SickleItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Random ran = new Random();
        if(ran.nextInt(5)==3)
        {
            pAttacker.heal(pAttacker.getMaxHealth()*0.15f);
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}