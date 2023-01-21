package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMiranda2;
import com.joy187.re8joymod.common.entity.model.ModelMiranda2;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMiranda2 extends MobRenderer<EntityMiranda2, ModelMiranda2<EntityMiranda2>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/miranda2.png");

    public RenderMiranda2(EntityRendererManager manager) {
        super(manager, new  ModelMiranda2<EntityMiranda2>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMiranda2  p_110775_1_) {
        return TEXTURE;
    }

}
