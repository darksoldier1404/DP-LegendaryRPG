package com.darksoldier1404.dlr.loader;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.dEntity.mobs.LRMobImpl;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@SuppressWarnings("all")
public class LRMobLoader {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();

    public static void loadMobs() {
        plugin.getLrmobs().clear();
        File mobPath = new File(plugin.getDataFolder() + "/mobs");
        if (mobPath.exists()) {
            if (mobPath.isDirectory()) {
                if (mobPath.listFiles().length == 0) {
                    System.out.println("몹이 없습니다.");
                    return;
                }
                for (File file : mobPath.listFiles()) {
                    if (file.getName().endsWith(".yml") || file.getName().endsWith(".yaml")) {
                        plugin.getLogger().info("Loading weapon: " + file.getName());
                        YamlConfiguration w = YamlConfiguration.loadConfiguration(file);
                        if (w.getString("DisplayName").isBlank()) {
                            plugin.getLogger().warning(file.getName() + " 파일의 몹 이름이 없습니다, 해당 몹은 로딩되지 않습니다.");
                            continue;
                        }
                        if (w.getString("EntityType").isBlank()) {
                            plugin.getLogger().warning(file.getName() + " 파일의 몹 종류가 없습니다, 해당 몹은 로딩되지 않습니다.");
                            continue;
                        }
                        String name = w.getString("Name");
                        plugin.getLrmobs().put(name, new LRMobImpl(w));
                        plugin.getRawLRMobs().put(name, w);
                        plugin.getLogger().info("Loaded mob: " + name);
                    }
                }
            }
        }
    }

    public static void saveDefaultMobs() {
        File fexWeapon = new File(plugin.getDataFolder() + "/mobs", "Kuva.yml");
        if (!fexWeapon.exists()) {
            plugin.saveResource("mobs/Kuva.yml", false);
        }
    }

}
