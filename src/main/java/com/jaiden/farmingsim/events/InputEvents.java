package com.jaiden.farmingsim.events;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.init.KeybindsInit;
import com.jaiden.farmingsim.util.network.FarmingSimNetwork;
import com.jaiden.farmingsim.util.network.messages.KeyInputMessage;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FarmingSim.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class InputEvents {

    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;
        onInput(mc, event.getKey(), event.getAction());
    }
    @SubscribeEvent
    public static void onMouseClick(InputEvent.MouseInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;
        onInput(mc, event.getButton(), event.getAction());
    }


    private static void onInput(Minecraft mc, int key, int action){
        if(mc.screen == null && KeybindsInit.shop_key.consumeClick()){
            //do thing
            FarmingSimNetwork.CHANNEL.sendToServer(new KeyInputMessage(key));
        }
    }
}
