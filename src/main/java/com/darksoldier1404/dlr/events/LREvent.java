package com.darksoldier1404.dlr.events;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletHitedEvent;
import com.darksoldier1404.dlr.events.fire.BulletLaunchedEvent;
import com.darksoldier1404.dlr.utils.DamageUtils;
import com.darksoldier1404.dlr.utils.ParticleUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
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
                ParticleUtil.sphere(loc, 5, 15, Particle.SOUL_FIRE_FLAME);
                loc.getNearbyEntities(5, 5, 5).forEach(o -> {
                    if(o instanceof LivingEntity le && !(o instanceof Player)) {
                        try{
                            DamageUtils.damage(e.getArrow(), le);
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            });
        }catch (Exception ignored) {}
    }
}
