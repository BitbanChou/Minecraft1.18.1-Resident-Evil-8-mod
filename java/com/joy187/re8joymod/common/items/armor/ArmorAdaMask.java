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

public class ArmorAdaMask extends ArmorItem {

    public ArmorAdaMask(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {

        super(material, equipmentSlot, properties);

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
        if(!itemStack.isEmpty())
        {
            if(itemStack.getItem() instanceof ArmorItem)
            {
                AdaMask dimihatModel = new AdaMask();
                dimihatModel.head.visible = armorSlot == EquipmentSlotType.HEAD;

                dimihatModel.leftArmPose = defaultArmor.leftArmPose;
                dimihatModel.rightArmPose = defaultArmor.rightArmPose;
                dimihatModel.crouching = defaultArmor.crouching;
                dimihatModel.riding=defaultArmor.riding;
                dimihatModel.young=defaultArmor.young;

                return dimihatModel;
            }
        }
        return null;
        //.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.HEAD);
    }



    @OnlyIn(Dist.CLIENT)
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.ADA_MASK.get())
        {
            player.addEffect(new EffectInstance(Effects.INVISIBILITY,20,1,false,false));
            player.addEffect(new EffectInstance(Effects.NIGHT_VISION,20,1,false,false));

            //player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST,10,2,false,false));
        }
        if(player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.HUMUS_HELMET.get() &&
           player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.HUMUS_CHESTPLATE.get() &&
           player.getItemBySlot(EquipmentSlotType.LEGS).getItem() == ModItems.HUMUS_LEGGINGS.get() &&
           player.getItemBySlot(EquipmentSlotType.FEET).getItem() == ModItems.HUMUS_BOOTS.get())
        {
            player.addEffect(new EffectInstance(ModEffects.ZEN_HEART.get(),20,1,false,false));

        }
        super.onArmorTick(stack,world, player);
    }
}
