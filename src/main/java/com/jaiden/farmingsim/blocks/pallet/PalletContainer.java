package com.jaiden.farmingsim.blocks.pallet;

import com.jaiden.farmingsim.init.BlockInit;
import com.jaiden.farmingsim.init.ContainerTypesInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Objects;


public class PalletContainer extends Container {

    public static final TranslationTextComponent title = new TranslationTextComponent("container.pallet");

    private IWorldPosCallable worldPosCallable;

    public PalletContainer(final int id, final PlayerInventory inv, final PacketBuffer buffer) {
        this(id, inv, getTileEntity(inv, buffer));
    }

    public PalletContainer(int id, PlayerInventory playerInventory,
                           PalletTileEntity te) {
        super(ContainerTypesInit.PALLET_CONTAINER.get(), id);
        worldPosCallable = IWorldPosCallable.create(te.getLevel(), te.getBlockPos());

        //player inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        //hotbar
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        //storage inventory
        for (int i = 0; i < 2; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, i + j, j * 18 + 8, i * 18 + 23));
                // 8,23
                // 8,41
            }
        }
    }

    /*this is how to make a fuel slot
    public static class FuelSlot extends SlotItemHandler {
        public FuelSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return stack.getItem() == ItemInit.FUEL_CELL_FULL.get() || stack.getItem() == ItemInit.FUEL_CELL_EMPTY.get();
        }
    }

    //output slot
    public static class OutputSlot extends SlotItemHandler {
        public OutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return false;
        }
    }
     */



    @Override
    public boolean stillValid(PlayerEntity player) {
        return stillValid(worldPosCallable, player, BlockInit.PALLET.get());
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index){
        if(index >= 36){
            moveItemStackTo(this.getItems().get(index), 0, 35, false);
        } else {
            moveItemStackTo(this.getItems().get(index), 36, 40, false);
        }
        return ItemStack.EMPTY;
    }

    private static PalletTileEntity  getTileEntity(PlayerInventory inv, PacketBuffer buffer) {
        Objects.requireNonNull(inv, "Inventory cannot be null");
        Objects.requireNonNull(buffer, "PacketBuffer cannot be null");
        final TileEntity tileEntity = inv.player.level.getBlockEntity(buffer.readBlockPos());
        if (tileEntity instanceof PalletTileEntity) {
            return (PalletTileEntity) tileEntity;
        }
        throw new IllegalStateException("TileEntity is not correct!");
    }

}
