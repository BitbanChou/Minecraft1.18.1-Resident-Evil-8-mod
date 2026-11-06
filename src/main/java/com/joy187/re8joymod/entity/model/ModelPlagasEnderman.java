package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasEnderman;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelPlagasEnderman extends GeoModel<EntityPlagasEnderman> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "plagasenderman"), "main");

    @Override
    public ResourceLocation getModelResource(EntityPlagasEnderman object) {
        return new ResourceLocation(Main.MOD_ID, "geo/plagasenderman.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPlagasEnderman object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/plagasenderman.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPlagasEnderman animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/plagascreeper.animation.json");
    }

}