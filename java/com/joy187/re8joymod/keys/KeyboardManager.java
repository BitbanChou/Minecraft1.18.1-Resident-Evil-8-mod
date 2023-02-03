//package com.joy187.re8joymod.common.keys;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.settings.KeyBinding;
//import net.minecraft.client.util.InputMappings;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.client.event.InputEvent;
//import net.minecraftforge.client.settings.KeyConflictContext;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.client.registry.ClientRegistry;
//import net.minecraftforge.fml.common.Mod;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Mod.EventBusSubscriber
//public class KeyboardManager {
//
//    public static final List<KeyBinding> KEY_BINDINGS = new ArrayList<KeyBinding>();
//    private static boolean  doZoom = false;
//
//    //键位描述                           不改                         不改                        具体键位          属于哪个模组的按键效果
//    //public static final KeyBinding EFFECTME = new ModKeyBinding("activate_skill_portal", KeyConflictContext.IN_GAME, InputMappings.Type.KEYSYM, 82, "key.category.re8joymod");
//    public static final KeyBinding ON = new ModKeyBinding("activate_skill_portal", KeyConflictContext.IN_GAME, InputMappings.Type.KEYSYM, 82, "key.category.re8joymod");
//    public static final KeyBinding OFF = new ModKeyBinding("activate_skill_portal1", KeyConflictContext.IN_GAME, InputMappings.Type.KEYSYM, 67, "key.category.re8joymod");
//
//    public static void init() {
//        for (KeyBinding key:
//                KEY_BINDINGS) {
//            ClientRegistry.registerKeyBinding(key);
//        }
//    }
//
//
//    @OnlyIn(Dist.CLIENT)
//    @SubscribeEvent
//    public static void onKeyPressed(InputEvent.KeyInputEvent event) {
//        if(ON.isDown())
//        {
//            System.out.println("放大！");
//            doZoom=true;
//            Minecraft.getInstance().options.fov=100;
//            Minecraft.getInstance().options.smoothCamera = true;
//        }
//
//        if(OFF.isDown())
//        {
//            doZoom=false;
//            Minecraft.getInstance().options.fov=70;
//            Minecraft.getInstance().options.smoothCamera = false;
//        }
//    }
//
//}
