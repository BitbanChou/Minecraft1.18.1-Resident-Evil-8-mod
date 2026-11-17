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

public class ArmorFrankLegg extends ArmorItem {
//    public ArmorDimiHat(IArmorMaterial armorMaterial, EquipmentSlotType equipmentSlotType, Properties properties) {
//        super(armorMaterial, equipmentSlotType, properties);
//        this.armorMaterial = armorMaterial;
//        this.equipmentSlotType = equipmentSlotType;
//    }

    public ArmorFrankLegg(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
        super(material, equipmentSlot, properties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
//        this.frankLeggModel.copyPropertiesTo(defaultArmor);
//        return frankLeggModel.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.LEGS);

        if(!itemStack.isEmpty())
        {
            if(itemStack.getItem() instanceof ArmorItem)
            {
                FrankLegg frankLeggModel = new FrankLegg();
                frankLeggModel.leftLeg.visible = armorSlot == EquipmentSlotType.LEGS;
//                frankLeggModel.rightLeg.visible = armorSlot == EquipmentSlotType.LEGS;


                frankLeggModel.leftArmPose = defaultArmor.leftArmPose;
                frankLeggModel.rightArmPose = defaultArmor.rightArmPose;
                frankLeggModel.crouching = defaultArmor.crouching;
                frankLeggModel.riding=defaultArmor.riding;
                frankLeggModel.young=defaultArmor.young;

                return frankLeggModel;
            }
        }
        return null;
    }
}
