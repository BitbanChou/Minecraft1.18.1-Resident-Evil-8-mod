package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMiranda2;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMiranda2 extends GeoModel<EntityMiranda2>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "miranda2"), "main");

    @Override
    public ResourceLocation getModelResource(EntityMiranda2 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/miranda2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMiranda2 object) {
        //return RenderMiranda2.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/miranda2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMiranda2 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/miranda2.animation.json");
    }

}