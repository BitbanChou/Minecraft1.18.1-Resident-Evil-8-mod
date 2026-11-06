package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMuHeisen;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMuHeisen extends GeoModel<EntityMuHeisen>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "muheisen"), "main");

    @Override
    public ResourceLocation getModelResource(EntityMuHeisen object) {
        return new ResourceLocation(Main.MOD_ID, "geo/muheisen.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMuHeisen object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/heisenberg2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMuHeisen animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/muheisen.animation.json");
    }

}