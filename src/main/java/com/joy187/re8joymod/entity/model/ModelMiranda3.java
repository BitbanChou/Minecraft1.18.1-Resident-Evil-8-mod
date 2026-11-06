package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMiranda3;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMiranda3 extends GeoModel<EntityMiranda3>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "miranda3"), "main");

    @Override
    public ResourceLocation getModelResource(EntityMiranda3 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/miranda3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMiranda3 object) {
        //return RenderMiranda3.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/miranda2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMiranda3 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/miranda3.animation.json");
    }

}