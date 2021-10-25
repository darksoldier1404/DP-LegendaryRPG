package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.LegendaryRPG;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigUtils {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();
    private static final String prefix = LegendaryRPG.prefix;

    public static void saveData(YamlConfiguration data, String path) {
        try {
            data.save(new File(path));
        } catch (IOException e) {
            System.out.println(prefix + "데이터 저장 실패, 에러 메시지를 확인해주세요.");
            e.printStackTrace();
        }
    }

    public static YamlConfiguration loadData(String path) {
        return YamlConfiguration.loadConfiguration(new File(path));
    }

    public static void loadDefaultConfig() {
        File fconfig = new File(plugin.getDataFolder(), "config.yml");
        if (!fconfig.exists()) {
            plugin.saveResource("config.yml", false);
        }
        plugin.config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "config.yml"));
    }
}
