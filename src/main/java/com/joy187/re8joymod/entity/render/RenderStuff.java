package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.entity.EntityStuff;
import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.model.ModelStuff;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderStuff extends GeoEntityRenderer<EntityStuff>{

    public RenderStuff(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelStuff());
        this.shadowRadius = 0.5f;
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityStuff instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/stuff.png");
    }

    @Override
    public void render(EntityStuff animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}