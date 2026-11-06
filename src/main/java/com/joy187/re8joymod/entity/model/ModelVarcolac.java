package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityVarcolac;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelVarcolac extends GeoModel<EntityVarcolac>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "varcolac"), "main");

    @Override
    public ResourceLocation getModelResource(EntityVarcolac object) {
        return new ResourceLocation(Main.MOD_ID, "geo/varcolac.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityVarcolac object) {
        //return RenderVarcolac.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/varcolac.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityVarcolac animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/varcolac.animation.json");
    }

}