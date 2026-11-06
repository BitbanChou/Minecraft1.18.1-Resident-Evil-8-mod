package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityU3;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelU3 extends GeoModel<EntityU3>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "u3"), "main");

    @Override
    public ResourceLocation getModelResource(EntityU3 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/u3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityU3 object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/u3.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityU3 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/u3.animation.json");
    }

}