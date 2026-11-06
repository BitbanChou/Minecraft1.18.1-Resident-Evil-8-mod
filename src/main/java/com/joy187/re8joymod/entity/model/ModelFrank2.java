package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank1;
import com.joy187.re8joymod.entity.EntityFrank2;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelFrank2 extends GeoModel<EntityFrank2>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "frank2"), "main");

    @Override
    public ResourceLocation getModelResource(EntityFrank2 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/frank2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFrank2 object) {
        //return RenderFrank1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/frank2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFrank2 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/frank2.animation.json");
    }

}