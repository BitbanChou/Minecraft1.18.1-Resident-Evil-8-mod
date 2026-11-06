package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFly;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelFly extends GeoModel<EntityFly>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "fly"), "main");

    @Override
    public ResourceLocation getModelResource(EntityFly object) {
        return new ResourceLocation(Main.MOD_ID, "geo/fly.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFly object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/fly.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFly animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/fly.animation.json");
    }

}