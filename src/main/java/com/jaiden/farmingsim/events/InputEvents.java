package com.jaiden.farmingsim.events;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.init.KeybindsInit;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
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
        if(mc.screen == null && KeybindsInit.shop_key.isDown()){
            //do thing
            mc.level.players().get(0).sendMessage(new StringTextComponent("test"), mc.level.players().get(0).getUUID());
//            FarmingSimNetwork.CHANNEL.sendToServer(new KeyInputMessage(key));
        }
    }
}
