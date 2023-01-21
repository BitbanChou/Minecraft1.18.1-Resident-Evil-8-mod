package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityLycan1;
import com.joy187.re8joymod.common.entity.model.ModelLycan1;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderLycan1 extends MobRenderer<EntityLycan1, ModelLycan1<EntityLycan1>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/lycan1.png");

    public RenderLycan1(EntityRendererManager manager) {
        super(manager, new  ModelLycan1<EntityLycan1>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityLycan1  p_110775_1_) {
        return TEXTURE;
    }

}