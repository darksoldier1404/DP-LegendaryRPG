package com.darksoldier1404.dlr;

import com.darksoldier1404.dlr.events.LREvent;
import com.darksoldier1404.dlr.functions.CommandFunction;
import com.darksoldier1404.dlr.utils.ConfigUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class LegendaryRPG extends JavaPlugin {
    public static final String prefix = "§f[ §eDLR §f] ";
    private static LegendaryRPG plugin;
    public YamlConfiguration config;

    public static LegendaryRPG getInstance() {
        return plugin;
    }

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        ConfigUtils.loadDefaultConfig();
        plugin.getServer().getPluginManager().registerEvents(new LREvent(), plugin);
        CommandFunction.commandRegister();
    }

    @Override
    public void onDisable() {
        //save yaml files
    }
}
