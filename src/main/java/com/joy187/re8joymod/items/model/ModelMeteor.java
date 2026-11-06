package com.joy187.re8joymod.items.model;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.items.ItemMeteor;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedGeoModel;
import software.bernie.geckolib.model.GeoModel;

public class ModelMeteor extends GeoModel<ItemMeteor> {

    @Override
    public ResourceLocation getModelResource(ItemMeteor object) {
        return new ResourceLocation(Main.MOD_ID, "geo/meteor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ItemMeteor object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/zealot.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ItemMeteor animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/meteor.animation.json");
    }
}

