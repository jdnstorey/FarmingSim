package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.blocks.pallet.PalletTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, FarmingSim.MODID);

    //pallet
    public static final RegistryObject<TileEntityType<PalletTileEntity>> PALLET_TILE_ENTITY = TILE_ENTITY_TYPE.register(
            "pallet", () -> TileEntityType.Builder.of(PalletTileEntity::new, BlockInit.PALLET.get()).build(null)
    );

}
