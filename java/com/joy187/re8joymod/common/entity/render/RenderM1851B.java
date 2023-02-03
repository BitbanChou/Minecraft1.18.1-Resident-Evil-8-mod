package com.joy187.re8joymod.common.entity.render;

import com.joy187.re8joymod.Utils;
import com.joy187.re8joymod.common.entity.EntityM1851B;
import com.joy187.re8joymod.common.entity.model.ModelGM79B;
import com.joy187.re8joymod.common.init.ModItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ModelManager;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.ModelTransformComposition;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class RenderM1851B extends EntityRenderer<EntityM1851B> {


    public static final ResourceLocation TEXTURE = new ResourceLocation(Utils.MOD_ID ,"textures/entity/m1851.png");
    private static final RenderType field_229044_e_ = RenderType.entityCutoutNoCull(TEXTURE);

    public RenderM1851B(EntityRendererManager manager) {
        super(manager);
    }

    protected int getSkyLightLevel(EntityM1851B p_239381_1_, BlockPos p_239381_2_) {
        return 15;
    }


    public void render(EntityM1851B entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.pushPose();
        matrixStackIn.scale(2.0F, 2.0F, 2.0F);
//        matrixStackIn. .rotate(this.renderManager.getCameraOrientation());
//        matrixStackIn.(Vector3f.YP.rotationDegrees(180.0F));
        matrixStackIn.mulPose(this.entityRenderDispatcher.cameraOrientation());
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.F));
        MatrixStack.Entry matrixstack$entry = matrixStackIn.last();
        Matrix4f matrix4f = matrixstack$entry.pose();
        Matrix3f matrix3f = matrixstack$entry.normal();
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(field_229044_e_);
        func_229045_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 0.0F, 0, 0, 1);
        func_229045_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 1.0F, 0, 1, 1);
        func_229045_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 1.0F, 1, 1, 0);
        func_229045_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 0.0F, 1, 0, 0);

//        Minecraft.getInstance().getItemRenderer().render(
//                itemstack,
//                itemModelShaper.getModelManager().getModel(new ModelResourceLocation(Utils.MOD_ID ,"textures/entity/m1851.png")),
//                packedLightIn,
//                OverlayTexture.NO_OVERLAY,
//                matrixStackIn,
//                bufferIn
//        );


        matrixStackIn.popPose();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityM1851B  p_110775_1_) {
        return TEXTURE;
    }

    private static void func_229045_a_(IVertexBuilder p_229045_0_, Matrix4f p_229045_1_, Matrix3f p_229045_2_, int p_229045_3_, float p_229045_4_, int p_229045_5_, int p_229045_6_, int p_229045_7_) {
        p_229045_0_.vertex(p_229045_1_, p_229045_4_ - 0.5F, (float)p_229045_5_ - 0.25F, 0.0F).color(255, 255, 255, 255).overlayCoords(OverlayTexture.NO_OVERLAY).normal(p_229045_2_, 0.0F, 1.0F, 0.0F).endVertex();
    }



    public static class RenderFactory implements IRenderFactory<EntityM1851B> {

        @Override
        public EntityRenderer<? super EntityM1851B> createRenderFor(EntityRendererManager manager) {
            manager.setRenderShadow(false);
            return new RenderM1851B(manager);
        }
    }

}