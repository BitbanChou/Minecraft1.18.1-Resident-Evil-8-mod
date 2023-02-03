//package com.joy187.re8joymod.common.mixin;
//
//import net.minecraft.client.gui.screen.MainMenuScreen;
//import net.minecraft.client.gui.screen.Screen;
//import net.minecraft.client.gui.widget.button.Button;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.TranslationTextComponent;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(MainMenuScreen.class)
//public class ScreenMixin extends Screen {
//
//    protected ScreenMixin(ITextComponent p_i51108_1_) {
//        super(p_i51108_1_);
//    }
//
//    @Inject(at=@At(value = "HEAD"),method = "Lnet/minecraft/client/gui/screen/MainMenuScreen;init()V",cancellable = true)
//    private void init(CallbackInfo ci)
//    {
//        this.addButton(new Button(20,20, 98, 20, new TranslationTextComponent("menu.quit"), (p_213094_1_) -> {
//            System.out.println("CCC!");
//        }));
//    }
//
//}
//
//
////        "InGameHudMixin",
////                "ScreenMixin",
////                "GameRendererMixin",
////                "PlayerRendererMixin",
////                "InGameHudMixin",
////                "ScreenMixin"