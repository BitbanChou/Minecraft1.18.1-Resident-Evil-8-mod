package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityFrank5;
import com.joy187.re8joymod.common.entity.model.ModelFrank5;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderFrank5 extends MobRenderer<EntityFrank5, ModelFrank5<EntityFrank5>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID, "textures/entity/frank5.png");

    public RenderFrank5(EntityRendererManager manager) {
        super(manager, new ModelFrank5 <EntityFrank5>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFrank5  p_110775_1_) {
        return TEXTURE;
    }

}