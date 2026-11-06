package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMycete;
import com.joy187.re8joymod.entity.model.ModelMycete;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderMycete extends MobRenderer<EntityMycete, ModelMycete<EntityMycete>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/mycete.png");

    public RenderMycete(EntityRendererProvider.Context manager) {
        super(manager, new ModelMycete<>(manager.bakeLayer(ModelMycete.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityMycete p_110775_1_) {
        return TEXTURE;
    }
}