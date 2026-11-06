package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityPlagasDog;
import com.joy187.re8joymod.entity.model.ModelPlagasDog;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderPlagasDog extends GeoEntityRenderer<EntityPlagasDog>{

    public RenderPlagasDog(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelPlagasDog());
        this.shadowRadius = 0.4f;
        //addLayer(new EvilPlagasDogLayer(this));
    }
    
    @Override
    public ResourceLocation getTextureLocation(EntityPlagasDog instance) {
    	return new ResourceLocation(Main.MOD_ID, "textures/entity/evildog.png");
    }

    @Override
    public void render(EntityPlagasDog animatable,float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

    	stack.scale(1F, 1F, 1F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}