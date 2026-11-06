package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDund2;
import com.joy187.re8joymod.entity.model.ModelDund2;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderDund2 extends GeoEntityRenderer<EntityDund2>{
	
    public RenderDund2(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelDund2());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityDund2 instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/dund2.png");
    }

    @Override
    public void render(EntityDund2 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {
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
