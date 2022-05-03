package com.darksoldier1404.dlr.loader;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.weapon.obj.gun.GunImpl;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@SuppressWarnings("all")
public class WeaponLoader {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();

    public static void loadGuns() {
        plugin.getWeapons().clear();
        plugin.getRawWeapons().clear();
        File weaponPath = new File(plugin.getDataFolder() + "/weapons");
        if (weaponPath.exists()) {
            if (weaponPath.isDirectory()) {
                if(weaponPath.listFiles().length == 0){
                    System.out.println("무기가 없습니다.");
                    return;
                }
                for (File file : weaponPath.listFiles()) {
                    if (file.getName().endsWith(".yml") || file.getName().endsWith(".yaml")) {
                        plugin.getLogger().info("Loading weapon: " + file.getName());
                        YamlConfiguration w = YamlConfiguration.loadConfiguration(file);
                        if(w.getString("DisplayName").isBlank()) {
                            plugin.getLogger().warning(file.getName() + " 파일의 무기 이름이 없습니다, 해당 무기는 로딩되지 않습니다.");
                            continue;
                        }
                        if(w.getString("WeaponType").isBlank()) {
                            plugin.getLogger().warning(file.getName() + " 파일의 무기 종류가 없습니다, 해당 무기는 로딩되지 않습니다.");
                            continue;
                        }
                        String type = w.getString("WeaponType");
                        String name = file.getName();
                        String bulletType = w.getString("BulletType");
                        if(type.equals("GUN")) {
                            plugin.getWeapons().put(name, new GunImpl(w));
                            plugin.getRawWeapons().put(name, w);
                            plugin.getLogger().info("Loaded weapon: " + name);
                        }
                    }
                }
            }
        }
    }

    public static void loadMelees() {

    }

    public static void saveDefaultWeapons() {
        File fexWeapon = new File(plugin.getDataFolder() + "/weapons", "W-GAR-1.yml");
        if (!fexWeapon.exists()) {
            plugin.saveResource("weapons/W-GAR-1.yml", false);
        }
    }

}
