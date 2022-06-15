package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.blocks.pallet.Pallet;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FarmingSim.MODID);

    //pallet
    public static final RegistryObject<Block> PALLET = BLOCKS.register("pallet", Pallet::new);

}
