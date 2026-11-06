package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasArmadura;
import com.joy187.re8joymod.entity.model.ModelPlagasArmadura;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderPlagasArmadura extends GeoEntityRenderer<EntityPlagasArmadura>{
	
    public RenderPlagasArmadura(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelPlagasArmadura());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityPlagasArmadura instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/armadura1.png");
    }

    @Override
    public void render(EntityPlagasArmadura animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

        stack.scale(0.7F, 0.7F, 0.7F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}