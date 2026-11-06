package com.joy187.re8joymod.items.itemBook;


import com.joy187.re8joymod.Main;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.ForgeRenderTypes;
import net.minecraftforge.client.model.data.ModelData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BookItemRenderer extends BlockEntityWithoutLevelRenderer
{
    static final ResourceLocation MODEL_HELPER =
    		new ResourceLocation(Main.MOD_ID, "textures/item/storybook.png");
    
    private final List<Direction> sides = Util.make(new ArrayList<>(), c -> {
        Collections.addAll(c, Direction.values());
        c.add(null);
    });

    public BookItemRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_)
    {
        super(p_172550_, p_172551_);
    }

//    @Override
//    public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack matrixStack, MultiBufferSource buffers, int combinedLight, int combinedOverlay)
//    {
//        BakedModel model = Minecraft.getInstance().getModelManager().getModel(MODEL_HELPER);
//        BakedModel bookModel = model.getOverrides().resolve(model, stack, null, null, 0);
//        if (bookModel == null)
//            bookModel = model;
//
//        boolean leftHand = (transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
//                || (transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND);
//
//        matrixStack.pushPose();
//        if (SpecialBakedModel.cameraTransformType != null)
//        {
//            matrixStack.translate(0.5D, 0.5D, 0.5D);
//            bookModel = ForgeHooksClient.handleCameraTransforms(matrixStack, bookModel, SpecialBakedModel.cameraTransformType, leftHand);
//            matrixStack.translate(-0.5D, -0.5D, -0.5D);
//            SpecialBakedModel.cameraTransformType = null;
//        }
//
//        VertexConsumer buffer = buffers.getBuffer(ForgeRenderTypes.ITEM_UNSORTED_TRANSLUCENT.get());
//        Random rnd = new Random();
//        rnd.setSeed(42L);
//        for (Direction side : sides)
//        {
//            rnd.setSeed(42);
////            for (BakedQuad quad : bookModel.getQuads(null, side, rnd, EmptyModelData.INSTANCE))
////            {
////                buffer.putBulkData(matrixStack.last(), quad, 1.0f, 1.0f, 1.0f, combinedLight, combinedOverlay);
////            }
//        }
//
//        matrixStack.popPose();
//    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack matrixStack, MultiBufferSource buffers, int combinedLight, int combinedOverlay) {
        // 获取模型
        BakedModel model = Minecraft.getInstance().getModelManager().getModel(MODEL_HELPER);
        BakedModel bookModel = model.getOverrides().resolve(model, stack, null, null, 0);
        if (bookModel == null) {
            bookModel = model;
        }

        // 判断是否为左手
        boolean leftHand = (transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                || (transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND);

        matrixStack.pushPose();
        if (SpecialBakedModel.cameraTransformType != null) {
            matrixStack.translate(0.5D, 0.5D, 0.5D);
            bookModel = ForgeHooksClient.handleCameraTransforms(matrixStack, bookModel, transformType, leftHand);
            matrixStack.translate(-0.5D, -0.5D, -0.5D);
        }

        // 获取渲染缓冲区
        VertexConsumer buffer = buffers.getBuffer(ForgeRenderTypes.ITEM_UNSORTED_TRANSLUCENT.get());
        RandomSource rnd = RandomSource.create();
        rnd.setSeed(42L);

        // 渲染模型的每个面
        for (Direction side : Direction.values()) {
            rnd.setSeed(42);
            for (BakedQuad quad : bookModel.getQuads(null, side, rnd, ModelData.EMPTY, null)) {
                buffer.putBulkData(matrixStack.last(), quad, 1.0f, 1.0f, 1.0f, combinedLight, combinedOverlay);
            }
        }

        matrixStack.popPose();
    }
}
