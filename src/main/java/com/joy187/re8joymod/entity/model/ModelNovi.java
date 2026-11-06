package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityNovi;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelNovi extends GeoModel<EntityNovi>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "novi"), "main");

    @Override
    public ResourceLocation getModelResource(EntityNovi object) {
        return new ResourceLocation(Main.MOD_ID, "geo/novi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityNovi object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/novi.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityNovi animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/novi.animation.json");
    }

}