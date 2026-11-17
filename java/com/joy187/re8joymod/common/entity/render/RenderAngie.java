package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityAngie;
import com.joy187.re8joymod.common.entity.model.ModelAngie;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;


public class RenderAngie extends MobRenderer<EntityAngie, ModelAngie<EntityAngie>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/angie.png");

    public RenderAngie(EntityRendererManager manager) {
        super(manager, new ModelAngie<EntityAngie>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityAngie p_110775_1_) {
        return TEXTURE;
    }

}