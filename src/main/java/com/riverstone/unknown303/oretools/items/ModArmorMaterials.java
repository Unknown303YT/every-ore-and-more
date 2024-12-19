package com.riverstone.unknown303.oretools.items;

import com.riverstone.unknown303.errorlib.api.misc.CustomArmorMaterial;
import com.riverstone.unknown303.oretools.OreMod;
import com.riverstone.unknown303.oretools.sounds.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.jarjar.nio.util.Lazy;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements CustomArmorMaterial {
    LAPIS("lapis", 27, new int[]{ 3, 8, 6, 3 }, 32,
            ModSounds.ARMOR_EQUIP_LAPIS, 1.75f, 0.0F, () -> Ingredient.of(Items.LAPIS_LAZULI));

    private final ResourceLocation location;
    private final int durabilityMultiplier;
    private final int[] protection;
    private final int enchantability;
    private final Supplier<SoundEvent> equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = new int[]{ 11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protection, int enchantability, Supplier<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.location = new ResourceLocation(OreMod.MOD_ID, name);
        this.durabilityMultiplier = durabilityMultiplier;
        this.protection = protection;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protection[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
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
    public ResourceLocation getId() {
        return this.location;
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
