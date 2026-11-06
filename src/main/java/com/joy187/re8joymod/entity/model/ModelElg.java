package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityElg;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelElg extends GeoModel<EntityElg>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "elg"), "main");

    @Override
    public ResourceLocation getModelResource(EntityElg object) {
        return new ResourceLocation(Main.MOD_ID, "geo/elg.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityElg object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/elg.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityElg animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/elg.animation.json");
    }

}