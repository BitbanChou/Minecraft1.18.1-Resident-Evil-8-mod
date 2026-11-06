package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagas;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelPlagas extends GeoModel<EntityPlagas> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "plagas"), "main");

    @Override
    public ResourceLocation getModelResource(EntityPlagas object) {
        return new ResourceLocation(Main.MOD_ID, "geo/plagas.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPlagas object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/plagas.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPlagas animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/plagas.animation.json");
    }

}