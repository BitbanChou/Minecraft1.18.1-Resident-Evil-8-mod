package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMMycete;
import com.joy187.re8joymod.entity.model.ModelMMycete;
import com.joy187.re8joymod.entity.model.ModelMycete;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class RenderMMycete extends MobRenderer<EntityMMycete, ModelMMycete<EntityMMycete>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/mycete.png");

    public RenderMMycete(EntityRendererProvider.Context manager) {
        super(manager, new ModelMMycete<>(manager.bakeLayer(ModelMMycete.LAYER_LOCATION)), 0.7F);
    }


    @Override
    public ResourceLocation getTextureLocation(EntityMMycete p_110775_1_) {
        return TEXTURE;
    }
}