package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMerchant;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelMerchant extends GeoModel<EntityMerchant> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "merchant"), "main");

    @Override
    public ResourceLocation getModelResource(EntityMerchant object) {
        return new ResourceLocation(Main.MOD_ID, "geo/merchant.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMerchant object) {
        //return RenderMerchant.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/merchant.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMerchant animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/merchant.animation.json");
    }
}