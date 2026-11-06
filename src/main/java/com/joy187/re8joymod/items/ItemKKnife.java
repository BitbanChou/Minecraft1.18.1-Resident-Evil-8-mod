package com.joy187.re8joymod.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.joy187.re8joymod.entity.EntityRegenerator;
import com.joy187.re8joymod.init.EffectInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ItemKKnife extends ItemCombatKnife{
    public ItemKKnife() {
        super();
    }

    public boolean hurtEnemy(ItemStack itemstack, LivingEntity target, LivingEntity attacker) {
        target.hurt(attacker.damageSources().mobAttack(attacker),6.0F+attacker.getRandom().nextFloat());

        if(target instanceof EntityRegenerator){
            target.addEffect(new MobEffectInstance(EffectInit.BURN.get(),30,6,false,false));
        }

        if(attacker instanceof Player playerIn)
        {
            itemstack.hurtAndBreak(1, playerIn, (p_220009_1_) -> {
                p_220009_1_.broadcastBreakEvent(playerIn.getUsedItemHand());
            });
        }

        return true;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack)
    {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.<Attribute, AttributeModifier>create();
        if (equipmentSlot == EquipmentSlot.OFFHAND )
        {
            multimap.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(OFF_HAND_MODIFIER, "Weapon modifier", (double)0.2, AttributeModifier.Operation.fromValue(0)));
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)3, AttributeModifier.Operation.fromValue(0)));
        }

        if (equipmentSlot == EquipmentSlot.MAINHAND)
        {
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)2, AttributeModifier.Operation.fromValue(0)));
            //multimap.put(GlobalEntityTypeAttributes.ATTACK_DAMAGE, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)6 / 2f, AttributeModifier.Operation.fromValue(0)));
        }
        return multimap;
    }
}
