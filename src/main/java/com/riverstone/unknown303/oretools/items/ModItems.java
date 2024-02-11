package com.riverstone.unknown303.oretools.items;

import com.riverstone.unknown303.oretools.OreMod;
import com.riverstone.unknown303.oretools.items.custom.ModArmorItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OreMod.MOD_ID);

    public static final RegistryObject<Item> LAPIS_SWORD = ITEMS.register("lapis_sword",
            () -> new SwordItem(ModToolTiers.LAPIS, 3, -2.3f,
                    new Item.Properties().stacksTo(1)) {
                @Override
                public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
                    pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1800, 0,
                            false, false, true), pAttacker);

                    return super.hurtEnemy(pStack, pTarget, pAttacker);
                }
            });
    public static final RegistryObject<Item> LAPIS_PICKAXE = ITEMS.register("lapis_pickaxe",
            () -> new PickaxeItem(ModToolTiers.LAPIS, 1, -2.7f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LAPIS_AXE = ITEMS.register("lapis_axe",
            () -> new AxeItem(ModToolTiers.LAPIS, 5.0F, -2.9f,
                    new Item.Properties().stacksTo(1)) {
                @Override
                public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
                    pTarget.addEffect(new MobEffectInstance(MobEffects.HARM, 20, 1,
                            false, false, true), pAttacker);

                    return super.hurtEnemy(pStack, pTarget, pAttacker);
                }
            });
    public static final RegistryObject<Item> LAPIS_SHOVEL = ITEMS.register("lapis_shovel",
            () -> new ShovelItem(ModToolTiers.LAPIS, 1.5F, -2.9f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LAPIS_HOE = ITEMS.register("lapis_hoe",
            () -> new HoeItem(ModToolTiers.LAPIS, -3, 0.1f,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LAPIS_HELMET = ITEMS.register("lapis_helmet",
            () -> new ModArmorItem(ModArmorMaterials.LAPIS, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.LAPIS, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings",
            () -> new ModArmorItem(ModArmorMaterials.LAPIS, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> LAPIS_BOOTS = ITEMS.register("lapis_boots",
            () -> new ModArmorItem(ModArmorMaterials.LAPIS, ArmorItem.Type.BOOTS,
                    new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
