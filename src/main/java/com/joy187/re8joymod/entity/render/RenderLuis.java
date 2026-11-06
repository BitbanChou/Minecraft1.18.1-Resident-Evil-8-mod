package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityLuis;
import com.joy187.re8joymod.entity.model.ModelLuis;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderLuis extends GeoEntityRenderer<EntityLuis>{
	
    public RenderLuis(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelLuis());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityLuis instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/luis.png");
    }

    @Override
    public void render(EntityLuis animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}