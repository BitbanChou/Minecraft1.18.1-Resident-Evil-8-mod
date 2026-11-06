package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMiranda4;
import com.joy187.re8joymod.entity.model.ModelMiranda4;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderMiranda4 extends MobRenderer<EntityMiranda4, ModelMiranda4<EntityMiranda4>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/miranda2.png");

    public RenderMiranda4(EntityRendererProvider.Context manager) {
        super(manager, new ModelMiranda4<>(manager.bakeLayer(ModelMiranda4.LAYER_LOCATION)), 0.9F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityMiranda4 p_110775_1_) {
        return TEXTURE;
    }
}