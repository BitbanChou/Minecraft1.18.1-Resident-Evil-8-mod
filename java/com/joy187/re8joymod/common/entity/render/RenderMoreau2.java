package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMoreau2;
import com.joy187.re8joymod.common.entity.model.ModelMoreau2;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderMoreau2 extends MobRenderer<EntityMoreau2, ModelMoreau2<EntityMoreau2>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/moreau2.png");

    public RenderMoreau2(EntityRendererManager manager) {
        super(manager, new ModelMoreau2<EntityMoreau2>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMoreau2  p_110775_1_) {
        return TEXTURE;
    }

}