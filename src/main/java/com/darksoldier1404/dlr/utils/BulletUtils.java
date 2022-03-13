package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletLaunchedEvent;
import com.darksoldier1404.dlr.weapon.obj.gun.bullets.Bullet;
import com.darksoldier1404.dppc.utils.NBT;
import com.darksoldier1404.dppc.utils.Tuple;
import org.bukkit.Bukkit;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@SuppressWarnings("all")
public class BulletUtils {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();
    private static final Map<UUID, Tuple<BukkitTask, Arrow>> homingBullets = plugin.getHomingBullets();

    public static void setMetadata(Arrow ar, ItemStack item, double damage) {
        Bukkit.getScheduler().runTask(plugin, () -> {
            Bullet b = new Bullet(ar.getUniqueId());
//            b.setCriticalChance(NBT.getFloatTag(item, "currentCriticalChance"));
//            b.setCriticalAmount(NBT.getFloatTag(item, "currentCriticalAmount"));
//            b.setImpactDamage(NBT.getDoubleTag(item, "currentImpactDamage"));
//            b.setPunctureDamage(NBT.getDoubleTag(item, "currentPunctureDamage"));
//            b.setSlashDamage(NBT.getDoubleTag(item, "currentSlashDamage"));
//            b.setColdDamage(NBT.getDoubleTag(item, "currentColdDamage"));
//            b.setElectricityDamage(NBT.getDoubleTag(item, "currentElectricityDamage"));
//            b.setHeatDamage(NBT.getDoubleTag(item, "currentHeatDamage"));
//            b.setToxinDamage(NBT.getDoubleTag(item, "currentToxinDamage"));
//            b.setBlastDamage(NBT.getDoubleTag(item, "currentBlastDamage"));
//            b.setCorrosiveDamage(NBT.getDoubleTag(item, "currentCorrosiveDamage"));
//            b.setGasDamage(NBT.getDoubleTag(item, "currentGasDamage"));
//            b.setMagneticDamage(NBT.getDoubleTag(item, "currentMagneticDamage"));
//            b.setRadiationDamage(NBT.getDoubleTag(item, "currentRadiationDamage"));
//            b.setVirusDamage(NBT.getDoubleTag(item, "currentVirusDamage"));
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
            // cluster
            if (NBT.getStringTag(item, "isClusterBullet").equals("true")) {
                b.setClusterBullet(true);
                b.setClusterExplosionRange(NBT.getFloatTag(item, "clusterExplosionRange"));
                b.setClusterExplosionDamage(NBT.getDoubleTag(item, "clusterExplosionDamage"));
                b.setClusterAmount(NBT.getIntegerTag(item, "clusterAmount"));
                b.setClusterDamage(NBT.getDoubleTag(item, "clusterDamage"));
            }
            // remoteExplosive
            if (NBT.getStringTag(item, "isRemoteExplosiveBullet").equals("true")) {
                b.setRemoteExplosiveBullet(true);
                b.setRemoteExplosionRange(NBT.getFloatTag(item, "remoteExplosionRange"));
                b.setRemoteExplosiveDuration(NBT.getFloatTag(item, "remoteExplosiveDuration"));
                b.setRemoteExplosionDamage(NBT.getDoubleTag(item, "remoteExplosionDamage"));
                b.setRemoteExplosionKnockBack(NBT.getFloatTag(item, "remoteExplosionKnockBack"));
            }
            plugin.getFBOBJ().put(ar.getUniqueId(), b);
        });
    }

    public static void launchProjectile(Player p, ItemStack item, float bulletSpeed, float bulletDeletionTime, float ac) {
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
            Bukkit.getScheduler().runTaskLater(plugin, bullet::remove, (long) (20 * bulletDeletionTime));
            Bukkit.getScheduler().runTaskLater(plugin, () -> plugin.getFBOBJ().remove(bullet.getUniqueId()), (long) (20 * bulletDeletionTime));
            Bukkit.getPluginManager().callEvent(new BulletLaunchedEvent(p, item, bullet));
        });
    }

    public static void launchHomingProjectile(Player p, ItemStack item, float bulletSpeed, float bulletDeletionTime, float ac, List<LivingEntity> les) {
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
            Bukkit.getScheduler().runTaskLater(plugin, bullet::remove, (long) (20 * bulletDeletionTime));
            Bukkit.getScheduler().runTaskLater(plugin, () -> plugin.getFBOBJ().remove(bullet.getUniqueId()), (long) (20 * bulletDeletionTime));
            Bukkit.getPluginManager().callEvent(new BulletLaunchedEvent(p, item, bullet));
        });
    }
}
