package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityFrank3;
import com.joy187.re8joymod.common.entity.model.ModelFrank3;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderFrank3 extends MobRenderer<EntityFrank3, ModelFrank3<EntityFrank3>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/frank3.png");

    public RenderFrank3(EntityRendererManager manager) {
        super(manager, new ModelFrank3 <EntityFrank3>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFrank3  p_110775_1_) {
        return TEXTURE;
    }

}