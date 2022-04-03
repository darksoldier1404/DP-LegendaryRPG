package com.darksoldier1404.dlr.dEntity.mobs;

import com.darksoldier1404.dlr.obj.WarDamageable;
import org.bukkit.entity.EntityType;

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
