package com.leprofi.trolladdon;

import com.leprofi.trolladdon.commands.TrollCommand;
import com.leprofi.trolladdon.listener.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TrollAddon extends JavaPlugin {
    public static String prefix = "§cTrollAddon §8» §7";

    @Override
    public void onEnable() {
        final int supportedAPIVersion = 7;
        final String supportedVersionName = "5.0.6";

        try {
            Class apiClass = Class.forName("de.marcely.bedwars.api.BedwarsAPI");
            int apiVersion = (int) apiClass.getMethod("getAPIVersion").invoke(null);

            if (apiVersion < supportedAPIVersion)
                throw new IllegalStateException();
        } catch(Exception e) {
            getLogger().warning("Sorry, your installed version of MBedwars is not supported. Please install at least v" + supportedVersionName);
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        //Load everything
        getLogger().info("Loading..");
        getLogger().info("Loading Prefix \"" + prefix + "\"");
        getLogger().info("Loading Listeners & Commands");

        //Listeners
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        //Commands
        getCommand("troll").setExecutor(new TrollCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
