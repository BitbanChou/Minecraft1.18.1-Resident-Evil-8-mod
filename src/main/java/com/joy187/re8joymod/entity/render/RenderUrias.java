package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityUrias;
import com.joy187.re8joymod.entity.model.ModelUrias;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderUrias extends GeoEntityRenderer<EntityUrias>{
	
    public RenderUrias(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelUrias());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityUrias instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/urias.png");
    }

    @Override
    public void render(EntityUrias animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.1F, 1.1F, 1.1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}