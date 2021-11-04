package com.darksoldier1404.dlr.spawner;

import com.darksoldier1404.dlr.LegendaryRPG;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class SpawnerUtils {
    private final static LegendaryRPG plugin = LegendaryRPG.getInstance();

    public static void addSpawner(String key, Location loc, String mobName) {
        YamlConfiguration data = new YamlConfiguration();
        data.set("Name", key);
        data.set("Location", loc);
        data.set("MobName", mobName);
        // create new yml data

    }
}
