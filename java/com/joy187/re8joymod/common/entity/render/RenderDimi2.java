package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityDimi2;
import com.joy187.re8joymod.common.entity.model.ModelDimi2;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderDimi2 extends MobRenderer<EntityDimi2, ModelDimi2<EntityDimi2>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/dimi2.png");

    public RenderDimi2(EntityRendererManager manager) {
        super(manager, new ModelDimi2<EntityDimi2>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDimi2 p_110775_1_) {
        return TEXTURE;
    }

}