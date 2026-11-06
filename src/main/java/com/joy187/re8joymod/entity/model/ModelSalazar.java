package com.joy187.re8joymod.entity.model;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySalazar;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;


public class ModelSalazar extends GeoModel<EntitySalazar>{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Main.MOD_ID, "salazar"), "main");

    @Override
    public ResourceLocation getModelResource(EntitySalazar object) {
        return new ResourceLocation(Main.MOD_ID, "geo/salazar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntitySalazar object) {
        //return RenderAda.LOCATION_BY_VARIANT.get(object.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/salazar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntitySalazar animatable) {
        return new ResourceLocation(Main.MOD_ID, "animations/salazar.animation.json");
    }

}