package com.jaiden.farmingsim.data.client;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, FarmingSim.MODID, exFileHelper);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected void registerStatesAndModels() {
        BlockInit.getSimpleBlocks().forEach(this::simpleBlock);
    }

    private void semiComplexBlock(Block block) {
        horizontalBlock(block, models().orientableWithBottom(block.getRegistryName().getPath(),
                getSide(block), getSide(block), getBottom(block), getTop(block)));
    }

    private void complexBlock(Block block) {
        horizontalBlock(block, models().orientableWithBottom(block.getRegistryName().getPath(),
                getSide(block), getFront(block), getBottom(block), getTop(block)));
    }

    private ResourceLocation getSide(Block block) {
        System.out.println(block.getRegistryName());
        return modLoc("block/" + block.getRegistryName().toString().replace(FarmingSim.MODID + ":", "") + "/side");
    }

    private ResourceLocation getFront(Block block) {
        return modLoc("block/" + block.getRegistryName().toString().replace(FarmingSim.MODID + ":", "") + "/front");
    }

    private ResourceLocation getBottom(Block block) {
        return modLoc("block/" + block.getRegistryName().toString().replace(FarmingSim.MODID + ":", "") + "/bottom");
    }

    private ResourceLocation getTop(Block block) {
        return modLoc("block/" + block.getRegistryName().toString().replace(FarmingSim.MODID + ":", "") + "/top");
    }
}
