package com.joy187.re8joymod;

import com.joy187.re8joymod.init.KeyBindInit;
import com.joy187.re8joymod.packet.FirePacket;
import com.joy187.re8joymod.packet.ModMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class InputEvents {
    @SubscribeEvent
    public static void onKeyPress(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
//        if(KeyBindInit.KEY_FIRE.consumeClick())
//        {
//            mc.player.sendSystemMessage(Component.literal("FFF"));
//        }
        if (KeyBindInit.KEY_FIRE.consumeClick()) {
            //System.out.println("BEE");
            ModMessage.sendToServer(new FirePacket());
        }
        if (mc == null || mc.screen != null || mc.level == null) return;
        //onInput(mc, event.getKey(), event.getAction());
    }

//    private static void onInput(Minecraft mc, int key, int action) {
//        if (KeyBindInit.KEY_FIRE.consumeClick()) {
//            System.out.println("BEE");
//            ModMessage.SHOOT.sendToServer(new FirePacket(key));
//        }
//    }
}