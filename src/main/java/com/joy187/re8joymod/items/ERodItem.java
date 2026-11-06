package com.joy187.re8joymod.items;

import com.joy187.re8joymod.init.EffectInit;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

import java.util.Random;


public class ERodItem extends SwordItem {
    public ERodItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        Random ran = new Random();
        if(ran.nextInt(5)==2)
        {
            pTarget.addEffect(new MobEffectInstance(EffectInit.STUN.get(), 100,1,true,true));
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}