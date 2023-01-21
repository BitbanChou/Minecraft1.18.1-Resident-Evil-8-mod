package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityFrank6;
import com.joy187.re8joymod.common.entity.model.ModelFrank6;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderFrank6 extends MobRenderer<EntityFrank6, ModelFrank6<EntityFrank6>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/frank6.png");

    public RenderFrank6(EntityRendererManager manager) {
        super(manager, new ModelFrank6 <EntityFrank6>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFrank6  p_110775_1_) {
        return TEXTURE;
    }

}