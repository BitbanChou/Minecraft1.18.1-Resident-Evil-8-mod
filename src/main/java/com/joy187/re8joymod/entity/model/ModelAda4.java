package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityAda;
import com.joy187.re8joymod.entity.EntityAda4;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelAda4 extends GeoModel<EntityAda4>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "ada4"), "main");

    @Override
    public ResourceLocation getModelResource(EntityAda4 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/ada4.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityAda4 object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/ada4.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityAda4 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/ada4.animation.json");
    }

}