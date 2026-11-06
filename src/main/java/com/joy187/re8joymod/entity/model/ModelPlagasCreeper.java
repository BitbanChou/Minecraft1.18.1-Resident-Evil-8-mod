package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasCreeper;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelPlagasCreeper extends GeoModel<EntityPlagasCreeper> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "plagascreeper"), "main");

    @Override
    public ResourceLocation getModelResource(EntityPlagasCreeper object) {
        return new ResourceLocation(Main.MOD_ID, "geo/plagascreeper.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPlagasCreeper object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/plagascreeper.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPlagasCreeper animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/plagascreeper.animation.json");
    }

}