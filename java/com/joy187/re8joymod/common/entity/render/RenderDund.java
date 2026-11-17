package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityDund;
import com.joy187.re8joymod.common.entity.model.ModelDund;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderDund extends MobRenderer<EntityDund, ModelDund<EntityDund>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/dungeonz.png");

    public RenderDund(EntityRendererManager manager) {
        super(manager, new ModelDund<EntityDund>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDund p_110775_1_) {
        return TEXTURE;
    }

}