package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityWp;
import com.joy187.re8joymod.common.entity.model.ModelBlackpig;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderWp extends MobRenderer<EntityWp, ModelBlackpig<EntityWp>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/whitepig.png");

    public RenderWp(EntityRendererManager manager) {
        super(manager, new ModelBlackpig<EntityWp>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityWp p_110775_1_) {
        return TEXTURE;
    }

}