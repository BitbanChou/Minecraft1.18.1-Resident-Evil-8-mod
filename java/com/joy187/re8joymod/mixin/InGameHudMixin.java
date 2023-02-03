//package com.joy187.re8joymod.common.mixin;
//
//
//import com.joy187.re8joymod.common.init.ModItems;
//import com.mojang.blaze3d.matrix.MatrixStack;
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.IngameGui;
//import net.minecraft.client.renderer.BufferBuilder;
//import net.minecraft.client.renderer.Tessellator;
//import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ResourceLocation;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(IngameGui.class)
//public class InGameHudMixin {
//
//    @Shadow private int screenWidth;
//    @Shadow private int screenHeight;
//
//
//    private Minecraft minecraft;
//    private MatrixStack stack;
//    private PlayerEntity playerEntity;
//
//    boolean showArrowCount = true;
//    boolean showProgressBar = true;
//
//    int countStartX;
//    int countStartY;
//    int progStartW;
//    int progEndW;
//    int progStartH;
//    int progEndH;
//    int backgroundColor;
//
//    @Inject(at = @At("HEAD"), method = "render(Lcom/mojang/blaze3d/matrix/MatrixStack;F)V")
//    public void render(MatrixStack matrixStack, float tickDelta, CallbackInfo info) {
//        System.out.println("zhixingle!!!");
//        this.minecraft = Minecraft.getInstance();
//        this.stack = matrixStack;
//        //playerEntity = this.getCameraPlayer();
//
//        countStartX = (this.screenWidth / 2) + 2;
//        countStartY = (this.screenHeight / 2);
//
//        progStartW = countStartX - 12;
//        progStartH = countStartY + 10;
//        progEndW = progStartW + 18;
//        progEndH = progStartH + 1;
//
//        backgroundColor = 0xFF000000;
//
//        ItemStack itemstack = this.minecraft.player.getMainHandItem();
//        if (this.minecraft.options.getCameraType().isFirstPerson() && itemstack.getItem() == ModItems.F2RIFLE.get()) {
//            renderSniper();
//        }
//        if (itemstack.getItem() == ModItems.M1851.get()) {
//            System.out.println("YES!!!");
//        }
//        //if(showArrowCount) arrowCount();
//        //if(showProgressBar) progressBar();
//    }
//
//        private static final ResourceLocation ZOOM_OVERLAY =
//            new ResourceLocation("textures/misc/pumpkinblur.png");
//
//    protected void renderSniper() {
//        //System.out.println("zhixingle!!!");
//
//        RenderSystem.disableDepthTest();
//        RenderSystem.depthMask(false);
//        RenderSystem.defaultBlendFunc();
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.disableAlphaTest();
//        this.minecraft.getTextureManager().bind(ZOOM_OVERLAY);
//        Tessellator tessellator = Tessellator.getInstance();
//        BufferBuilder bufferbuilder = tessellator.getBuilder();
//        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
//        bufferbuilder.vertex(0.0D, (double)this.screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
//        bufferbuilder.vertex((double)this.screenWidth, (double)this.screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
//        bufferbuilder.vertex((double)this.screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
//        bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
//        tessellator.end();
//        RenderSystem.depthMask(true);
//        RenderSystem.enableDepthTest();
//        RenderSystem.enableAlphaTest();
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//    }
//
////    private static final ResourceLocation ZOOM_OVERLAY =
////            new ResourceLocation(Utils.MOD_ID, "textures/gui/zoom.png");
////    @Unique
////    public void renderZoomOverlay(float f) {
////        RenderSystem.disableAlphaTest();
////        RenderSystem.disableDepthTest();
////        RenderSystem.depthMask(false);
////        RenderSystem.defaultBlendFunc();
////        RenderSystem.color4f(1.0F, 1.0F, 1.0F, f);
////        this.client.getTextureManager().bind(ZOOM_OVERLAY);
////        Tessellator tessellator = Tessellator.getInstance();
////        BufferBuilder bufferBuilder = tessellator.getBuilder();
////        bufferBuilder.begin(7,  DefaultVertexFormats.POSITION_TEX);
////        bufferBuilder.vertex(0.0D, (double)this.client.getWindow().getGuiScaledHeight(), -90.0D).uv(0.0F, 1.0F).endVertex();
////        bufferBuilder.vertex((double)this.client.getWindow().getGuiScaledWidth(), this.client.getWindow().getGuiScaledHeight(), -90.0D).uv(1.0F, 1.0F).endVertex();
////        bufferBuilder.vertex((double)this.client.getWindow().getGuiScaledWidth(), 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
////        bufferBuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
////        tessellator.end();
////        RenderSystem.depthMask(true);
////        RenderSystem.enableDepthTest();
////        RenderSystem.enableAlphaTest();
////        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
////    }
//
//
////    private void arrowCount(){
////        int color = 0xFFFFFFFF;
////        int textX = countStartX;
////        int textY = countStartY;
////
////        client.renderBuffers().bind(stack, Calculations.useSubscript("99"), textX, textY, color);
////
////    }
//
////    private void progressBar(){
////        int xpLevel = playerEntity.experienceLevel;
////        int maxXp = 183;
////        int xp = (int)(playerEntity.experienceProgress * maxXp);
////
////        int xpColor = 0xFF00C853;
////        int relativeEndW = Calculations.relativeW(progStartW, progEndW, xp, maxXp);
////
////        DrawableHelper.fill(stack, progStartW, progStartH, progEndW, progEndH, backgroundColor);
////        DrawableHelper.fill(stack, progStartW, progStartH, relativeEndW, progEndH, xpColor);
////    }
////
////    private int baseRelativeEndW(int value, int total){
////        return Calculations.relativeW(progStartW, progEndW, value, total);
////    }
////
////    private int baseRelativeStartW(int value, int total){
////        return Calculations.relativeW(progEndW, progStartW, value, total);
////    }
//}