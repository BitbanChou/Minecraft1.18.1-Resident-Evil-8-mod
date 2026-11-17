package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityHeisen;
import com.joy187.re8joymod.common.entity.model.ModelHeisen;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderHeisen extends MobRenderer<EntityHeisen, ModelHeisen<EntityHeisen>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/heisenberg.png");

    public RenderHeisen(EntityRendererManager manager) {
        super(manager, new ModelHeisen<EntityHeisen>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityHeisen  p_110775_1_) {
        return TEXTURE;
    }

}