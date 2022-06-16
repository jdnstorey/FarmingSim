package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import java.awt.event.KeyEvent;

@OnlyIn(Dist.CLIENT)
public class KeybindsInit {
    public static KeyBinding exampleKey;
    public static KeyBinding shop_key;

    public static void register(){
        shop_key = create("shop_key", KeyEvent.VK_BACK_SLASH);

        ClientRegistry.registerKeyBinding(shop_key);
    }

    private static KeyBinding create(String name, int key){
        return new KeyBinding("key." + FarmingSim.MODID + "." + name, key, "key.category." + FarmingSim.MODID);
    }

}
