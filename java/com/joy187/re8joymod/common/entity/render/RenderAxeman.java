package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityAxeman;
import com.joy187.re8joymod.common.entity.model.ModelAxeman;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderAxeman extends MobRenderer<EntityAxeman, ModelAxeman<EntityAxeman>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/axeman.png");

    public RenderAxeman(EntityRendererManager manager) {
        super(manager, new ModelAxeman<EntityAxeman>(), 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityAxeman  p_110775_1_) {
        return TEXTURE;
    }

}