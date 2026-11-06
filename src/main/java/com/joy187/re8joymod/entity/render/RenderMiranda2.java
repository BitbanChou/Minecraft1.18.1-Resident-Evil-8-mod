package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMiranda2;
import com.joy187.re8joymod.entity.model.ModelMiranda2;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderMiranda2 extends GeoEntityRenderer<EntityMiranda2>{
	
    public RenderMiranda2(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelMiranda2());
        this.shadowRadius = 0.8f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityMiranda2 instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/miranda2.png");
    }

    @Override
    public void render(EntityMiranda2 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}