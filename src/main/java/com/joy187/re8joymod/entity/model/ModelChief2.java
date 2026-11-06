package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityChief2;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelChief2 extends GeoModel<EntityChief2> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "chief2"), "main");

    @Override
    public ResourceLocation getModelResource(EntityChief2 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/chief2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityChief2 object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/chief2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityChief2 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/chief2.animation.json");
    }

}