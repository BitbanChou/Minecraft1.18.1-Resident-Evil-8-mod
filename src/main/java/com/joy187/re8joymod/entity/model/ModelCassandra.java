package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityCassandra;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelCassandra extends GeoModel<EntityCassandra>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "cassandra"), "main");

    @Override
    public ResourceLocation getModelResource(EntityCassandra object) {
        return new ResourceLocation(Main.MOD_ID, "geo/bela.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityCassandra object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/cassandra.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityCassandra animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/bela.animation.json");
    }

}