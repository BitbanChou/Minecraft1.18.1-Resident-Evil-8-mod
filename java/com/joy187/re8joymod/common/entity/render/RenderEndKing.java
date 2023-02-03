package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityEndKing;
import com.joy187.re8joymod.common.entity.model.ModelEndKing;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderEndKing extends MobRenderer<EntityEndKing, ModelEndKing<EntityEndKing>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/endshadow_king.png");

    public RenderEndKing(EntityRendererManager manager) {
        super(manager, new ModelEndKing<EntityEndKing>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEndKing p_110775_1_) {
        return TEXTURE;
    }

}