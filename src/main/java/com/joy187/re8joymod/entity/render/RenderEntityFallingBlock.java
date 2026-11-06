package com.joy187.re8joymod.entity.render;

import com.joy187.re8joymod.entity.DetonatorEntity;
import com.joy187.re8joymod.entity.EntityFallingBlock;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.ModelData;

@OnlyIn(value=Dist.CLIENT)
public class RenderEntityFallingBlock extends EntityRenderer<EntityFallingBlock> {
    private final BlockRenderDispatcher dispatcher;

    public RenderEntityFallingBlock(EntityRendererProvider.Context p_174112_) {
        super(p_174112_);
        this.dispatcher = p_174112_.getBlockRenderDispatcher();
    }

    public void render(EntityFallingBlock p_114634_, float p_114635_, float p_114636_, PoseStack p_114637_, MultiBufferSource p_114638_, int p_114639_) {
        Level level=p_114634_.level();
        BlockState blockstate = p_114634_.getBlockState();
        if (blockstate.getRenderShape() == RenderShape.MODEL && blockstate != (level = p_114634_.level()).getBlockState(p_114634_.blockPosition()) && blockstate.getRenderShape() != RenderShape.INVISIBLE) {
            p_114637_.pushPose();
            BlockPos blockpos = new BlockPos(Mth.floor(p_114634_.getX()), Mth.floor(p_114634_.getBoundingBox().maxY), Mth.floor(p_114634_.getZ()));
            p_114637_.translate(-0.5, 0.0, -0.5);
            BakedModel model = this.dispatcher.getBlockModel(blockstate);
            for (RenderType renderType : model.getRenderTypes(blockstate, RandomSource.create((long)blockstate.getSeed(p_114634_.getStartPos())), ModelData.EMPTY)) {
                this.dispatcher.getModelRenderer().tesselateBlock(level, model, blockstate, blockpos, p_114637_, p_114638_.getBuffer(renderType), false, RandomSource.create(), blockstate.getSeed(p_114634_.getStartPos()), OverlayTexture.NO_OVERLAY, ModelData.EMPTY, renderType);
            }
            p_114637_.popPose();
            super.render(p_114634_, p_114635_, p_114636_, p_114637_, p_114638_, p_114639_);
        }
    }

    public boolean shouldRender(EntityFallingBlock p_114491_, Frustum p_114492_, double p_114493_, double p_114494_, double p_114495_) {
        if (!p_114491_.shouldRender(p_114493_, p_114494_, p_114495_)) {
            return false;
        } else if (p_114491_.noCulling) {
            return true;
        } else {
            AABB aabb = p_114491_.getBoundingBoxForCulling().inflate(0.5D);
            if (aabb.hasNaN() || aabb.getSize() == 0.0D) {
                aabb = new AABB(p_114491_.getX() - 2.0D, p_114491_.getY() - 2.0D, p_114491_.getZ() - 2.0D, p_114491_.getX() + 2.0D, p_114491_.getY() + 2.0D, p_114491_.getZ() + 2.0D);
            }

            return p_114492_.isVisible(aabb);
        }
    }

    public ResourceLocation getTextureLocation(EntityFallingBlock p_114632_) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}


