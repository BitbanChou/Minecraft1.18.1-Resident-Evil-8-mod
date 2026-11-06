package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank4;
import com.joy187.re8joymod.entity.model.ModelFrank4;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderFrank4 extends MobRenderer<EntityFrank4, ModelFrank4<EntityFrank4>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/frank4.png");

    public RenderFrank4(EntityRendererProvider.Context manager) {
        super(manager, new ModelFrank4<>(manager.bakeLayer(ModelFrank4.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityFrank4 p_110775_1_) {
        return TEXTURE;
    }
}