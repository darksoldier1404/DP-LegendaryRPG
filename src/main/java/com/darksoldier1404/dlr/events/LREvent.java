package com.darksoldier1404.dlr.events;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletHitedEvent;
import com.darksoldier1404.dlr.events.fire.BulletLaunchedEvent;
import com.darksoldier1404.dlr.utils.DamageUtils;
import com.darksoldier1404.dlr.utils.NBT;
import com.darksoldier1404.dlr.utils.ParticleUtil;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LREvent implements Listener {
    private final LegendaryRPG plugin = LegendaryRPG.getInstance();

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        if(e.getItem().hasMetadata("dc")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onOpenInventory(InventoryOpenEvent e) {
        if(e.getInventory().getType() == InventoryType.ANVIL) {
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
        try{
            // todo :  렉 해결하기
            Bukkit.getScheduler().runTask(LegendaryRPG.getInstance(), () -> {
                Location loc = e.getLastLocation();
                if(e.getArrow().hasMetadata("isExplosiveBullet")) {
                    if (e.getArrow().getMetadata("isExplosiveBullet").get(0).asBoolean()) {
                        // get explosion range from arrow as float
                        float range = e.getArrow().getMetadata("explosionRange").get(0).asFloat();
                        ParticleUtil.sphere(loc, range, 15, Particle.SOUL_FIRE_FLAME);
                        ParticleUtil.createParticle(Particle.EXPLOSION_NORMAL, loc, range, range, range, 0, 0);
                        loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 0.6F, 1.4F);
                        loc.getNearbyEntities(range, range, range).forEach(o -> {
                            if(o instanceof LivingEntity le && !(o instanceof Player)) {
                                try{
                                    DamageUtils.damage(e.getArrow(), le);
                                }catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                    }
                }
            });
        }catch (Exception ignored) {}
    }
}
