package com.jaiden.farmingsim.items;

import com.jaiden.farmingsim.init.FarmingSimCreativeTab;
import net.minecraft.item.Item;

public class SeedBagItem extends Item {

    private SeedType type;

    public SeedBagItem(SeedType type) {
        super(new Properties().tab(FarmingSimCreativeTab.ITEMS).stacksTo(1));
        this.type = type;
    }

    public SeedType getType() {
        return type;
    }

    public void setType(SeedType type) {
        this.type = type;
    }
}
