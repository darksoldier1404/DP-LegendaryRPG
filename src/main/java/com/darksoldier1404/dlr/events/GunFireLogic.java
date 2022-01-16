package com.darksoldier1404.dlr.events;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletLaunchedEvent;
import com.darksoldier1404.dlr.events.fire.GunFireEvent;
import com.darksoldier1404.dlr.utils.ItemStackNBTUtil;
import com.darksoldier1404.dlr.weapon.obj.enums.BulletType;
import com.darksoldier1404.dlr.weapon.obj.gun.bullets.Bullet;
import com.darksoldier1404.duc.utils.NBT;
import com.darksoldier1404.duc.utils.Tuple;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.*;

@SuppressWarnings("all")
public class GunFireLogic implements Listener {
    private final LegendaryRPG plugin = LegendaryRPG.getInstance();
    private final Set<UUID> fired = new HashSet<>();
    private final Set<UUID> reloading = new HashSet<>();
    private final Map<UUID, Tuple<BukkitTask, Arrow>> homingBullets = plugin.getHomingBullets();
    private final Random rnd = new Random();


    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        if (NBT.hasTagKey(e.getItemDrop().getItemStack(), "fireRate")) {
            e.setCancelled(true);
            if (reloading.contains(e.getPlayer().getUniqueId())) return;
            ItemStack item = e.getItemDrop().getItemStack();
            float reloadTime = Float.parseFloat(NBT.getStringTag(item, "reloadTime"));
            int magazineSize = Integer.parseInt(NBT.getStringTag(item, "magazineSize"));
            reloading.add(e.getPlayer().getUniqueId());
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                reloading.remove(e.getPlayer().getUniqueId());
                NBT.setStringTag(item, "currentMagazineSize", String.valueOf(magazineSize));
            }, (long) (20 * reloadTime));
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) { // TODO: 최적화 진행
        Player p = e.getPlayer();
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (e.getItem() == null) return;
            ItemStack item = e.getItem();
            if (NBT.hasTagKey(item, "fireRate")) {
                e.setCancelled(true);
                // if while reloading return
                if (reloading.contains(p.getUniqueId())) return;
                if (fired.contains(p.getUniqueId())) return;
                Bukkit.getScheduler().runTask(plugin, () -> {
                    BulletType bulletType = BulletType.valueOf(NBT.getStringTag(item, "bulletType"));
                    float bulletSpeed = NBT.getFloatTag(item, "bulletSpeed");
                    float fireRate = NBT.getFloatTag(item, "fireRate");
                    float bulletDeletionTime = NBT.getFloatTag(item, "bulletDeletionTime");
                    float multiShot = NBT.getFloatTag(item, "multiShot");
                    float accuracy = NBT.getFloatTag(item, "accuracy");
                    int im = (int) multiShot;
                    float imp = multiShot - im;

                    List<LivingEntity> les = new ArrayList<>();
                    if (bulletType == BulletType.HOMING) {
                        for (Entity ne : p.getNearbyEntities(70, 70, 70)) {
                            if (ne instanceof LivingEntity) {
                                les.add((LivingEntity) ne);
                            }
                        }
                    }
                    for (int i = 0; i < im; i++) {
                        if (bulletType == BulletType.HOMING) {
                            launchHomingProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy, les);
                            continue;
                        }
                        launchProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy);
                    }
                    if (imp > 0) {
                        if (Math.random() < imp) {
                            if (bulletType == BulletType.HOMING) {
                                launchHomingProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy, les);
                            } else {
                                launchProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy);
                            }
                        }
                    }
                    // after launched bullet
                    if (!((long) (20 / fireRate) == 0)) {
                        fired.add(p.getUniqueId());
                        Bukkit.getScheduler().runTaskLater(plugin, () -> fired.remove(p.getUniqueId()), (long) (20 / fireRate));
                    }
                    p.playSound(p.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 0.6F, 1.6F);
                    Bukkit.getPluginManager().callEvent(new GunFireEvent(p, item));
                });
            }
        }
    }

    private void setMetadata(Arrow ar, ItemStack item, double damage) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            Bullet b = new Bullet(ar.getUniqueId());
            b.setCriticalChance(NBT.getFloatTag(item, "currentCriticalChance"));
            b.setCriticalAmount(NBT.getFloatTag(item, "currentCriticalAmount"));
            b.setImpactDamage(NBT.getDoubleTag(item, "currentImpactDamage"));
            b.setPunctureDamage(NBT.getDoubleTag(item, "currentPunctureDamage"));
            b.setSlashDamage(NBT.getDoubleTag(item, "currentSlashDamage"));
            b.setColdDamage(NBT.getDoubleTag(item, "currentColdDamage"));
            b.setElectricityDamage(NBT.getDoubleTag(item, "currentElectricityDamage"));
            b.setHeatDamage(NBT.getDoubleTag(item, "currentHeatDamage"));
            b.setToxinDamage(NBT.getDoubleTag(item, "currentToxinDamage"));
            b.setBlastDamage(NBT.getDoubleTag(item, "currentBlastDamage"));
            b.setCorrosiveDamage(NBT.getDoubleTag(item, "currentCorrosiveDamage"));
            b.setGasDamage(NBT.getDoubleTag(item, "currentGasDamage"));
            b.setMagneticDamage(NBT.getDoubleTag(item, "currentMagneticDamage"));
            b.setRadiationDamage(NBT.getDoubleTag(item, "currentRadiationDamage"));
            b.setVirusDamage(NBT.getDoubleTag(item, "currentVirusDamage"));
            // bullet type
            // homing
            if (NBT.getStringTag(item, "isHomingBullet").equals("true")) {
                b.setHomingBullet(true);
                b.setStartHomingDelay(NBT.getFloatTag(item, "startHomingDelay"));
            }
            // electric
            if (NBT.getStringTag(item, "isElectricBullet").equals("true")) {
                b.setElectricBullet(true);
                b.setChainRange(NBT.getFloatTag(item, "chainRange"));
                b.setMaxChainRange(NBT.getFloatTag(item, "maxChainRange"));
                b.setChainDamage(NBT.getDoubleTag(item, "chainDamage"));
            }
            // gravity
            if (NBT.getStringTag(item, "isGravityBullet").equals("true")) {
                b.setGravityBullet(true);
                b.setGravityRange(NBT.getFloatTag(item, "gravityRange"));
                b.setGravityDuration(NBT.getFloatTag(item, "gravityDuration"));
                b.setGravityPower(NBT.getFloatTag(item, "gravityPower"));
                b.setGravityDamage(NBT.getDoubleTag(item, "gravityDamage"));
                b.setReversal(NBT.getStringTag(item, "isReversal").equals("true"));
            }
            // explosive
            if (NBT.getStringTag(item, "isExplosiveBullet").equals("true")) {
                b.setExplosiveBullet(true);
                b.setExplosionRange(NBT.getFloatTag(item, "explosionRange"));
                b.setExplosionDamage(NBT.getDoubleTag(item, "explosionDamage"));
                b.setExplosionKnockBack(NBT.getFloatTag(item, "explosionKnockBack"));
            }
            // stray
            if (NBT.getStringTag(item, "isStrayBullet").equals("true")) {
                b.setStrayBullet(true);
                b.setStrayExplosionRange(NBT.getFloatTag(item, "strayRange"));
                b.setStrayExplosionDamage(NBT.getDoubleTag(item, "strayDamage"));
                b.setStrayExplosionKnockBack(NBT.getFloatTag(item, "strayKnockBack"));
                b.setStrayExplosionDelay(NBT.getLongTag(item, "strayExplosionDelay"));
            }
            // harpoon
            if (NBT.getStringTag(item, "isHarpoonBullet").equals("true")) {
                b.setHarpoonBullet(true);
                b.setHarpoonGrabRange(NBT.getFloatTag(item, "harpoonGrabRange"));
                b.setHarpoonPullRange(NBT.getFloatTag(item, "harpoonPullRange"));
                b.setHarpoonDamage(NBT.getDoubleTag(item, "harpoonDamage"));
            }
            plugin.getFBOBJ().put(ar.getUniqueId(), b);
        });
    }

    private void launchProjectile(Player p, ItemStack item, float bulletSpeed, float bulletDeletionTime, float ac) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            Arrow bullet = p.launchProjectile(Arrow.class);
            bullet.setVelocity(p.getLocation().getDirection().multiply(bulletSpeed));
            bullet.setPickupStatus(AbstractArrow.PickupStatus.CREATIVE_ONLY);
            double damage = ItemStackNBTUtil.getTotalDamage(item);
            // Using random variables, the closer the accuracy is to 100, the more the vectors x, y, and z spread.
            double spread = ac / 100;
            double x = Math.random() * spread - (spread / 2);
            double y = Math.random() * spread - (spread / 2);
            double z = Math.random() * spread - (spread / 2);
            bullet.setVelocity(bullet.getVelocity().add(new Vector(x, y, z)));
            setMetadata(bullet, item, damage);
            //todo 상태이상 추가
            Bukkit.getScheduler().runTaskLater(plugin, () -> bullet.remove(), (long) (20 * bulletDeletionTime));
            Bukkit.getScheduler().runTaskLater(plugin, () -> plugin.getFBOBJ().remove(bullet.getUniqueId()), (long) (20 * bulletDeletionTime));
            Bukkit.getPluginManager().callEvent(new BulletLaunchedEvent(p, item, bullet));
        });
    }

    private void launchHomingProjectile(Player p, ItemStack item, float bulletSpeed, float bulletDeletionTime, float ac, List<LivingEntity> les) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            Arrow bullet = p.launchProjectile(Arrow.class);
            bullet.setVelocity(p.getLocation().getDirection().multiply(bulletSpeed));
            bullet.setPickupStatus(AbstractArrow.PickupStatus.CREATIVE_ONLY);
            double damage = ItemStackNBTUtil.getTotalDamage(item);
            // Using random variables, the closer the accuracy is to 100, the more the vectors x, y, and z spread.
            double spread = ac / 100;
            double x = Math.random() * spread - (spread / 2);
            double y = Math.random() * spread - (spread / 2);
            double z = Math.random() * spread - (spread / 2);
            bullet.setVelocity(bullet.getVelocity().add(new Vector(x, y + 0.7, z)));
            setMetadata(bullet, item, damage);
            //todo 상태이상 추가
            try {
                LivingEntity le = les.get(new Random().nextInt(les.size()));
                homingBullets.put(bullet.getUniqueId(), new Tuple<>(Bukkit.getScheduler().runTaskTimer(plugin, () -> {
                    bullet.setVelocity(le.getLocation().toVector().subtract(bullet.getLocation().toVector()).normalize().multiply(bulletSpeed));
                }, 0, 10), bullet));
            } catch (Exception ignored) {
            }
            Bukkit.getScheduler().runTaskLater(plugin, () -> bullet.remove(), (long) (20 * bulletDeletionTime));
            Bukkit.getScheduler().runTaskLater(plugin, () -> plugin.getFBOBJ().remove(bullet.getUniqueId()), (long) (20 * bulletDeletionTime));
            Bukkit.getPluginManager().callEvent(new BulletLaunchedEvent(p, item, bullet));
        });
    }
}
