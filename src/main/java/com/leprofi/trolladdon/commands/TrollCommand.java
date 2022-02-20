package com.leprofi.trolladdon.commands;

import com.leprofi.trolladdon.TrollAddon;
import com.leprofi.trolladdon.utils.ItemBuilder;
import com.leprofi.trolladdon.utils.Items;
import de.marcely.bedwars.api.GameAPI;
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

            if(args.length > 0) {
                if(args[0].equalsIgnoreCase("confirm")) {
                    openGUI(player);
                    TrollAddon.trollArenas.add(GameAPI.get().getArenaByPlayer(player));
                }
            }
            if(!TrollAddon.trollArenas.contains(GameAPI.get().getArenaByPlayer(player))) {
                player.sendMessage(TrollAddon.prefix + "§cWARNING! §7If you want to enable Troll Mode, type \"/troll confirm\". This will disable Stats for all players in this Round.");
            } else {
                openGUI(player);
            }


        }
        return true;
    }

    public void openGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 54, "§cTroll §bMenu");
        inventory.setItem(12, Items.getItem("fly"));
        inventory.setItem(14, Items.getItem("invis"));

        for (int i = 0; i < inventory.getSize(); i++) {
            if(inventory.getItem(i) == null) {
                inventory.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("").getItemStack());
            }
        }
        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
    }
}
