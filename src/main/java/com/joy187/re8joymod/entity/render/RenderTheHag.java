package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityTheHag;
import com.joy187.re8joymod.entity.model.ModelTheHag;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderTheHag extends MobRenderer<EntityTheHag, ModelTheHag<EntityTheHag>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/thehag.png");

    public RenderTheHag(EntityRendererProvider.Context manager) {
        super(manager, new ModelTheHag<>(manager.bakeLayer(ModelTheHag.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityTheHag p_110775_1_) {
        return TEXTURE;
    }
}