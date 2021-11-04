package com.darksoldier1404.dlr.weapon.obj.melee;

import com.darksoldier1404.dlr.weapon.obj.enums.WeaponType;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AbstractMelee implements Melee {
    //weapon
    private String displayName;
    private int requiredLevel;
    private int currentLevel;
    private int maxLevel;
    private double currentExp;
    private double maxExp;
    private Material material;
    private WeaponType weaponType;
    private float criticalChance;
    private float criticalAmount;
    private float statusChance;
    private double impactDamage;
    private double punctureDamage;
    private double slashDamage;
    private double coldDamage;
    private double electricityDamage;
    private double heatDamage;
    private double toxinDamage;
    private double blastDamage;
    private double corrosiveDamage;
    private double gasDamage;
    private double magneticDamage;
    private double radiationDamage;
    private double virusDamage;
    // melee
    private byte attackSpeed;
    private byte range;
    private double comboDuration;

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public int getRequiredLevel() {
        return requiredLevel;
    }

    @Override
    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
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
    public double getCurrentExp() {
        return currentExp;
    }

    @Override
    public void setCurrentExp(double currentExp) {
        this.currentExp = currentExp;
    }

    @Override
    public double getMaxExp() {
        return maxExp;
    }

    @Override
    public void setMaxExp(double maxExp) {
        this.maxExp = maxExp;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public float getCriticalChance() {
        return criticalChance;
    }

    @Override
    public void setCriticalChance(float criticalChance) {
        this.criticalChance = criticalChance;
    }

    @Override
    public float getCriticalAmount() {
        return criticalAmount;
    }

    @Override
    public void setCriticalAmount(float criticalAmount) {
        this.criticalAmount = criticalAmount;
    }

    @Override
    public float getStatusChance() {
        return statusChance;
    }

    @Override
    public void setStatusChance(float statusChance) {
        this.statusChance = statusChance;
    }

    @Override
    public double getImpactDamage() {
        return impactDamage;
    }

    @Override
    public void setImpactDamage(double impactDamage) {
        this.impactDamage = impactDamage;
    }

    @Override
    public double getPunctureDamage() {
        return punctureDamage;
    }

    @Override
    public void setPunctureDamage(double punctureDamage) {
        this.punctureDamage = punctureDamage;
    }

    @Override
    public double getSlashDamage() {
        return slashDamage;
    }

    @Override
    public void setSlashDamage(double slashDamage) {
        this.slashDamage = slashDamage;
    }

    @Override
    public double getColdDamage() {
        return coldDamage;
    }

    @Override
    public void setColdDamage(double coldDamage) {
        this.coldDamage = coldDamage;
    }

    @Override
    public double getElectricityDamage() {
        return electricityDamage;
    }

    @Override
    public void setElectricityDamage(double electricityDamage) {
        this.electricityDamage = electricityDamage;
    }

    @Override
    public double getHeatDamage() {
        return heatDamage;
    }

    @Override
    public void setHeatDamage(double heatDamage) {
        this.heatDamage = heatDamage;
    }

    @Override
    public double getToxinDamage() {
        return toxinDamage;
    }

    @Override
    public void setToxinDamage(double toxinDamage) {
        this.toxinDamage = toxinDamage;
    }

    @Override
    public double getBlastDamage() {
        return blastDamage;
    }

    @Override
    public void setBlastDamage(double blastDamage) {
        this.blastDamage = blastDamage;
    }

    @Override
    public double getCorrosiveDamage() {
        return corrosiveDamage;
    }

    @Override
    public void setCorrosiveDamage(double corrosiveDamage) {
        this.corrosiveDamage = corrosiveDamage;
    }

    @Override
    public double getGasDamage() {
        return gasDamage;
    }

    @Override
    public void setGasDamage(double gasDamage) {
        this.gasDamage = gasDamage;
    }

    @Override
    public double getMagneticDamage() {
        return magneticDamage;
    }

    @Override
    public void setMagneticDamage(double magneticDamage) {
        this.magneticDamage = magneticDamage;
    }

    @Override
    public double getRadiationDamage() {
        return radiationDamage;
    }

    @Override
    public void setRadiationDamage(double radiationDamage) {
        this.radiationDamage = radiationDamage;
    }

    @Override
    public double getVirusDamage() {
        return virusDamage;
    }

    @Override
    public void setVirusDamage(double virusDamage) {
        this.virusDamage = virusDamage;
    }

    @Override
    public byte getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public void setAttackSpeed(byte attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @Override
    public byte getRange() {
        return range;
    }

    @Override
    public void setRange(byte range) {
        this.range = range;
    }

    @Override
    public double getComboDuration() {
        return comboDuration;
    }

    @Override
    public void setComboDuration(double comboDuration) {
        this.comboDuration = comboDuration;
    }
}
