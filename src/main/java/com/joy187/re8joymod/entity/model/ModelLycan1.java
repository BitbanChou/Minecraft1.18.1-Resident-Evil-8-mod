package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityLycan1;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelLycan1 extends GeoModel<EntityLycan1>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "lycan1"), "main");

    @Override
    public ResourceLocation getModelResource(EntityLycan1 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/lycan1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityLycan1 object) {
        //return RenderLycan1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/lycan1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityLycan1 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/lycan1.animation.json");
    }

}