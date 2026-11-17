package com.joy187.re8joymod.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ItemHSaw extends ItemAxe{
    public ItemHSaw(IItemTier toolMaterial, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }

    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new EffectInstance(Effects.WEAKNESS, 20 * 10, 2,false,true));
        target.addEffect(new EffectInstance(Effects.BAD_OMEN, 20 * 15, 2,false,true));
        attacker.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 20 * 5, 1,false,true));

        return true;
    }


}
