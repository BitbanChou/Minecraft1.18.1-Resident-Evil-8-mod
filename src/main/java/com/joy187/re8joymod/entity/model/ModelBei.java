package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityBei;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelBei extends GeoModel<EntityBei>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "bei"), "main");

    @Override
    public ResourceLocation getModelResource(EntityBei object) {
        return new ResourceLocation(Main.MOD_ID, "geo/bei.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityBei object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/beneviento.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityBei animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/bei.animation.json");
    }

}