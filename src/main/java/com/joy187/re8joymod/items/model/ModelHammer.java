package com.joy187.re8joymod.items.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.ItemHammer;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelHammer extends GeoModel<ItemHammer> {
	@Override
	public ResourceLocation getModelResource(ItemHammer object) {
		return new ResourceLocation(Main.MOD_ID, "geo/hammer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ItemHammer object) {
		return new ResourceLocation(Main.MOD_ID, "textures/item/dimihand.png");
	}

	@Override
	public ResourceLocation getAnimationResource(ItemHammer animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/hammer.animation.json");
	}
}
