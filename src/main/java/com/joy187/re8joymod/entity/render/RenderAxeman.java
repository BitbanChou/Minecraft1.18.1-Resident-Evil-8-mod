package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityAxeman;
import com.joy187.re8joymod.entity.model.ModelAxeman;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderAxeman extends GeoEntityRenderer<EntityAxeman>{
	
    public RenderAxeman(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelAxeman());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityAxeman instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/axeman.png");
    }

    @Override
    public void render(EntityAxeman animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.1F, 1.1F, 1.1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}