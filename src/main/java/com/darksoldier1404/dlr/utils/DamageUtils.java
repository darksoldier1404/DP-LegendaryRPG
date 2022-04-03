package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.dEntity.obj.ElementalType;
import com.darksoldier1404.dlr.obj.WarDamage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("all")
public class DamageUtils {
    private final static Random rd = new Random();
    private final static LegendaryRPG plugin = LegendaryRPG.getInstance();

    public static void damage(WarDamage b, LivingEntity vic) {
        try {
            // physical damage
            Map<ElementalType, Double> damageTable = new HashMap<>();
            damageTable.put(ElementalType.IMPACT, b.getCurrentImpactDamage());
            damageTable.put(ElementalType.PUNCTURE, b.getCurrentPunctureDamage());
            damageTable.put(ElementalType.SLASH, b.getCurrentSlashDamage());
            // elemental damage
            damageTable.put(ElementalType.COLD, b.getCurrentColdDamage());
            damageTable.put(ElementalType.ELECTRICITY, b.getCurrentElectricityDamage());
            damageTable.put(ElementalType.HEAT, b.getCurrentHeatDamage());
            damageTable.put(ElementalType.TOXIN, b.getCurrentToxinDamage());
            // combined damage
            damageTable.put(ElementalType.BLAST, b.getCurrentBlastDamage());
            damageTable.put(ElementalType.CORROSIVE, b.getCurrentCorrosiveDamage());
            damageTable.put(ElementalType.GAS, b.getCurrentGasDamage());
            damageTable.put(ElementalType.MAGNETIC, b.getCurrentMagneticDamage());
            damageTable.put(ElementalType.RADIATION, b.getCurrentRadiationDamage());
            damageTable.put(ElementalType.VIRUS, b.getCurrentVirusDamage());

            float sc = b.getCurrentStatusChance();

            double impact = damageTable.get(ElementalType.IMPACT);
            double puncture = damageTable.get(ElementalType.PUNCTURE);
            double slash = damageTable.get(ElementalType.SLASH);

            double cold = damageTable.get(ElementalType.COLD);
            double electricity = damageTable.get(ElementalType.ELECTRICITY);
            double heat = damageTable.get(ElementalType.HEAT);
            double toxin = damageTable.get(ElementalType.TOXIN);

            double blast = damageTable.get(ElementalType.BLAST);
            double corrosive = damageTable.get(ElementalType.CORROSIVE);
            double gas = damageTable.get(ElementalType.GAS);
            double magnetic = damageTable.get(ElementalType.MAGNETIC);
            double radiation = damageTable.get(ElementalType.RADIATION);
            double virus = damageTable.get(ElementalType.VIRUS);

            double totalPhysicalDamage = impact + puncture + slash;
            double totalSingleElementalDamage = cold + electricity + heat + toxin;
            double totalCombinedElementalDamage = blast + corrosive + gas + magnetic + radiation + virus;
            double totalDamage = totalPhysicalDamage + totalSingleElementalDamage + totalCombinedElementalDamage;

            ElementalType mainType = ElementalType.SLASH;
            ElementalType additionalType;

            if (impact > puncture && impact > slash) {
                mainType = ElementalType.IMPACT;
            }
            if (puncture > impact && puncture > slash) {
                mainType = ElementalType.PUNCTURE;
            }
            if (slash > impact && slash > puncture) {
                mainType = ElementalType.SLASH;
            }

            float criticalChance = b.getCurrentCriticalChance();
            float criticalAmount = b.getCurrentCriticalAmount();
            boolean isCritical = false;
            int loop = (int) (criticalChance * 0.01);
            if (loop != 0) {
                totalPhysicalDamage *= criticalAmount + loop;
                criticalChance = criticalChance - (loop * 100);
            }
            if (Math.random() * 100 < criticalChance) {
                totalPhysicalDamage *= criticalAmount;
                isCritical = true;
            }
            double finalDamage = totalPhysicalDamage;
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
