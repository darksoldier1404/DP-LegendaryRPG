package com.darksoldier1404.dlr;

import com.darksoldier1404.dlr.events.LREvent;
import com.darksoldier1404.dlr.events.GunFireLogic;
import com.darksoldier1404.dlr.events.damage.EntityGetDamageEvent;
import com.darksoldier1404.dlr.events.fire.BulletHitedEvent;
import com.darksoldier1404.dlr.functions.CommandFunction;
import com.darksoldier1404.dlr.tasks.BulletTask;
import com.darksoldier1404.dlr.utils.ConfigUtils;
import com.darksoldier1404.dlr.utils.WeaponLoader;
import com.darksoldier1404.dlr.weapon.obj.Weapon;
import net.minecraft.util.Tuple;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// TODO : 이벤트 의존 -> 스케듈러 의존으로 변경 & 데미지 관련 이벤트, 총 발사, 총알 핸들링 관련은 모두 대기열에 추가하여 핸들링 하도록 변경
// 이로 인하여 이 플러그인은 싱글 쓰레드가 아닌 멀티 쓰레드에서 더 좋은 성능을 가질 수 있게된다.

@SuppressWarnings("all")
public class LegendaryRPG extends JavaPlugin {
    private PluginManager pm;
    public static final String prefix = "§f[ §eDLR §f] ";
    private static LegendaryRPG plugin;
    public YamlConfiguration config; // 설정 파일
    private final Map<String, Weapon> weapons = new HashMap<>(); // 모든 무기 목록
    private final Map<String, YamlConfiguration> rawWeapons = new HashMap<>(); // 모든 무기의 콘피그 raw 파일
    private final Map<String, YamlConfiguration> spawners = new HashMap<>(); // 스포너 목록
    private final Map<UUID, Tuple<BukkitTask, Arrow>> homingArrows = new HashMap<>();
    private final Map<UUID, Arrow> firedArrows = new HashMap<>();

    public Map<String, YamlConfiguration> getRawWeapons() {
        return rawWeapons;
    }

    public Map<String, Weapon> getWeapons() {
        return weapons;
    }

    public Map<String, YamlConfiguration> getSpawners() {
        return spawners;
    }

    public Map<UUID, Tuple<BukkitTask, Arrow>> getHomingArrows() {
        return homingArrows;
    }

    public Map<UUID, Arrow> getFiredArrows() {
        return firedArrows;
    }

    public static LegendaryRPG getInstance() {
        return plugin;
    }

    @Override
    public void onLoad() {
        plugin = this;
        pm = getServer().getPluginManager();
    }

    @Override
    public void onEnable() {
        System.out.println("default world name : " + Bukkit.getWorlds().get(0).getName());
        // 아레 플러그인은 이 플러그인과 충돌 가능성이 높으므로 같이 사용이 불가할 수 있습니다.
        // 이외 다른 플러그인중 플레이어의 어트리뷰트 정보를 가져와 사용하는 플러그인은 해당 플러그인을 정식 서버에 사용하기 전에 먼저 테스트를 해보셔야 합니다.
        getServer().getScheduler().runTaskLater(plugin, () -> {
            try {
                if (pm.getPlugin("MythicMobs").isEnabled()) {
                    disableThisPlugin();
                }
            } catch (Exception ignored) {
            }
            try {
                if (pm.getPlugin("RPGItems").isEnabled()) {
                    disableThisPlugin();
                }
            } catch (Exception ignored) {
            }
            try {
                if (pm.getPlugin("MMOItems").isEnabled()) {
                    disableThisPlugin();
                }
            } catch (Exception ignored) {
            }
        }, 40L);

        WeaponLoader.saveDefaultWeapons();
        WeaponLoader.loadGuns();

        ConfigUtils.loadDefaultConfig();
        plugin.getServer().getPluginManager().registerEvents(new LREvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GunFireLogic(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EntityGetDamageEvent(), plugin); // register EntityGetDamageEvent

        CommandFunction.commandRegister();

        BulletTask.BulletHitTask();
        BulletTask.BulletListTask();
    }

    @Override
    public void onDisable() {
        // save all yaml file

    }

    private void disableThisPlugin() {
        System.out.println(" ");
        System.out.println("!==============================!");
        System.out.println("This Plugin is can't load with MythicMobs, RPGItems, MMOItems plugin.");
        System.out.println("!==============================!");
        plugin.getPluginLoader().disablePlugin(plugin); // will go to onDisable method.

    }
}
