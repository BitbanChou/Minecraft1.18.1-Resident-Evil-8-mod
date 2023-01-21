package com.joy187.re8joymod.common.items.armor;

import com.joy187.re8joymod.common.init.ModEffects;
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

public class ArmorDimiSuit extends ArmorItem {



    public ArmorDimiSuit(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {

        super(material, equipmentSlot, properties);

        //this.dimisuitModel = armorModel;

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
        if(!itemStack.isEmpty())
        {
            if(itemStack.getItem() instanceof ArmorItem)
            {
                DimiSuit dimisuitModel = new DimiSuit();
                dimisuitModel.body.visible = armorSlot == EquipmentSlotType.CHEST;
                dimisuitModel.leftArm.visible = armorSlot == EquipmentSlotType.CHEST;
                dimisuitModel.rightArm.visible = armorSlot == EquipmentSlotType.CHEST;

                dimisuitModel.leftArmPose = defaultArmor.leftArmPose;
                dimisuitModel.rightArmPose = defaultArmor.rightArmPose;
                dimisuitModel.crouching = defaultArmor.crouching;
                dimisuitModel.riding=defaultArmor.riding;
                dimisuitModel.young=defaultArmor.young;

                return dimisuitModel;
            }
        }
        return null;
        //.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.HEAD);
    }



    @OnlyIn(Dist.CLIENT)
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.DIMI_SUIT.get())
        {
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST,10,2,false,false));
            player.addEffect(new EffectInstance(ModEffects.ZEN_HEART.get(),10,0,false,false));
        }
        super.onArmorTick(stack,world, player);
    }

}
