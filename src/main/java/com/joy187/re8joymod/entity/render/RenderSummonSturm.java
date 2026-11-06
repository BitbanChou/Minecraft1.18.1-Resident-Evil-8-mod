package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySummonSturm;
import com.joy187.re8joymod.entity.model.ModelSummonSturm;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderSummonSturm extends GeoEntityRenderer<EntitySummonSturm>{
	
    public RenderSummonSturm(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelSummonSturm());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntitySummonSturm instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/frank5.png");
    }

    @Override
    public void render(EntitySummonSturm animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.2F, 1.3F, 1.2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}