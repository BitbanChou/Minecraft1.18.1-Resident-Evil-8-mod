package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityUrias;
import com.joy187.re8joymod.common.entity.model.ModelUrias;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderUrias extends MobRenderer<EntityUrias, ModelUrias<EntityUrias>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/urias.png");

    public RenderUrias(EntityRendererManager manager) {
        super(manager, new ModelUrias<EntityUrias>(), 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityUrias  p_110775_1_) {
        return TEXTURE;
    }

}