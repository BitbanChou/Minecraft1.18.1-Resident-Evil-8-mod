package com.joy187.re8joymod.entity.model;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityHeli;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelHeli extends GeoModel<EntityHeli> {

    @Override
    public ResourceLocation getModelResource(EntityHeli object) {
        return new ResourceLocation(Main.MOD_ID, "geo/helicopter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityHeli object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/helicopter.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityHeli animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/helicopter.animation.json");
    }

}