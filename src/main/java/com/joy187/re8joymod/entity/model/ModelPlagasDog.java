package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasDog;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelPlagasDog extends GeoModel<EntityPlagasDog>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "plagasdog"), "main");

    @Override
    public ResourceLocation getModelResource(EntityPlagasDog object) {
        return new ResourceLocation(Main.MOD_ID, "geo/plagasdog.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPlagasDog object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/evildog.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPlagasDog animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/evildog.animation.json");
    }

}