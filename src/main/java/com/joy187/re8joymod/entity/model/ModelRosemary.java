package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityRosemary;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelRosemary extends GeoModel<EntityRosemary>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "rosemary"), "main");

    @Override
    public ResourceLocation getModelResource(EntityRosemary object) {
        return new ResourceLocation(Main.MOD_ID, "geo/rosemary.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityRosemary object) {
        //return RenderRosemary.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/rosemary.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityRosemary animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/rose.animation.json");
    }

}