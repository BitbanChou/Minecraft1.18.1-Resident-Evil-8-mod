package com.joy187.re8joymod.common.keys;

//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.settings.KeyBinding;
//import net.minecraft.client.util.InputMappings;
//import net.minecraftforge.client.settings.KeyConflictContext;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//
//
//public class KeyInputHandler {
//    boolean previousDoZoom = false;
//    public static final KeyBinding ON = new ModKeyBinding("activate_skill_portal", KeyConflictContext.IN_GAME, InputMappings.Type.KEYSYM, 82, "key.category.re8joymod");
//    public static final KeyBinding OFF = new ModKeyBinding("activate_skill_portal1", KeyConflictContext.IN_GAME, InputMappings.Type.KEYSYM, 67, "key.category.re8joymod");
//
//    @SubscribeEvent
//    public void onPreRender(TickEvent.RenderTickEvent event) {
//
//        boolean doZoom = false;
//
//        if(ON.isDown())
//        {
//            doZoom=true;
//        }
//
//        if(OFF.isDown())
//        {
//            doZoom=false;
//        }
//
//        if (Minecraft.getInstance().getCameraEntity() != null)
//            doZoom = false;
//
//        if (doZoom && !previousDoZoom) {
//            //ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, Minecraft.getInstance().gameRenderer, 2, "cameraZoom", "field_78503_V");
//            Minecraft.getInstance().options.fov=100;
//            Minecraft.getInstance().options.smoothCamera = true;
//        } else if (!doZoom && previousDoZoom) {
//            //ObfuscationReflectionHelper.setPrivateValue(EntityRenderer.class, Minecraft.getInstance().gameRenderer, 1.0d, "cameraZoom");
//            Minecraft.getInstance().options.fov=70;
//            Minecraft.getInstance().options.smoothCamera = false;
//        }
//
//        previousDoZoom = doZoom;
//    }
//}
