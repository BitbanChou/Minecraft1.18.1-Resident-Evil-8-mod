package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasm;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelPlagasm extends GeoModel<EntityPlagasm>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "plagasm"), "main");

    @Override
    public ResourceLocation getModelResource(EntityPlagasm object) {
        return new ResourceLocation(Main.MOD_ID, "geo/plagasm.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPlagasm object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/plagasm.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPlagasm animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/plagasm.animation.json");
    }

}