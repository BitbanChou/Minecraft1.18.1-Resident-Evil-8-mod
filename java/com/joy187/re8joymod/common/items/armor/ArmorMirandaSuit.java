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


public class ArmorMirandaSuit extends ArmorItem {


    public ArmorMirandaSuit(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
        super(material, equipmentSlot, properties);
       // this.mirandaSuitModel = armorModel;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
        MirandaSuit mirandaSuitModel = new MirandaSuit();
        mirandaSuitModel.copyPropertiesTo(defaultArmor);
        return mirandaSuitModel.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.CHEST);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.MIRANDA_SUIT.get())
        {
            player.addEffect(new EffectInstance(Effects.DIG_SPEED,10,3,false,false));
            player.addEffect(new EffectInstance(Effects.REGENERATION,10,3,true,true));
        }
        super.onArmorTick(stack,world, player);
    }


}
