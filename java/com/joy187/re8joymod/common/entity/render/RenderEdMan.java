package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityEdMan;
import com.joy187.re8joymod.common.entity.model.ModelEdMan;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderEdMan extends MobRenderer<EntityEdMan, ModelEdMan<EntityEdMan>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/edman.png");

    public RenderEdMan(EntityRendererManager manager) {
        super(manager, new ModelEdMan<EntityEdMan>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEdMan p_110775_1_) {
        return TEXTURE;
    }

}