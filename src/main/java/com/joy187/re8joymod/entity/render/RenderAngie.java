package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityAngie;
import com.joy187.re8joymod.entity.model.ModelAngie;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderAngie extends MobRenderer<EntityAngie, ModelAngie<EntityAngie>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/angie.png");

    public RenderAngie(EntityRendererProvider.Context manager) {
        super(manager, new ModelAngie<>(manager.bakeLayer(ModelAngie.LAYER_LOCATION)), 0.7F);
     }
    
    @Override
    public ResourceLocation getTextureLocation(EntityAngie p_110775_1_) {
        return TEXTURE;
    }
}