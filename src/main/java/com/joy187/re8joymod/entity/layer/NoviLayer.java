//package com.joy187.re8joymod.entity.layer;
//
//
//import com.joy187.re8joymod.Main;
//import com.joy187.re8joymod.entity.EntityNovi;
//import com.joy187.re8joymod.entity.render.RenderNovi;
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.client.renderer.texture.OverlayTexture;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.Entity;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import software.bernie.geckolib.cache.object.BakedGeoModel;
//import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
//import software.bernie.geckolib.renderer.GeoRenderer;
//
//@OnlyIn(value= Dist.CLIENT)
//public class NoviLayer extends GeoRenderLayer<EntityNovi> {
//    //    private static final ResourceLocation REG_LAYER_TEXTURES = new ResourceLocation("cataclysm:textures/entity/ender_golem_layer.png");
////
////    public NoviLayer(RenderNovi renderIn) {
////        super(renderIn);
////    }
////
////    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntityNovi entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
////        if (entity.deathTime <= 30) {
////            float f = 1.0f - entity.deathTime / 30.0f;
////            RenderType eyes = RenderType.eyes(REG_LAYER_TEXTURES);
////            VertexConsumer VertexConsumer2 = bufferIn.getBuffer(eyes);
////            ((ModelNovi)this.getParentModel()).renderToBuffer(matrixStackIn, VertexConsumer2, packedLightIn, OverlayTexture.NO_OVERLAY, f, f, f, f);
////        }
////    }
//    public NoviLayer(GeoRenderer<EntityNovi> entityRendererIn) {
//        super(entityRendererIn);
//    }
//
//    // A resource location for the texture of the layer. This will be applied onto pre-existing cubes on the model
//    private static final ResourceLocation NOVI_LAYER_TEXTURES = new ResourceLocation(Main.MOD_ID, "textures/entity/novi.png");
//    // A resource location for the model of the entity. This model is put on top of the normal one, which is then given the texture
//    private static final ResourceLocation REG_MODEL = new ResourceLocation(Main.MOD_ID, "geo/novi.geo.json");
//
//    @Override
//    public void render(PoseStack matrixStackIn, EntityNovi animatable, BakedGeoModel bakedModel, RenderType renderType,
//                       MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick,
//                       int packedLight, int packedOverlay) {
//        RenderType cameo =  RenderType.eyes(NOVI_LAYER_TEXTURES);
//        matrixStackIn.pushPose();
//        //Move or scale the model as you see fit
//        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
//        matrixStackIn.translate(0.0d, 0.0d, 0.0d);
//        //float[] RGB = entityLivingBaseIn.getSkinRGB();
//        int blockColor = animatable.changeColor(animatable);
//        float f = (float)(blockColor >> 16 & 255) / 255.0F;
//        float f1 = (float)(blockColor >> 8 & 255) / 255.0F;
//        float f2 = (float)(blockColor & 255) / 255.0F;
//        //System.out.println("R："+f+"G："+f1+"B："+f2);
////        this.getRenderer().reRender(getDefaultBakedModel(REG_MODEL), entityLivingBaseIn, partialTicks, cameo, matrixStackIn, bufferIn,
////                bufferIn.getBuffer(cameo), packedLightIn, OverlayTexture.NO_OVERLAY,f,
////                f1, f2, 1f);
//        render(matrixStackIn, animatable, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
//        matrixStackIn.popPose();
//    }
//
////        @Override
////    public void render(EntityNovi entity, double x, double y, double z, float entityYaw, PoseStack poseStackIn, MultiBufferSource bufferIn float partialTicks)
////    {
////
////        float[] RGB = entity.getSkinRGB();
////
////        poseStackIn.pushPose();
////        bufferIn.color(RGB[0]/255.0F, RGB[1]/255.0F, RGB[2]/255.0F, 1.0F);
////        poseStackIn.popPose();
////
////        super.render(entity, x, y, z, entityYaw, partialTicks);
////
////    }
//
//}
//
