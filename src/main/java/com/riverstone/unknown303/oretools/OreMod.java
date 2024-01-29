package com.riverstone.unknown303.oretools;

import com.riverstone.unknown303.oretools.item.ModCreativeModeTabs;
import com.riverstone.unknown303.oretools.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OreMod implements ModInitializer {
	public static final String MOD_ID = "oretools";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.register();

		ModCreativeModeTabs.register();
	}
}