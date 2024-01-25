package com.riverstone.unknown303.oretools.datagen.statesandmodels;

import com.riverstone.unknown303.oretools.OreMod;
import com.riverstone.unknown303.oretools.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ModItems.LAPIS_SWORD);
        handheldItem(ModItems.LAPIS_AXE);
        handheldItem(ModItems.LAPIS_PICKAXE);
        handheldItem(ModItems.LAPIS_SHOVEL);
        handheldItem(ModItems.LAPIS_HOE);

        simpleItem(ModItems.LAPIS_SWORD);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(OreMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(OreMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
