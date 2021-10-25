package com.darksoldier1404.dlr.weapon.obj;

import com.darksoldier1404.dlr.weapon.obj.enums.TriggerType;
import com.darksoldier1404.dlr.weapon.obj.enums.WeaponType;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AbstractGun implements Gun {
    //weapon
    private String displayName;
    private int requiredLevel;
    private Material material;
    private WeaponType weaponType;
    private byte criticalChance;
    private double criticalAmount;
    private byte statusChance;
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
    // gun
    private TriggerType triggerType;
    private byte burstAtOnce;
    private int accuracy;
    private String ammoType;
    private float fireRate;
    private int magazineSize;
    private int maxAmmo;
    private byte reloadTime;
    private byte multiShot;
    private byte bulletDeletionTime;

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
    public byte getCriticalChance() {
        return criticalChance;
    }

    @Override
    public void setCriticalChance(byte criticalChance) {
        this.criticalChance = criticalChance;
    }

    @Override
    public double getCriticalAmount() {
        return criticalAmount;
    }

    @Override
    public void setCriticalAmount(double criticalAmount) {
        this.criticalAmount = criticalAmount;
    }

    @Override
    public byte getStatusChance() {
        return statusChance;
    }

    @Override
    public void setStatusChance(byte statusChance) {
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
    public TriggerType getTriggerType() {
        return triggerType;
    }

    @Override
    public void setTriggerType(TriggerType triggerType) {
        this.triggerType = triggerType;
    }

    @Override
    public byte getBurstAtOnce() {
        return burstAtOnce;
    }

    @Override
    public void setBurstAtOnce(byte burstAtOnce) {
        this.burstAtOnce = burstAtOnce;
    }

    @Override
    public int getAccuracy() {
        return accuracy;
    }

    @Override
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String getAmmoType() {
        return ammoType;
    }

    @Override
    public void setAmmoType(String ammoType) {
        this.ammoType = ammoType;
    }

    @Override
    public float getFireRate() {
        return fireRate;
    }

    @Override
    public void setFireRate(float fireRate) {
        this.fireRate = fireRate;
    }

    @Override
    public int getMagazineSize() {
        return magazineSize;
    }

    @Override
    public void setMagazineSize(int magazineSize) {
        this.magazineSize = magazineSize;
    }

    @Override
    public int getMaxAmmo() {
        return maxAmmo;
    }

    @Override
    public void setMaxAmmo(int maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    @Override
    public byte getReloadTime() {
        return reloadTime;
    }

    @Override
    public void setReloadTime(byte reloadTime) {
        this.reloadTime = reloadTime;
    }

    @Override
    public byte getMultiShot() {
        return multiShot;
    }

    @Override
    public void setMultiShot(byte multiShot) {
        this.multiShot = multiShot;
    }

    @Override
    public byte getBulletDeletionTime() {
        return bulletDeletionTime;
    }

    @Override
    public void setBulletDeletionTime(byte bulletDeletionTime) {
        this.bulletDeletionTime = bulletDeletionTime;
    }

}
