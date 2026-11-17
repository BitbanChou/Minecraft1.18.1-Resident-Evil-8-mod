package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityDoll1;
import com.joy187.re8joymod.common.entity.model.ModelDoll1;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderDoll1 extends MobRenderer<EntityDoll1, ModelDoll1<EntityDoll1>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/angie.png");

    public RenderDoll1(EntityRendererManager manager) {
        super(manager, new ModelDoll1<EntityDoll1>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDoll1 p_110775_1_) {
        return TEXTURE;
    }

}