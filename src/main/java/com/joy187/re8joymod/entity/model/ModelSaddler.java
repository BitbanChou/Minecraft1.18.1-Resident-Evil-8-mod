package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySaddler;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelSaddler extends GeoModel<EntitySaddler>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "saddler"), "main");

    @Override
    public ResourceLocation getModelResource(EntitySaddler object) {
        return new ResourceLocation(Main.MOD_ID, "geo/saddler.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySaddler object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/saddler.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySaddler animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/saddler.animation.json");
    }

}