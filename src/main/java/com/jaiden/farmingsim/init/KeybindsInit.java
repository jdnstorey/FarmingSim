package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.util.entisy.betterLists.SimpleList;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;

import java.awt.event.KeyEvent;

public class KeybindsInit {
    public static KeyBinding shop_key;

    public static void register() {
        shop_key = create("shop", KeyEvent.VK_BACK_SLASH);

        ClientRegistry.registerKeyBinding(shop_key);
    }

    private static KeyBinding create(String name, int key) {
        return new KeyBinding("key." + FarmingSim.MODID + "." + name, key, "key.category." + FarmingSim.MODID);
    }
}
