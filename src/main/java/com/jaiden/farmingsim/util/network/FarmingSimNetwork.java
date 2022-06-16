package com.jaiden.farmingsim.util.network;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.util.network.messages.KeyInputMessage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class FarmingSimNetwork {

    public static final String NETWORK_VERSION = "0.1.0";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(
            FarmingSim.MODID, "network"),
            () -> NETWORK_VERSION,
            version -> version.equals(NETWORK_VERSION),
            version -> version.equals(NETWORK_VERSION)
    );

    public static void init() {
        CHANNEL.registerMessage(0, KeyInputMessage.class, KeyInputMessage::encode, KeyInputMessage::decode, KeyInputMessage::handle);
    }

}
