package com.darksoldier1404.dlr.loader;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.kapality.ability.ClearTargetAbility;
import com.darksoldier1404.dlr.kapality.ability.DelayAbility;
import com.darksoldier1404.dlr.kapality.ability.TargetAbility;
import com.darksoldier1404.dlr.kapality.ability.obj.AbilityCast;
import com.darksoldier1404.dlr.kapality.enums.TargetType;
import com.darksoldier1404.dlr.weapon.obj.gun.GunImpl;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;

@SuppressWarnings("all")
public class AbilityLoader {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();

    public static void loadAbilities() {
        plugin.getAbilities().clear();
        File files = new File(plugin.getDataFolder() + "/abilities");
        if (files.exists()) {
            if (files.isDirectory()) {
                if (files.listFiles().length == 0) {
                    System.out.println("어빌리티가 없습니다.");
                    return;
                }
                for (File file : files.listFiles()) {
                    if (file.getName().endsWith(".yml") || file.getName().endsWith(".yaml")) {
                        plugin.getLogger().info("Loading Ability: " + file.getName());
                        YamlConfiguration w = YamlConfiguration.loadConfiguration(file);
                        ArrayList<String> keys = new ArrayList<>();
                        w.getKeys(false).forEach(keys::add);
                        if (keys.size() == 0) {
                            System.out.println("어빌리티가 없습니다.");
                            continue;
                        }
                        if (keys.get(0).startsWith(".")) {
                            System.out.println("어빌리티 이름이 누락되었습니다.");
                            continue;
                        }
                        String name = keys.get(0);
                        keys.remove(0);
                        AbilityCast abilityCast = new AbilityCast();
                        initAbilityCast(keys, abilityCast, w);
                        plugin.getAbilities().put(name, abilityCast);
                        plugin.getLogger().info("Loaded Ability: " + name);
                    }
                }
            }
        }
    }

    public static void initAbilityCast(ArrayList<String> keys, AbilityCast cast, YamlConfiguration data) {
        for (String key : keys) {
            if(key.startsWith(".")) {
                if(key.equals(".DelayAbility")) {
                    cast.addAbility(new DelayAbility(data.getLong(key+".delay")));
                    continue;
                }
                if(key.equals(".TargetAbility")) {
                    TargetType type = TargetType.valueOf(data.getString(key+".TargetType").toUpperCase());
                    double range = data.getDouble(key+".TargetRange");
                    double angle = data.getDouble(key+".TargetAngle");
                    int maxTarget = data.getInt(key+".MaxTarget");
                    cast.addAbility(new TargetAbility(type, range, angle, maxTarget));
                    continue;
                }
                if(key.equals(".ClearTargetAbility")) {
                    cast.addAbility(new ClearTargetAbility());
                    continue;
                }

            }
        }
    }

    public static void saveDefaultAbilities() {
        File file = new File(plugin.getDataFolder() + "/abilities", "TestAbility.yml");
        if (!file.exists()) {
            plugin.saveResource("abilities/TestAbility.yml", false);
        }
    }

}
