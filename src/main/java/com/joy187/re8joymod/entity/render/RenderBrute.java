package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityBrute;
import com.joy187.re8joymod.entity.model.ModelBrute;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderBrute extends GeoEntityRenderer<EntityBrute>{
	
    public RenderBrute(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelBrute());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityBrute instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/brute.png");
    }

    @Override
    public void render(EntityBrute animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(0.9F, 0.9F, 0.9F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}