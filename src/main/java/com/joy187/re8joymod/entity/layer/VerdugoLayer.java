//package com.joy187.re8joymod.entity.layer;
//
//
//import com.joy187.re8joymod.entity.EntityVerdugo;
//import com.joy187.re8joymod.entity.model.ModelVerdugo;
//import com.joy187.re8joymod.entity.render.RenderVerdugo;
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.client.renderer.entity.RenderLayerParent;
//import net.minecraft.client.renderer.entity.layers.RenderLayer;
//import net.minecraft.client.renderer.texture.OverlayTexture;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//
//import com.joy187.re8joymod.Main;
//import net.minecraft.world.entity.Entity;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
//import software.bernie.geckolib.renderer.GeoRenderer;
//
//@OnlyIn(value=Dist.CLIENT)
//public class VerdugoLayer extends GeoRenderLayer {
//    public VerdugoLayer(GeoRenderer<?> entityRendererIn) {
//        super(entityRendererIn);
//    }
//
//    // A resource location for the texture of the layer. This will be applied onto pre-existing cubes on the model
//    private static final ResourceLocation REG_LAYER_TEXTURES = new ResourceLocation(Main.MOD_ID, "textures/entity/reeye.png");
//    // A resource location for the model of the entity. This model is put on top of the normal one, which is then given the texture
//    private static final ResourceLocation REG_MODEL = new ResourceLocation(Main.MOD_ID, "geo/verdugo.geo.json");
//
////    @Override
////    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Entity entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
////        RenderType cameo =  RenderType.eyes(REG_LAYER_TEXTURES);
////        matrixStackIn.pushPose();
////        //Move or scale the model as you see fit
////        matrixStackIn.scale(1.0f, 1.0f, 1.0f);
////        matrixStackIn.translate(0.0d, 0.0d, 0.0d); //.getEntityModel().getModel(REG_MODEL)
//////        this.getRenderer().reRender(this.getGeoModel().getBakedModel(REG_MODEL),matrixStackIn,bufferIn, entityLivingBaseIn, partialTicks, cameo, matrixStackIn, bufferIn,
//////                bufferIn.getBuffer(cameo), packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f);
////        matrixStackIn.popPose();
////    }
//
//}
