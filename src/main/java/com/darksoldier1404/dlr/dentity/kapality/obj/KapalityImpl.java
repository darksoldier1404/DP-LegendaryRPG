package com.darksoldier1404.dlr.dentity.kapality.obj;

import com.darksoldier1404.dlr.obj.WarDamageableImpl;

@SuppressWarnings("unused")
public class KapalityImpl extends WarDamageableImpl implements Kapality {
    private String name;
    private String description;
    private int requireMasteryRank;
    private int defaultLevel;
    private int currentLevel;
    private int maxLevel;
    private float defaultSpeed;
    private float currentSpeed;
    private float maxSpeed;
    private float additionalSpeed;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getRequireMasteryRank() {
        return requireMasteryRank;
    }

    @Override
    public void setRequireMasteryRank(int requireMasteryRank) {
        this.requireMasteryRank = requireMasteryRank;
    }

    @Override
    public int getDefaultLevel() {
        return defaultLevel;
    }

    @Override
    public void setDefaultLevel(int defaultLevel) {
        this.defaultLevel = defaultLevel;
    }

    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public float getDefaultSpeed() {
        return defaultSpeed;
    }

    @Override
    public void setDefaultSpeed(float defaultSpeed) {
        this.defaultSpeed = defaultSpeed;
    }

    @Override
    public float getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public void setCurrentSpeed(float currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    @Override
    public float getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public float getAdditionalSpeed() {
        return additionalSpeed;
    }

    @Override
    public void setAdditionalSpeed(float additionalSpeed) {
        this.additionalSpeed = additionalSpeed;
    }
}
