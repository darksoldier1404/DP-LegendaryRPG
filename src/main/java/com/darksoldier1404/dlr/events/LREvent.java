package com.darksoldier1404.dlr.events;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletHitedEvent;
import com.darksoldier1404.dlr.events.fire.BulletLaunchedEvent;
import com.darksoldier1404.dlr.utils.DamageUtils;
import com.darksoldier1404.dlr.weapon.obj.gun.bullets.Bullet;
import com.darksoldier1404.duc.utils.ParticleUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("all")
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
    public void onBulletFired(BulletLaunchedEvent e) {
        plugin.getFiredBullets().put(e.getBullet().getUniqueId(), e.getBullet());
    }

    @EventHandler
    public void onBulletHit(BulletHitedEvent e) {
        try {
            // todo :  렉 해결하기
            Location loc = e.getLastLocation();
            Bullet b = plugin.getFBOBJ().get(e.getBullet().getUniqueId());
            e.getBullet().remove();
            if (b.isExplosiveBullet()) {
                // get explosion range from arrow as float
                float range = b.getExplosionRange();
                ParticleUtil.sphere(loc, range, 20, Particle.CRIT);
                loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 0.6F, 1.4F);
                loc.getWorld().getNearbyEntities(loc, range, range, range).forEach(o -> {
                    if (o instanceof LivingEntity le && !(o instanceof Player)) {
                        try {
                            Bukkit.getScheduler().runTask(plugin, () -> DamageUtils.damage(b, le));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
            if (b.isElectricBullet()) {
                final Map<UUID, HashSet<UUID>> alreadyChained = new HashMap<>();
                Location cl = loc.clone();
                float range = b.getChainRange();
                float maxRange = b.getMaxChainRange();
                HashSet<LivingEntity> list = new HashSet<>();
                cl.getWorld().getNearbyEntities(cl, maxRange, maxRange, maxRange).forEach(o -> {
                    if (o instanceof LivingEntity le && !(o instanceof Player)) {
                        list.add((LivingEntity) o);
                    }
                });
                // get nearest entity from loc in list in range
                int maxTarget = 100;
                LivingEntity nearest = null;
                for (int i = 0; i < maxTarget; i++) {
                    double nearestDistance = Double.MAX_VALUE;
                    for (LivingEntity le : list) {
                        if (!alreadyChained.containsKey(le.getUniqueId())) {
                            double distance = le.getLocation().distance(cl);
                            if (distance < nearestDistance && distance < range) {
                                nearest = le;
                                nearestDistance = distance;
                            }
                        }
                    }
                    if (nearest != null) {
                        if (!alreadyChained.containsKey(nearest.getUniqueId())) {
                            alreadyChained.put(nearest.getUniqueId(), new HashSet<>());
                            LivingEntity finalNearest = nearest;
                            Bukkit.getScheduler().runTask(plugin, () -> DamageUtils.damage(b, finalNearest));
                            Location finalCl = cl;
                            Bukkit.getScheduler().runTask(plugin, () -> ParticleUtil.line(finalCl, finalNearest.getLocation().add(0, 1, 0), 0.4F, Particle.SOUL_FIRE_FLAME, 0, 0, 0, 0, 0));
                            cl = nearest.getLocation();
                        }
                    }
                }
                alreadyChained.clear();
            }
            if (b.isGravityBullet()) {
                Location gl = loc.clone();
                float range = b.getGravityRange();
                float duration = b.getGravityDuration();
                float power = b.getGravityPower();
                BukkitTask task = Bukkit.getScheduler().runTaskTimer(plugin, () -> gl.getWorld().getNearbyEntities(gl, range, range, range).forEach(o -> {
                    if (o instanceof LivingEntity le && !(o instanceof Player)) {
                        Bukkit.getScheduler().runTask(plugin, () -> le.setVelocity(gl.toVector().subtract(le.getLocation().toVector()).normalize().multiply(power)));
                        Bukkit.getScheduler().runTask(plugin, () -> DamageUtils.damage(b, le));
                    }
                }), 0L, 5L);
                Bukkit.getScheduler().runTaskLater(plugin, task::cancel, (long) (duration * 20));
            }
            if (b.isStrayBullet()) {
                Location gl = loc.clone();
                float range = b.getStrayExplosionRange();
                float knockBack = b.getStrayExplosionKnockBack();
                long delay = b.getStrayExplosionDelay();
                Bukkit.getScheduler().runTaskLater(plugin, () -> gl.getWorld().getNearbyEntities(gl, range, range, range).forEach(o -> {
                    if (o instanceof LivingEntity le && !(o instanceof Player)) {
                        Bukkit.getScheduler().runTask(plugin, () -> le.setVelocity(le.getLocation().toVector().subtract(gl.toVector()).normalize().multiply(knockBack)));
                        Bukkit.getScheduler().runTask(plugin, () -> DamageUtils.damage(b, le));
                        Bukkit.getScheduler().runTask(plugin, () -> ParticleUtil.sphere(loc, range, 20, Particle.CRIT));
                        loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 0.6F, 1.4F);
                    }
                }), delay);
            }
            if (b.isHarpoonBullet()) {
                Location gl = loc.clone();
                float range = b.getHarpoonGrabRange();
                float pullRange = b.getHarpoonPullRange();
                double damage = b.getHarpoonDamage();
                //todo true damage logic
                Bukkit.getScheduler().runTask(plugin, () -> gl.getWorld().getNearbyEntities(gl, range, range, range).forEach(o -> {
                    if (o instanceof LivingEntity le && !(o instanceof Player)) {
                        Bukkit.getScheduler().runTask(plugin, () -> le.setVelocity(gl.toVector().subtract(le.getLocation().toVector()).normalize().multiply(2)));
                        Bukkit.getScheduler().runTask(plugin, () -> ParticleUtil.line(le.getLocation(), gl.add(0, 1, 0), 0.4F, Particle.ENCHANTMENT_TABLE, 0, 0, 0, 0, 0));
                        Bukkit.getScheduler().runTask(plugin, () -> DamageUtils.damage(b, le));
                        Bukkit.getScheduler().runTaskLater(plugin, () -> {
                            if (le.isValid()) {
                                Bukkit.getScheduler().runTask(plugin, () -> le.setVelocity(e.getShooter().getLocation().toVector().subtract(le.getLocation().toVector()).normalize().multiply(pullRange)));
                                Bukkit.getScheduler().runTask(plugin, () -> ParticleUtil.line(le.getLocation(), e.getShooter().getLocation().add(0, 1, 0), 0.4F, Particle.ENCHANTMENT_TABLE, 0, 0, 0, 0, 0));
                            }
                        }, 10L);
                    }
                }));
            }
        } catch (Exception ignored) {
        }
    }
}
