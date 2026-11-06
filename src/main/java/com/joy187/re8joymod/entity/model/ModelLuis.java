package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityLuis;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelLuis extends GeoModel<EntityLuis>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "luis"), "main");

    @Override
    public ResourceLocation getModelResource(EntityLuis object) {
        return new ResourceLocation(Main.MOD_ID, "geo/luis.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityLuis object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/luis.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityLuis animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/leon.animation.json");
    }

}