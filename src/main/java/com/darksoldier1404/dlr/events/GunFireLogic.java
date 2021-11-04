package com.darksoldier1404.dlr.events;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletLaunchedEvent;
import com.darksoldier1404.dlr.events.fire.GunFireEvent;
import com.darksoldier1404.dlr.utils.ItemStackNBTUtil;
import com.darksoldier1404.dlr.utils.NBT;
import com.darksoldier1404.dlr.weapon.obj.enums.BulletType;
import net.minecraft.util.Tuple;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.*;

@SuppressWarnings("all")
public class GunFireLogic implements Listener {
    private final Set<UUID> fired = new HashSet<>();
    private final Set<UUID> reloading = new HashSet<>();
    private final Map<UUID, Tuple<BukkitTask, Arrow>> homingArrows = LegendaryRPG.getInstance().getHomingArrows();
    private final Random rnd = new Random();


    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        if (NBT.hasTagKey(e.getItemDrop().getItemStack(), "fireRate")) {
            e.setCancelled(true);
            if (reloading.contains(e.getPlayer().getUniqueId())) return;
            ItemStack item = e.getItemDrop().getItemStack();
            float reloadTime = Float.parseFloat(NBT.getStringTag(item, "reloadTime").replace('"', ' ').trim());
            int magazineSize = Integer.parseInt(NBT.getStringTag(item, "magazineSize").replace('"', ' ').trim());
            reloading.add(e.getPlayer().getUniqueId());
            Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                reloading.remove(e.getPlayer().getUniqueId());
                NBT.setTag(item, "currentMagazineSize", String.valueOf(magazineSize));
            }, (long) (20 * reloadTime));
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (e.getItem() == null) return;
            ItemStack item = e.getItem();
            if (NBT.hasTagKey(item, "fireRate")) {
                e.setCancelled(true);
                // if while reloading return
                if (reloading.contains(p.getUniqueId())) return;
                if (fired.contains(p.getUniqueId())) return;

                BulletType bulletType = BulletType.valueOf(NBT.getStringTag(item, "bulletType").replace('"', ' ').trim());
                float bulletSpeed = Float.parseFloat(NBT.getStringTag(item, "bulletSpeed").replace('"', ' ').trim());
                float fireRate = Float.parseFloat(NBT.getStringTag(item, "fireRate").replace('"', ' ').trim());
                float bulletDeletionTime = Float.parseFloat(NBT.getStringTag(item, "bulletDeletionTime").replace('"', ' ').trim());
                float multiShot = Float.parseFloat(NBT.getStringTag(item, "multiShot").replace('"', ' ').trim());
                float accuracy = Float.parseFloat(NBT.getStringTag(item, "accuracy").replace('"', ' ').trim());
                int im = (int) multiShot;
                float imp = multiShot - im;

                List<LivingEntity> les = new ArrayList<>();
                for(Entity ne : p.getNearbyEntities(70, 70, 70)) {
                    if(ne instanceof LivingEntity) {
                        les.add((LivingEntity) ne);
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
                    Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> fired.remove(p.getUniqueId()), (long) (20 / fireRate));
                }
                p.playSound(p.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 0.6F, 1.6F);
                Bukkit.getPluginManager().callEvent(new GunFireEvent(p, item));
            }
        }
    }

    private void launchProjectile(Player p, ItemStack item, float bulletSpeed, float bulletDeletionTime, float ac) {
        Bukkit.getScheduler().runTask(LegendaryRPG.getInstance(), () -> {
            Arrow ar = p.launchProjectile(Arrow.class);
            ar.setVelocity(p.getLocation().getDirection().multiply(bulletSpeed));
            ar.setPickupStatus(AbstractArrow.PickupStatus.CREATIVE_ONLY);
            double damage = ItemStackNBTUtil.getTotalDamage(item);
            // Using random variables, the closer the accuracy is to 100, the more the vectors x, y, and z spread.
            double spread = ac / 100;
            double x = Math.random() * spread - (spread / 2);
            double y = Math.random() * spread - (spread / 2);
            double z = Math.random() * spread - (spread / 2);
            ar.setVelocity(ar.getVelocity().add(new Vector(x, y, z)));
            ar.setMetadata("damage", new FixedMetadataValue(LegendaryRPG.getInstance(), damage));
            // critical chance metadata
            ar.setMetadata("criticalChance", new FixedMetadataValue(LegendaryRPG.getInstance(), Float.parseFloat(NBT.getStringTag(item, "criticalChance").replace('"', ' ').trim())));
            // critical damage metadata
            ar.setMetadata("criticalAmount", new FixedMetadataValue(LegendaryRPG.getInstance(), Float.parseFloat(NBT.getStringTag(item, "criticalAmount").replace('"', ' ').trim())));
            //todo 상태이상 추가
            Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> ar.remove(), (long) (20 * bulletDeletionTime));
            Bukkit.getPluginManager().callEvent(new BulletLaunchedEvent(p, item));
        });
    }

    private void launchHomingProjectile(Player p, ItemStack item, float bulletSpeed, float bulletDeletionTime, float ac, List<LivingEntity> les) {
        Bukkit.getScheduler().runTask(LegendaryRPG.getInstance(), () -> {
            Arrow ar = p.launchProjectile(Arrow.class);
            ar.setVelocity(p.getLocation().getDirection().multiply(bulletSpeed));
            ar.setPickupStatus(AbstractArrow.PickupStatus.CREATIVE_ONLY);
            double damage = ItemStackNBTUtil.getTotalDamage(item);
            // Using random variables, the closer the accuracy is to 100, the more the vectors x, y, and z spread.
            double spread = ac / 100;
            double x = Math.random() * spread - (spread / 2);
            double y = Math.random() * spread - (spread / 2);
            double z = Math.random() * spread - (spread / 2);
            ar.setVelocity(ar.getVelocity().add(new Vector(x, y+2, z)));
            ar.setMetadata("damage", new FixedMetadataValue(LegendaryRPG.getInstance(), damage));
            // critical chance metadata
            ar.setMetadata("criticalChance", new FixedMetadataValue(LegendaryRPG.getInstance(), Float.parseFloat(NBT.getStringTag(item, "criticalChance").replace('"', ' ').trim())));
            // critical damage metadata
            ar.setMetadata("criticalAmount", new FixedMetadataValue(LegendaryRPG.getInstance(), Float.parseFloat(NBT.getStringTag(item, "criticalAmount").replace('"', ' ').trim())));
            //todo 상태이상 추가


            LivingEntity le = les.get(new Random().nextInt(les.size()));

            homingArrows.put(ar.getUniqueId(), new Tuple<>(Bukkit.getScheduler().runTaskTimer(LegendaryRPG.getInstance(), () -> {
                ar.setVelocity(le.getLocation().toVector().subtract(ar.getLocation().toVector()).normalize().multiply(bulletSpeed));
                //
            }, 10, 2), ar));
            Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> ar.remove(), (long) (20 * bulletDeletionTime));
            Bukkit.getPluginManager().callEvent(new BulletLaunchedEvent(p, item));
        });
    }
}