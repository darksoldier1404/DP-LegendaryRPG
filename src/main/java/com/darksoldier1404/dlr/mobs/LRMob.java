package com.darksoldier1404.dlr.mobs;

import com.darksoldier1404.dlr.obj.WarDamageable;
import org.bukkit.entity.EntityType;
/*
Name: "Kuva"

DisplayName: "&f[ &6그리니어 &f] &f&l쿠바 렌서 &f[ &6LV.<level> &f]"
EntityType: ZOMBIE

DropTable:
  TestItem1:
    DropChance: 20
    DropSize: 1-3
  TestItem2:
    DropChance: 20
    DropSize: 1-3
  TestItem3:
    DropChance: 20
    DropSize: 1-3
  TestItem4:
    DropChance: 20
    DropSize: 1-3

Health: 350
Shield: 0
Armor: 8
Damage: 5
DropExp: 100
 */
@SuppressWarnings("all")
public interface LRMob extends WarDamageable {
    String getName();
    EntityType getEntityType();
    String getDisplayName();
    int getMinLevel();
    int getCurrentLevel();
    int getMaxLevel();
    double getMinDropExp();
    double getCurrentDropExp();
    double getDropExpPerLevel();

    void setName(String name);
    void setEntityType(EntityType entityType);
    void setDisplayName(String displayName);
    void setMinLevel(int minLevel);
    void setCurrentLevel(int currentLevel);
    void setMaxLevel(int maxLevel);
    void setMinDropExp(double minDropExp);
    void setCurrentDropExp(double currentDropExp);
    void setDropExpPerLevel(double dropExpPerLevel);


}
