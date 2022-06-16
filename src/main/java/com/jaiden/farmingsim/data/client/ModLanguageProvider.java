package com.jaiden.farmingsim.data.client;

import com.jaiden.farmingsim.FarmingSim;
import com.jaiden.farmingsim.init.BlockInit;
import com.jaiden.farmingsim.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen) {
        super(gen, FarmingSim.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + FarmingSim.MODID + "_tab", "Techniq");
        add("tooltip." + FarmingSim.MODID + ".hidden", "hold \u00A7eSHIFT\u00A7r for Info!");
//        add("tooltip." + Techniq.MOD_ID + ".lunar_panel", TechniqConfig.LUNAR_PANEL.get() + "TE/Tick");

        ItemInit.getAllItems().forEach(this::addItem);
        BlockInit.getSimpleBlocks().forEach(this::addBlock);
    }

    private void addBlock(Block block) {
        add(block, getName(block));
    }

    private void addFluid(FlowingFluid fluid) {
        add(fluid, getName(fluid));
    }

    private void addItem(Item item) {
        add(item, getName(item));
    }

    private String getName(Item item) {
        String itemId = item.getRegistryName().toString().replace(FarmingSim.MODID + ":", "");
        String[] args = itemId.split("_");
        String ret = "";
        for (int i = 0; i < args.length; i++) {
            if (i < args.length - 1) {
                ret += upperCaseWord(args[i]) + " ";
            } else {
                ret += upperCaseWord(args[i]);
            }
        }
        return ret;
    }

    private String getName(FlowingFluid fluid) {
        String itemId = fluid.getRegistryName().toString().replace(FarmingSim.MODID + ":", "");
        String[] args = itemId.split("_");
        String ret = "";
        for (int i = 0; i < args.length; i++) {
            if (i < args.length - 1) {
                ret += upperCaseWord(args[i]) + " ";
            } else {
                ret += upperCaseWord(args[i]);
            }
        }
        return ret;
    }

    private String getName(Block block) {
        String itemId = block.getRegistryName().toString().replace(FarmingSim.MODID + ":", "");
        String[] args = itemId.split("_");
        String ret = "";
        for (int i = 0; i < args.length; i++) {
            if (i < args.length - 1) {
                ret += upperCaseWord(args[i]) + " ";
            } else {
                ret += upperCaseWord(args[i]);
            }
        }
        return ret;
    }

    private String upperCaseWord(String word) {
        String ret = word.substring(0, 1).toUpperCase() + word.substring(1);
        return ret;
    }

    public void add(FlowingFluid key, String name) {
        add("fluid." + FarmingSim.MODID + "." + key.getRegistryName().toString().replace(FarmingSim.MODID + ":", ""), name);
    }
}
