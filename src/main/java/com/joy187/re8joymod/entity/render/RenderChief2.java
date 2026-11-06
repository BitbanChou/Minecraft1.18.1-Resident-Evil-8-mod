package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityChief2;
import com.joy187.re8joymod.entity.model.ModelChief2;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderChief2 extends GeoEntityRenderer<EntityChief2>{
	
    public RenderChief2(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelChief2());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityChief2 instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/chief2.png");
    }

    @Override
    public void render(EntityChief2 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.2F, 1.2F, 1.2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}