package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityDoll3;
import com.joy187.re8joymod.common.entity.model.ModelDoll3;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderDoll3 extends MobRenderer<EntityDoll3, ModelDoll3<EntityDoll3>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/angie.png");

    public RenderDoll3(EntityRendererManager manager) {
        super(manager, new ModelDoll3<EntityDoll3>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDoll3 p_110775_1_) {
        return TEXTURE;
    }

}