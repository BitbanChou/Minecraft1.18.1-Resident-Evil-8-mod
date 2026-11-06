package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityArmadura;
import com.joy187.re8joymod.entity.render.RenderArmadura;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelArmadura extends GeoModel<EntityArmadura> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "armadura"), "main");

    @Override
    public ResourceLocation getModelResource(EntityArmadura object) {
        return new ResourceLocation(Main.MOD_ID, "geo/armadura.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityArmadura object) {
        return RenderArmadura.LOCATION_BY_VARIANT.get(object.getVariant2());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/ganado.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityArmadura animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/arma.animation.json");
    }

}