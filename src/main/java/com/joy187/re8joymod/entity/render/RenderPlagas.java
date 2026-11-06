package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagas;
import com.joy187.re8joymod.entity.model.ModelPlagas;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderPlagas extends GeoEntityRenderer<EntityPlagas>{
	
    public RenderPlagas(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelPlagas());
        this.shadowRadius = 0.3f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityPlagas instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/plagas.png");
    }

    @Override
    public void render(EntityPlagas animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(0.8F, 0.8F, 0.8F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}