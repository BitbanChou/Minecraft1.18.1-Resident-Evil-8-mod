package com.joy187.re8joymod.entity.model;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityUriass;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelUriass extends GeoModel<EntityUriass>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "uriass"), "main");

    @Override
    public ResourceLocation getModelResource(EntityUriass object) {
        return new ResourceLocation(Main.MOD_ID, "geo/strajer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityUriass object) {
        //return RenderUriass.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/uriasstrajer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityUriass animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/strajer.animation.json");
    }

}