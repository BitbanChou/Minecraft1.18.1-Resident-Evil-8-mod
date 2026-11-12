package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityGarrador;
import com.joy187.re8joymod.entity.model.ModelGarrador;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderGarrador extends GeoEntityRenderer<EntityGarrador>{
	
    public RenderGarrador(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelGarrador());
        this.shadowRadius = 0.7f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityGarrador instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/garrador.png");
    }

    @Override
    public void render(EntityGarrador animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1.2F, 1.2F, 1.2F);
        boolean showPlaga = animatable.isPlagaIntact();
        for (String boneName : new String[]{"parasite", "plaga_tail", "plaga_tenta", "plaga_tenta2", "plaga_tenta3"}) {
            this.getGeoModel().getBone(boneName).ifPresent(bone -> bone.setHidden(!showPlaga));
        }

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}
