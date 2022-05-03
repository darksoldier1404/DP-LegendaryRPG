package com.darksoldier1404.dlr.dentity.kapality.obj;

import com.darksoldier1404.dlr.obj.WarDamageable;

@SuppressWarnings("unused")
public interface Kapality extends WarDamageable {
    String getName();

    String getDescription();

    int getRequireMasteryRank();

    int getDefaultLevel();

    int getCurrentLevel();

    int getMaxLevel();

    float getDefaultSpeed();

    float getCurrentSpeed();

    float getMaxSpeed();

    float getAdditionalSpeed();

    void setName(String name);

    void setDescription(String description);

    void setRequireMasteryRank(int requireMasteryRank);

    void setDefaultLevel(int defaultLevel);

    void setCurrentLevel(int currentLevel);

    void setMaxLevel(int maxLevel);

    void setDefaultSpeed(float defaultSpeed);

    void setCurrentSpeed(float currentSpeed);

    void setMaxSpeed(float maxSpeed);

    void setAdditionalSpeed(float additionalSpeed);
}