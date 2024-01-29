package com.riverstone.unknown303.oretools.item;

import com.riverstone.unknown303.oretools.OreMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModCreativeModeTabs {
    private static void addItemsToCombatTab(FabricItemGroupEntries pOutput) {
        pOutput.addAfter(new ItemStack(Items.GOLDEN_SWORD), new ItemStack(ModItems.LAPIS_SWORD));
        pOutput.addAfter(new ItemStack(Items.GOLDEN_AXE), new ItemStack(ModItems.LAPIS_AXE));
    }

    private static void addItemsToToolsTab(FabricItemGroupEntries pOutput) {
        pOutput.addAfter(new ItemStack(Items.GOLDEN_HOE), new ItemStack(ModItems.LAPIS_SHOVEL));
        pOutput.addAfter(new ItemStack(ModItems.LAPIS_SHOVEL), new ItemStack(ModItems.LAPIS_PICKAXE));
        pOutput.addAfter(new ItemStack(ModItems.LAPIS_PICKAXE), new ItemStack(ModItems.LAPIS_AXE));
        pOutput.addAfter(new ItemStack(ModItems.LAPIS_AXE), new ItemStack(ModItems.LAPIS_HOE));
    }

    public static void register() {
        OreMod.LOGGER.info("Adding Items to Creative Mode Tabs for " + OreMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModCreativeModeTabs::addItemsToCombatTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModCreativeModeTabs::addItemsToToolsTab);
    }
}
