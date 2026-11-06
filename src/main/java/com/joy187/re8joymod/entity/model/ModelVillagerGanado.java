package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityVillagerGanado;
import com.joy187.re8joymod.entity.render.RenderVillagerGanado;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelVillagerGanado extends GeoModel<EntityVillagerGanado> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "ganado"), "main");

    @Override
    public ResourceLocation getModelResource(EntityVillagerGanado object) {
        return new ResourceLocation(Main.MOD_ID, "geo/ganado.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityVillagerGanado object) {
        return RenderVillagerGanado.LOCATION_BY_VARIANT.get(object.getVariant1());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/ganado.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityVillagerGanado animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/ganado.animation.json");
    }

}