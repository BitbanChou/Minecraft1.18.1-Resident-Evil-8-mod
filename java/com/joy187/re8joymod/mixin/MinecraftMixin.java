//package com.joy187.re8joymod.common.mixin;
//
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//import net.minecraft.client.Minecraft;
//import net.minecraft.util.SharedConstants;
//
//@Mixin(Minecraft.class)
//public abstract class MinecraftMixin {
//
//    /**
//     * Modifys window title.
//     */
//    @Inject(method = "createTitle", at = @At("HEAD"), cancellable = true)
//    private void createTitle(CallbackInfoReturnable<String> callbackInfo) {
//        callbackInfo.setReturnValue(
//                "Minecraft " + SharedConstants.getCurrentVersion().getName() + " - Crafting Dead");
//    }
//
//    /**
//     * Increases GUI frame rate for a smoother experience.
//     */
//    @Inject(method = "getFramerateLimit", at = @At("HEAD"), cancellable = true)
//    private void getFramerateLimit(CallbackInfoReturnable<Integer> callbackInfo) {
//        callbackInfo.setReturnValue(Minecraft.getInstance().getWindow().getFramerateLimit());
//    }
//}