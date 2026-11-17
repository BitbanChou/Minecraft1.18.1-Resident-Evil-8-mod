package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityUriass;
import com.joy187.re8joymod.common.entity.model.ModelUriass;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderUriass extends MobRenderer<EntityUriass, ModelUriass<EntityUriass>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/uriasstrajer.png");

    public RenderUriass(EntityRendererManager manager) {
        super(manager, new ModelUriass<EntityUriass>(), 0.9f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityUriass  p_110775_1_) {
        return TEXTURE;
    }

}