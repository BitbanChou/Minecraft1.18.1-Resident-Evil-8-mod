package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDoll2;
import com.joy187.re8joymod.entity.model.ModelDoll2;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderDoll2 extends MobRenderer<EntityDoll2, ModelDoll2<EntityDoll2>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/angie.png");

    public RenderDoll2(EntityRendererProvider.Context manager) {
        super(manager, new ModelDoll2<>(manager.bakeLayer(ModelDoll2.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityDoll2 p_110775_1_) {
        return TEXTURE;
    }
}