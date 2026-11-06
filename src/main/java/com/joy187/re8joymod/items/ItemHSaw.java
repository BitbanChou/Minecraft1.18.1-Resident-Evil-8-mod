package com.joy187.re8joymod.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import static com.joy187.re8joymod.items.ItemShield.MAIN_HAND_MODIFIER;
import static com.joy187.re8joymod.items.ItemShield.OFF_HAND_MODIFIER;

public class ItemHSaw extends AxeItem{
    public ItemHSaw(Tier toolMaterial, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolMaterial, attackDamage, attackSpeed, itemProperties);
    }

    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20 * 10, 2,false,true));
        target.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 20 * 15, 2,false,true));
        attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 5, 1,false,true));

        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand hand) {
        ItemStack itemstack = playerIn.getItemInHand(hand);
        if(!playerIn.getCooldowns().isOnCooldown(itemstack.getItem())) {

            playerIn.setDeltaMovement(playerIn.getViewVector(1));

            playerIn.getCooldowns().addCooldown(this,120);

            itemstack.hurtAndBreak(1, playerIn, (p_220009_1_) -> {
                p_220009_1_.broadcastBreakEvent(playerIn.getUsedItemHand());
            });
        }

        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack)
    {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.<Attribute, AttributeModifier>create();
        if (equipmentSlot == EquipmentSlot.OFFHAND )
        {
            multimap.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(OFF_HAND_MODIFIER, "Weapon modifier", (double)0.3, AttributeModifier.Operation.fromValue(0)));
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)4, AttributeModifier.Operation.fromValue(0)));
        }

        if (equipmentSlot == EquipmentSlot.MAINHAND)
        {
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)8, AttributeModifier.Operation.fromValue(0)));
            multimap.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(OFF_HAND_MODIFIER, "Weapon modifier", (double)0.6, AttributeModifier.Operation.fromValue(0)));
        }
        return multimap;
    }

}