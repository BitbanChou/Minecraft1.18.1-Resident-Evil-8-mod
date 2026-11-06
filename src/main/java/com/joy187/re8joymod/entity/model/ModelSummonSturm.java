package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySummonSturm;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelSummonSturm extends GeoModel<EntitySummonSturm>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "summonsturm"), "main");

    @Override
    public ResourceLocation getModelResource(EntitySummonSturm object) {
        return new ResourceLocation(Main.MOD_ID, "geo/frank5.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySummonSturm object) {
        //return RenderFrank1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/frank5.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySummonSturm animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/frank5.animation.json");
    }

}