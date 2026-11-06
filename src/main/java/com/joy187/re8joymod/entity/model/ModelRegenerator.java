package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityRegenerator;
import com.joy187.re8joymod.entity.render.RenderRegenerator;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelRegenerator extends GeoModel<EntityRegenerator>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "regenerator"), "main");

    @Override
    public ResourceLocation getModelResource(EntityRegenerator object) {
        return new ResourceLocation(Main.MOD_ID, "geo/regenerator.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityRegenerator object) {
        return RenderRegenerator.LOCATION_BY_VARIANT.get(object.getVariant());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/regenerator.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityRegenerator animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/regenerator.animation.json");
    }

}