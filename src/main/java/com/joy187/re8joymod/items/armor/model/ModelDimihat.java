package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.DimihatArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelDimihat extends GeoModel<DimihatArmorItem> {
	@Override
	public ResourceLocation getModelResource(DimihatArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/dimihat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DimihatArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/models/armor/dimisuit_layer_1.png");
	}

	@Override
	public ResourceLocation getAnimationResource(DimihatArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/dimihat.animation.json");
	}
}