package com.leprofi.trolladdon;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TrollAddon extends JavaPlugin {

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

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
