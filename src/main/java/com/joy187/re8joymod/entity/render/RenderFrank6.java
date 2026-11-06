package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank6;
import com.joy187.re8joymod.entity.model.ModelFrank6;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderFrank6 extends GeoEntityRenderer<EntityFrank6>{
	
    public RenderFrank6(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelFrank6());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityFrank6 instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/frank6.png");
    }

    @Override
    public void render(EntityFrank6 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.3F, 1.3F, 1.3F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}