package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityM1851B;
import com.joy187.re8joymod.entity.EntityNovi;
import com.joy187.re8joymod.entity.model.ModelNovi;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderNovi extends GeoEntityRenderer<EntityNovi>{
	
    public RenderNovi(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelNovi());
        this.shadowRadius = 0.7f;
        //addLayer(new NoviLayer(this));
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityNovi instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/novi.png");
    }

    @Override
    public void render(EntityNovi animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(0.8F, 0.8F, 0.8F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
//    @Override
//    public void render(EntityNovi entity, double x, double y, double z, float entityYaw, PoseStack poseStackIn, MultiBufferSource bufferIn float partialTicks)
//    {
//
//        float[] RGB = entity.getSkinRGB();
//
//        poseStackIn.pushPose();
//        bufferIn.color(RGB[0]/255.0F, RGB[1]/255.0F, RGB[2]/255.0F, 1.0F);
//        poseStackIn.popPose();
//
//        super.render(entity, x, y, z, entityYaw, partialTicks);
//
//    }

}