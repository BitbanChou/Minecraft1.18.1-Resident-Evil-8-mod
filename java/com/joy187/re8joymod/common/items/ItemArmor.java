package com.joy187.re8joymod.common.items;


import com.joy187.re8joymod.common.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import java.util.List;

public class ItemArmor extends ArmorItem {
    private IArmorMaterial armorMaterial;
    private EquipmentSlotType equipmentSlotType;
    public ItemArmor(IArmorMaterial armorMaterial, EquipmentSlotType equipmentSlotType, Properties properties) {
        super(armorMaterial, equipmentSlotType, properties);
        this.armorMaterial = armorMaterial;
        this.equipmentSlotType = equipmentSlotType;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {

        Item HELMET = player.getItemBySlot(EquipmentSlotType.HEAD).getItem();
        Item CHESTPLATE = player.getItemBySlot(EquipmentSlotType.CHEST).getItem();
        Item LEGGINGS = player.getItemBySlot(EquipmentSlotType.LEGS).getItem();
        Item BOOTS = player.getItemBySlot(EquipmentSlotType.FEET).getItem();

        if(HELMET == ModItems.DIMI_HAT.get())
        {
            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED,10,2,false,false));
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST,10,2,false,false));
        }
        else if(HELMET == ModItems.MIRANDA_MASK.get())
        {
            player.addEffect(new EffectInstance(Effects.INVISIBILITY,0,2,false,false));
            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE,0,2,false,false));
        }
        else if(HELMET == (ModItems.FRANK_HEAD.get())
                && CHESTPLATE == (ModItems.FRANK_CHEST.get())
                && LEGGINGS == (ModItems.FRANK_LEGG.get())
                && BOOTS == (ModItems.FRANK_BOOTS.get()))
        {
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST,0,1,false,false));
            player.addEffect(new EffectInstance(Effects.JUMP,0,0,false,false));
            player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE,0,1,true,true));
            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE,0,1,true,true));
        }

//        //Turquoise: Water breathing & Dolphins Grace
//        if (HELMET == (ItemInit.TURQUOISE_HELMET.get())
//                && CHESTPLATE == (ItemInit.TURQUOISE_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.TURQUOISE_LEGGINGS.get())
//                && BOOTS == (ItemInit.TURQUOISE_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 10, 0, false, false));
//            player.addEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 10, 0, false, false));
//
//            //Sapphire: Night Vision
//        }else if (HELMET == (ItemInit.SAPPHIRE_HELMET.get())
//                && CHESTPLATE == (ItemInit.SAPPHIRE_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.SAPPHIRE_LEGGINGS.get())
//                && BOOTS == (ItemInit.SAPPHIRE_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 10, 0, false, false));
//
//            //Ruby: Fire Resistance
//        }else if (HELMET == (ItemInit.RUBY_HELMET.get())
//                && CHESTPLATE == (ItemInit.RUBY_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.RUBY_LEGGINGS.get())
//                && BOOTS == (ItemInit.RUBY_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 10, 0, false, false));
//
//            //Tanzanite: Speed Boost
//        }else if (HELMET == (ItemInit.TANZANITE_HELMET.get())
//                && CHESTPLATE == (ItemInit.TANZANITE_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.TANZANITE_LEGGINGS.get())
//                && BOOTS == (ItemInit.TANZANITE_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 10, 0, false, false));
//
//            //Cobalt: Mining Boost
//        }else if (HELMET == (ItemInit.COBALT_HELMET.get())
//                && CHESTPLATE == (ItemInit.COBALT_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.COBALT_LEGGINGS.get())
//                && BOOTS == (ItemInit.COBALT_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.DIG_SPEED, 10, 0, false, false));
//
//            //Tourmaline: Regeneration
//        }else if (HELMET == (ItemInit.TOURMALINE_HELMET.get())
//                && CHESTPLATE == (ItemInit.TOURMALINE_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.TOURMALINE_LEGGINGS.get())
//                && BOOTS == (ItemInit.TOURMALINE_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.REGENERATION, 10, 0, false, false));
//
//            //Emerald: Luck
//        }else if (HELMET == (ItemInit.EMERALD_HELMET.get())
//                && CHESTPLATE == (ItemInit.EMERALD_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.EMERALD_LEGGINGS.get())
//                && BOOTS == (ItemInit.EMERALD_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.LUCK, 10, 0, false, false));
//
//            //Obsidian: Slowness + Strength
//        }else if (HELMET == (ItemInit.OBSIDIAN_HELMET.get())
//                && CHESTPLATE == (ItemInit.OBSIDIAN_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.OBSIDIAN_LEGGINGS.get())
//                && BOOTS == (ItemInit.OBSIDIAN_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 10, 0, false, false));
//            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 10, 0, false, false));
//
//            //Tin: Jump Boost
//        }else if (HELMET == (ItemInit.TIN_HELMET.get())
//                && CHESTPLATE == (ItemInit.TIN_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.TIN_LEGGINGS.get())
//                && BOOTS == (ItemInit.TIN_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.JUMP, 10, 1, false, false));
//
//            //Amethyst: Slow Falling
//        }else if (HELMET == (ItemInit.AMETHYST_HELMET.get())
//                && CHESTPLATE == (ItemInit.AMETHYST_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.AMETHYST_LEGGINGS.get())
//                && BOOTS == (ItemInit.AMETHYST_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.SLOW_FALLING, 10, 0, false, false));
//            //Topaz: Mining Boost 2
//        }else if (HELMET == (ItemInit.TOPAZ_HELMET.get())
//                && CHESTPLATE == (ItemInit.TOPAZ_CHESTPLATE.get())
//                && LEGGINGS == (ItemInit.TOPAZ_LEGGINGS.get())
//                && BOOTS == (ItemInit.TOPAZ_BOOTS.get())) {
//            player.addEffect(new EffectInstance(Effects.DIG_SPEED, 10, 1, false, false));
//        }
    }


    @Override
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn){
//        if (armorMaterial == CustomArmorMaterial.ARMOR_TIN){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.DARK_GRAY + "Jump Boost"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_TIN.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_COBALT){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.GOLD + "Haste"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_COBALT.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_AMETHYST){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.GRAY + "Slow Falling"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_AMETHYST.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_OBSIDIAN){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.DARK_PURPLE + "Strength & Slowness"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_OBSIDIAN.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_EMERALD){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.GREEN + "Luck"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_EMERALD.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_TOURMALINE){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.RED + "Regeneration"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_TOURMALINE.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_TANZANITE){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.YELLOW + "Speed"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_TANZANITE.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_RUBY){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.DARK_RED + "Fire Resistance"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_RUBY.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_SAPPHIRE){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.BLUE + "Night Vision"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_SAPPHIRE.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_TURQUOISE){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.AQUA + "Water Breathing & Dolphins"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_TURQUOISE.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_COPPER){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_COPPER.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_BRONZE){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_BRONZE.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_SILVER){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_SILVER.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_STERLING){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_STERLING.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_STEEL){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_STEEL.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_TOPAZ){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Full Set Bonus: " + TextFormatting.GOLD + "Haste"));
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_TOPAZ.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_MOISSANITE){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_MOISSANITE.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_ONYX){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_ONYX.getDurabilityForSlot(equipmentSlotType)));
//        }
//        else if (armorMaterial == CustomArmorMaterial.ARMOR_GRAPHENE){
//            //Making the tooltips
//            tooltip.add(ITextComponent.nullToEmpty("Max Uses: " + TextFormatting.LIGHT_PURPLE + CustomArmorMaterial.ARMOR_GRAPHENE.getDurabilityForSlot(equipmentSlotType)));
//        }
    }


//    @Override
//    public EquipmentSlotType getSlot() {
//        return super.getSlot();
//    }
//
//    @Override
//    public IArmorMaterial getMaterial() {
//        return super.getMaterial();
//    }
}
