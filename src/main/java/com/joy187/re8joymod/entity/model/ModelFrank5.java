package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank5;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelFrank5 extends GeoModel<EntityFrank5>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "frank5"), "main");

    @Override
    public ResourceLocation getModelResource(EntityFrank5 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/frank5.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityFrank5 object) {
        //return RenderFrank1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/frank5.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityFrank5 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/frank5.animation.json");
    }

}