package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityRose;
import com.joy187.re8joymod.common.entity.model.ModelRose;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderRose extends MobRenderer<EntityRose, ModelRose<EntityRose>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/rosemary.png");

    public RenderRose(EntityRendererManager manager) {
        super(manager, new  ModelRose<EntityRose>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityRose  p_110775_1_) {
        return TEXTURE;
    }

}