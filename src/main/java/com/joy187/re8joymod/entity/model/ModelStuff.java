package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.entity.EntityStuff;
import com.joy187.re8joymod.Main;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelStuff extends GeoModel<EntityStuff>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "stuff"), "main");

    @Override
    public ResourceLocation getModelResource(EntityStuff object) {
        return new ResourceLocation(Main.MOD_ID, "geo/stuff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityStuff object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/stuff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityStuff animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/stuff.animation.json");
    }

}