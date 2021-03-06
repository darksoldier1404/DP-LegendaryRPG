package com.darksoldier1404.dlr.weapon.obj;

import com.darksoldier1404.dlr.obj.WarDamage;
import com.darksoldier1404.dlr.weapon.obj.enums.WeaponType;
import org.bukkit.Material;

@SuppressWarnings("unused")
public interface Weapon extends WarDamage, Cloneable {
    String getDisplayName();

    int getRequireMasteryRank();

    int getCurrentLevel();

    int getMaxLevel();

    double getCurrentExp();

    double getMaxExp();

    Material getMaterial();

    WeaponType getWeaponType();

    void setDisplayName(String displayName);

    void setRequireMasteryRank(int requireMasteryRank);

    void setCurrentLevel(int currentLevel);

    void setMaxLevel(int maxLevel);

    void setCurrentExp(double currentExp);

    void setMaxExp(double maxExp);

    void setMaterial(Material material);

    void setWeaponType(WeaponType weaponType);

}
