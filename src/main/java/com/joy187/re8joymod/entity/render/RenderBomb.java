package com.joy187.re8joymod.entity.render;


import com.joy187.re8joymod.Main;
import com.joy187.re8joymod.entity.Bomb;
import com.joy187.re8joymod.entity.EntityJJ;
import com.joy187.re8joymod.entity.model.ModelBomb;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class RenderBomb extends GeoEntityRenderer<Bomb> {

    public RenderBomb(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelBomb());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(Bomb instance) {
        //return LOCATION_BY_VARIANT.get(instance.getVariant());
        return new ResourceLocation(Main.MOD_ID, "textures/entity/klee.png");
    }

    @Override
    public void render(Bomb animatable, float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int packedLight) {

        stack.scale(0.8F, 0.8F, 0.8F);

        this.animatable = animatable;
        defaultRender(stack, animatable, bufferSource, null, null, entityYaw, partialTick, packedLight);
    }

}
