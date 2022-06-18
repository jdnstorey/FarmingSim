package com.jaiden.farmingsim.items.seedBag;

import com.jaiden.farmingsim.blocks.pallet.PalletBlock;
import com.jaiden.farmingsim.init.FarmingSimCreativeTab;
import com.jaiden.farmingsim.items.SeedType;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SeedBagItem extends Item implements INamedContainerProvider {

    private SeedType type;

    public SeedBagItem(SeedType type) {
        super(new Properties().tab(FarmingSimCreativeTab.ITEMS).stacksTo(1));
        this.type = type;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide()) {
            NetworkHooks.openGui((ServerPlayerEntity) player, this);
        }

        return ActionResult.success(stack);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();

        if (!world.isClientSide()) {
            if (!(world.getBlockState(context.getClickedPos()).getBlock() instanceof PalletBlock)) {
                NetworkHooks.openGui((ServerPlayerEntity) Objects.requireNonNull(context.getPlayer()), this);
            }
        }

        return ActionResultType.CONSUME;
    }

    public SeedType getType() {
        return type;
    }

    public void setType(SeedType type) {
        this.type = type;
        getDefaultInstance().getOrCreateTag().putString("SeedType", type.getIdentifier());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("");
    }

    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory inv, PlayerEntity player) {
        return new SeedBagContainer(windowId, this);
    }
}
