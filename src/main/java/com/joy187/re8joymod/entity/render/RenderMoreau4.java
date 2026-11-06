package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMoreau4;
import com.joy187.re8joymod.entity.model.ModelMoreau4;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderMoreau4 extends MobRenderer<EntityMoreau4, ModelMoreau4<EntityMoreau4>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/moreau3.png");

    public RenderMoreau4(EntityRendererProvider.Context manager) {
        super(manager, new ModelMoreau4<>(manager.bakeLayer(ModelMoreau4.LAYER_LOCATION)), 0.9F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityMoreau4 p_110775_1_) {
        return TEXTURE;
    }
}