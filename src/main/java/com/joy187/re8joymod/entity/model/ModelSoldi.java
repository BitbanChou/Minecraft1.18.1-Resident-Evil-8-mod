package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySoldi;
import com.joy187.re8joymod.entity.EntityVillagerGanado;
import com.joy187.re8joymod.entity.render.RenderSoldi;
import com.joy187.re8joymod.entity.render.RenderVillagerGanado;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelSoldi extends GeoModel<EntitySoldi>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "frank3"), "main");

    @Override
    public ResourceLocation getModelResource(EntitySoldi object) {
        return new ResourceLocation(Main.MOD_ID, "geo/soldi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySoldi object) {
        return RenderSoldi.LOCATION_BY_VARIANT.get(object.getVariant1());
        //return new ResourceLocation(Main.MOD_ID, "textures/entity/ganado.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySoldi animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/frank3.animation.json");
    }

}