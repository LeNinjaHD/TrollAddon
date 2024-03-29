package com.leprofi.trolladdon.listener;

import com.leprofi.trolladdon.TrollAddon;
import com.leprofi.trolladdon.utils.Items;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HitListener implements Listener {
    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent event) {
        if(event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Player damager = (Player) event.getDamager();
            Player target = (Player) event.getEntity();

            if(damager.getInventory().getItemInMainHand().equals(Items.getItem("freeze"))) {
                if(!target.hasPermission("trolladdon.prevent")) {
                    TrollAddon.frozenPlayers.add(target.getName());
                    TrollAddon.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(TrollAddon.getInstance(), new Runnable() {

                        public void run() {
                            TrollAddon.frozenPlayers.remove(target.getName());
                        }
                    }, 20*5L);
                }
            }
        }
    }
}
