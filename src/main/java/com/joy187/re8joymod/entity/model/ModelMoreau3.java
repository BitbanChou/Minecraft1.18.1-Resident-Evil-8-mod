package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMoreau3;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMoreau3 extends GeoModel<EntityMoreau3>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "moreau3"), "main");

    @Override
    public ResourceLocation getModelResource(EntityMoreau3 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/moreau3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMoreau3 object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/moreau3.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMoreau3 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/moreau3.animation.json");
    }

}