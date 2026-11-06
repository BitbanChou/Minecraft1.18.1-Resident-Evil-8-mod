package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasCreeper;
import com.joy187.re8joymod.entity.model.ModelPlagasCreeper;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderPlagasCreeper extends GeoEntityRenderer<EntityPlagasCreeper> {

    //public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/lycan.png");


    @Override
    public ResourceLocation getTextureLocation(EntityPlagasCreeper instance) {
        return new ResourceLocation(Main.MOD_ID, "textures/entity/plagascreeper.png");
    }

    public RenderPlagasCreeper(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelPlagasCreeper());
        this.shadowRadius = 0.5f;
    }

    @Override
    public void render(EntityPlagasCreeper animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1.1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}