///*
// * Decompiled with CFR 0.150.
// *
// * Could not load the following classes:
// *  com.mojang.blaze3d.vertex.PoseStack
// *  com.mojang.blaze3d.vertex.VertexConsumer
// *  net.minecraft.client.renderer.MultiBufferSource
// *  net.minecraft.client.renderer.RenderType
// *  net.minecraft.client.renderer.entity.RenderLayerParent
// *  net.minecraft.client.renderer.entity.layers.RenderLayer
// *  net.minecraft.client.renderer.texture.OverlayTexture
// *  net.minecraft.resources.ResourceLocation
// *  net.minecraftforge.api.distmarker.Dist
// *  net.minecraftforge.api.distmarker.OnlyIn
// */
//package com.joy187.re8joymod.entity.layer;
//
//import com.joy187.re8joymod.Main;
//import com.mojang.blaze3d.vertex.PoseStack;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.client.renderer.texture.OverlayTexture;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.Entity;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
//import software.bernie.geckolib.renderer.GeoRenderer;
//
//@OnlyIn(value=Dist.CLIENT)
//public class EvilPlagasDogLayer extends GeoRenderLayer {
//
//    public EvilPlagasDogLayer(GeoRenderer<?> entityRendererIn) {
//        super(entityRendererIn);
//    }
//
//    // A resource location for the texture of the layer. This will be applied onto pre-existing cubes on the model
//    private static final ResourceLocation REG_LAYER_TEXTURES = new ResourceLocation(Main.MOD_ID, "textures/entity/reeye.png");
//    // A resource location for the model of the entity. This model is put on top of the normal one, which is then given the texture
//    private static final ResourceLocation REG_MODEL = new ResourceLocation(Main.MOD_ID, "geo/plagasdog.geo.json");
//
////    @Override
////    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Entity entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
////        RenderType cameo =  RenderType.eyes(REG_LAYER_TEXTURES);
////        matrixStackIn.pushPose();
////        //Move or scale the model as you see fit
////        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
////        matrixStackIn.translate(0.0d, 0.0d, 0.0d);
////        this.getRenderer().render(this.getEntityModel().getModel(REG_MODEL), entityLivingBaseIn, partialTicks, cameo, matrixStackIn, bufferIn,
////                bufferIn.getBuffer(cameo), packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
////        matrixStackIn.popPose();
////    }
//
//}
//
