package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityHeisen;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelHeisen extends GeoModel<EntityHeisen>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "heisen"), "main");

    @Override
    public ResourceLocation getModelResource(EntityHeisen object) {
        return new ResourceLocation(Main.MOD_ID, "geo/heisen.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityHeisen object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/heisenberg.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityHeisen animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/heisen.animation.json");
    }

}