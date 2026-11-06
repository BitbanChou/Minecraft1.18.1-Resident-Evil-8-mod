package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityBrute;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelBrute extends GeoModel<EntityBrute>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "brute"), "main");

    @Override
    public ResourceLocation getModelResource(EntityBrute object) {
        return new ResourceLocation(Main.MOD_ID, "geo/brute.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityBrute object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/brute.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityBrute animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/brute.animation.json");
    }

}