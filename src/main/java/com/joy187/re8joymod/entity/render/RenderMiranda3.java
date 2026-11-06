package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityMiranda3;
import com.joy187.re8joymod.entity.model.ModelMiranda3;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderMiranda3 extends GeoEntityRenderer<EntityMiranda3>{
	
    public RenderMiranda3(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelMiranda3());
        this.shadowRadius = 0.9f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityMiranda3 instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/miranda2.png");
    }

    @Override
    public void render(EntityMiranda3 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.2F, 1.2F, 1.2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}