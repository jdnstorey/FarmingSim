package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.items.seedBag.SeedBagContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, FarmingSim.MODID);

    public static final RegistryObject<ContainerType<SeedBagContainer>> SEED_BAG = CONTAINER_TYPES.register(
            "seed_bag", () -> IForgeContainerType.create(SeedBagContainer::new)
    );
}
