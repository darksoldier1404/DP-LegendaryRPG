package com.darksoldier1404.dlr.tasks;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletHitedEvent;
import com.darksoldier1404.duc.utils.Tuple;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.scheduler.BukkitTask;

import java.util.Map;
import java.util.UUID;

public class BulletTask {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();
    private static BukkitTask bulletHitTask = null;
    private static BukkitTask bulletListTask = null;
    private static final Map<UUID, Tuple<BukkitTask, Arrow>> homingBullets = plugin.getHomingBullets();
    private static final Map<UUID, Arrow> firedBullets = plugin.getFiredBullets();

    public static void BulletListTask() { // for debug
        try {
            bulletListTask.cancel();
            bulletListTask = null;
        } catch (Exception ignored) {
        }
        bulletListTask = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            try {
                System.out.println("size of homingArrows : " + homingBullets.size());
                System.out.println("size of firedArrows : " + firedBullets.size());
            } catch (Exception ignored) {

            }
        }, 0, 20);
    }

    public static void BulletHitTask() {
        try {
            bulletHitTask.cancel();
            bulletHitTask = null;
        } catch (Exception ignored) {
        }
        bulletHitTask = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            try {
                homingBullets.forEach((uuid, tuple) -> {
                    if (tuple.getB().isOnGround()) {
                        tuple.getA().cancel();
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(tuple.getB()));
                        homingBullets.remove(uuid);
                        firedBullets.remove(uuid);
                    } else if (tuple.getB().isDead()) {
                        tuple.getA().cancel();
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(tuple.getB()));
                        homingBullets.remove(uuid);
                        firedBullets.remove(uuid);
                    } else if (!tuple.getB().isValid()) {
                        tuple.getA().cancel();
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(tuple.getB()));
                        homingBullets.remove(uuid);
                        firedBullets.remove(uuid);
                    }
                });
                firedBullets.forEach((uuid, arrow) -> {
                    if (arrow.isOnGround()) {
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(arrow));
                        homingBullets.remove(uuid);
                        firedBullets.remove(uuid);
                    }
                    if (arrow.isDead()) {
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(arrow));
                        homingBullets.remove(uuid);
                        firedBullets.remove(uuid);
                    }
                    if (!arrow.isValid()) {
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(arrow));
                        homingBullets.remove(uuid);
                        firedBullets.remove(uuid);
                    }
                });
            } catch (Exception ignored) {
            }
        }, 0L, 1L);
    }
}
