package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.MirandamaskArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMirandamask extends GeoModel<MirandamaskArmorItem> {
	@Override
	public ResourceLocation getModelResource(MirandamaskArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/mirandamask.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MirandamaskArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/models/armor/mirandasuit_layer_1.png");
	}

	@Override
	public ResourceLocation getAnimationResource(MirandamaskArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/mirandamask.animation.json");
	}
}