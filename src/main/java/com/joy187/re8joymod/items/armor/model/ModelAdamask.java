package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.AdamaskArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;



public class ModelAdamask extends GeoModel<AdamaskArmorItem> {
	@Override
	public ResourceLocation getModelResource(AdamaskArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/adamask.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AdamaskArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/models/armor/adamask_layer_1.png");
	}

	@Override
	public ResourceLocation getAnimationResource(AdamaskArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/adamask.animation.json");
	}
}