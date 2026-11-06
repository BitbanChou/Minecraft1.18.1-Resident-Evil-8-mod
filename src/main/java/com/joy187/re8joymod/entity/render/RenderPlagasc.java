package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasc;
import com.joy187.re8joymod.entity.model.ModelPlagasc;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderPlagasc extends GeoEntityRenderer<EntityPlagasc>{
	
    public RenderPlagasc(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelPlagasc());
        this.shadowRadius = 0.3f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityPlagasc instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/plagasc.png");
    }

    @Override
    public void render(EntityPlagasc animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.2F, 1.2F, 1.2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}