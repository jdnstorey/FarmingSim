package com.jaiden.farmingsim.blocks.pallet;

import com.jaiden.farmingsim.init.TileEntityTypesInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.ShulkerBoxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;


public class Pallet extends Block {

    public Pallet() {
        super(Properties.of(Material.WOOD).strength(2f, 3f)
                .harvestLevel(0).sound(SoundType.WOOD)
                .requiresCorrectToolForDrops()
                .noOcclusion()
        );
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypesInit.PALLET_TILE_ENTITY.get().create();
    }

    @Override
    public ActionResultType use(BlockState blockState, World world,
                                BlockPos blockPos, PlayerEntity player,
                                Hand hand, BlockRayTraceResult hit) {
        TileEntity tile = world.getBlockEntity(blockPos);
        if(tile instanceof PalletTileEntity && player instanceof ServerPlayerEntity) {
            PalletTileEntity te = (PalletTileEntity) tile;
            IContainerProvider provider = PalletContainer.getServerContainerProvider(te, blockPos);
            INamedContainerProvider namedProvider = new SimpleNamedContainerProvider(provider, PalletContainer.title);
            NetworkHooks.openGui((ServerPlayerEntity) player, namedProvider);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
        return ActionResultType.SUCCESS;
    }

/*
    @Override
    public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        TileEntity tileentity = world.getBlockEntity(pos);
        if (tileentity instanceof PalletTileEntity) {
            PalletTileEntity te = (PalletTileEntity) tileentity;
            if (!world.isClientSide && player.isCreative()) {
                ItemStack itemstack = new ItemStack(this.getBlock().asItem());
                CompoundNBT compoundnbt = te.save(new CompoundNBT());
                if (!compoundnbt.isEmpty()) {
                    itemstack.addTagElement("BlockEntityTag", compoundnbt);
                }
                ItemEntity itementity = new ItemEntity(world, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D,
                        (double)pos.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickUpDelay();
                world.addFreshEntity(itementity);
            } else {
                //shulkerboxtileentity.unpackLootTable(p_176208_4_);
            }
        }

        super.playerWillDestroy(world, pos, state, player);
    }
    public List<ItemStack> getDrops(BlockState p_220076_1_, LootContext.Builder p_220076_2_) {
        TileEntity tileentity = p_220076_2_.getOptionalParameter(LootParameters.BLOCK_ENTITY);
        if (tileentity instanceof ShulkerBoxTileEntity) {
            ShulkerBoxTileEntity shulkerboxtileentity = (ShulkerBoxTileEntity)tileentity;
            p_220076_2_ = p_220076_2_.withDynamicDrop(CONTENTS, (p_220168_1_, p_220168_2_) -> {
                for(int i = 0; i < shulkerboxtileentity.getContainerSize(); ++i) {
                    p_220168_2_.accept(shulkerboxtileentity.getItem(i));
                }

            });
        }

        return super.getDrops(p_220076_1_, p_220076_2_);
    }

 */






    public VoxelShape makeShape(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.09375, 0, 0.125, 0.109375, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.875, 0.09375, 0, 1, 0.109375, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.09375, 0, 0.5625, 0.109375, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0, 0.109375, 0.125, 0.015625, 0.890625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.875, 0, 0.109375, 1, 0.015625, 0.890625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0, 0.109375, 0.5625, 0.015625, 0.890625), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.015625, 0, 0.125, 0.09375, 0.109375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.015625, 0.890625, 0.125, 0.09375, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.015625, 0.4375, 0.125, 0.09375, 0.546875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.015625, 0, 0.5625, 0.09375, 0.109375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.875, 0.015625, 0.890625, 1, 0.09375, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.875, 0.015625, 0.4375, 1, 0.09375, 0.546875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.875, 0.015625, 0, 1, 0.09375, 0.109375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.015625, 0.890625, 0.5625, 0.09375, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0.4375, 0.015625, 0.4375, 0.5625, 0.09375, 0.546875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.109375, 0, 1, 0.125, 0.125), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.109375, 0.421875, 1, 0.125, 0.546875), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.109375, 0.65625, 1, 0.125, 0.78125), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.109375, 0.203125, 1, 0.125, 0.328125), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0.109375, 0.875, 1, 0.125, 1), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0, 0, 1, 0.015625, 0.109375), IBooleanFunction.OR);
        shape = VoxelShapes.join(shape, VoxelShapes.box(0, 0, 0.890625, 1, 0.015625, 1), IBooleanFunction.OR);

        return shape;
    }

}
