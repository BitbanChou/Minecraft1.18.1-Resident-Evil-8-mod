package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDoll1;
import com.joy187.re8joymod.entity.model.ModelDoll1;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderDoll1 extends MobRenderer<EntityDoll1, ModelDoll1<EntityDoll1>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/angie.png");

    public RenderDoll1(EntityRendererProvider.Context manager) {
        super(manager, new ModelDoll1<>(manager.bakeLayer(ModelDoll1.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityDoll1 p_110775_1_) {
        return TEXTURE;
    }
}