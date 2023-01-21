package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMoreau4;
import com.joy187.re8joymod.common.entity.model.ModelMoreau4;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderMoreau4 extends MobRenderer<EntityMoreau4, ModelMoreau4<EntityMoreau4>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/moreau3.png");

    public RenderMoreau4(EntityRendererManager manager) {
        super(manager, new ModelMoreau4<EntityMoreau4>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMoreau4  p_110775_1_) {
        return TEXTURE;
    }

}