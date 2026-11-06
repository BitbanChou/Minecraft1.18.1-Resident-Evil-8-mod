package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityDimi2;
import com.joy187.re8joymod.entity.EntityDimi2;
import com.joy187.re8joymod.entity.model.ModelDimi2;
import com.joy187.re8joymod.entity.model.ModelRe8Dimi;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderDimi2 extends GeoEntityRenderer<EntityDimi2> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(Main.MOD_ID, "textures/entity/dimi2.png");

//    public RenderDimi2(EntityRendererProvider.Context manager) {
//        super(manager, new ModelDimi2<>(manager.bakeLayer(ModelDimi2.LAYER_LOCATION)), 0.7F);
//     }
//    
//    @Override
//    public ResourceLocation getTextureLocation(EntityDimi2 p_110775_1_) {
//        return TEXTURE;
//    }
    public RenderDimi2(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelDimi2());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityDimi2 instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/dimi2.png");
    }

    @Override
    public void render(EntityDimi2 animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {
//        if(animatable.isBaby()) {
//            stack.scale(0.4F, 0.4F, 0.4F);
//        } else {
//            stack.scale(0.8F, 0.8F, 0.8F);
//        }
    	stack.scale(2F, 2F, 2F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
   
}
