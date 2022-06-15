package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FarmingSim.MODID);

    //pallet
    public static final RegistryObject<Item> PALLET = ITEMS.register("pallet",
            () -> new BlockItem(BlockInit.PALLET.get(),
                    new Item.Properties().tab(FarmingSimCreativeTab.BLOCKS)));

}
