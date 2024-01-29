package com.riverstone.unknown303.oretools.item;

import com.riverstone.unknown303.oretools.OreMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item LAPIS_SWORD = registerItem("lapis_sword",
            new SwordItem(ModToolMaterials.LAPIS, 3, -2.3f,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)) {
                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 1800, 0,
                            false, false, true), attacker);

                    return super.postHit(stack, target, attacker);
                }
            });
    public static final Item LAPIS_PICKAXE = registerItem("lapis_pickaxe",
            new PickaxeItem(ModToolMaterials.LAPIS, 1, -2.7f,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item LAPIS_AXE = registerItem("lapis_axe",
            new AxeItem(ModToolMaterials.LAPIS, 3, -2.3f,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)) {
                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    target.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 20, 1,
                            false, false, true), attacker);

                    return super.postHit(stack, target, attacker);
                }
            });
    public static final Item LAPIS_SHOVEL = registerItem("lapis_shovel",
            new ShovelItem(ModToolMaterials.LAPIS, 1.5F, -2.9f,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item LAPIS_HOE = registerItem("lapis_hoe",
            new HoeItem(ModToolMaterials.LAPIS, -3, 0.1f,
                    new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(OreMod.MOD_ID, name), item);
    }

    public static void register() {
        OreMod.LOGGER.info("Registering Items for " + OreMod.MOD_ID);
    }
}
