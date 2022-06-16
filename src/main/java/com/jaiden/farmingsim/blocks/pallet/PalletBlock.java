package com.jaiden.farmingsim.blocks.pallet;

import com.jaiden.farmingsim.init.ItemInit;
import com.jaiden.farmingsim.items.SeedBagItem;
import static com.jaiden.farmingsim.items.SeedType.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class PalletBlock extends Block {

    public static final BooleanProperty EMPTY = BooleanProperty.create("empty");
    /*
    0 = nothing
    1 = wheat
    2 = ...
     */
    public static final IntegerProperty CURRENT = IntegerProperty.create("current", 0, 2);
    public static final VoxelShape EMPTY_VS = Block.box(0, 0, 0, 16, 2, 16);
    public static final VoxelShape FULL_VS = Block.box(0, 0, 0, 16, 22, 16);

    public PalletBlock() {
        super(Properties.of(Material.WOOD).strength(2f, 3f)
                .harvestLevel(0).sound(SoundType.WOOD).requiresCorrectToolForDrops().noOcclusion());
        registerDefaultState(stateDefinition.any().setValue(EMPTY, true).setValue(CURRENT, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(EMPTY, CURRENT);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTrace) {
        if (world != null && !world.isClientSide()) {
            if (player.getItemInHand(hand).getItem() instanceof SeedBagItem) {
                if (state.getValue(EMPTY)) {
                    state.setValue(CURRENT, getInt((SeedBagItem) player.getItemInHand(hand).getItem()));
                    player.getItemInHand(hand).shrink(1);
                }
                cycleProperty(pos, state, world);
            } else if (!state.getValue(EMPTY)) {
                player.inventory.add(ItemInit.SEED_BAG.get().getDefaultInstance());
                cycleProperty(pos, state, world);
            }
        }
        return ActionResultType.SUCCESS;
    }

    private int getInt(SeedBagItem item) {
        return item.getType().getId();
    }

    private void cycleProperty(BlockPos pos, BlockState state, World world) {
        world.setBlockAndUpdate(pos, state.cycle(EMPTY));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        if (state.getValue(EMPTY))
            return EMPTY_VS;
        else
            return FULL_VS;
    }
}