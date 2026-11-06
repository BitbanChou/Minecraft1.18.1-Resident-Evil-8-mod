package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityKrauser;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelKrauser extends GeoModel<EntityKrauser> {

    @Override
    public ResourceLocation getModelResource(EntityKrauser object) {
        return new ResourceLocation(Main.MOD_ID, "geo/krauser.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityKrauser object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/krauser0.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityKrauser animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/krauser0.animation.json");
    }

}