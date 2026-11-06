package com.joy187.re8joymod.items.armor.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.armor.HanksuitArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelHanksuit extends GeoModel<HanksuitArmorItem> {
	@Override
	public ResourceLocation getModelResource(HanksuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "geo/hanksuit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HanksuitArmorItem object) {
		return new ResourceLocation(Main.MOD_ID, "textures/entity/hank.png");
	}

	@Override
	public ResourceLocation getAnimationResource(HanksuitArmorItem animatable) {
		return new ResourceLocation(Main.MOD_ID, "animations/heisensuit.animation.json");
	}
}