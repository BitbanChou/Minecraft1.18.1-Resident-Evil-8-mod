package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMuHeisen;
import com.joy187.re8joymod.common.entity.model.ModelMuHeisen;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderMuHeisen extends MobRenderer<EntityMuHeisen, ModelMuHeisen<EntityMuHeisen>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/heisenberg2.png");

    public RenderMuHeisen(EntityRendererManager manager) {
        super(manager, new ModelMuHeisen<EntityMuHeisen>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMuHeisen  p_110775_1_) {
        return TEXTURE;
    }

}