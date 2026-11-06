package com.joy187.re8joymod.effects;

import java.util.Random;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class EffectErosion extends BaseEffect{
	   public EffectErosion(MobEffectCategory type, int color, boolean isInstant) {
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
	        for (EquipmentSlot slot: EquipmentSlot.values()) {
	            DamageItemInSlot(slot, living, co*amplified);
	        }
	        //EntityUtil.spawnCubeParticleAround(living, EnumParticleTypes.SPELL_MOB_AMBIENT,0.5);


	    }

	    public void DamageItemInSlot(EquipmentSlot slot, LivingEntity livingBase, int amount)
	    {
	        ItemStack stack = livingBase.getItemBySlot(slot);
	        //stack.setDamageValue(amount);
	        //stack.shrink(1);
	        //stack.hurtAndBreak(amount,livingBase,null);
	        stack.hurtAndBreak(amount, livingBase, (p_220287_1_) -> {
	            p_220287_1_.broadcastBreakEvent(slot);
	        });
	    }

	    @Override
	    public boolean isBeneficial() {
	        return false;
	    }
}
