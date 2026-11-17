package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityChris;
import com.joy187.re8joymod.common.entity.model.ModelChris;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderChris extends MobRenderer<EntityChris, ModelChris<EntityChris>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/chris.png");

    public RenderChris(EntityRendererManager manager) {
        super(manager, new ModelChris<EntityChris>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityChris p_110775_1_) {
        return TEXTURE;
    }

}