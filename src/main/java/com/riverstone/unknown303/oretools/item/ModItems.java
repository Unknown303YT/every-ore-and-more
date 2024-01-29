package com.riverstone.unknown303.oretools.item;

import com.riverstone.unknown303.oretools.OreMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(OreMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        OreMod.LOGGER.info("Registering Items for " + OreMod.MOD_ID);
    }
}
