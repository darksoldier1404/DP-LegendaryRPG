package com.darksoldier1404.dlr.weapon.obj;

import com.darksoldier1404.dlr.weapon.obj.enums.WeaponType;
import org.bukkit.Material;

@SuppressWarnings("unused")
public interface Weapon {
    String getDisplayName();

    int getRequiredLevel();

    int getCurrentLevel();

    int getMaxLevel();

    double getCurrentExp();

    double getMaxExp();

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

    double getHeatDamage();

    double getToxinDamage();

    double getBlastDamage();

    double getCorrosiveDamage();

    double getGasDamage();

    double getMagneticDamage();

    double getRadiationDamage();

    double getVirusDamage();

    void setDisplayName(String displayName);

    void setRequiredLevel(int requiredLevel);

    void setCurrentLevel(int currentLevel);

    void setMaxLevel(int maxLevel);

    void setCurrentExp(double currentExp);

    void setMaxExp(double maxExp);

    void setMaterial(Material material);

    void setWeaponType(WeaponType weaponType);

    void setCriticalChance(byte criticalChance);

    void setCriticalAmount(double criticalAmount);

    void setStatusChance(byte statusChance);

    void setImpactDamage(double impactDamage);

    void setPunctureDamage(double punctureDamage);

    void setSlashDamage(double slashDamage);

    void setColdDamage(double coldDamage);

    void setElectricityDamage(double electricityDamage);

    void setHeatDamage(double heatDamage);

    void setToxinDamage(double toxinDamage);

    void setBlastDamage(double blastDamage);

    void setCorrosiveDamage(double corrosiveDamage);

    void setGasDamage(double gasDamage);

    void setMagneticDamage(double magneticDamage);

    void setRadiationDamage(double radiationDamage);

    void setVirusDamage(double virusDamage);

}
