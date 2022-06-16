package com.jaiden.farmingsim.util;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.init.KeybindsInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = FarmingSim.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
}
