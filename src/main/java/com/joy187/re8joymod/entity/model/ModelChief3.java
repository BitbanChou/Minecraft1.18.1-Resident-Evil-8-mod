package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityChief3;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelChief3 extends GeoModel<EntityChief3> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "chief3"), "main");

    @Override
    public ResourceLocation getModelResource(EntityChief3 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/chief3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityChief3 object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/chief2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityChief3 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/chief2.animation.json");
    }

}