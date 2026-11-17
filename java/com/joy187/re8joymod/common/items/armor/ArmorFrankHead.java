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

public class ArmorFrankHead extends ArmorItem {


    public ArmorFrankHead(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
        super(material, equipmentSlot, properties);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
        if(!itemStack.isEmpty())
        {
            if(itemStack.getItem() instanceof ArmorItem)
            {
                FrankHead frankHeadModel = new FrankHead();
                frankHeadModel.head.visible = armorSlot == EquipmentSlotType.HEAD;

                frankHeadModel.leftArmPose = defaultArmor.leftArmPose;
                frankHeadModel.rightArmPose = defaultArmor.rightArmPose;
                frankHeadModel.crouching = defaultArmor.crouching;
                frankHeadModel.riding=defaultArmor.riding;
                frankHeadModel.young=defaultArmor.young;

                return frankHeadModel;
            }
        }
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.FRANK_HEAD.get()
        && player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.FRANK_CHEST.get()
        && player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.FRANK_LEGG.get()
        && player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.FRANK_BOOTS.get())
        {
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST,0,1,false,false));
            player.addEffect(new EffectInstance(Effects.JUMP,0,0,false,false));
            player.addEffect(new EffectInstance(Effects.FIRE_RESISTANCE,0,1,true,true));
            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE,0,1,true,true));
        }
        super.onArmorTick(stack,world, player);
    }

}
