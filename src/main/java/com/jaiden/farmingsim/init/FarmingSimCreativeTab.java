package com.jaiden.farmingsim.init;

import com.jaiden.farmingsim.FarmingSim;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class FarmingSimCreativeTab extends ItemGroup {

    public FarmingSimCreativeTab(int index, String label) { super(index, label); }

    public static final FarmingSimCreativeTab ITEMS = new FarmingSimCreativeTab(ItemGroup.TABS.length, FarmingSim.MODID + ".items");
    public static final FarmingSimCreativeTab BLOCKS = new FarmingSimCreativeTab(ItemGroup.TABS.length, FarmingSim.MODID + ".blocks");
    public static final FarmingSimCreativeTab VEHICLES = new FarmingSimCreativeTab(ItemGroup.TABS.length, FarmingSim.MODID + ".vehicles");
    public static final FarmingSimCreativeTab CROPS = new FarmingSimCreativeTab(ItemGroup.TABS.length, FarmingSim.MODID + ".crops");
    public static final FarmingSimCreativeTab LIQUIDS = new FarmingSimCreativeTab(ItemGroup.TABS.length, FarmingSim.MODID + ".fluids");


    @Override
    public ItemStack makeIcon() {
        if(this == ITEMS) {
            return new ItemStack(Items.DIAMOND_HOE);
        }else if(this == BLOCKS) {
            return new ItemStack(Items.HAY_BLOCK);
        }else if(this == VEHICLES) {
            return new ItemStack(Items.CHEST_MINECART);
        }else if(this == CROPS) {
            return new ItemStack(Items.WHEAT);
        }else if(this == LIQUIDS) {
            return new ItemStack(Items.WATER_BUCKET);
        } else {
            return ItemStack.EMPTY;
        }
    }
}
