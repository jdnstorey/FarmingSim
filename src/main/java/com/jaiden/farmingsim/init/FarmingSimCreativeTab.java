package com.jaiden.farmingsim.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class FarmingSimCreativeTab extends ItemGroup {

    public FarmingSimCreativeTab(int index, String label) { super(index, label); }

    public static final FarmingSimCreativeTab ITEMS = new FarmingSimCreativeTab(ItemGroup.TABS.length, "farmingsim_items");
    public static final FarmingSimCreativeTab BLOCKS = new FarmingSimCreativeTab(ItemGroup.TABS.length, "farmingsim_blocks");
    public static final FarmingSimCreativeTab VEHICLES = new FarmingSimCreativeTab(ItemGroup.TABS.length, "farmingsim_vehicles");
    public static final FarmingSimCreativeTab CROPS = new FarmingSimCreativeTab(ItemGroup.TABS.length, "farmingsim_crops");
    public static final FarmingSimCreativeTab LIQUIDS = new FarmingSimCreativeTab(ItemGroup.TABS.length, "farmingsim_liquids");


    @Override
    public ItemStack makeIcon() {
        if(this == ITEMS) {
            return new ItemStack(Items.DIAMOND_HOE);
        }
        if(this == BLOCKS) {
            return new ItemStack(Items.HAY_BLOCK);
        }
        if(this == VEHICLES) {
            return new ItemStack(Items.CHEST_MINECART);
        }
        if(this == CROPS) {
            return new ItemStack(Items.WHEAT);
        }
        if(this == LIQUIDS) {
            return new ItemStack(Items.WATER_BUCKET);
        }
        else {
            return ItemStack.EMPTY;
        }
    }
}
