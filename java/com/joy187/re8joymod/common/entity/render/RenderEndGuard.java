package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityEndGuard;
import com.joy187.re8joymod.common.entity.model.ModelEndGuard;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderEndGuard extends MobRenderer<EntityEndGuard, ModelEndGuard<EntityEndGuard>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/endguard.png");

    public RenderEndGuard(EntityRendererManager manager) {
        super(manager, new ModelEndGuard<EntityEndGuard>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEndGuard p_110775_1_) {
        return TEXTURE;
    }

}