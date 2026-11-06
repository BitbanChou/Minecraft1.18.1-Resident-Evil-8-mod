package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityChris;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelChris extends GeoModel<EntityChris>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "chris"), "main");

    @Override
    public ResourceLocation getModelResource(EntityChris object) {
        return new ResourceLocation(Main.MOD_ID, "geo/chris.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityChris object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/chris.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityChris animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/chris.animation.json");
    }

}