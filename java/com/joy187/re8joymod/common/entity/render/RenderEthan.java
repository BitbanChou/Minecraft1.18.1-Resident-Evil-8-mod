package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityEthan;
import com.joy187.re8joymod.common.entity.EntityRe8Dimi;
import com.joy187.re8joymod.common.entity.model.ModelEthan;
import com.joy187.re8joymod.common.entity.model.ModelRe8Dimi;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderEthan extends MobRenderer<EntityEthan, ModelEthan<EntityEthan>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/ethan.png");

    public RenderEthan(EntityRendererManager manager) {
        super(manager, new ModelEthan <EntityEthan>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEthan  p_110775_1_) {
        return TEXTURE;
    }

}