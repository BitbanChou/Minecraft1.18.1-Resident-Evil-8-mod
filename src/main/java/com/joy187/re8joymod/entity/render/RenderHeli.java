package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityHeli;
import com.joy187.re8joymod.entity.model.ModelHeli;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderHeli extends GeoEntityRenderer<EntityHeli> {

    public RenderHeli(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelHeli());
        this.shadowRadius = 1f;
    }

    @Override
    public ResourceLocation getTextureLocation(EntityHeli instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/helicopter.png");
    }

    @Override
    public void render(EntityHeli animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

        stack.scale(1.5F, 1.5F, 1.5F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}