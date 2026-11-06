package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank1;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelFrank1 extends GeoModel<EntityFrank1>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "frank1"), "main");

    @Override
    public ResourceLocation getModelResource(EntityFrank1 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/frank1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFrank1 object) {
        //return RenderFrank1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/frank1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFrank1 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/frank1.animation.json");
    }

}