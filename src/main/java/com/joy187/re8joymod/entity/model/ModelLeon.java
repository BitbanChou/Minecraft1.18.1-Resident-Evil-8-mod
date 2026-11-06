package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityLeon;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelLeon extends GeoModel<EntityLeon>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "leon"), "main");

    @Override
    public ResourceLocation getModelResource(EntityLeon object) {
        return new ResourceLocation(Main.MOD_ID, "geo/leon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityLeon object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/leon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityLeon animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/leon.animation.json");
    }

}