package com.riverstone.unknown303.oretools;

import com.riverstone.unknown303.oretools.datagen.*;
import com.riverstone.unknown303.oretools.datagen.loot.ModBlockLootTableProvider;
import com.riverstone.unknown303.oretools.datagen.tags.ModBlockTagProvider;
import com.riverstone.unknown303.oretools.datagen.tags.ModItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OreModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
