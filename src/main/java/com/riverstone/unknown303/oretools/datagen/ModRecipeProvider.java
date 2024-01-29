package com.riverstone.unknown303.oretools.datagen;

import com.riverstone.unknown303.oretools.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LAPIS_HELMET)
//                .pattern("LLL")
//                .pattern("L L")
//                .input('L', Items.LAPIS_LAZULI)
//                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
//                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_HELMET)));
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LAPIS_CHESTPLATE)
//                .pattern("L L")
//                .pattern("LLL")
//                .pattern("LLL")
//                .input('L', Items.LAPIS_LAZULI)
//                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
//                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_CHESTPLATE)));
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LAPIS_LEGGINGS)
//                .pattern("LLL")
//                .pattern("L L")
//                .pattern("L L")
//                .input('L', Items.LAPIS_LAZULI)
//                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
//                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_LEGGINGS)));
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LAPIS_BOOTS)
//                .pattern("L L")
//                .pattern("L L")
//                .input('L', Items.LAPIS_LAZULI)
//                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
//                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_BOOTS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LAPIS_SWORD)
                .pattern(" L ")
                .pattern(" L ")
                .pattern(" S ")
                .input('L', Items.LAPIS_LAZULI)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_SWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LAPIS_AXE)
                .pattern("LL ")
                .pattern("LS ")
                .pattern(" S ")
                .input('L', Items.LAPIS_LAZULI)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_AXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LAPIS_PICKAXE)
                .pattern("LLL")
                .pattern(" S ")
                .pattern(" S ")
                .input('L', Items.LAPIS_LAZULI)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LAPIS_SHOVEL)
                .pattern(" L ")
                .pattern(" S ")
                .pattern(" S ")
                .input('L', Items.LAPIS_LAZULI)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_SHOVEL)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LAPIS_HOE)
                .pattern("LL ")
                .pattern(" S ")
                .pattern(" S ")
                .input('L', Items.LAPIS_LAZULI)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_HOE)));
    }
}
