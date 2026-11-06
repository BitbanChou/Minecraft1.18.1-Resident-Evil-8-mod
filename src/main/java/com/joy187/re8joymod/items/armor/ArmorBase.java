package com.joy187.re8joymod.items.armor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArmorBase extends ArmorItem{
	
    public ArmorBase(ArmorMaterial material, Type equipmentSlot, Properties properties) {

        super(material, equipmentSlot, properties);

        //this.dimisuitModel = armorModel;

    }
    
//    @OnlyIn(Dist.CLIENT)
//    @Override
//    public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
//        if(!itemStack.isEmpty())
//        {
//            if(itemStack.getItem() instanceof ArmorItem)
//            {
//                DimiSuit dimisuitModel = new DimiSuit();
//                dimisuitModel.body.visible = armorSlot == EquipmentSlotType.CHEST;
//                dimisuitModel.leftArm.visible = armorSlot == EquipmentSlotType.CHEST;
//                dimisuitModel.rightArm.visible = armorSlot == EquipmentSlotType.CHEST;
//
//                dimisuitModel.leftArmPose = defaultArmor.leftArmPose;
//                dimisuitModel.rightArmPose = defaultArmor.rightArmPose;
//                dimisuitModel.crouching = defaultArmor.crouching;
//                dimisuitModel.riding=defaultArmor.riding;
//                dimisuitModel.young=defaultArmor.young;
//
//                return dimisuitModel;
//            }
//        }
//        return null;
//        //.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.HEAD);
//    }



//    @OnlyIn(Dist.CLIENT)
//    @Override
//    public void onArmorTick(ItemStack stack, World world, Player player) {
//        if(player.getItemBySlot(EquipmentSlotType.CHEST).getItem() == ModItems.DIMI_SUIT.get())
//        {
//            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST,10,2,false,false));
//            player.addEffect(new EffectInstance(ModEffects.ZEN_HEART.get(),10,0,false,false));
//        }
//        super.onArmorTick(stack,world, player);
//    }
    
}
