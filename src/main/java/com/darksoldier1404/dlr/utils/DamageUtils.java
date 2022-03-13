package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.weapon.obj.gun.bullets.Bullet;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

import java.util.Random;

@SuppressWarnings("all")
public class DamageUtils {
    private final static Random rd = new Random();
    private final static LegendaryRPG plugin = LegendaryRPG.getInstance();

    public static void damage(Bullet b, LivingEntity vic) {
        try {
            // physical damage
            double impact = b.getCurrentImpactDamage();
            double puncture = b.getCurrentPunctureDamage();
            double slash = b.getCurrentSlashDamage();
            // elemental damage
            double cold = b.getCurrentColdDamage();
            double electric = b.getCurrentElectricityDamage();
            double heat = b.getCurrentHeatDamage();
            double toxin = b.getCurrentToxinDamage();
            // combined damage
            double blast = b.getCurrentBlastDamage();
            double corrosive = b.getCurrentCorrosiveDamage();
            double gas = b.getCurrentGasDamage();
            double magnetic = b.getCurrentMagneticDamage();
            double radiation = b.getCurrentRadiationDamage();
            double virus = b.getCurrentVirusDamage();

            float sc = b.getCurrentStatusChance();

            double damage = impact + puncture + slash;

            float criticalChance = b.getCurrentCriticalChance();
            float criticalAmount = b.getCurrentCriticalAmount();
            boolean isCritical = false;
            int loop = (int) (criticalChance * 0.01);
            if (loop != 0) {
                damage *= criticalAmount + loop;
                criticalChance = criticalChance - (loop * 100);
            }
            if (Math.random() * 100 < criticalChance) {
                damage *= criticalAmount;
                isCritical = true;
            }
            double finalDamage = damage;
            Bukkit.getScheduler().runTask(plugin, () -> {
                vic.setHealth(Math.max(0, vic.getHealth() - finalDamage));
                vic.setCustomName("체력 : " + (int) vic.getHealth());
            });

//            damageCounter(vic, damage, loop, isCritical);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void damageCounter(LivingEntity le, double damage, int loop, boolean isCritical) {
        double x = rd.nextDouble();
        double y = rd.nextDouble();
        double z = rd.nextDouble();
        Location loc = le.getLocation();
        loc.add(-0.5 + x, 1.8 + y, -0.5 + z);
        Item dc = le.getWorld().dropItem(loc, new ItemStack(Material.DIAMOND_SWORD));
        if (loop == 0) {
            if (isCritical) {
                dc.setCustomName("§o§l§c" + (int) damage);
            } else {
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
