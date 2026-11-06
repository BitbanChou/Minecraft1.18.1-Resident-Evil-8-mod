package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityZealot;
import com.joy187.re8joymod.entity.render.RenderZealot;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelZealot extends GeoModel<EntityZealot> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "zealot"), "main");

    @Override
    public ResourceLocation getModelResource(EntityZealot object) {
        return new ResourceLocation(Main.MOD_ID, "geo/zealot.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityZealot object) {
        return RenderZealot.LOCATION_BY_VARIANT.get(object.getVariant2());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/ganado.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityZealot animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/zealot.animation.json");
    }

}