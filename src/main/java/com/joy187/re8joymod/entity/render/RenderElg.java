package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityElg;
import com.joy187.re8joymod.entity.model.ModelElg;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderElg extends GeoEntityRenderer<EntityElg>{
	
    public RenderElg(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelElg());
        this.shadowRadius = 3f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityElg instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/elg.png");
    }

    @Override
    public void render(EntityElg animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(2.5F, 2.5F, 2.5F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}