package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityBeibaby;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelBeibaby extends GeoModel<EntityBeibaby>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "beibaby"), "main");

    @Override
    public ResourceLocation getModelResource(EntityBeibaby object) {
        return new ResourceLocation(Main.MOD_ID, "geo/beibaby.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityBeibaby object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/beibaby.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityBeibaby animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/beibaby.animation.json");
    }

}