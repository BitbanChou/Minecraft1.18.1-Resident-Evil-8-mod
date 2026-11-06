package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityEvilDog;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelEvilDog extends GeoModel<EntityEvilDog>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "evildog"), "main");

    @Override
    public ResourceLocation getModelResource(EntityEvilDog object) {
        return new ResourceLocation(Main.MOD_ID, "geo/evildog.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityEvilDog object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/evildog.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityEvilDog animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/evildog.animation.json");
    }

}