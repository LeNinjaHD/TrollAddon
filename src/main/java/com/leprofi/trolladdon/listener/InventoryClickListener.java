package com.leprofi.trolladdon.listener;

import com.leprofi.trolladdon.TrollAddon;
import com.leprofi.trolladdon.utils.Items;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(event.getView().getTitle().equals("§cTroll §bMenu")) {
            if (event.getCurrentItem() != null) {
                event.setCancelled(true);
                player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1, 1);
                if(event.getCurrentItem().equals(Items.getItem("fly"))) {
                    if(player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        player.sendMessage(TrollAddon.prefix + "You §ccan not §bfly §7anymore.");
                    } else {
                        player.setAllowFlight(true);
                        player.sendMessage(TrollAddon.prefix + "You §acan §bfly §7now!");
                    }
                } else if(event.getCurrentItem().equals(Items.getItem("invis"))) {
                    if(TrollAddon.invisPlayers.contains(player.getName())) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.showPlayer(TrollAddon.getInstance(), player);
                        }
                        TrollAddon.invisPlayers.remove(player.getName());
                        player.sendMessage(TrollAddon.prefix + "You are now §cvisible§7.");
                    } else {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.hidePlayer(TrollAddon.getInstance(), player);
                        }
                        TrollAddon.invisPlayers.add(player.getName());
                        player.sendMessage(TrollAddon.prefix + "You are now §ainvisible§7.");
                    }
                } else if(event.getCurrentItem().equals(Items.getItem("gm"))) {
                    if(player.getGameMode().equals(GameMode.SURVIVAL)) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(TrollAddon.prefix + "You are now in §aCreative §7Mode!");
                    } else {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(TrollAddon.prefix + "You are now in §cSurvival §7Mode!");
                    }
                } else if(event.getCurrentItem().equals(Items.getItem("invulnerable"))) {
                    if(player.isInvulnerable()) {
                        player.setInvulnerable(false);
                        player.sendMessage(TrollAddon.prefix + "You are now §cvulnerable§7!");
                        player.playSound(player.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 1, 1);
                    } else {
                        player.setInvulnerable(true);
                        player.sendMessage(TrollAddon.prefix + "You are now §ainvulnerable§7!");
                        player.playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1, 1);
                    }
                } else if(event.getCurrentItem().equals(Items.getItem("freeze"))) {
                    player.getInventory().addItem(Items.getItem("freeze"));
                    player.closeInventory();
                }
            }
        }
    }
}
