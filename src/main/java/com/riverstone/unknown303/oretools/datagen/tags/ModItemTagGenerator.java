package com.riverstone.unknown303.oretools.datagen.tags;

import com.riverstone.unknown303.oretools.OreMod;
import com.riverstone.unknown303.oretools.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                               CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, OreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.LAPIS_HELMET.get())
                .add(ModItems.LAPIS_CHESTPLATE.get())
                .add(ModItems.LAPIS_LEGGINGS.get())
                .add(ModItems.LAPIS_BOOTS.get());
        this.tag(ItemTags.SWORDS)
                .add(ModItems.LAPIS_SWORD.get());
        this.tag(ItemTags.AXES)
                .add(ModItems.LAPIS_AXE.get());
        this.tag(ItemTags.PICKAXES)
                .add(ModItems.LAPIS_PICKAXE.get());
        this.tag(ItemTags.SHOVELS)
                .add(ModItems.LAPIS_SHOVEL.get());
        this.tag(ItemTags.HOES)
                .add(ModItems.LAPIS_HOE.get());
    }
}
