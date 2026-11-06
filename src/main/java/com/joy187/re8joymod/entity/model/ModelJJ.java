package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityJJ;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelJJ extends GeoModel<EntityJJ>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "jj"), "main");

    @Override
    public ResourceLocation getModelResource(EntityJJ object) {
        return new ResourceLocation(Main.MOD_ID, "geo/jj.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityJJ object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/jj.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityJJ animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/jj.animation.json");
    }

}