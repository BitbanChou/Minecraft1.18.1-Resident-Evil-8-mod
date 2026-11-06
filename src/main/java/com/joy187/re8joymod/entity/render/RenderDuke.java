package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDuke;
import com.joy187.re8joymod.entity.model.ModelDuke;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderDuke extends GeoEntityRenderer<EntityDuke>{

	
    public RenderDuke(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelDuke());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityDuke instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/duke.png");
    }

    @Override
    public void render(EntityDuke animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {
//        if(animatable.isBaby()) {
//            stack.scale(0.4F, 0.4F, 0.4F);
//        } else {
//            stack.scale(0.8F, 0.8F, 0.8F);
//        }
    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}