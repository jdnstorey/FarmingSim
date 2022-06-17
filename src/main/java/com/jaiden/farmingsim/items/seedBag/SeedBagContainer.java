package com.jaiden.farmingsim.items.seedBag;

import com.jaiden.farmingsim.init.ContainerTypesInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;


public class SeedBagContainer extends Container {

    private final SeedBagItem seedBag;

    public SeedBagContainer(final int windowId, SeedBagItem seedBag) {
        super(ContainerTypesInit.SEED_BAG.get(), windowId);
        this.seedBag = seedBag;
    }

    public SeedBagContainer(final int windowId, PlayerInventory inv, PacketBuffer buffer) {
        this(windowId, get(inv));
    }

    private static SeedBagItem get(PlayerInventory inv) {
        return (SeedBagItem) inv.getSelected().getItem();
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return true;
    }
}
