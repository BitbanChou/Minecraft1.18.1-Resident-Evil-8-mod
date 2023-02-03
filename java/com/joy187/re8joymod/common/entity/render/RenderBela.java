package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityBela;
import com.joy187.re8joymod.common.entity.model.ModelBela;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderBela extends MobRenderer<EntityBela, ModelBela<EntityBela>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/bela.png");

    public RenderBela(EntityRendererManager manager) {
        super(manager, new ModelBela<EntityBela>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityBela p_110775_1_) {
        return TEXTURE;
    }

}