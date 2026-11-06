package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityHeisencar;
import com.joy187.re8joymod.entity.model.ModelHeisencar;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderHeisencar extends MobRenderer<EntityHeisencar, ModelHeisencar<EntityHeisencar>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/heisenberg2.png");

    public RenderHeisencar(EntityRendererProvider.Context manager) {
        super(manager, new ModelHeisencar<>(manager.bakeLayer(ModelHeisencar.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityHeisencar p_110775_1_) {
        return TEXTURE;
    }
}