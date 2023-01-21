package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityDaniela;
import com.joy187.re8joymod.common.entity.model.ModelDaniela;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderDaniela extends MobRenderer<EntityDaniela, ModelDaniela<EntityDaniela>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/daniela.png");

    public RenderDaniela(EntityRendererManager manager) {
        super(manager, new ModelDaniela<EntityDaniela>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDaniela p_110775_1_) {
        return TEXTURE;
    }

}