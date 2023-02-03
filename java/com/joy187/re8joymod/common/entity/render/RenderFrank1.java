package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityFrank1;
import com.joy187.re8joymod.common.entity.model.ModelFrank1;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderFrank1 extends MobRenderer<EntityFrank1, ModelFrank1<EntityFrank1>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/frank1.png");

    public RenderFrank1(EntityRendererManager manager) {
        super(manager, new ModelFrank1 <EntityFrank1>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFrank1  p_110775_1_) {
        return TEXTURE;
    }

}