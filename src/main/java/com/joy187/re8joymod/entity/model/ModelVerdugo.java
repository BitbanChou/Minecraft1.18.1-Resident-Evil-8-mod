package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityVerdugo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelVerdugo extends GeoModel<EntityVerdugo> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "textures/entity/verdugo2"), "main");

    @Override
    public ResourceLocation getModelResource(EntityVerdugo object) {
        return new ResourceLocation(Main.MOD_ID, "geo/verdugo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityVerdugo object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/verdugo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityVerdugo animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/verdugo.animation.json");
    }


}