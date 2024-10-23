package com.riverstone.unknown303.oretools;

import com.mojang.logging.LogUtils;
import com.riverstone.unknown303.errorlib.api.CustomRegistries;
import com.riverstone.unknown303.errorlib.api.registries.horse_armor.HorseArmorRegistry;
import com.riverstone.unknown303.oretools.blocks.ModBlocks;
import com.riverstone.unknown303.oretools.items.ModCreativeTabs;
import com.riverstone.unknown303.oretools.items.ModItems;
import com.riverstone.unknown303.oretools.sounds.ModSounds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OreMod.MOD_ID)
public class OreMod {
    public static final String MOD_ID = "oretools";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static HorseArmorRegistry HORSE_ARMOR_REGISTRY;
    static IEventBus modEventBus;

    public OreMod(@NotNull FMLJavaModLoadingContext context) {
        modEventBus = context.getModEventBus();
        HORSE_ARMOR_REGISTRY = (HorseArmorRegistry)
                CustomRegistries.createRegistry(new HorseArmorRegistry(MOD_ID, "horse_armor", modEventBus));

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);

        CustomRegistries.enableRegistry(HORSE_ARMOR_REGISTRY);
        ModCreativeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
//        MinecraftForge.EVENT_BUS.post(new RegisterReadyEvent());

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    public static IEventBus getEventBus() {
        return modEventBus;
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ModCreativeTabs.register(OreMod.getEventBus());
                LOGGER.error("NOT ERROR. CREATIVE TAB REGISTERED.");
            });
        }
    }
}
