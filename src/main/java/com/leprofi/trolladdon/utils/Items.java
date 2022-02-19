package com.leprofi.trolladdon.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Items {
    private static ItemStack fly = new ItemBuilder(Material.FEATHER).setName("§bFly").addLoreLine("§7Makes you §bFly§7!").getItemStack();

    public static ItemStack getItem(String itemName) {
        switch (itemName) {
            case "fly":
                return fly;
            default:
                return null;
        }
    }
}
