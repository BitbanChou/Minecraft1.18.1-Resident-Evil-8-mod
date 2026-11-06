package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDund;
import com.joy187.re8joymod.entity.render.RenderDund;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelDund extends GeoModel<EntityDund>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "dund"), "main");

    @Override
    public ResourceLocation getModelResource(EntityDund object) {
        return new ResourceLocation(Main.MOD_ID, "geo/dund.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityDund object) {
        //return RenderDund.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/dund.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityDund animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/dund.animation.json");
    }

}
