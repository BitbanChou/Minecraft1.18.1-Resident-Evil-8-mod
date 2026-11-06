package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasc;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelPlagasc extends GeoModel<EntityPlagasc>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "plagasc"), "main");

    @Override
    public ResourceLocation getModelResource(EntityPlagasc object) {
        return new ResourceLocation(Main.MOD_ID, "geo/plagasc.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityPlagasc object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/plagasc.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityPlagasc animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/plagasc.animation.json");
    }

}