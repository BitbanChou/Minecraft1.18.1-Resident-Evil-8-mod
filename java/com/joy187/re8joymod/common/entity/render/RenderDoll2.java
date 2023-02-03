package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityDoll2;
import com.joy187.re8joymod.common.entity.model.ModelDoll2;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderDoll2 extends MobRenderer<EntityDoll2, ModelDoll2<EntityDoll2>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/angie.png");

    public RenderDoll2(EntityRendererManager manager) {
        super(manager, new ModelDoll2<EntityDoll2>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDoll2 p_110775_1_) {
        return TEXTURE;
    }

}