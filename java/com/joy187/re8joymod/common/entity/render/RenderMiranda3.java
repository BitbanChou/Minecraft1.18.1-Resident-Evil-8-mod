package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMiranda3;
import com.joy187.re8joymod.common.entity.model.ModelMiranda3;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderMiranda3 extends MobRenderer<EntityMiranda3, ModelMiranda3<EntityMiranda3>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/miranda2.png");

    public RenderMiranda3(EntityRendererManager manager) {
        super(manager, new  ModelMiranda3<EntityMiranda3>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMiranda3  p_110775_1_) {
        return TEXTURE;
    }

}