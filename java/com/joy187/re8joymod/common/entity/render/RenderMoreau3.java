package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMoreau3;
import com.joy187.re8joymod.common.entity.model.ModelMutatedMoreau;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderMoreau3 extends MobRenderer<EntityMoreau3, ModelMutatedMoreau<EntityMoreau3>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/moreau3.png");

    public RenderMoreau3(EntityRendererManager manager) {
        super(manager, new ModelMutatedMoreau<EntityMoreau3>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMoreau3  p_110775_1_) {
        return TEXTURE;
    }

}