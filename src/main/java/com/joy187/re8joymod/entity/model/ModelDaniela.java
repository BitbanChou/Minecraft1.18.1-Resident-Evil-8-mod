package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDaniela;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelDaniela extends GeoModel<EntityDaniela>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "daniela"), "main");

    @Override
    public ResourceLocation getModelResource(EntityDaniela object) {
        return new ResourceLocation(Main.MOD_ID, "geo/daniela.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityDaniela object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/daniela.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityDaniela animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/bela.animation.json");
    }

}