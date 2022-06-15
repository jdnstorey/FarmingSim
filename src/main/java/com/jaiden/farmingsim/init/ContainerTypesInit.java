package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.blocks.pallet.PalletContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, FarmingSim.MODID);

    //pallet
    public static final RegistryObject<ContainerType<PalletContainer>> PALLET_CONTAINER = CONTAINER_TYPES.register(
            "pallet", () -> IForgeContainerType.create(PalletContainer::getClientContainer)
    );
}
