package com.riverstone.unknown303.oretools.items.custom;

import com.google.common.collect.ImmutableMap;
import com.riverstone.unknown303.oretools.items.ModArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.LAPIS, new MobEffectInstance(MobEffects.SATURATION, 1800, 8,
                            false, true, true)).build();

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @SuppressWarnings("removal")
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            if (hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapMobEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapMobEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial armorMaterial,
                                            MobEffectInstance mobEffect) {
        boolean hasPlayerEffect = player.hasEffect(mobEffect.getEffect());
        boolean hasDolphinsGrace = player.hasEffect(MobEffects.DOLPHINS_GRACE);

        if (hasLapisArmorOn(armorMaterial, player) && !hasPlayerEffect && !hasDolphinsGrace) {
            player.addEffect(new MobEffectInstance(mobEffect));
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1100, 0,
                    false, true, false));
        }
        if (hasCorrectArmorOn(armorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mobEffect));
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack helmet = player.getInventory().getArmor(3);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack boots = player.getInventory().getArmor(0);

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial armorMaterial, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());

        return helmet.getMaterial() == armorMaterial && chestplate.getMaterial() == armorMaterial &&
                leggings.getMaterial() == armorMaterial && boots.getMaterial() == armorMaterial;
    }

    private boolean hasLapisArmorOn(ArmorMaterial armorMaterial, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());

        return helmet.getMaterial() == ModArmorMaterials.LAPIS && chestplate.getMaterial() == ModArmorMaterials.LAPIS &&
                leggings.getMaterial() == ModArmorMaterials.LAPIS && boots.getMaterial() == ModArmorMaterials.LAPIS;
    }
}
