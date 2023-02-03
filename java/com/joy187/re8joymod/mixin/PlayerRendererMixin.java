//package com.joy187.re8joymod.common.mixin;
//
//import com.joy187.re8joymod.common.items.ItemSniper.RenderUtil;
//import com.mojang.blaze3d.matrix.MatrixStack;
//import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
//import net.minecraft.client.renderer.IRenderTypeBuffer;
//import net.minecraft.client.renderer.entity.PlayerRenderer;
//import net.minecraft.client.renderer.model.ModelRenderer;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(PlayerRenderer.class)
//public abstract class PlayerRendererMixin {
//
//    /**
//     * Renders first person arm with custom clothing.
//     */
//    @Inject(at = @At("RETURN"), method = "renderHand")
//    private void renderHand(MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer,
//                            int packedLight, AbstractClientPlayerEntity playerEntity, ModelRenderer armRenderer,
//                            ModelRenderer armwearRenderer,
//                            CallbackInfo callbackInfo) {
//        final PlayerRenderer playerRenderer = (PlayerRenderer) (Object) this;
//        RenderUtil.renderArmWithClothing(playerRenderer, matrixStack, renderTypeBuffer, packedLight,
//                playerEntity, armRenderer, armwearRenderer);
//    }
//
//}
//
