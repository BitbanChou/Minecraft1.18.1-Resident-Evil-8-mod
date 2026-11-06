package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityKrauser2;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelKrauser2 extends GeoModel<EntityKrauser2> {

    @Override
    public ResourceLocation getModelResource(EntityKrauser2 object) {
        return new ResourceLocation(Main.MOD_ID, "geo/krauser2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityKrauser2 object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/krauser.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityKrauser2 animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/krauser.animation.json");
    }

}