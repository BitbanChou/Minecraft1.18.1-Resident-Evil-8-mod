package com.joy187.re8joymod.entity.render;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityJJ;
import com.joy187.re8joymod.entity.JumpBomb;
import com.joy187.re8joymod.entity.model.ModelJumpBomb;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderJumpBomb extends GeoEntityRenderer<JumpBomb> {

    public RenderJumpBomb(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelJumpBomb());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(JumpBomb instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/klee.png");
    }

    @Override
    public void render(JumpBomb animatable, float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

        stack.scale(1.5F, 1.5F, 1.5F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}
