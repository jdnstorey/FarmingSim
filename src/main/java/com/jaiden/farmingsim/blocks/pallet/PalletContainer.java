package com.jaiden.farmingsim.blocks.pallet;

import com.jaiden.farmingsim.init.BlockInit;
import com.jaiden.farmingsim.init.ContainerTypesInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;


public class PalletContainer extends Container {

    public static final TranslationTextComponent title = new TranslationTextComponent("container.pallet");

    public static PalletContainer getClientContainer(int id, PlayerInventory playerInventory, PacketBuffer buffer) {
        return new PalletContainer(id, new InvWrapper(playerInventory), new ItemStackHandler(18), playerInventory.player, BlockPos.ZERO);
    }
    public static IContainerProvider getServerContainerProvider(PalletTileEntity te, BlockPos activationPos){
        return (id, playerInventory, serverPlayer) -> new PalletContainer(id, new InvWrapper(playerInventory), te.getInventory(), playerInventory.player, activationPos);
    }

    private final IWorldPosCallable worldPosCallable;

    protected PalletContainer(int id, IItemHandlerModifiable playerInventory, IItemHandlerModifiable storageInventory,
                              PlayerEntity player, BlockPos pos) {
        super(ContainerTypesInit.PALLET_CONTAINER.get(), id);
        worldPosCallable = IWorldPosCallable.create(player.level, pos);

        //player inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new SlotItemHandler(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        //hotbar
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new SlotItemHandler(playerInventory, i, 8 + i * 18, 142));
        }

        //storage inventory
        for (int i = 0; i < 2; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new SlotItemHandler(storageInventory, i + j, j * 18 + 8, i * 18 + 23));
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

}
