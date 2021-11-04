package com.darksoldier1404.dlr.events;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.GunFireEvent;
import com.darksoldier1404.dlr.utils.ItemStackNBTUtil;
import com.darksoldier1404.dlr.utils.NBT;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@SuppressWarnings("all")
public class GunFireLogic implements Listener {
    private final Set<UUID> fired = new HashSet<>();
    private final Set<UUID> reloading = new HashSet<>();

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        if(NBT.hasTagKey(e.getItemDrop().getItemStack(), "fireRate")) {
            e.setCancelled(true);
            if (reloading.contains(e.getPlayer().getUniqueId())) return;
            ItemStack item = e.getItemDrop().getItemStack();
            float reloadTime = Float.parseFloat(NBT.getStringTag(item, "reloadTime").replace('"', ' ').trim());
            int magazineSize = Integer.parseInt(NBT.getStringTag(item, "magazineSize").replace('"', ' ').trim());
            reloading.add(e.getPlayer().getUniqueId());
            Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
                reloading.remove(e.getPlayer().getUniqueId());
                NBT.setTag(item, "currentMagazineSize", String.valueOf(magazineSize));
            }, (long) (20*reloadTime));
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        p.getPlayerProfile();


        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (e.getItem() == null) return;
            ItemStack item = e.getItem();
            if (NBT.hasTagKey(item, "fireRate")) {
                e.setCancelled(true);
                // if while reloading return
                if (reloading.contains(p.getUniqueId())) return;
                if (fired.contains(p.getUniqueId())) return;
                float bulletSpeed = Float.parseFloat(NBT.getStringTag(item, "bulletSpeed").replace('"', ' ').trim());
                float fireRate = Float.parseFloat(NBT.getStringTag(item, "fireRate").replace('"', ' ').trim());
                float bulletDeletionTime = Float.parseFloat(NBT.getStringTag(item, "bulletDeletionTime").replace('"', ' ').trim());
                float multiShot = Float.parseFloat(NBT.getStringTag(item, "multiShot").replace('"', ' ').trim());
                float accuracy = Float.parseFloat(NBT.getStringTag(item, "accuracy").replace('"', ' ').trim());
                int im = (int) multiShot;
                float imp = multiShot - im;
                // launch bullet
                for (int i = 0; i < im; i++) {
                    launchProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy);
                }
                if (imp > 0) {
                    if (Math.random() < imp) {
                        launchProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy);
                    }
                }
                // after launched bullet
                if (!((long) (20 / fireRate) == 0)) {
                    fired.add(p.getUniqueId());
                    Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> fired.remove(p.getUniqueId()), (long) (20 / fireRate));
                }
                p.playSound(p.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 0.6F, 1.6F);
                Bukkit.getPluginManager().callEvent(new GunFireEvent(p, p.getLocation()));
            }
        }
    }

    public void launchProjectile(Player p, ItemStack item, float bulletSpeed, float bulletDeletionTime, float ac) {
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
        });
    }
}
