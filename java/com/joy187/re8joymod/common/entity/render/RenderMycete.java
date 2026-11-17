package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMycete;
import com.joy187.re8joymod.common.entity.model.ModelMycete;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderMycete extends MobRenderer<EntityMycete, ModelMycete<EntityMycete>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/mycete.png");

    public RenderMycete(EntityRendererManager manager) {
        super(manager, new ModelMycete <EntityMycete>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMycete  p_110775_1_) {
        return TEXTURE;
    }

}