package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityAxeman;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelAxeman extends GeoModel<EntityAxeman>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "axeman"), "main");

    @Override
    public ResourceLocation getModelResource(EntityAxeman object) {
        return new ResourceLocation(Main.MOD_ID, "geo/axeman.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityAxeman object) {
        //return RenderAxeman.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/axeman.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityAxeman animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/axeman.animation.json");
    }

}