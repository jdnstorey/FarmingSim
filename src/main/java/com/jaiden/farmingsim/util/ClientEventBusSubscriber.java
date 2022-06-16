package com.jaiden.farmingsim.util;

import com.jaiden.farmingsim.FarmingSim;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = FarmingSim.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {}
