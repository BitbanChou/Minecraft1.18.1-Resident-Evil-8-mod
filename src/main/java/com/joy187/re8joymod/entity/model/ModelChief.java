package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityChief;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelChief extends GeoModel<EntityChief> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "chief"), "main");

    @Override
    public ResourceLocation getModelResource(EntityChief object) {
        return new ResourceLocation(Main.MOD_ID, "geo/chief.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityChief object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/chief.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityChief animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/chief.animation.json");
    }

}