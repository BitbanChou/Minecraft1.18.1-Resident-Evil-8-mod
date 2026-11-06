package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank3;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelFrank3 extends GeoModel<EntityFrank3>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "frank3"), "main");

    @Override
    public ResourceLocation getModelResource(EntityFrank3 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/frank3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFrank3 object) {
        //return RenderFrank1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/frank3.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFrank3 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/frank3.animation.json");
    }

}