package com.joy187.re8joymod.common.items.ItemSniper;

public class RenderUtil {
//
//    private static final Minecraft minecraft = Minecraft.getInstance();
//
//
//    public static void bind(ResourceLocation resourceLocation) {
//        minecraft.getTextureManager().bind(resourceLocation);
//    }
//
//    public static void blit(double x, double y, float width, float height,
//                            float textureX, float textureY) {
//        blit(x, y, x + width, y + height, textureX, textureY, textureX + width,
//                textureY + height, 256, 256);
//    }
//
//    public static void blit(double x, double y, double x2, double y2, float textureX,
//                            float textureY, float textureX2, float textureY2, float width, float height) {
//        float u = textureX / width;
//        float u2 = textureX2 / width;
//        float v = textureY / height;
//        float v2 = textureY2 / height;
//        blit(x, y, x2, y2, u, v, u2, v2);
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
//
//    public static double getFitScale(final double imageWidth, final double imageHeight) {
//        double widthScale = minecraft.getWindow().getScreenWidth() / imageWidth;
//        double heightScale = minecraft.getWindow().getScreenHeight() / imageHeight;
//        final double scale =
//                imageHeight * widthScale < minecraft.getWindow().getScreenHeight() ? heightScale
//                        : widthScale;
//        return scale / minecraft.getWindow().getGuiScale();
//    }
//
////    /**
////     * @see com.joy187.re8joymod.common.mixin.PlayerRendererMixin
////     */
//    public static void renderArmWithClothing(PlayerRenderer renderer, MatrixStack matrixStack,
//                                             IRenderTypeBuffer renderTypeBuffer,
//                                             int packedLight, AbstractClientPlayerEntity playerEntity, ModelRenderer armRenderer,
//                                             ModelRenderer armwearRenderer) {
//
////        ResourceLocation clothingTexture = playerEntity.getCapability(Capabilities.LIVING_EXTENSION)
////                .map(LivingExtension::getItemHandler)
////                .map(itemHandler -> itemHandler.getStackInSlot(ModEquipmentSlotType.CLOTHING.getIndex()))
////                .flatMap(clothingStack -> clothingStack.getCapability(Capabilities.CLOTHING).resolve())
////                .map(clothing -> clothing.getTexture(playerEntity.getModelName()))
////                .orElse(null);
//        ResourceLocation clothingTexture=new ResourceLocation(Utils.MOD_ID, "textures/entity/ethan.png");
//        RenderArmClothingEvent event = new RenderArmClothingEvent(playerEntity, clothingTexture);
//        MinecraftForge.EVENT_BUS.post(event);
//        //clothingTexture = event.getClothingTexture();
//
////        if (clothingTexture != null) {
//            PlayerModel<AbstractClientPlayerEntity> playerModel = renderer.getModel();
//            playerModel.attackTime = 0.0F;
//            playerModel.crouching = false;
//            playerModel.swimAmount = 0.0F;
//            playerModel.setupAnim(playerEntity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
//
//            armRenderer.visible = true;
//            armwearRenderer.visible = true;
//
//            armRenderer.xRot = 0.0F;
//            armRenderer.render(matrixStack,
//                    renderTypeBuffer.getBuffer(RenderType.entityTranslucent(clothingTexture)), packedLight,
//                    OverlayTexture.NO_OVERLAY);
//            armwearRenderer.xRot = 0.0F;
//            armwearRenderer.render(matrixStack,
//                    renderTypeBuffer.getBuffer(RenderType.entityTranslucent(clothingTexture)), packedLight,
//                    OverlayTexture.NO_OVERLAY);
//        }
////    }
}
