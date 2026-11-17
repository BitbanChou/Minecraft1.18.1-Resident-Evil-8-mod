package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityFrank4;
import com.joy187.re8joymod.common.entity.model.ModelFrank4;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderFrank4 extends MobRenderer<EntityFrank4, ModelFrank4<EntityFrank4>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/frank4.png");

    public RenderFrank4(EntityRendererManager manager) {
        super(manager, new ModelFrank4 <EntityFrank4>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFrank4  p_110775_1_) {
        return TEXTURE;
    }

}