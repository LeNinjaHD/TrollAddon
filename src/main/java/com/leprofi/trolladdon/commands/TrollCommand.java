package com.leprofi.trolladdon.commands;

import com.leprofi.trolladdon.utils.ItemBuilder;
import com.leprofi.trolladdon.utils.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TrollCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            Inventory inventory = Bukkit.createInventory(player, 54, "§cTroll §bMenu");
            inventory.setItem(13, Items.getItem("fly"));

            for (int i = 0; i < inventory.getSize(); i++) {
                if(inventory.getItem(i) == null) {
                    inventory.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("").getItemStack());
                }
            }
            player.openInventory(inventory);
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        }
        return true;
    }
}
