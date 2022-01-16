package com.darksoldier1404.dlr.weapon.obj;

@SuppressWarnings({"all", "deprecation"})
public abstract class WarDamageImpl implements WarDamage {
    private float defaultCriticalChance;
    private float defaultCriticalAmount;
    private float defaultStatusChance;
    private double defaultImpactDamage;
    private double defaultPunctureDamage;
    private double defaultSlashDamage;
    private double defaultColdDamage;
    private double defaultElectricityDamage;
    private double defaultHeatDamage;
    private double defaultToxinDamage;
    private double defaultBlastDamage;
    private double defaultCorrosiveDamage;
    private double defaultGasDamage;
    private double defaultMagneticDamage;
    private double defaultRadiationDamage;
    private double defaultVirusDamage;
    private float maxCriticalChance;
    private float maxCriticalAmount;
    private float maxStatusChance;
    private double maxImpactDamage;
    private double maxPunctureDamage;
    private double maxSlashDamage;
    private double maxColdDamage;
    private double maxElectricityDamage;
    private double maxHeatDamage;
    private double maxToxinDamage;
    private double maxBlastDamage;
    private double maxCorrosiveDamage;
    private double maxGasDamage;
    private double maxMagneticDamage;
    private double maxRadiationDamage;
    private double maxVirusDamage;
    private float currentCriticalChance;
    private float currentCriticalAmount;
    private float currentStatusChance;
    private double currentImpactDamage;
    private double currentPunctureDamage;
    private double currentSlashDamage;
    private double currentColdDamage;
    private double currentElectricityDamage;
    private double currentHeatDamage;
    private double currentToxinDamage;
    private double currentBlastDamage;
    private double currentCorrosiveDamage;
    private double currentGasDamage;
    private double currentMagneticDamage;
    private double currentRadiationDamage;
    private double currentVirusDamage;
    private float additionalCriticalChance;
    private float additionalCriticalAmount;
    private float additionalStatusChance;
    private double additionalImpactDamage;
    private double additionalPunctureDamage;
    private double additionalSlashDamage;
    private double additionalColdDamage;
    private double additionalElectricityDamage;
    private double additionalHeatDamage;
    private double additionalToxinDamage;
    private double additionalBlastDamage;
    private double additionalCorrosiveDamage;
    private double additionalGasDamage;
    private double additionalMagneticDamage;
    private double additionalRadiationDamage;
    private double additionalVirusDamage;

    @Override
    public float getDefaultCriticalChance() {
        return defaultCriticalChance;
    }

    @Override
    public void setDefaultCriticalChance(float defaultCriticalChance) {
        this.defaultCriticalChance = defaultCriticalChance;
    }

    @Override
    public float getDefaultCriticalAmount() {
        return defaultCriticalAmount;
    }

    @Override
    public void setDefaultCriticalAmount(float defaultCriticalAmount) {
        this.defaultCriticalAmount = defaultCriticalAmount;
    }

    @Override
    public float getDefaultStatusChance() {
        return defaultStatusChance;
    }

    @Override
    public void setDefaultStatusChance(float defaultStatusChance) {
        this.defaultStatusChance = defaultStatusChance;
    }

    @Override
    public double getDefaultImpactDamage() {
        return defaultImpactDamage;
    }

    @Override
    public void setDefaultImpactDamage(double defaultImpactDamage) {
        this.defaultImpactDamage = defaultImpactDamage;
    }

    @Override
    public double getDefaultPunctureDamage() {
        return defaultPunctureDamage;
    }

    @Override
    public void setDefaultPunctureDamage(double defaultPunctureDamage) {
        this.defaultPunctureDamage = defaultPunctureDamage;
    }

    @Override
    public double getDefaultSlashDamage() {
        return defaultSlashDamage;
    }

    @Override
    public void setDefaultSlashDamage(double defaultSlashDamage) {
        this.defaultSlashDamage = defaultSlashDamage;
    }

    @Override
    public double getDefaultColdDamage() {
        return defaultColdDamage;
    }

    @Override
    public void setDefaultColdDamage(double defaultColdDamage) {
        this.defaultColdDamage = defaultColdDamage;
    }

    @Override
    public double getDefaultElectricityDamage() {
        return defaultElectricityDamage;
    }

    @Override
    public void setDefaultElectricityDamage(double defaultElectricityDamage) {
        this.defaultElectricityDamage = defaultElectricityDamage;
    }

    @Override
    public double getDefaultHeatDamage() {
        return defaultHeatDamage;
    }

    @Override
    public void setDefaultHeatDamage(double defaultHeatDamage) {
        this.defaultHeatDamage = defaultHeatDamage;
    }

    @Override
    public double getDefaultToxinDamage() {
        return defaultToxinDamage;
    }

    @Override
    public void setDefaultToxinDamage(double defaultToxinDamage) {
        this.defaultToxinDamage = defaultToxinDamage;
    }

    @Override
    public double getDefaultBlastDamage() {
        return defaultBlastDamage;
    }

    @Override
    public void setDefaultBlastDamage(double defaultBlastDamage) {
        this.defaultBlastDamage = defaultBlastDamage;
    }

    @Override
    public double getDefaultCorrosiveDamage() {
        return defaultCorrosiveDamage;
    }

    @Override
    public void setDefaultCorrosiveDamage(double defaultCorrosiveDamage) {
        this.defaultCorrosiveDamage = defaultCorrosiveDamage;
    }

    @Override
    public double getDefaultGasDamage() {
        return defaultGasDamage;
    }

    @Override
    public void setDefaultGasDamage(double defaultGasDamage) {
        this.defaultGasDamage = defaultGasDamage;
    }

    @Override
    public double getDefaultMagneticDamage() {
        return defaultMagneticDamage;
    }

    @Override
    public void setDefaultMagneticDamage(double defaultMagneticDamage) {
        this.defaultMagneticDamage = defaultMagneticDamage;
    }

    @Override
    public double getDefaultRadiationDamage() {
        return defaultRadiationDamage;
    }

    @Override
    public void setDefaultRadiationDamage(double defaultRadiationDamage) {
        this.defaultRadiationDamage = defaultRadiationDamage;
    }

    @Override
    public double getDefaultVirusDamage() {
        return defaultVirusDamage;
    }

    @Override
    public void setDefaultVirusDamage(double defaultVirusDamage) {
        this.defaultVirusDamage = defaultVirusDamage;
    }

    @Override
    public float getMaxCriticalChance() {
        return maxCriticalChance;
    }

    @Override
    public void setMaxCriticalChance(float maxCriticalChance) {
        this.maxCriticalChance = maxCriticalChance;
    }

    @Override
    public float getMaxCriticalAmount() {
        return maxCriticalAmount;
    }

    @Override
    public void setMaxCriticalAmount(float maxCriticalAmount) {
        this.maxCriticalAmount = maxCriticalAmount;
    }

    @Override
    public float getMaxStatusChance() {
        return maxStatusChance;
    }

    @Override
    public void setMaxStatusChance(float maxStatusChance) {
        this.maxStatusChance = maxStatusChance;
    }

    @Override
    public double getMaxImpactDamage() {
        return maxImpactDamage;
    }

    @Override
    public void setMaxImpactDamage(double maxImpactDamage) {
        this.maxImpactDamage = maxImpactDamage;
    }

    @Override
    public double getMaxPunctureDamage() {
        return maxPunctureDamage;
    }

    @Override
    public void setMaxPunctureDamage(double maxPunctureDamage) {
        this.maxPunctureDamage = maxPunctureDamage;
    }

    @Override
    public double getMaxSlashDamage() {
        return maxSlashDamage;
    }

    @Override
    public void setMaxSlashDamage(double maxSlashDamage) {
        this.maxSlashDamage = maxSlashDamage;
    }

    @Override
    public double getMaxColdDamage() {
        return maxColdDamage;
    }

    @Override
    public void setMaxColdDamage(double maxColdDamage) {
        this.maxColdDamage = maxColdDamage;
    }

    @Override
    public double getMaxElectricityDamage() {
        return maxElectricityDamage;
    }

    @Override
    public void setMaxElectricityDamage(double maxElectricityDamage) {
        this.maxElectricityDamage = maxElectricityDamage;
    }

    @Override
    public double getMaxHeatDamage() {
        return maxHeatDamage;
    }

    @Override
    public void setMaxHeatDamage(double maxHeatDamage) {
        this.maxHeatDamage = maxHeatDamage;
    }

    @Override
    public double getMaxToxinDamage() {
        return maxToxinDamage;
    }

    @Override
    public void setMaxToxinDamage(double maxToxinDamage) {
        this.maxToxinDamage = maxToxinDamage;
    }

    @Override
    public double getMaxBlastDamage() {
        return maxBlastDamage;
    }

    @Override
    public void setMaxBlastDamage(double maxBlastDamage) {
        this.maxBlastDamage = maxBlastDamage;
    }

    @Override
    public double getMaxCorrosiveDamage() {
        return maxCorrosiveDamage;
    }

    @Override
    public void setMaxCorrosiveDamage(double maxCorrosiveDamage) {
        this.maxCorrosiveDamage = maxCorrosiveDamage;
    }

    @Override
    public double getMaxGasDamage() {
        return maxGasDamage;
    }

    @Override
    public void setMaxGasDamage(double maxGasDamage) {
        this.maxGasDamage = maxGasDamage;
    }

    @Override
    public double getMaxMagneticDamage() {
        return maxMagneticDamage;
    }

    @Override
    public void setMaxMagneticDamage(double maxMagneticDamage) {
        this.maxMagneticDamage = maxMagneticDamage;
    }

    @Override
    public double getMaxRadiationDamage() {
        return maxRadiationDamage;
    }

    @Override
    public void setMaxRadiationDamage(double maxRadiationDamage) {
        this.maxRadiationDamage = maxRadiationDamage;
    }

    @Override
    public double getMaxVirusDamage() {
        return maxVirusDamage;
    }

    @Override
    public void setMaxVirusDamage(double maxVirusDamage) {
        this.maxVirusDamage = maxVirusDamage;
    }

    @Override
    public float getCurrentCriticalChance() {
        return currentCriticalChance;
    }

    @Override
    public void setCurrentCriticalChance(float currentCriticalChance) {
        this.currentCriticalChance = currentCriticalChance;
    }

    @Override
    public float getCurrentCriticalAmount() {
        return currentCriticalAmount;
    }

    @Override
    public void setCurrentCriticalAmount(float currentCriticalAmount) {
        this.currentCriticalAmount = currentCriticalAmount;
    }

    @Override
    public float getCurrentStatusChance() {
        return currentStatusChance;
    }

    @Override
    public void setCurrentStatusChance(float currentStatusChance) {
        this.currentStatusChance = currentStatusChance;
    }

    @Override
    public double getCurrentImpactDamage() {
        return currentImpactDamage;
    }

    @Override
    public void setCurrentImpactDamage(double currentImpactDamage) {
        this.currentImpactDamage = currentImpactDamage;
    }

    @Override
    public double getCurrentPunctureDamage() {
        return currentPunctureDamage;
    }

    @Override
    public void setCurrentPunctureDamage(double currentPunctureDamage) {
        this.currentPunctureDamage = currentPunctureDamage;
    }

    @Override
    public double getCurrentSlashDamage() {
        return currentSlashDamage;
    }

    @Override
    public void setCurrentSlashDamage(double currentSlashDamage) {
        this.currentSlashDamage = currentSlashDamage;
    }

    @Override
    public double getCurrentColdDamage() {
        return currentColdDamage;
    }

    @Override
    public void setCurrentColdDamage(double currentColdDamage) {
        this.currentColdDamage = currentColdDamage;
    }

    @Override
    public double getCurrentElectricityDamage() {
        return currentElectricityDamage;
    }

    @Override
    public void setCurrentElectricityDamage(double currentElectricityDamage) {
        this.currentElectricityDamage = currentElectricityDamage;
    }

    @Override
    public double getCurrentHeatDamage() {
        return currentHeatDamage;
    }

    @Override
    public void setCurrentHeatDamage(double currentHeatDamage) {
        this.currentHeatDamage = currentHeatDamage;
    }

    @Override
    public double getCurrentToxinDamage() {
        return currentToxinDamage;
    }

    @Override
    public void setCurrentToxinDamage(double currentToxinDamage) {
        this.currentToxinDamage = currentToxinDamage;
    }

    @Override
    public double getCurrentBlastDamage() {
        return currentBlastDamage;
    }

    @Override
    public void setCurrentBlastDamage(double currentBlastDamage) {
        this.currentBlastDamage = currentBlastDamage;
    }

    @Override
    public double getCurrentCorrosiveDamage() {
        return currentCorrosiveDamage;
    }

    @Override
    public void setCurrentCorrosiveDamage(double currentCorrosiveDamage) {
        this.currentCorrosiveDamage = currentCorrosiveDamage;
    }

    @Override
    public double getCurrentGasDamage() {
        return currentGasDamage;
    }

    @Override
    public void setCurrentGasDamage(double currentGasDamage) {
        this.currentGasDamage = currentGasDamage;
    }

    @Override
    public double getCurrentMagneticDamage() {
        return currentMagneticDamage;
    }

    @Override
    public void setCurrentMagneticDamage(double currentMagneticDamage) {
        this.currentMagneticDamage = currentMagneticDamage;
    }

    @Override
    public double getCurrentRadiationDamage() {
        return currentRadiationDamage;
    }

    @Override
    public void setCurrentRadiationDamage(double currentRadiationDamage) {
        this.currentRadiationDamage = currentRadiationDamage;
    }

    @Override
    public double getCurrentVirusDamage() {
        return currentVirusDamage;
    }

    @Override
    public void setCurrentVirusDamage(double currentVirusDamage) {
        this.currentVirusDamage = currentVirusDamage;
    }

    @Override
    public float getAdditionalCriticalChance() {
        return additionalCriticalChance;
    }

    @Override
    public void setAdditionalCriticalChance(float additionalCriticalChance) {
        this.additionalCriticalChance = additionalCriticalChance;
    }

    @Override
    public float getAdditionalCriticalAmount() {
        return additionalCriticalAmount;
    }

    @Override
    public void setAdditionalCriticalAmount(float additionalCriticalAmount) {
        this.additionalCriticalAmount = additionalCriticalAmount;
    }

    @Override
    public float getAdditionalStatusChance() {
        return additionalStatusChance;
    }

    @Override
    public void setAdditionalStatusChance(float additionalStatusChance) {
        this.additionalStatusChance = additionalStatusChance;
    }

    @Override
    public double getAdditionalImpactDamage() {
        return additionalImpactDamage;
    }

    @Override
    public void setAdditionalImpactDamage(double additionalImpactDamage) {
        this.additionalImpactDamage = additionalImpactDamage;
    }

    @Override
    public double getAdditionalPunctureDamage() {
        return additionalPunctureDamage;
    }

    @Override
    public void setAdditionalPunctureDamage(double additionalPunctureDamage) {
        this.additionalPunctureDamage = additionalPunctureDamage;
    }

    @Override
    public double getAdditionalSlashDamage() {
        return additionalSlashDamage;
    }

    @Override
    public void setAdditionalSlashDamage(double additionalSlashDamage) {
        this.additionalSlashDamage = additionalSlashDamage;
    }

    @Override
    public double getAdditionalColdDamage() {
        return additionalColdDamage;
    }

    @Override
    public void setAdditionalColdDamage(double additionalColdDamage) {
        this.additionalColdDamage = additionalColdDamage;
    }

    @Override
    public double getAdditionalElectricityDamage() {
        return additionalElectricityDamage;
    }

    @Override
    public void setAdditionalElectricityDamage(double additionalElectricityDamage) {
        this.additionalElectricityDamage = additionalElectricityDamage;
    }

    @Override
    public double getAdditionalHeatDamage() {
        return additionalHeatDamage;
    }

    @Override
    public void setAdditionalHeatDamage(double additionalHeatDamage) {
        this.additionalHeatDamage = additionalHeatDamage;
    }

    @Override
    public double getAdditionalToxinDamage() {
        return additionalToxinDamage;
    }

    @Override
    public void setAdditionalToxinDamage(double additionalToxinDamage) {
        this.additionalToxinDamage = additionalToxinDamage;
    }

    @Override
    public double getAdditionalBlastDamage() {
        return additionalBlastDamage;
    }

    @Override
    public void setAdditionalBlastDamage(double additionalBlastDamage) {
        this.additionalBlastDamage = additionalBlastDamage;
    }

    @Override
    public double getAdditionalCorrosiveDamage() {
        return additionalCorrosiveDamage;
    }

    @Override
    public void setAdditionalCorrosiveDamage(double additionalCorrosiveDamage) {
        this.additionalCorrosiveDamage = additionalCorrosiveDamage;
    }

    @Override
    public double getAdditionalGasDamage() {
        return additionalGasDamage;
    }

    @Override
    public void setAdditionalGasDamage(double additionalGasDamage) {
        this.additionalGasDamage = additionalGasDamage;
    }

    @Override
    public double getAdditionalMagneticDamage() {
        return additionalMagneticDamage;
    }

    @Override
    public void setAdditionalMagneticDamage(double additionalMagneticDamage) {
        this.additionalMagneticDamage = additionalMagneticDamage;
    }

    @Override
    public double getAdditionalRadiationDamage() {
        return additionalRadiationDamage;
    }

    @Override
    public void setAdditionalRadiationDamage(double additionalRadiationDamage) {
        this.additionalRadiationDamage = additionalRadiationDamage;
    }

    @Override
    public double getAdditionalVirusDamage() {
        return additionalVirusDamage;
    }

    @Override
    public void setAdditionalVirusDamage(double additionalVirusDamage) {
        this.additionalVirusDamage = additionalVirusDamage;
    }
}
