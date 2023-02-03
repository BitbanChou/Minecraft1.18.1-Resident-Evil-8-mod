package com.joy187.re8joymod.common.items.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArmorFrankChest extends ArmorItem {


    public ArmorFrankChest(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
        super(material, equipmentSlot, properties);
       // this.frankChestModel = armorModel;

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
        FrankChest frankChestModel = new FrankChest();
        frankChestModel.copyPropertiesTo(defaultArmor);
        return frankChestModel.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.CHEST);
    }


}
