package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityLycan;
import com.joy187.re8joymod.common.entity.model.ModelLycan;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderLycan extends MobRenderer<EntityLycan, ModelLycan<EntityLycan>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/lycan.png");

    public RenderLycan(EntityRendererManager manager) {
        super(manager, new  ModelLycan<EntityLycan>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityLycan  p_110775_1_) {
        return TEXTURE;
    }

}