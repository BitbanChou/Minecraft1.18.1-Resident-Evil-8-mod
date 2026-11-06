package com.joy187.re8joymod.items;

import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.joy187.re8joymod.Main;

import net.minecraft.tags.ItemTags;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ItemShield extends ShieldItem{
    protected static final UUID OFF_HAND_MODIFIER = UUID.fromString("9271eeea-5f74-4e12-97b6-7cf3c60ef7a0");
    protected static final UUID MAIN_HAND_MODIFIER = UUID.fromString("7d766720-0695-46c6-b320-44529f3da63f");

    public ItemShield() {
        super(new Properties().stacksTo(1).durability(768));
    }
    
    public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
        return true;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public UseAnim getUseAnimation(ItemStack p_40678_) {
        return UseAnim.BLOCK;
     }
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_77659_1_, Player playerIn, InteractionHand handIn) {

        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.startUsingItem(handIn);
        return InteractionResultHolder.consume(itemstack);
    }
    
    @Override
    public int getMaxDamage(ItemStack stack) {
        return 768;
    }

  
    public boolean isValidRepairItem(ItemStack p_43091_, ItemStack p_43092_) {
        return p_43092_.is(ItemTags.PLANKS) || super.isValidRepairItem(p_43091_, p_43092_);
     }
    
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack)
    {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.<Attribute, AttributeModifier>create();
        if (equipmentSlot == EquipmentSlot.OFFHAND )
        {
            multimap.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(OFF_HAND_MODIFIER, "Weapon modifier", (double)0.3, AttributeModifier.Operation.fromValue(0)));
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)6, AttributeModifier.Operation.fromValue(0)));
        }

        if (equipmentSlot == EquipmentSlot.MAINHAND)
        {
            multimap.put(Attributes.ARMOR, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)6, AttributeModifier.Operation.fromValue(0)));
            //multimap.put(GlobalEntityTypeAttributes.ATTACK_DAMAGE, new AttributeModifier(MAIN_HAND_MODIFIER, "Weapon modifier", (double)6 / 2f, AttributeModifier.Operation.fromValue(0)));
        }
        return multimap;
    }


}
