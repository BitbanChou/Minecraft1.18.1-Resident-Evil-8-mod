package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDoll3;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelDoll3 extends GeoModel<EntityDoll3>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "doll3"), "main");

    @Override
    public ResourceLocation getModelResource(EntityDoll3 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/doll3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityDoll3 object) {
        //return RenderDoll3.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/angie.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityDoll3 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/doll3.animation.json");
    }

}