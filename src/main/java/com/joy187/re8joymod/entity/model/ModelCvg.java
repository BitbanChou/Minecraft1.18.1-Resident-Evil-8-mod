package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityCvg;
import com.joy187.re8joymod.entity.render.RenderCvg;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelCvg extends GeoModel<EntityCvg> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "ganado"), "main");

    @Override
    public ResourceLocation getModelResource(EntityCvg object) {
        return new ResourceLocation(Main.MOD_ID, "geo/cvg.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityCvg object) {
        return RenderCvg.LOCATION_BY_VARIANT.get(object.getVariant1());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/ganado.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityCvg animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/cvg.animation.json");
    }

}