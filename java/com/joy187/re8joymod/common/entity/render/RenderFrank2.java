package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityFrank2;
import com.joy187.re8joymod.common.entity.model.ModelFrank2;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderFrank2 extends MobRenderer<EntityFrank2, ModelFrank2<EntityFrank2>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/frank2.png");

    public RenderFrank2(EntityRendererManager manager) {
        super(manager, new ModelFrank2 <EntityFrank2>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFrank2  p_110775_1_) {
        return TEXTURE;
    }

}