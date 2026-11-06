package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDellago;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelDellago extends GeoModel<EntityDellago>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "dellago"), "main");

    @Override
    public ResourceLocation getModelResource(EntityDellago object) {
        return new ResourceLocation(Main.MOD_ID, "geo/dellago.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityDellago object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/dellago.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityDellago animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/dellago.animation.json");
    }

}