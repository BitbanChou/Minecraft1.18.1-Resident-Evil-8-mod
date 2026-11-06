package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDoll3;
import com.joy187.re8joymod.entity.model.ModelDoll3;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderDoll3 extends GeoEntityRenderer<EntityDoll3>{

	
    public RenderDoll3(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelDoll3());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityDoll3 instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/angie.png");
    }

    @Override
    public void render(EntityDoll3 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}