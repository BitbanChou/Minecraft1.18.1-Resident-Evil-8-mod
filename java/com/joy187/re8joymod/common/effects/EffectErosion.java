package com.joy187.re8joymod.common.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectType;

import java.util.Random;

public class EffectErosion extends BaseEffect {
    public EffectErosion(EffectType type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return remainingTicks % 7 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplified) {
        amplified ++;
        Random ran = new Random();
        int co = ran.nextInt(5);
        for (EquipmentSlotType slot: EquipmentSlotType.values()) {
            DamageItemInSlot(slot, living, co*amplified);
        }
        //EntityUtil.spawnCubeParticleAround(living, EnumParticleTypes.SPELL_MOB_AMBIENT,0.5);


    }

    public void DamageItemInSlot(EquipmentSlotType slot, LivingEntity livingBase, int amount)
    {
        ItemStack stack = livingBase.getItemBySlot(slot);
        //stack.setDamageValue(amount);
        //stack.shrink(1);
        //stack.hurtAndBreak(amount,livingBase,null);
        stack.hurtAndBreak(1, livingBase, (p_220287_1_) -> {
            p_220287_1_.broadcastBreakEvent(slot);
        });
    }

    @Override
    public boolean isBeneficial() {
        return false;
    }

}
