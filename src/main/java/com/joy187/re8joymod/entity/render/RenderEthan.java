package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityEthan;
import com.joy187.re8joymod.entity.model.ModelEthan;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderEthan extends MobRenderer<EntityEthan, ModelEthan<EntityEthan>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/ethan.png");

    public RenderEthan(EntityRendererProvider.Context manager) {
        super(manager, new ModelEthan<>(manager.bakeLayer(ModelEthan.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityEthan p_110775_1_) {
        return TEXTURE;
    }
}
