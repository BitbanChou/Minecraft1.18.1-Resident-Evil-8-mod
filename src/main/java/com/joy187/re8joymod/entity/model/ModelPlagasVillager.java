package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasVillager;
import com.joy187.re8joymod.entity.render.RenderPlagasVillager;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelPlagasVillager extends GeoModel<EntityPlagasVillager> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "ganado"), "main");

    @Override
    public ResourceLocation getModelResource(EntityPlagasVillager object) {
        return new ResourceLocation(Main.MOD_ID, "geo/plagasvillager.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPlagasVillager object) {
        return RenderPlagasVillager.LOCATION_BY_VARIANT.get(object.getVariant2());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/ganado.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPlagasVillager animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/ganado.animation.json");
    }

}