package com.joy187.re8joymod.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ItemZealotShield extends ItemShield {

    public ItemZealotShield() {
        super();
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 108;
    }


    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack)
    {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.<Attribute, AttributeModifier>create();
        if (equipmentSlot == EquipmentSlot.OFFHAND )
        {
            multimap.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(OFF_HAND_MODIFIER, "Weapon modifier", (double)0.1, AttributeModifier.Operation.fromValue(0)));
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)1, AttributeModifier.Operation.fromValue(0)));
        }

        if (equipmentSlot == EquipmentSlot.MAINHAND)
        {
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)1, AttributeModifier.Operation.fromValue(0)));
            //multimap.put(GlobalEntityTypeAttributes.ATTACK_DAMAGE, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)6 / 2f, AttributeModifier.Operation.fromValue(0)));
        }
        return multimap;
    }

}
