package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySaddler2;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelSaddler2 extends GeoModel<EntitySaddler2>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "saddler2"), "main");

    @Override
    public ResourceLocation getModelResource(EntitySaddler2 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/saddler2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySaddler2 object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/saddler2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySaddler2 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/saddler2.animation.json");
    }

}