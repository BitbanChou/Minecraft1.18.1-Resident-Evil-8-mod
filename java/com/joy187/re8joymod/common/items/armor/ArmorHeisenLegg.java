package com.joy187.re8joymod.common.items.armor;

import com.joy187.re8joymod.common.init.ModItems;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class ArmorHeisenLegg extends ArmorItem {

//    public ArmorDimiHat(IArmorMaterial armorMaterial, EquipmentSlotType equipmentSlotType, Properties properties) {
//        super(armorMaterial, equipmentSlotType, properties);
//        this.armorMaterial = armorMaterial;
//        this.equipmentSlotType = equipmentSlotType;
//    }

    public ArmorHeisenLegg(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
        super(material, equipmentSlot, properties);
        //this.HeisenLeggModel = armorModel;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
//        this.HeisenLeggModel.copyPropertiesTo(defaultArmor);
//        return HeisenLeggModel.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.LEGS);

        if(!itemStack.isEmpty())
        {
            if(itemStack.getItem() instanceof ArmorItem)
            {
                HeisenLegg HeisenLeggModel = new HeisenLegg();
                HeisenLeggModel.leftLeg.visible = armorSlot == EquipmentSlotType.LEGS;
//                HeisenLeggModel.rightLeg.visible = armorSlot == EquipmentSlotType.LEGS;


                HeisenLeggModel.leftArmPose = defaultArmor.leftArmPose;
                HeisenLeggModel.rightArmPose = defaultArmor.rightArmPose;
                HeisenLeggModel.crouching = defaultArmor.crouching;
                HeisenLeggModel.riding=defaultArmor.riding;
                HeisenLeggModel.young=defaultArmor.young;

                return HeisenLeggModel;
            }
        }
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.HEISEN_LEGG.get())
        {
            player.addEffect(new EffectInstance(Effects.SLOW_FALLING,0,1,false,false));
        }
        super.onArmorTick(stack,world, player);
    }
}