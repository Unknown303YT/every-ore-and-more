package com.riverstone.unknown303.oretools.items;

import com.riverstone.unknown303.oretools.OreMod;
import com.riverstone.unknown303.oretools.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier LAPIS = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1570, 8.5f, 3.0f, 27,
                    ModTags.Blocks.NEEDS_LAPIS_TOOL, () -> Ingredient.of(Items.LAPIS_LAZULI)),
            new ResourceLocation(OreMod.MOD_ID, "lapis"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));
}
