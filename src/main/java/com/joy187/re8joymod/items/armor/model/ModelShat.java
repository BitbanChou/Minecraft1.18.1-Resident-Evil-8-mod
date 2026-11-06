package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.SHatArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelShat extends GeoModel<SHatArmorItem> {
	@Override
	public ResourceLocation getModelResource(SHatArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/shat.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SHatArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/entity/salazar.png");
	}

	@Override
	public ResourceLocation getAnimationResource(SHatArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/adamask.animation.json");
	}
}