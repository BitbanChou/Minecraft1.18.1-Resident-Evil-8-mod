package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityVarcolac;
import com.joy187.re8joymod.common.entity.model.ModelVarcolac;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderVarcolac extends MobRenderer<EntityVarcolac, ModelVarcolac<EntityVarcolac>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/varcolac.png");

    public RenderVarcolac(EntityRendererManager manager) {
        super(manager, new  ModelVarcolac<EntityVarcolac>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityVarcolac  p_110775_1_) {
        return TEXTURE;
    }

}