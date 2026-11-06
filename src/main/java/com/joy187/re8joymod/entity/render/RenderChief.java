package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityChief;
import com.joy187.re8joymod.entity.model.ModelChief;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderChief extends GeoEntityRenderer<EntityChief>{
	
    public RenderChief(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelChief());
        this.shadowRadius = 0.7f;
        //addLayer(new ChiefLayer(this));
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityChief instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/chief.png");
    }

    @Override
    public void render(EntityChief animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.2F, 1.2F, 1.2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}