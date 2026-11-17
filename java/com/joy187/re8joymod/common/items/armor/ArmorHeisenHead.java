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


public class ArmorHeisenHead extends ArmorItem {

    public ArmorHeisenHead(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
        super(material, equipmentSlot, properties);
        //this.HeisenHeadModel = armorModel;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
        if(!itemStack.isEmpty())
        {
            if(itemStack.getItem() instanceof ArmorItem)
            {
                HeisenHead HeisenHeadModel = new HeisenHead();
                HeisenHeadModel.head.visible = armorSlot == EquipmentSlotType.HEAD;

                HeisenHeadModel.leftArmPose = defaultArmor.leftArmPose;
                HeisenHeadModel.rightArmPose = defaultArmor.rightArmPose;
                HeisenHeadModel.crouching = defaultArmor.crouching;
                HeisenHeadModel.riding=defaultArmor.riding;
                HeisenHeadModel.young=defaultArmor.young;

                return HeisenHeadModel;
            }
        }
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.HEISEN_HEAD.get())
        {
            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE,0,4,false,false));
        }
        super.onArmorTick(stack,world, player);
    }

}