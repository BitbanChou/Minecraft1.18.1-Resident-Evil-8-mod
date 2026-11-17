package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityBeibaby;
import com.joy187.re8joymod.common.entity.model.ModelBeibaby;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderBeibaby extends MobRenderer<EntityBeibaby, ModelBeibaby<EntityBeibaby>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/beibaby.png");

    public RenderBeibaby(EntityRendererManager manager) {
        super(manager, new ModelBeibaby<EntityBeibaby>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityBeibaby p_110775_1_) {
        return TEXTURE;
    }

}