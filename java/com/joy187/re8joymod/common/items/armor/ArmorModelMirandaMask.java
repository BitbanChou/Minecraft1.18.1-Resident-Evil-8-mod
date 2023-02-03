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


// Made with Blockbench 3.9.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class ArmorModelMirandaMask extends ArmorItem {

//	public ArmorModelMirandaMask(String name,CreativeTabs tab, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
//		super(materialIn, 1, equipmentSlotIn);
//		setUnlocalizedName(name);
//		setRegistryName(name);
//		setCreativeTab(tab);
//		setMaxStackSize(1);
//		ModItems.ITEMS.add(this) ;
//	}

	public ArmorModelMirandaMask(IArmorMaterial material, EquipmentSlotType equipmentSlot, Item.Properties properties) {
		super(material, equipmentSlot, properties);
		//this.mirandaMaskModel = armorModel;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor) {
//        return dimihatModel.applyEntityStats(defaultArmor).applySlot(armorSlot);
//        DimiHat model = new DimiHat();
//        return model;
		MirandaMask mirandaMaskModel = new MirandaMask();
		mirandaMaskModel.copyPropertiesTo(defaultArmor);
		return mirandaMaskModel.applyEntityStats(defaultArmor).applySlot(EquipmentSlotType.HEAD);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if(player.getItemBySlot(EquipmentSlotType.HEAD).getItem() == ModItems.MIRANDA_MASK.get())
		{
			player.addEffect(new EffectInstance(Effects.INVISIBILITY,10,2,false,false));
			player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE,10,2,false,false));
			player.addEffect(new EffectInstance(Effects.NIGHT_VISION,30,2,false,false));
		}
		super.onArmorTick(stack,world, player);
	}


}