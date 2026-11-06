package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityAsh;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelAsh extends GeoModel<EntityAsh>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "ash"), "main");

    @Override
    public ResourceLocation getModelResource(EntityAsh object) {
        return new ResourceLocation(Main.MOD_ID, "geo/ash.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityAsh object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/ash.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityAsh animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/ash.animation.json");
    }

}