package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.blocks.pallet.PalletBlock;
import com.jaiden.farmingsim.util.entisy.betterLists.SimpleList;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FarmingSim.MODID);

    //pallet
    public static final RegistryObject<PalletBlock> PALLET = BLOCKS.register("pallet", PalletBlock::new);


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
}
