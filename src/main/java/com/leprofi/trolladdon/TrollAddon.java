package com.leprofi.trolladdon;

import com.leprofi.trolladdon.commands.TrollCommand;
import com.leprofi.trolladdon.listener.HitListener;
import com.leprofi.trolladdon.listener.InventoryClickListener;
import com.leprofi.trolladdon.listener.PlayerMoveListener;
import com.leprofi.trolladdon.listener.PlayerStatChangeListener;
import com.leprofi.trolladdon.utils.Metrics;
import de.marcely.bedwars.api.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class TrollAddon extends JavaPlugin {
    public static String prefix = "§cTrollAddon §8» §7";
    public static ArrayList<Arena> trollArenas = new ArrayList<>();
    public static ArrayList<String> invisPlayers = new ArrayList<>();
    public static ArrayList<String> frozenPlayers = new ArrayList<>();
    private static TrollAddon instance;

    public TrollAddon() {
        instance = this;
    }

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
        Bukkit.getPluginManager().registerEvents(new PlayerStatChangeListener(), this);
        Bukkit.getPluginManager().registerEvents(new HitListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);

        //Commands
        getCommand("troll").setExecutor(new TrollCommand());

        getLogger().info("Loading bStats");
        int pluginId = 14431;
        Metrics metrics = new Metrics(this, pluginId);

        getLogger().info("Done!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TrollAddon getInstance() {
        return instance;
    }
}
