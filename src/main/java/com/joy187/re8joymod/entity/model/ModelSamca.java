package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySamca;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.example.entity.ParasiteEntity;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;


public class ModelSamca extends GeoModel<EntitySamca>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "samca"), "main");

    @Override
    public ResourceLocation getModelResource(EntitySamca object) {
        return new ResourceLocation(Main.MOD_ID, "geo/samca.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySamca object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/dund2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySamca animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/samca.animation.json");
    }

}

