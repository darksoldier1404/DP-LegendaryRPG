package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.dEntity.mobs.LRMobImpl;
import com.darksoldier1404.dlr.dEntity.obj.ElementalType;
import com.darksoldier1404.dlr.obj.WarDamage;
import com.darksoldier1404.dlr.obj.WarDamageable;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
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
            if (!LRMobUtils.isLRMob(vic.getUniqueId())) return;
            if (b == null) return;
            LRMobImpl lrm = plugin.getSummonedLRMobs().get(vic.getUniqueId());
            // physical damage
            Map<ElementalType, Double> damageTable = new HashMap<>();
            damageTable.put(ElementalType.IMPACT, b.getDefaultImpactDamage());
            damageTable.put(ElementalType.PUNCTURE, b.getDefaultPunctureDamage());
            damageTable.put(ElementalType.SLASH, b.getDefaultSlashDamage());
            // elemental damage
            damageTable.put(ElementalType.COLD, b.getDefaultColdDamage());
            damageTable.put(ElementalType.ELECTRICITY, b.getDefaultElectricityDamage());
            damageTable.put(ElementalType.HEAT, b.getDefaultHeatDamage());
            damageTable.put(ElementalType.TOXIN, b.getDefaultToxinDamage());
            // combined damage
            damageTable.put(ElementalType.BLAST, b.getDefaultBlastDamage());
            damageTable.put(ElementalType.CORROSIVE, b.getDefaultCorrosiveDamage());
            damageTable.put(ElementalType.GAS, b.getDefaultGasDamage());
            damageTable.put(ElementalType.MAGNETIC, b.getDefaultMagneticDamage());
            damageTable.put(ElementalType.RADIATION, b.getDefaultRadiationDamage());
            damageTable.put(ElementalType.VIRUS, b.getDefaultVirusDamage());

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

            float criticalChance = b.getDefaultCriticalChance();
            float criticalAmount = b.getDefaultCriticalAmount();
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
            final double totalDamage = totalPhysicalDamage + totalSingleElementalDamage + totalCombinedElementalDamage;
            lrm.setCurrentHealth(lrm.getCurrentHealth() - totalDamage);
            if (lrm.getCurrentHealth() <= 0) {
                vic.setHealth(0);
                vic.remove();
                plugin.getSummonedLRMobs().remove(lrm);
            } else {
                Bukkit.getScheduler().runTask(plugin, () -> {
                    lrm.updateName();
                    System.out.println(lrm.getUuid());
                });
                damageCounter(vic, totalDamage, loop, isCritical);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void damage(WarDamageable entity, ElementalType type, double damage) {
        switch (type) {
            case IMPACT:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultImpactResistance()));
                break;
            case PUNCTURE:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultPunctureResistance()));
                break;
            case SLASH:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultSlashResistance()));
                break;
            case COLD:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultColdResistance()));
                break;
            case ELECTRICITY:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultElectricityResistance()));
                break;
            case HEAT:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultHeatResistance()));
                break;
            case TOXIN:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultToxinResistance()));
                break;
            case BLAST:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultBlastResistance()));
                break;
            case CORROSIVE:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultCorrosiveResistance()));
                break;
            case GAS:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultGasResistance()));
                break;
            case MAGNETIC:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultMagneticResistance()));
                break;
            case RADIATION:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultRadiationResistance()));
                break;
            case VIRUS:
                entity.setCurrentHealth(entity.getCurrentHealth() - (damage - entity.getDefaultVirusResistance()));
                break;
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
