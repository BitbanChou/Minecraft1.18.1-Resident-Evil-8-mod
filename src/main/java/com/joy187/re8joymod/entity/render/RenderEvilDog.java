package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityEvilDog;
import com.joy187.re8joymod.entity.model.ModelEvilDog;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderEvilDog extends GeoEntityRenderer<EntityEvilDog>{
	
    public RenderEvilDog(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelEvilDog());
        this.shadowRadius = 0.4f;
        //addLayer(new EvilDaogLayer(this));
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityEvilDog instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/evildog.png");
    }

    @Override
    public void render(EntityEvilDog animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}