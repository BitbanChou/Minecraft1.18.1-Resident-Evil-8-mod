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

public class ArmorHeisenBoots extends ArmorItem {

//    public ArmorDimiHat(IArmorMaterial armorMaterial, EquipmentSlotType equipmentSlotType, Properties properties) {
//        super(armorMaterial, equipmentSlotType, properties);
//        this.armorMaterial = armorMaterial;
//        this.equipmentSlotType = equipmentSlotType;
//    }

    public ArmorHeisenBoots(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
        super(material, equipmentSlot, properties);
        //this.HeisenBootsModel = armorModel;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
//        this.HeisenBootsModel.copyPropertiesTo(defaultArmor);
//        return HeisenBootsModel.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.FEET);
        if(!itemStack.isEmpty())
        {
            if(itemStack.getItem() instanceof ArmorItem)
            {
                HeisenBoots HeisenBootsModel = new HeisenBoots();
                HeisenBootsModel.leftLeg.visible = armorSlot == EquipmentSlotType.FEET;
//                HeisenBootsModel.rightLeg.visible = armorSlot == EquipmentSlotType.LEGS;

                HeisenBootsModel.leftArmPose = defaultArmor.leftArmPose;
                HeisenBootsModel.rightArmPose = defaultArmor.rightArmPose;
                HeisenBootsModel.crouching = defaultArmor.crouching;
                HeisenBootsModel.riding=defaultArmor.riding;
                HeisenBootsModel.young=defaultArmor.young;

                return HeisenBootsModel;
            }
        }
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.HEISEN_BOOTS.get())
        {
            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED,0,0,false,false));
        }
        super.onArmorTick(stack,world, player);
    }
}
