package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityFly;
import com.joy187.re8joymod.entity.model.ModelAda;
import com.joy187.re8joymod.entity.model.ModelFly;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderFly extends GeoEntityRenderer<EntityFly>{
	
    public RenderFly(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelFly());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityFly instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/fly.png");
    }

    @Override
    public void render(EntityFly animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}