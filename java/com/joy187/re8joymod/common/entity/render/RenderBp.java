package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityBp;
import com.joy187.re8joymod.common.entity.model.ModelBlackpig;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderBp extends MobRenderer<EntityBp, ModelBlackpig<EntityBp>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/blackpig.png");

    public RenderBp(EntityRendererManager manager) {
        super(manager, new ModelBlackpig<EntityBp>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityBp p_110775_1_) {
        return TEXTURE;
    }

}