package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityDund2;
import com.joy187.re8joymod.common.entity.model.ModelDund2;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderDund2 extends MobRenderer<EntityDund2, ModelDund2<EntityDund2>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/dungeonz.png");

    public RenderDund2(EntityRendererManager manager) {
        super(manager, new ModelDund2<EntityDund2>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDund2 p_110775_1_) {
        return TEXTURE;
    }

}