package com.darksoldier1404.dlr.weapon.obj;

import com.darksoldier1404.dlr.weapon.obj.enums.WeaponType;
import org.bukkit.Material;

public interface Weapon {
    String getDisplayName();

    int getRequiredLevel();

    Material getMaterial();

    WeaponType getWeaponType();

    byte getCriticalChance();

    double getCriticalAmount();

    byte getStatusChance();

    double getImpactDamage();

    double getPunctureDamage();

    double getSlashDamage();

    double getColdDamage();

    double getElectricityDamage();

    double HeatDamage();

    double getToxinDamage();

    double getBlastDamage();

    double getCorrosiveDamage();

    double getGasDamage();

    double getMagneticDamage();

    double getRadiationDamage();

    double getVirusDamage();


}
