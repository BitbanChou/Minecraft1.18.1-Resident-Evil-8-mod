package com.joy187.re8joymod.items;

import java.util.Random;

import com.joy187.re8joymod.init.EffectInit;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class EbonySwordItem extends SwordItem {
    public EbonySwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Random ran = new Random();
        if(ran.nextInt(5)==1)
        	pTarget.addEffect(new MobEffectInstance(EffectInit.DEADLY.get(), 20*3, 0, true, true), pAttacker);
        
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}