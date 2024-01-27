package com.riverstone.unknown303.oretools;

import com.mojang.logging.LogUtils;
import com.riverstone.unknown303.oretools.blocks.ModBlocks;
import com.riverstone.unknown303.oretools.items.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forgespi.language.IModInfo;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OreMod.MOD_ID)
public class OreMod {
    public static final String MOD_ID = "oretools";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static IModInfo iModInfo;

    public OreMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        iModInfo = ModLoadingContext.get().getActiveContainer().getModInfo();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.LAPIS_SWORD.get());
            event.accept(ModItems.LAPIS_AXE.get());

            event.accept(ModItems.LAPIS_HELMET.get());
            event.accept(ModItems.LAPIS_CHESTPLATE.get());
            event.accept(ModItems.LAPIS_LEGGINGS.get());
            event.accept(ModItems.LAPIS_BOOTS.get());
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.LAPIS_SHOVEL.get());
            event.accept(ModItems.LAPIS_PICKAXE.get());
            event.accept(ModItems.LAPIS_AXE.get());
            event.accept(ModItems.LAPIS_HOE.get());
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
        }
    }
}
