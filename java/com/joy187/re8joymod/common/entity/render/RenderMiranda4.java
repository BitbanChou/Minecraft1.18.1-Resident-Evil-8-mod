package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMiranda4;
import com.joy187.re8joymod.common.entity.model.ModelMiranda4;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMiranda4 extends MobRenderer<EntityMiranda4, ModelMiranda4<EntityMiranda4>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/miranda2.png");

    public RenderMiranda4(EntityRendererManager manager) {
        super(manager, new  ModelMiranda4<EntityMiranda4>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMiranda4  p_110775_1_) {
        return TEXTURE;
    }

}