package com.jaiden.farmingsim.util.network.messages;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.List;
import java.util.function.Supplier;

public class KeyInputMessage {

    public int key;

    public KeyInputMessage(){};

    public KeyInputMessage(int key){
        this.key = key;
    }

    public static void encode(KeyInputMessage message, PacketBuffer buffer){
        buffer.writeInt(message.key);
    }
    public static KeyInputMessage decode(PacketBuffer buffer){
        return new KeyInputMessage(buffer.readInt());
    }
    public static void handle(KeyInputMessage message, Supplier<NetworkEvent.Context> contextSupplier){
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayerEntity player = context.getSender();
            World world = player.level;
            System.out.println(message.key);

            if (player.inventory.contains(new ItemStack(Items.DIAMOND))){
                player.sendMessage(new StringTextComponent("You already have diamonds!"), player.getUUID());
            } else {
                player.sendMessage(new StringTextComponent("You have been given a free diamond!"), player.getUUID());
                player.inventory.add(new ItemStack(Items.DIAMOND));
            }
        });
        context.setPacketHandled(true);
    }
}
