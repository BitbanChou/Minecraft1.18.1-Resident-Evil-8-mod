package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityHank;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelHank extends GeoModel<EntityHank>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "hank"), "main");

    @Override
    public ResourceLocation getModelResource(EntityHank object) {
        return new ResourceLocation(Main.MOD_ID, "geo/hank.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityHank object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/hank.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityHank animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/hank.animation.json");
    }

}