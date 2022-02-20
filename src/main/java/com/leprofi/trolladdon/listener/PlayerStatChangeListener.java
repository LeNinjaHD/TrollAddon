package com.leprofi.trolladdon.listener;

import com.leprofi.trolladdon.TrollAddon;
import de.marcely.bedwars.api.GameAPI;
import de.marcely.bedwars.api.event.player.PlayerStatChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerStatChangeListener implements Listener {
    @EventHandler
    public void onPlayerStatChange(PlayerStatChangeEvent event) {
        Player player = Bukkit.getPlayer(event.getStats().getPlayerUUID());
        if(TrollAddon.trollArenas.contains(GameAPI.get().getArenaByPlayer(player))) {
            event.setCancelled(true);
        }
    }
}
