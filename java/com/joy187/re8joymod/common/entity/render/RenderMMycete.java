package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMMycete;
import com.joy187.re8joymod.common.entity.model.ModelMMycete;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderMMycete extends MobRenderer<EntityMMycete, ModelMMycete<EntityMMycete>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/mycete.png");

    public RenderMMycete(EntityRendererManager manager) {
        super(manager, new ModelMMycete <EntityMMycete>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMMycete  p_110775_1_) {
        return TEXTURE;
    }

}