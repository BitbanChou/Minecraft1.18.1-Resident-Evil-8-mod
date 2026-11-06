package com.joy187.re8joymod.items.model;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.ItemWand;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ModelWand extends GeoModel<ItemWand> {

    @Override
    public ResourceLocation getModelResource(ItemWand object) {
        return new ResourceLocation(Main.MOD_ID, "geo/wand.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ItemWand object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/saddler.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ItemWand animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/wand.animation.json");
    }
}

