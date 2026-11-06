package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFrank5;
import com.joy187.re8joymod.entity.model.ModelFrank5;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderFrank5 extends GeoEntityRenderer<EntityFrank5>{
	
    public RenderFrank5(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelFrank5());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityFrank5 instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/frank5.png");
    }

    @Override
    public void render(EntityFrank5 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.6F, 1.3F, 1.6F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}