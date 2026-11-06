package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityVerdugo;
import com.joy187.re8joymod.entity.model.ModelVerdugo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderVerdugo extends GeoEntityRenderer<EntityVerdugo>{
    public RenderVerdugo(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelVerdugo());
        this.shadowRadius = 0.7f;
        //addLayer(new VerdugoLayer(this));
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityVerdugo instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/verdugo.png");
    }

    @Override
    public void render(EntityVerdugo animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}