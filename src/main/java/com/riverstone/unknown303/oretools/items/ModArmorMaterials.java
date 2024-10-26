package com.riverstone.unknown303.oretools.items;

import com.riverstone.unknown303.errorlib.api.CustomArmorMaterial;
import com.riverstone.unknown303.oretools.OreMod;
import com.riverstone.unknown303.oretools.sounds.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.jarjar.nio.util.Lazy;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements CustomArmorMaterial {
    LAPIS(new ResourceLocation(OreMod.MOD_ID, "lapis"), 27, new int[]{ 3, 8, 6, 3 }, 32,
            ModSounds.ARMOR_EQUIP_LAPIS, 1.75f, 0.0F, () -> Ingredient.of(ModItems.CONDENSED_LAPIS.get()));

    private final ResourceLocation name;
    private final int[] durability;
    private final int durabilityMultiplier;
    private final int[] protection;
    private final int enchantability;
    private final Lazy<SoundEvent> equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;
    private final boolean useVanilla;

    private static final int[] BASE_DURABILITY = new int[]{ 11, 16, 15, 13};

    ModArmorMaterials(ResourceLocation name, int[] durability, int[] protection, int enchantability, Supplier<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durability = durability;
        this.durabilityMultiplier = 0;
        this.protection = protection;
        this.enchantability = enchantability;
        this.equipSound = Lazy.of(equipSound);
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
        this.useVanilla = false;
    }

    ModArmorMaterials(ResourceLocation name, int durabilityMultiplier, int[] protection, int enchantability, Supplier<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.durability = new int[]{ 0, 0, 0, 0 };
        this.protection = protection;
        this.enchantability = enchantability;
        this.equipSound = Lazy.of(equipSound);
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
        this.useVanilla = true;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        if (useVanilla) {
            return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
        } else {
            return durability[type.ordinal()];
        }
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protection[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound.get();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return this.name.toString();
    }

    @Override
    public String getPath() {
        return this.name.getPath();
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
