package com.leprofi.trolladdon.listener;

import com.leprofi.trolladdon.TrollAddon;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(TrollAddon.frozenPlayers.contains(player.getName())) {
            //Thanks to Metallic 😁
            final Location from = event.getFrom();
            final Location to = event.getTo();
            event.setTo(new Location(to.getWorld(), from.getX(), from.getY(), from.getZ(), to.getYaw(), to.getPitch()));
        }
    }
}
