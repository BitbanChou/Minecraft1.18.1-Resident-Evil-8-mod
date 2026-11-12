package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMiranda4;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelMiranda4 extends GeoModel<EntityMiranda4> {

    @Override
    public ResourceLocation getModelResource(EntityMiranda4 animatable) {
        return new ResourceLocation(Main.MOD_ID, "geo/miranda4.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMiranda4 animatable) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/miranda2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMiranda4 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/miranda4.animation.json");
    }
}
