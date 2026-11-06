package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySalaz;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelSalaz extends GeoModel<EntitySalaz>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "sala"), "main");

    @Override
    public ResourceLocation getModelResource(EntitySalaz object) {
        return new ResourceLocation(Main.MOD_ID, "geo/sala.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySalaz object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/sala.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySalaz animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/sala.animation.json");
    }

}