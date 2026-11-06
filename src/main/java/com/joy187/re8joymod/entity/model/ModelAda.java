package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityAda;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelAda extends GeoModel<EntityAda>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "ada"), "main");

    @Override
    public ResourceLocation getModelResource(EntityAda object) {
        return new ResourceLocation(Main.MOD_ID, "geo/ada.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityAda object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/ada.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityAda animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/ada.animation.json");
    }

}