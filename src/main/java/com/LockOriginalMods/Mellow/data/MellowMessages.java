package com.LockOriginalMods.Mellow.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class MellowMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;



        net.messageBuilder(EnergySync.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(EnergySync::new)
                .encoder(EnergySync::toBytes)
                .consumerMainThread(EnergySync::handle)
                .add();

        net.messageBuilder(CrusherSync.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(CrusherSync::new)
                .encoder(CrusherSync::toBytes)
                .consumerMainThread(CrusherSync::handle)
                .add();

    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <MSG> void sendToClients(MSG message) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), message);
    }
}