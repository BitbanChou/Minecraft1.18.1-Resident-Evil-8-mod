package com.joy187.re8joymod.entity.model;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.Bomb;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelBomb extends GeoModel<Bomb> {

    @Override
    public ResourceLocation getModelResource(Bomb object) {
        return new ResourceLocation(Main.MOD_ID, "geo/jumpbomb.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Bomb object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/klee.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Bomb animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/klee.animation.json");
    }

}