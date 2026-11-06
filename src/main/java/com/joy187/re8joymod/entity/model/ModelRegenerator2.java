package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityRegenerator2;
import com.joy187.re8joymod.entity.render.RenderRegenerator;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelRegenerator2 extends GeoModel<EntityRegenerator2>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "regenerator2"), "main");

    @Override
    public ResourceLocation getModelResource(EntityRegenerator2 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/regenerator2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityRegenerator2 object) {
        return RenderRegenerator.LOCATION_BY_VARIANT.get(object.getVariant());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/regenerator.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityRegenerator2 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/regenerator.animation.json");
    }

}