package com.darksoldier1404.dlr.events.damage;

import com.darksoldier1404.dlr.LegendaryRPG;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

import java.util.Random;

public class EntityGetDamageEvent implements Listener {
    private final Random rd = new Random();
    private final LegendaryRPG plugin = LegendaryRPG.getInstance();

    @EventHandler
    public void onEntityGetDamageByEntity(EntityDamageByEntityEvent e) {
        e.setCancelled(true);
        if (e.getEntity() instanceof Player) return;
        if (e.getEntity() instanceof LivingEntity le) {
            Bukkit.getScheduler().runTask(plugin, () -> le.setNoDamageTicks(0));
            if (e.getDamager() instanceof Arrow ar) {
                if (!ar.hasMetadata("damage")) return;
                double damage = ar.getMetadata("damage").get(0).asDouble();
                float criticalChance = ar.getMetadata("criticalChance").get(0).asFloat();
                float criticalAmount = ar.getMetadata("criticalAmount").get(0).asFloat();
                boolean isCritical = false;
                ar.remove();
                int loop = (int) (criticalChance * 0.01);
                if (loop != 0) {
                    damage *= criticalAmount + loop;
                    criticalChance = criticalChance - (loop * 100);
                }
                if (Math.random() * 100 < criticalChance) {
                    damage *= criticalAmount;
                    isCritical = true;
                }
                le.setHealth(Math.max(0, le.getHealth() - damage));
                le.setCustomNameVisible(true);
                le.setCustomName("체력 : " + (int) le.getHealth());
                damageCounter(le, damage, loop, isCritical);
            }
        }
    }

    public void damageCounter(LivingEntity le, double damage, int loop, boolean isCritical) {
        double x = rd.nextDouble();
        double y = rd.nextDouble();
        double z = rd.nextDouble();
        Location loc = le.getLocation();
        loc.add(-0.5 + x, 1.8 + y, -0.5 + z);
        Item dc = le.getWorld().dropItem(loc, new ItemStack(Material.DIAMOND_SWORD));
        if (loop == 0) {
            if (isCritical) {
                dc.setCustomName("§o§l§c" + (int) damage);
            }else {
                dc.setCustomName("§o§l" + (int) damage);
            }
        } else if (loop == 1) {
            dc.setCustomName("§o§l§c" + (int) damage);
        } else if (loop == 2) {
            dc.setCustomName("§o§l§4" + (int) damage);
        } else {
            dc.setCustomName("§o§l§5" + (int) damage);
        }
        dc.setCustomNameVisible(true);
        dc.setVelocity(new Vector(0, 0.2, 0));
        dc.setMetadata("dc", new FixedMetadataValue(plugin, true));
        Bukkit.getScheduler().runTaskLater(plugin, dc::remove, 10L);
    }

}
