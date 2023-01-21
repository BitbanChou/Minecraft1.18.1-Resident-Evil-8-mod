package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityEndScienceBlack;
import com.joy187.re8joymod.common.entity.model.ModelEndScienceBlack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderEndScienceBlack extends MobRenderer<EntityEndScienceBlack, ModelEndScienceBlack<EntityEndScienceBlack>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/scienceblack.png");

    public RenderEndScienceBlack(EntityRendererManager manager) {
        super(manager, new ModelEndScienceBlack<EntityEndScienceBlack>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEndScienceBlack p_110775_1_) {
        return TEXTURE;
    }

}