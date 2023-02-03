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


public class ArmorHeisenSuit extends ArmorItem {

    public ArmorHeisenSuit(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
        super(material, equipmentSlot, properties);
        //this.heisensuitModel = armorModel;

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
        if(!itemStack.isEmpty())
        {
            if(itemStack.getItem() instanceof ArmorItem)
            {
                HeisenSuit heisensuitModel = new HeisenSuit();
                heisensuitModel.body.visible = armorSlot == EquipmentSlotType.CHEST;
                heisensuitModel.leftArm.visible = armorSlot == EquipmentSlotType.CHEST;
                heisensuitModel.rightArm.visible = armorSlot == EquipmentSlotType.CHEST;

                heisensuitModel.leftArmPose = defaultArmor.leftArmPose;
                heisensuitModel.rightArmPose = defaultArmor.rightArmPose;
                heisensuitModel.crouching = defaultArmor.crouching;
                heisensuitModel.riding=defaultArmor.riding;
                heisensuitModel.young=defaultArmor.young;

                return heisensuitModel;
            }
        }
        return null;
        //.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.HEAD);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.HEISEN_SUIT.get())
        {
            player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE,0,3,false,false));
            player.addEffect(new EffectInstance(Effects.ABSORPTION,0,1,false,false));
        }
        super.onArmorTick(stack,world, player);
    }
}