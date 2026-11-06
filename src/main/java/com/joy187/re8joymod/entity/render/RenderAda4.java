package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityAda4;
import com.joy187.re8joymod.entity.model.ModelAda4;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderAda4 extends GeoEntityRenderer<EntityAda4>{
	
    public RenderAda4(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelAda4());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityAda4 instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/ada4.png");
    }

    @Override
    public void render(EntityAda4 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}