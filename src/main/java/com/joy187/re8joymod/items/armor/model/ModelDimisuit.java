package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.DimisuitArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelDimisuit extends GeoModel<DimisuitArmorItem> {
	@Override
	public ResourceLocation getModelResource(DimisuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/dimisuit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DimisuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/models/armor/dimi1suit_layer_1.png");
	}

	@Override
	public ResourceLocation getAnimationResource(DimisuitArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/dimisuit.animation.json");
	}
}