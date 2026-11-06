package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySaddler2;
import com.joy187.re8joymod.entity.model.ModelSaddler2;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderSaddler2 extends GeoEntityRenderer<EntitySaddler2>{
	
    public RenderSaddler2(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelSaddler2());
        this.shadowRadius = 1.2f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntitySaddler2 instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/saddler2.png");
    }

    @Override
    public void render(EntitySaddler2 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.2F, 1.2F, 1.2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}