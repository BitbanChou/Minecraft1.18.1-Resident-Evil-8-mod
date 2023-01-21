package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityTheHag;
import com.joy187.re8joymod.common.entity.model.ModelTheHag;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderTheHag extends MobRenderer<EntityTheHag, ModelTheHag<EntityTheHag>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/thehag.png");

    public RenderTheHag(EntityRendererManager manager) {
        super(manager, new ModelTheHag<EntityTheHag>(), 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityTheHag  p_110775_1_) {
        return TEXTURE;
    }

}