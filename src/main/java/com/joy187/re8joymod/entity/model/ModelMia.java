package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMia;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelMia extends GeoModel<EntityMia>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "mia"), "main");

    @Override
    public ResourceLocation getModelResource(EntityMia object) {
        return new ResourceLocation(Main.MOD_ID, "geo/mia.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMia object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/mia.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMia animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/mia.animation.json");
    }

}