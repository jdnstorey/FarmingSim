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

    public static void register(){
        exampleKey = create("example_key", KeyEvent.VK_H);

        ClientRegistry.registerKeyBinding(exampleKey);
    }

    private static KeyBinding create(String name, int key){
        return new KeyBinding("key." + FarmingSim.MODID + "." + name, key, "key.category." + FarmingSim.MODID);
    }

}
