package com.joy187.re8joymod.packet;

import com.joy187.re8joymod.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessage {

//    public static final String NETWORK_VERSION = "0.1.0";
//    private static int channel_id = 0;
//
//    public static final SimpleChannel SHOOT = NetworkRegistry.newSimpleChannel(
//            new ResourceLocation(Main.MOD_ID, "fire"), () -> NETWORK_VERSION,
//            version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));
//
//    public static void init() {
//        SHOOT.registerMessage(++channel_id, FirePacket.class, FirePacket::writePacketData, FirePacket::decode, FirePacket::handle);
//    }

    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(Main.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "2.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

//        net.messageBuilder(ExampleC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
//                .decoder(ExampleC2SPacket::new)
//                .encoder(ExampleC2SPacket::toBytes)
//                .consumerMainThread(ExampleC2SPacket::handle)
//                .add();

        net.messageBuilder(FirePacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(FirePacket::new)
                .encoder(FirePacket::toBytes)
                .consumerMainThread(FirePacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}

