package com.darksoldier1404.dlr.tasks;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletHitedEvent;
import net.minecraft.util.Tuple;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.scheduler.BukkitTask;

import java.util.Map;
import java.util.UUID;

public class BulletTask {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();
    private static BukkitTask bulletHitTask = null;
    private static BukkitTask bulletListTask = null;
    private static final Map<UUID, Tuple<BukkitTask, Arrow>> homingArrows = plugin.getHomingArrows();
    private static final Map<UUID, Arrow> firedArrows = plugin.getFiredArrows();

    public static void BulletListTask() {
        try {
            bulletListTask.cancel();
            bulletListTask = null;
        } catch (Exception ignored) {
        }
        bulletListTask = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            try {
                System.out.println("size of homingArrows : " + homingArrows.size());
                System.out.println("size of firedArrows : " + firedArrows.size());
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
                homingArrows.forEach((uuid, tuple) -> {
                    if (tuple.b().isOnGround()) {
                        tuple.a().cancel();
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(tuple.b()));
                        homingArrows.remove(uuid);
                        firedArrows.remove(uuid);
                    } else if (tuple.b().isDead()) {
                        tuple.a().cancel();
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(tuple.b()));
                        homingArrows.remove(uuid);
                        firedArrows.remove(uuid);
                    } else if (!tuple.b().isValid()) {
                        tuple.a().cancel();
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(tuple.b()));
                        homingArrows.remove(uuid);
                        firedArrows.remove(uuid);
                    }
                });
                firedArrows.forEach((uuid, arrow) -> {
                    if (arrow.isOnGround()) {
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(arrow));
                        homingArrows.remove(uuid);
                        firedArrows.remove(uuid);
                    }
                    if (arrow.isDead()) {
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(arrow));
                        homingArrows.remove(uuid);
                        firedArrows.remove(uuid);
                    }
                    if (!arrow.isValid()) {
                        plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(arrow));
                        homingArrows.remove(uuid);
                        firedArrows.remove(uuid);
                    }
                });
            } catch (Exception ignored) {
            }
        }, 0L, 1L);
    }
}
