package com.joy187.re8joymod.common.items.ItemSniper;

import com.joy187.re8joymod.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class SimpleScope implements Scope {

    private final float zoomMultiplier;
    private final ResourceLocation overlayTexture;
    private final int overlayTextureWidth;
    private final int overlayTextureHeight;
    private final ItemStack itemStack;
    private static final ResourceLocation TEXTURE=
            new ResourceLocation(Utils.MOD_ID, "textures/gui/zoom.png");

    public SimpleScope(ItemStack itemStack) {
        this(1.0F, null, 648, 256, itemStack);
    }

    public SimpleScope(float zoomMultiplier, ResourceLocation overlayTexture,
                       int overlayTextureWidth, int overlayTextureHeight, ItemStack itemStack) {
        this.zoomMultiplier = zoomMultiplier;
        this.overlayTexture = TEXTURE;
        this.overlayTextureWidth = overlayTextureWidth;
        this.overlayTextureHeight = overlayTextureHeight;
        this.itemStack = itemStack;
    }

    @Override
    public boolean isAiming(Entity entity) {
        return entity instanceof LivingEntity
                ? ((LivingEntity) entity).getUseItem() == this.itemStack
                : false;
    }

    @Override
    public float getZoomMultiplier(Entity entit) {
        return this.zoomMultiplier;
    }

    @Override
    public ResourceLocation getOverlayTexture(Entity entity) {
        return this.overlayTexture;
    }

    @Override
    public int getOverlayTextureWidth() {
        return this.overlayTextureWidth;
    }

    @Override
    public int getOverlayTextureHeight() {
        return this.overlayTextureHeight;
    }


//    public static void renderScopeOverlay(PlayerEntity playerEntity,
//                                          int width,
//                                          int height) {
////        scope.getOverlayTexture(playerEntity)
////                .ifPresent(overlayTexture -> {
//                    bind(TEXTURE);
//                    double overlayTextureWidth = 2048;
//                    double overlayTextureHeight = 512;
//                    double scale = getFitScale(overlayTextureWidth, overlayTextureHeight);
//                    overlayTextureWidth *= scale;
//                    overlayTextureHeight *= scale;
//                    //RenderSystem.enableBlend();
////                    blit(width / 2 - overlayTextureWidth / 2,
////                                    height / 2 - overlayTextureHeight / 2, overlayTextureWidth,
////                                    overlayTextureHeight);
//                    //RenderSystem.disableBlend();
////                });
//
//    }
//
//    public static void bind(ResourceLocation resourceLocation) {
//        Minecraft.getInstance().getTextureManager().bind(resourceLocation);
//    }
//
//    public static double getFitScale(final double imageWidth, final double imageHeight) {
//        double widthScale = Minecraft.getInstance().getWindow().getScreenWidth() / imageWidth;
//        double heightScale = Minecraft.getInstance().getWindow().getScreenHeight() / imageHeight;
//        final double scale =
//                imageHeight * widthScale < Minecraft.getInstance().getWindow().getScreenHeight() ? heightScale
//                        : widthScale;
//        return scale / Minecraft.getInstance().getWindow().getGuiScale();
//    }
//
//    public static void blit(double x, double y, double width, double height) {
//        blit(x, y, x + width, y + height, 0.0F, 1.0F, 1.0F, 0.0F);
//    }
//
//    public static void blit(double x, double y, double x2, double y2, float u,
//                            float v, float u2, float v2) {
//        Tessellator tessellator = Tessellator.getInstance();
//        BufferBuilder bufferbuilder = tessellator.getBuilder();
//        bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
//        bufferbuilder.vertex(x, y2, 0.0D).uv(u, v).endVertex();
//        bufferbuilder.vertex(x2, y2, 0.0D).uv(u2, v).endVertex();
//        bufferbuilder.vertex(x2, y, 0.0D).uv(u2, v2).endVertex();
//        bufferbuilder.vertex(x, y, 0.0D).uv(u, v2).endVertex();
//        tessellator.end();
//    }

}
