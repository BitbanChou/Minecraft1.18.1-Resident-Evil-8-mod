package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityHeisen;
import com.joy187.re8joymod.entity.model.ModelHeisen;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderHeisen extends GeoEntityRenderer<EntityHeisen>{
	
    public RenderHeisen(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelHeisen());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityHeisen instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/heisenberg.png");
    }

    @Override
    public void render(EntityHeisen animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.0F, 1.0F, 1.0F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}