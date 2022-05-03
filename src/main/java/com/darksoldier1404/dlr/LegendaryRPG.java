package com.darksoldier1404.dlr;

import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityCast;
import com.darksoldier1404.dlr.dentity.mobs.LRMobImpl;
import com.darksoldier1404.dlr.dentity.mobs.dt.DropTableManager;
import com.darksoldier1404.dlr.events.GunFireLogic;
import com.darksoldier1404.dlr.events.LREvent;
import com.darksoldier1404.dlr.events.damage.EntityGetDamageEvent;
import com.darksoldier1404.dlr.functions.CommandFunction;
import com.darksoldier1404.dlr.loader.AbilityLoader;
import com.darksoldier1404.dlr.loader.LRMobLoader;
import com.darksoldier1404.dlr.loader.WeaponLoader;
import com.darksoldier1404.dlr.tasks.BulletTask;
import com.darksoldier1404.dlr.weapon.obj.Weapon;
import com.darksoldier1404.dlr.weapon.obj.gun.bullets.Bullet;
import com.darksoldier1404.dppc.utils.ConfigUtils;
import com.darksoldier1404.dppc.utils.Metrics;
import com.darksoldier1404.dppc.utils.Tuple;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

// TODO : 이벤트 의존 -> 스케듈러 의존으로 변경 & 데미지 관련 이벤트, 총 발사, 총알 핸들링 관련은 모두 대기열에 추가하여 핸들링 하도록 변경
// 이로 인하여 이 플러그인은 싱글 쓰레드가 아닌 멀티 쓰레드에서 더 좋은 성능을 가질 수 있게된다.

@SuppressWarnings("all")
public class LegendaryRPG extends JavaPlugin {
    private final int pluginID = 13314;
    private PluginManager pm;
    public static final String prefix = "§f[ §eDLR §f] ";
    private static LegendaryRPG plugin;
    public YamlConfiguration config; // 설정 파일
    private final Map<String, Weapon> weapons = new HashMap<>(); // 모든 무기 목록
    private final Map<String, AbilityCast> abilities = new HashMap<>(); // 모든 무기 목록
    private final Map<String, YamlConfiguration> rawWeapons = new HashMap<>(); // 모든 무기의 콘피그 raw 파일
    private final Map<String, YamlConfiguration> rawLRMobs = new HashMap<>(); // 모든 무기의 콘피그 raw 파일
    private final Map<String, YamlConfiguration> spawners = new HashMap<>(); // 스포너 목록
    private final Map<UUID, Tuple<BukkitTask, Arrow>> homingBullets = new HashMap<>(); // 발사된 미사일 총알
    private final Map<UUID, Arrow> firedBullets = new HashMap<>(); // 발사된 모든 총알
    private final Map<UUID, Bullet> FBOBJ = new HashMap<>(); // 발사된 모든 총알 - 객체
    private final Map<String, LRMobImpl> lrmobs = new HashMap<>(); // 로드된 모든 몹
    private final Map<UUID, LRMobImpl> summonedLRMobs = new HashMap<>(); // 로드된 모든 몹
    private final DropTableManager dtm = new DropTableManager();
    private final Set<UUID> drawing = new HashSet<>(); // 연사중인 플레이어

    public Map<String, YamlConfiguration> getRawWeapons() {
        return rawWeapons;
    }

    public Map<String, Weapon> getWeapons() {
        return weapons;
    }

    public Map<String, AbilityCast> getAbilities() {
        return abilities;
    }

    public Map<String, YamlConfiguration> getSpawners() {
        return spawners;
    }

    public Map<UUID, Tuple<BukkitTask, Arrow>> getHomingBullets() {
        return homingBullets;
    }

    public Map<UUID, Arrow> getFiredBullets() {
        return firedBullets;
    }

    public Map<UUID, Bullet> getFBOBJ() {
        return FBOBJ;
    }

    public Map<String, YamlConfiguration> getRawLRMobs() {
        return rawLRMobs;
    }

    public Map<String, LRMobImpl> getLrmobs() {
        return lrmobs;
    }

    public Map<UUID, LRMobImpl> getSummonedLRMobs() {
        return summonedLRMobs;
    }

    public DropTableManager getDropTableManager() {
        return dtm;
    }

    public Set<UUID> getDrawing() {
        return drawing;
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

        Metrics metrics = new Metrics(this, pluginID);
        WeaponLoader.saveDefaultWeapons();
        WeaponLoader.loadGuns();
        LRMobLoader.saveDefaultMobs();
        LRMobLoader.loadMobs();
        AbilityLoader.saveDefaultAbilities();
        AbilityLoader.loadAbilities();

        config = ConfigUtils.loadDefaultPluginConfig(plugin);
        plugin.getServer().getPluginManager().registerEvents(new LREvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new GunFireLogic(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new EntityGetDamageEvent(), plugin); // register EntityGetDamageEvent

        CommandFunction.commandRegister();

        BulletTask.BulletHitTask();
//        BulletTask.BulletListTask();
        plugin.getServer().getScheduler().runTaskTimer(plugin, () -> {
            try {
                for (final Player p : plugin.getServer().getOnlinePlayers()) {
                    if (p.getItemInHand() != null && p.getItemInHand().getType() == Material.BOW
                            && drawing.contains(p.getUniqueId())) {
                        final ItemStack item = p.getItemInHand();
                        GunFireLogic.fire(p, item);
                    }
                }
            } catch (Exception e) {
            }

        }, 20L, 1L);
    }

    @Override
    public void onDisable() {
        // save all yaml file
        for (LRMobImpl lrm : summonedLRMobs.values()) {
            lrm.getLe().remove();
        }
    }

    private void disableThisPlugin() {
        System.out.println(" ");
        System.out.println("!==============================!");
        System.out.println("This Plugin is can't load with MythicMobs, RPGItems, MMOItems plugin.");
        System.out.println("!==============================!");
        plugin.getPluginLoader().disablePlugin(plugin); // will go to onDisable method.

    }
}
