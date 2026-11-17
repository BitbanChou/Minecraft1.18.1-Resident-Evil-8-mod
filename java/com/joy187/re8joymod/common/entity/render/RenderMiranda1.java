package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMiranda1;
import com.joy187.re8joymod.common.entity.model.ModelMiranda1;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderMiranda1 extends MobRenderer<EntityMiranda1, ModelMiranda1<EntityMiranda1>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/miranda1.png");

    public RenderMiranda1(EntityRendererManager manager) {
        super(manager, new  ModelMiranda1<EntityMiranda1>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMiranda1  p_110775_1_) {
        return TEXTURE;
    }

}