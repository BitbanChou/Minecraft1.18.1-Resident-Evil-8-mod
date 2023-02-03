package com.joy187.re8joymod.common.items;


import com.joy187.re8joymod.common.init.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;

import java.util.Random;

public class EbonySwordItem extends SwordItem {
    public EbonySwordItem(IItemTier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Random ran = new Random();
        if(ran.nextInt(5)==1)
            pTarget.addEffect(new EffectInstance(ModEffects.DEADLY.get(), 20*3, 0, true, true));

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}