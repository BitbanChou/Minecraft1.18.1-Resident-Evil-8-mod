package com.joy187.re8joymod.entity.model;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.JumpBomb;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelJumpBomb extends GeoModel<JumpBomb> {

    @Override
    public ResourceLocation getModelResource(JumpBomb object) {
        return new ResourceLocation(Main.MOD_ID, "geo/jumpbomb.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JumpBomb object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/klee.png");
    }

    @Override
    public ResourceLocation getAnimationResource(JumpBomb animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/klee.animation.json");
    }

}