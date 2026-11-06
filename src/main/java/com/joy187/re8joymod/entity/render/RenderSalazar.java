package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntitySalazar;
import com.joy187.re8joymod.entity.model.ModelSalazar;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderSalazar extends GeoEntityRenderer<EntitySalazar>{

    public RenderSalazar(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelSalazar());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntitySalazar instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/salazar.png");
    }

    @Override
    public void render(EntitySalazar animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(0.8F, 0.8F, 0.8F);
        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}