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

public class ArmorFrankBoots extends ArmorItem {

//    public ArmorDimiHat(IArmorMaterial armorMaterial, EquipmentSlotType equipmentSlotType, Properties properties) {
//        super(armorMaterial, equipmentSlotType, properties);
//        this.armorMaterial = armorMaterial;
//        this.equipmentSlotType = equipmentSlotType;
//    }

    public ArmorFrankBoots(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
        super(material, equipmentSlot, properties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
//        this.frankBootsModel.copyPropertiesTo(defaultArmor);
//        return frankBootsModel.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.FEET);
        if(!itemStack.isEmpty())
        {
            if(itemStack.getItem() instanceof ArmorItem)
            {
                FrankBoots frankBootsModel = new FrankBoots();
                frankBootsModel.leftLeg.visible = armorSlot == EquipmentSlotType.FEET;
//                frankBootsModel.rightLeg.visible = armorSlot == EquipmentSlotType.LEGS;

                frankBootsModel.leftArmPose = defaultArmor.leftArmPose;
                frankBootsModel.rightArmPose = defaultArmor.rightArmPose;
                frankBootsModel.crouching = defaultArmor.crouching;
                frankBootsModel.riding=defaultArmor.riding;
                frankBootsModel.young=defaultArmor.young;

                return frankBootsModel;
            }
        }
        return null;
    }
}
