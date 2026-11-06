package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.FranksuitArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelFranksuit extends GeoModel<FranksuitArmorItem> {
	@Override
	public ResourceLocation getModelResource(FranksuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/franksuit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FranksuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/models/armor/franksuit_layer_1.png");
	}

	@Override
	public ResourceLocation getAnimationResource(FranksuitArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/franksuit.animation.json");
	}
}