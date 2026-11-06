package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.HeisensuitArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelHeisensuit extends GeoModel<HeisensuitArmorItem> {
	@Override
	public ResourceLocation getModelResource(HeisensuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/heisensuit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HeisensuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/models/armor/heisensuit_layer_1.png");
	}

	@Override
	public ResourceLocation getAnimationResource(HeisensuitArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/heisensuit.animation.json");
	}
}