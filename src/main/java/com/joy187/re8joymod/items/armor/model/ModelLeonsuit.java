package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.LeonsuitArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelLeonsuit extends GeoModel<LeonsuitArmorItem> {
	@Override
	public ResourceLocation getModelResource(LeonsuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/leonsuit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LeonsuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/models/armor/leonsuit_layer_1.png");
	}

	@Override
	public ResourceLocation getAnimationResource(LeonsuitArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/heisensuit.animation.json");
	}
}