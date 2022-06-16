package com.jaiden.farmingsim.events;


import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.init.BlockInit;
import com.jaiden.farmingsim.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FarmingSim.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {
}
