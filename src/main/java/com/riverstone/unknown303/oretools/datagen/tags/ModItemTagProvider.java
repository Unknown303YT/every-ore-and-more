package com.riverstone.unknown303.oretools.datagen.tags;

import com.riverstone.unknown303.oretools.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.LAPIS_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.LAPIS_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.LAPIS_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.LAPIS_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.LAPIS_HOE);
    }
}
