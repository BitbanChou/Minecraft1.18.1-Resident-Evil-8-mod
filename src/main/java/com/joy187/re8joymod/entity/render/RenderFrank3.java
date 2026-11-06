package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank3;
import com.joy187.re8joymod.entity.model.ModelFrank3;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderFrank3 extends GeoEntityRenderer<EntityFrank3>{
	
    public RenderFrank3(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelFrank3());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityFrank3 instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/frank3.png");
    }

    @Override
    public void render(EntityFrank3 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.1F, 1.1F, 1.1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}