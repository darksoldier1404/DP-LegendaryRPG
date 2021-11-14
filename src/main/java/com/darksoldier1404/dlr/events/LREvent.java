package com.darksoldier1404.dlr.events;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletHitedEvent;
import com.darksoldier1404.dlr.events.fire.BulletLaunchedEvent;
import com.darksoldier1404.dlr.utils.DamageUtils;
import com.darksoldier1404.dlr.utils.ParticleUtil;
import org.bukkit.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

public class LREvent implements Listener {
    private final LegendaryRPG plugin = LegendaryRPG.getInstance();

    @EventHandler
    public void onMobSpawned(EntitySpawnEvent e) {
        if (e.getEntity() instanceof LivingEntity le) {
            le.setCustomNameVisible(true);
        }
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        if (e.getItem().hasMetadata("dc")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onOpenInventory(InventoryOpenEvent e) {
        if (e.getInventory().getType() == InventoryType.ANVIL) {
            Inventory inv = e.getInventory();
            inv.setItem(0, new ItemStack(Material.STICK));
            inv.setItem(1, new ItemStack(Material.DIAMOND));
            inv.setItem(2, new ItemStack(Material.DIAMOND_SWORD));
        }
    }

    @EventHandler
    public void onBulletFired(BulletLaunchedEvent e) {
        plugin.getFiredArrows().put(e.getBullet().getUniqueId(), e.getBullet());
    }

    @EventHandler
    public void onBulletHit(BulletHitedEvent e) {
        try {
            // todo :  렉 해결하기
            Location loc = e.getLastLocation();
            Arrow ar = e.getArrow();
            if (ar.hasMetadata("isExplosiveBullet")) {
                if (ar.getMetadata("isExplosiveBullet").get(0).asBoolean()) {
                    // get explosion range from arrow as float
                    float range = ar.getMetadata("explosionRange").get(0).asFloat();
                    ParticleUtil.sphere(loc, range, 15, Particle.CRIT);
                    loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 0.6F, 1.4F);
                    loc.getNearbyEntities(range, range, range).forEach(o -> {
                        if (o instanceof LivingEntity le && !(o instanceof Player)) {
                            try {
                                DamageUtils.damage(ar, le);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                }
            }
            if (ar.hasMetadata("isElectricBullet")) {
                if (ar.getMetadata("isElectricBullet").get(0).asBoolean()) {
                    final Map<UUID, HashSet<UUID>> alreadyChained = new HashMap<>();
                    Location cl = loc.clone();
                    float range = ar.getMetadata("chainRange").get(0).asFloat();
                    float maxRange = ar.getMetadata("maxChainRange").get(0).asFloat();
                    HashSet<LivingEntity> list = new HashSet<>();
                    cl.getNearbyEntities(maxRange, maxRange, maxRange).forEach(o -> {
                        if (o instanceof LivingEntity le && !(o instanceof Player)) {
                            list.add((LivingEntity) o);
                        }
                    });
                    // get nearest entity from loc in list in range
                    int maxTarget = 10;
                    LivingEntity nearest = null;
                    for (int i = 0; i < maxTarget; i++) {
                        double nearestDistance = Double.MAX_VALUE;
                        for (LivingEntity le : list) {
                            if(!alreadyChained.containsKey(le.getUniqueId())) {
                                double distance = le.getLocation().distance(cl);
                                if (distance < nearestDistance && distance < range) {
                                    nearest = le;
                                    nearestDistance = distance;
                                }
                            }
                        }
                        if(nearest != null) {
                            if (!alreadyChained.containsKey(nearest.getUniqueId())) {
                                alreadyChained.put(nearest.getUniqueId(), new HashSet<>());
                                DamageUtils.damage(ar, nearest);
                                ParticleUtil.line(cl, nearest.getLocation(), 0.1F, Particle.SOUL_FIRE_FLAME, 0, 0, 0, 0, 0);
                                cl = nearest.getLocation();
                            }
                        }
                    }
                    alreadyChained.clear();
                }
            }
        } catch (Exception ignored) {
        }
    }
}
