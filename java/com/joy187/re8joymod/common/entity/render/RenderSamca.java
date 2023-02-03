package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntitySamca;
import com.joy187.re8joymod.common.entity.model.ModelSamca;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderSamca extends MobRenderer<EntitySamca, ModelSamca<EntitySamca>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/dungeonz2.png");

    public RenderSamca(EntityRendererManager manager) {
        super(manager, new ModelSamca<EntitySamca>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySamca  p_110775_1_) {
        return TEXTURE;
    }

}