package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMoreau;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMoreau extends GeoModel<EntityMoreau>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "moreau"), "main");

    @Override
    public ResourceLocation getModelResource(EntityMoreau object) {
        return new ResourceLocation(Main.MOD_ID, "geo/moreau.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMoreau object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/moreau.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMoreau animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/moreau.animation.json");
    }

}