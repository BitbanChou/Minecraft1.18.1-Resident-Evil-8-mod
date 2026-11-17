package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntitySummonSturm;
import com.joy187.re8joymod.common.entity.model.ModelSummonSturm;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderSummonSturm extends MobRenderer<EntitySummonSturm, ModelSummonSturm<EntitySummonSturm>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/frank5.png");

    public RenderSummonSturm(EntityRendererManager manager) {
        super(manager, new ModelSummonSturm<EntitySummonSturm>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySummonSturm  p_110775_1_) {
        return TEXTURE;
    }

}