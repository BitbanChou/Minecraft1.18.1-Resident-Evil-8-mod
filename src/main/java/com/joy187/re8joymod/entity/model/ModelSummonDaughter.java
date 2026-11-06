package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityBela;
import com.joy187.re8joymod.entity.EntitySummonDaughter;
import com.joy187.re8joymod.entity.render.RenderLycan;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelSummonDaughter extends GeoModel<EntitySummonDaughter>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "summondaughter"), "main");

    @Override
    public ResourceLocation getModelResource(EntitySummonDaughter object) {
        return new ResourceLocation(Main.MOD_ID, "geo/bela.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySummonDaughter object) {
        return RenderLycan.LOCATION_BY_VARIANT.get(object.getVariant());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/bela.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySummonDaughter animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/bela.animation.json");
    }

}