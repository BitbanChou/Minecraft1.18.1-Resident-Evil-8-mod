package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasArmadura;
import com.joy187.re8joymod.entity.render.RenderArmadura;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelPlagasArmadura extends GeoModel<EntityPlagasArmadura> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "plagasarmadura"), "main");

    @Override
    public ResourceLocation getModelResource(EntityPlagasArmadura object) {
        return new ResourceLocation(Main.MOD_ID, "geo/plagasarmadura.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPlagasArmadura object) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/armadura1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPlagasArmadura animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/arma.animation.json");
    }

}