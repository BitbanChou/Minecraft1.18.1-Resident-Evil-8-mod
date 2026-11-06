package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDund2;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelDund2 extends GeoModel<EntityDund2>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "dund2"), "main");

    @Override
    public ResourceLocation getModelResource(EntityDund2 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/dund2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityDund2 object) {
        //return RenderDund2.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/dund2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityDund2 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/dund2.animation.json");
    }

}
