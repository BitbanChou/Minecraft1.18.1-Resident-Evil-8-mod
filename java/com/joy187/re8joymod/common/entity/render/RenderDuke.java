package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityDuke;
import com.joy187.re8joymod.common.entity.model.ModelDuke;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderDuke extends MobRenderer<EntityDuke, ModelDuke<EntityDuke>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/duke.png");

    public RenderDuke(EntityRendererManager manager) {
        super(manager, new  ModelDuke<EntityDuke>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDuke  p_110775_1_) {
        return TEXTURE;
    }

}