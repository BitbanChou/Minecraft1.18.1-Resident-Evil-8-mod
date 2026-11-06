package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank6;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelFrank6 extends GeoModel<EntityFrank6>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "frank6"), "main");

    @Override
    public ResourceLocation getModelResource(EntityFrank6 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/frank6.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFrank6 object) {
        //return RenderFrank1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/frank6.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFrank6 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/frank6.animation.json");
    }

}