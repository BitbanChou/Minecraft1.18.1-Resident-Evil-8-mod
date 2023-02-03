package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityBei;
import com.joy187.re8joymod.common.entity.model.ModelBei;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderBei extends MobRenderer<EntityBei, ModelBei<EntityBei>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/beneviento.png");

    public RenderBei(EntityRendererManager manager) {
        super(manager, new ModelBei<EntityBei>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityBei p_110775_1_) {
        return TEXTURE;
    }

}