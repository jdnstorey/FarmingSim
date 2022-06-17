package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.blocks.pallet.PalletBlock;
import com.jaiden.farmingsim.util.entisy.betterLists.SimpleList;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FarmingSim.MODID);

    //pallet
    public static final RegistryObject<PalletBlock> PALLET =
            register("pallet", PalletBlock::new, FarmingSimCreativeTab.BLOCKS);


    public static SimpleList<Block> getSimpleBlocks() {
        SimpleList<Block> ret = new SimpleList<>();
        BLOCKS.getEntries().forEach(b -> {
            if (isAllowed(b.get())) {
                ret.append(b.get());
            }
        });
        return ret;
    }

    public static SimpleList<Block> getAllBlocks() {
        SimpleList<Block> ret = new SimpleList<>();
        BLOCKS.getEntries().forEach(b -> ret.append(b.get()));
        return ret;
    }

    private static boolean isAllowed(Block block) {
        return !(block instanceof PalletBlock);
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, final ItemGroup tab) {
        RegistryObject<T> obj = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(obj.get(), new Item.Properties().tab(tab)));
        return obj;
    }
}
