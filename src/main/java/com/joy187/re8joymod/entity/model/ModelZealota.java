package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityZealota;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelZealota extends GeoModel<EntityZealota>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "zealota"), "main");

    @Override
    public ResourceLocation getModelResource(EntityZealota object) {
        return new ResourceLocation(Main.MOD_ID, "geo/zealota.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityZealota object) {
        //return RenderFrank1.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/zealota.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityZealota animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/lycana.animation.json");
    }

}