package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityMia;
import com.joy187.re8joymod.common.entity.model.ModelMia;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMia extends MobRenderer<EntityMia, ModelMia<EntityMia>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/mia.png");

    public RenderMia(EntityRendererManager manager) {
        super(manager, new  ModelMia<EntityMia>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMia  p_110775_1_) {
        return TEXTURE;
    }

}