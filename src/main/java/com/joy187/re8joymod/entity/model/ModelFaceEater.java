package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFaceEater;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelFaceEater extends GeoModel<EntityFaceEater>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "fe"), "main");

    @Override
    public ResourceLocation getModelResource(EntityFaceEater object) {
        return new ResourceLocation(Main.MOD_ID, "geo/fe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFaceEater object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/mum.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFaceEater animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/fe.animation.json");
    }

}