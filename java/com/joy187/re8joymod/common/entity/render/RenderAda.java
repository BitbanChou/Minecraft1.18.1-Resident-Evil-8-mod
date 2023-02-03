package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityAda;
import com.joy187.re8joymod.common.entity.model.ModelAdawang;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderAda extends MobRenderer<EntityAda, ModelAdawang<EntityAda>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/ada.png");

    public RenderAda(EntityRendererManager manager) {
        super(manager, new  ModelAdawang<EntityAda>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityAda  p_110775_1_) {
        return TEXTURE;
    }

}