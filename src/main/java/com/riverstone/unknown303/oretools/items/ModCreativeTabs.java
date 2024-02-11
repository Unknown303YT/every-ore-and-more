package com.riverstone.unknown303.oretools.items;

import com.riverstone.unknown303.oretools.OreMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OreMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ORE_TOOLS = CREATIVE_TABS.register("oretools_tools",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LAPIS_AXE.get()))
                    .title(Component.translatable("creativetabs.oretools.oretools_tools"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.LAPIS_SWORD.get());
                        pOutput.accept(ModItems.LAPIS_PICKAXE.get());
                        pOutput.accept(ModItems.LAPIS_AXE.get());
                        pOutput.accept(ModItems.LAPIS_SHOVEL.get());
                        pOutput.accept(ModItems.LAPIS_HOE.get());
                    }))
                    .build());

    public static final RegistryObject<CreativeModeTab> ORE_ARMOR = CREATIVE_TABS.register("oretools_armor",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LAPIS_HELMET.get()))
                    .title(Component.translatable("creativetabs.oretools.oretools_armor"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.LAPIS_HELMET.get());
                        pOutput.accept(ModItems.LAPIS_CHESTPLATE.get());
                        pOutput.accept(ModItems.LAPIS_LEGGINGS.get());
                        pOutput.accept(ModItems.LAPIS_BOOTS.get());
                    }))
                    .withTabsBefore(ORE_TOOLS.getKey())
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
