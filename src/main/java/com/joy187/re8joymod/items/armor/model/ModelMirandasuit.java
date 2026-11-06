package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.MirandasuitArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMirandasuit extends GeoModel<MirandasuitArmorItem> {
	@Override
	public ResourceLocation getModelResource(MirandasuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/mirandasuit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MirandasuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/models/armor/miranda1suit_layer_1.png");
	}

	@Override
	public ResourceLocation getAnimationResource(MirandasuitArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/mirandasuit.animation.json");
	}
}