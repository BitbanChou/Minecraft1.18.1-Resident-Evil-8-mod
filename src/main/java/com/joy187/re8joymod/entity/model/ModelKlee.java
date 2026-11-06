package com.joy187.re8joymod.entity.model;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.Klee;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelKlee extends GeoModel<Klee> {

    @Override
    public ResourceLocation getModelResource(Klee object) {
        return new ResourceLocation(Main.MOD_ID, "geo/klee.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Klee object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/klee.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Klee animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/klee.animation.json");
    }

}