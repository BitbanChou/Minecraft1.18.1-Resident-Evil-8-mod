package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMiranda1;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMiranda1 extends GeoModel<EntityMiranda1>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "miranda1"), "main");

    @Override
    public ResourceLocation getModelResource(EntityMiranda1 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/miranda1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMiranda1 object) {
        //return RenderMiranda1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/miranda1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMiranda1 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/miranda1.animation.json");
    }

}