package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityLycana;
import com.joy187.re8joymod.common.entity.model.ModelLycana;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderLycana extends MobRenderer<EntityLycana, ModelLycana<EntityLycana>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/lycana.png");

    public RenderLycana(EntityRendererManager manager) {
        super(manager, new  ModelLycana<EntityLycana>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityLycana  p_110775_1_) {
        return TEXTURE;
    }

}