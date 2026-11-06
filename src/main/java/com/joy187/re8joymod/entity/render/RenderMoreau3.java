package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMoreau3;
import com.joy187.re8joymod.entity.model.ModelMoreau3;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderMoreau3 extends GeoEntityRenderer<EntityMoreau3>{
	
    public RenderMoreau3(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelMoreau3());
        this.shadowRadius = 2.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityMoreau3 instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/moreau3.png");
    }

    @Override
    public void render(EntityMoreau3 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.3F, 1.3F, 1.3F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}