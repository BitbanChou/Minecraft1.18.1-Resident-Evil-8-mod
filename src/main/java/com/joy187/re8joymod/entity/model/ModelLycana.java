package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityLycana;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelLycana extends GeoModel<EntityLycana>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "lycana"), "main");

    @Override
    public ResourceLocation getModelResource(EntityLycana object) {
        return new ResourceLocation(Main.MOD_ID, "geo/lycana.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityLycana object) {
        //return RenderFrank1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/lycana.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityLycana animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/lycana.animation.json");
    }

}