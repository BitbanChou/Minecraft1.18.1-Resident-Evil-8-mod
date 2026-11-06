package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySaddler;
import com.joy187.re8joymod.entity.model.ModelSaddler;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderSaddler extends GeoEntityRenderer<EntitySaddler>{
	
    public RenderSaddler(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelSaddler());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntitySaddler instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/saddler.png");
    }

    @Override
    public void render(EntitySaddler animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.2F, 1.2F, 1.2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}