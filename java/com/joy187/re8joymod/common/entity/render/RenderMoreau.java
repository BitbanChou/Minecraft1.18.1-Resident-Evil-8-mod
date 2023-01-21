package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMoreau;
import com.joy187.re8joymod.common.entity.model.ModelMoreau;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMoreau extends MobRenderer<EntityMoreau, ModelMoreau<EntityMoreau>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/moreau.png");

    public RenderMoreau(EntityRendererManager manager) {
        super(manager, new ModelMoreau<EntityMoreau>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMoreau  p_110775_1_) {
        return TEXTURE;
    }

}