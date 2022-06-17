package com.jaiden.farmingsim.util;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.init.ContainerTypesInit;
import com.jaiden.farmingsim.init.KeybindsInit;
import com.jaiden.farmingsim.items.seedBag.SeedBagScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = FarmingSim.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.register(ContainerTypesInit.SEED_BAG.get(), SeedBagScreen::new);
    }
}
