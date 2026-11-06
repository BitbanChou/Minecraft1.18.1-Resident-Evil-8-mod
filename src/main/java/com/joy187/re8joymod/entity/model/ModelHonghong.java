package com.joy187.re8joymod.entity.model;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityHonghong;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelHonghong extends GeoModel<EntityHonghong> {

    @Override
    public ResourceLocation getModelResource(EntityHonghong object) {
        return new ResourceLocation(Main.MOD_ID, "geo/honghong.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityHonghong object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/klee.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityHonghong animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/klee.animation.json");
    }

}