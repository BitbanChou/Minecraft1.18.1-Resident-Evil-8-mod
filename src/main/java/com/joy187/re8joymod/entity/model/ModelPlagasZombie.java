package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasZombie;
import com.joy187.re8joymod.entity.render.RenderPlagasZombie;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelPlagasZombie extends GeoModel<EntityPlagasZombie> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "ganado"), "main");

    @Override
    public ResourceLocation getModelResource(EntityPlagasZombie object) {
        return new ResourceLocation(Main.MOD_ID, "geo/plagasvillager.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPlagasZombie object) {
        return RenderPlagasZombie.LOCATION_BY_VARIANT.get(object.getVariant2());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/ganado.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPlagasZombie animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/ganado.animation.json");
    }

}