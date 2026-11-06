package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityUriass;
import com.joy187.re8joymod.entity.model.ModelUriass;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderUriass extends GeoEntityRenderer<EntityUriass>{
	
    public RenderUriass(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelUriass());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityUriass instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/uriasstrajer.png");
    }

    @Override
    public void render(EntityUriass animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.25F, 1.25F, 1.25F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}