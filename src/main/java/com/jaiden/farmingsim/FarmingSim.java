package com.jaiden.farmingsim;

import com.jaiden.farmingsim.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FarmingSim.MODID)
public class FarmingSim {
    public static final String MODID = "farmingsim";

    public FarmingSim() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);
        ContainerTypesInit.CONTAINER_TYPES.register(bus);
        KeybindsInit.register();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
