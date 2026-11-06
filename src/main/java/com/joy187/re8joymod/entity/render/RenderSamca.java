package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySamca;
import com.joy187.re8joymod.entity.model.ModelSamca;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.example.client.model.entity.ParasiteModel;
import software.bernie.example.entity.ParasiteEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class RenderSamca extends GeoEntityRenderer<EntitySamca> {
    public RenderSamca(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelSamca());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySamca instance) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/dund2.png");
    }

    @Override
    public void render(EntitySamca entity, float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {
        this.animatable = entity;
        stack.scale(1F, 1F, 1F);
        defaultRender(stack, entity, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }

}