package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMuHeisen;
import com.joy187.re8joymod.entity.model.ModelMuHeisen;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderMuHeisen extends GeoEntityRenderer<EntityMuHeisen>{
	
    public RenderMuHeisen(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelMuHeisen());
        this.shadowRadius = 5.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityMuHeisen instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/heisenberg2.png");
    }

    @Override
    public void render(EntityMuHeisen animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.5F, 1.5F, 1.5F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}