package com.leprofi.trolladdon.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class Items {
    private static ItemStack fly = new ItemBuilder(Material.FEATHER).setName("§bFly").addLoreLine("§7Makes you §bFly§7!").getItemStack();
    private static ItemStack invis = new ItemBuilder(Material.POTION).setBasePotionData(new PotionData(PotionType.INVISIBILITY, false, false)).addItemFlag(ItemFlag.HIDE_POTION_EFFECTS).setName("§bInvisibility").addLoreLine("§7Makes you §afully §binvisible §7to other players!").getItemStack();
    private static ItemStack gm = new ItemBuilder(Material.GRASS_BLOCK).setName("§aToggle GameMode").addLoreLine("§7Toggle between Creative & Survival!").getItemStack();
    private static ItemStack invulnerable = new ItemBuilder(Material.TOTEM_OF_UNDYING).setName("§eInvulnerability").addLoreLine("§7Makes you §eIMMORTAL§7!").getItemStack();

    public static ItemStack getItem(String itemName) {
        switch (itemName) {
            case "fly":
                return fly;
            case "invis":
                return invis;
            case "gm":
                return gm;
            case "invulnerable":
                return invulnerable;
            default:
                return null;
        }
    }
}
