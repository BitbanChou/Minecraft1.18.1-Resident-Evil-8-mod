package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityBela;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelBela extends GeoModel<EntityBela>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "bela"), "main");

    @Override
    public ResourceLocation getModelResource(EntityBela object) {
        return new ResourceLocation(Main.MOD_ID, "geo/daniela.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityBela object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/bela.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityBela animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/bela.animation.json");
    }

}