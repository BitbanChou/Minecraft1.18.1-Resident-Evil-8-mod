package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDuke;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelDuke extends GeoModel<EntityDuke>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "duke"), "main");

    @Override
    public ResourceLocation getModelResource(EntityDuke object) {
        return new ResourceLocation(Main.MOD_ID, "geo/duke.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityDuke object) {
        //return RenderDuke.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/duke.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityDuke animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/duke.animation.json");
    }
}
