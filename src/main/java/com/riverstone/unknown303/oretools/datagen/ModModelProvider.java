package com.riverstone.unknown303.oretools.datagen;

import com.riverstone.unknown303.oretools.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LAPIS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LAPIS_HOE, Models.HANDHELD);
    }
}
