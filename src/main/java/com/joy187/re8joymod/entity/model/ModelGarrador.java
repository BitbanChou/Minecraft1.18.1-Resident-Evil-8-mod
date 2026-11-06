package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityGarrador;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelGarrador extends GeoModel<EntityGarrador> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "garrador"), "main");

    @Override
    public ResourceLocation getModelResource(EntityGarrador object) {
        return new ResourceLocation(Main.MOD_ID, "geo/garrador.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityGarrador object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/garrador.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityGarrador animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/garrador.animation.json");
    }

}