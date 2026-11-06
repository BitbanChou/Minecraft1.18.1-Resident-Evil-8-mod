package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMoreau2;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelMoreau2 extends GeoModel<EntityMoreau2>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "moreau2"), "main");

    @Override
    public ResourceLocation getModelResource(EntityMoreau2 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/moreau2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMoreau2 object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/moreau2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMoreau2 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/moreau.animation.json");
    }

}