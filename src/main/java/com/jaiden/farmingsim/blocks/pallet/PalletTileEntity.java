package com.jaiden.farmingsim.blocks.pallet;

import com.jaiden.farmingsim.init.ItemInit;
import com.jaiden.farmingsim.init.TileEntityTypesInit;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import org.antlr.v4.runtime.misc.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PalletTileEntity extends TileEntity {

    private final LazyOptional<IItemHandlerModifiable> inventory = LazyOptional.of(this::createInventory);

    public PalletTileEntity() {
        super(TileEntityTypesInit.PALLET_TILE_ENTITY.get());
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if(Direction.Plane.HORIZONTAL.test(side) && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return inventory.cast();
        } else {
            return super.getCapability(cap, side);
        }
    }

    public IItemHandlerModifiable getInventory() {
        return inventory.orElseThrow(() -> new IllegalStateException("Inventory not created properly"));
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        compound.put("inventory", ((ItemStackHandler) getInventory()).serializeNBT());
        return compound;
    }

    @Nonnull
    @Override
    public void load(BlockState blockstate, CompoundNBT compound) {
        super.load(blockstate, compound);
        ((ItemStackHandler) getInventory()).deserializeNBT((CompoundNBT) compound.get("inventory"));
        this.setChanged();
    }

    @Nonnull
    public IItemHandlerModifiable createInventory() {
        return new ItemStackHandler(18){
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                /*if (slot == 2) {
                    return stack.getItem() == ItemInit.FUEL_CELL_FULL.get() || stack.getItem() == ItemInit.FUEL_CELL_EMPTY.get();
                } else {
                    return false;
                }

                 */
                return true;
            }
        };
    }

}
