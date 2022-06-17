package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.items.seedBag.SeedBagItem;
import com.jaiden.farmingsim.items.SeedType;
import com.jaiden.farmingsim.materials.CustomToolMaterial;
import com.jaiden.farmingsim.util.entisy.betterLists.SimpleList;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
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

    // Seed Bags
    public static final RegistryObject<Item> SEED_BAG = ITEMS.register("seed_bag", () -> new SeedBagItem(SeedType.WHEAT));


    public static final RegistryObject<Item> EXAMPLE_HOE = ITEMS.register("example_hoe",
            () -> new HoeItem(CustomToolMaterial.EXAMPLE_TOOL, 5, -1, new Item.Properties().tab(FarmingSimCreativeTab.ITEMS))
    );

    public static SimpleList<Item> getAllItems() {
        SimpleList<Item> ret = new SimpleList<>();
        ITEMS.getEntries().forEach(b -> ret.append(b.get()));
        return ret;
    }
}
