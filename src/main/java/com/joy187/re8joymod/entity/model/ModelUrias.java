package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityUrias;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelUrias extends GeoModel<EntityUrias>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "urias"), "main");

    @Override
    public ResourceLocation getModelResource(EntityUrias object) {
        return new ResourceLocation(Main.MOD_ID, "geo/urias.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityUrias object) {
        //return RenderUrias.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/urias.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityUrias animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/urias.animation.json");
    }

}