package com.joy187.re8joymod.entity.render;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.EntityJJ;
import com.joy187.re8joymod.entity.Klee;
import com.joy187.re8joymod.entity.model.ModelKlee;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderKlee extends GeoEntityRenderer<Klee> {

    public RenderKlee(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelKlee());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(Klee instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/klee.png");
    }

    @Override
    public void render(Klee animatable, float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

        stack.scale(0.7F, 0.7F, 0.7F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }
}
