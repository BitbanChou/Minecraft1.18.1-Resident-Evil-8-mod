package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityLycan;
import com.joy187.re8joymod.entity.render.RenderLycan;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelLycan extends GeoModel<EntityLycan>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "lycan"), "main");

    @Override
    public ResourceLocation getModelResource(EntityLycan object) {
        return new ResourceLocation(Main.MOD_ID, "geo/lycan.geo.json");

    }

    @Override
    public ResourceLocation getTextureResource(EntityLycan object) {
        return RenderLycan.LOCATION_BY_VARIANT.get(object.getVariant());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/regenerator.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityLycan animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/lycan.animation.json");
    }

}