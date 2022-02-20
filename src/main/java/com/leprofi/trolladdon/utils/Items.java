package com.leprofi.trolladdon.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class Items {
    private static ItemStack fly = new ItemBuilder(Material.FEATHER).setName("§bFly").addLoreLine("§7Makes you §bFly§7!").getItemStack();
    private static ItemStack invis = new ItemBuilder(Material.POTION).setBasePotionData(new PotionData(PotionType.INVISIBILITY, false, false)).setName("§bInvisibility").addLoreLine("§7Makes you §afully §binvisible §7to other players!").getItemStack();

    public static ItemStack getItem(String itemName) {
        switch (itemName) {
            case "fly":
                return fly;
            case "invis":
                return invis;
            default:
                return null;
        }
    }
}
