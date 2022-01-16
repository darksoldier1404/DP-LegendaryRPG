package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

import java.util.UUID;

@SuppressWarnings("all")
public class Bullet implements ElectricBullet, ExplosiveBullet, GravityBullet, HomingBullet, StrayBullet, HarpoonBullet {
    private final UUID uuid;
    // common field
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
    // bullet type
    // homing
    private boolean isHomingBullet = false;
    private float startHomingDelay;
    // electric
    private boolean isElectricBullet = false;
    private float chainRange;
    private float maxChainRange;
    private double chainDamage;
    // gravity
    private boolean isGravityBullet = false;
    private float gravityRange;
    private float gravityDuration;
    private float gravityPower;
    private double gravityDamage;
    private boolean isReversal = false;
    // explosive
    private boolean isExplosiveBullet = false;
    private float explosionRange;
    private double explosionDamage;
    private float explosionKnockBack;
    // Stray
    private boolean isStrayBullet = false;
    private float strayRange;
    private double strayDamage;
    private float strayKnockBack;
    private long strayExplosionDelay;
    // harpoon
    private boolean isHarpoonBullet = false;
    private float harpoonGrabRange;
    private float harpoonPullRange;
    private double harpoonDamage;


    public Bullet(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUniqueId() {
        return uuid;
    }

    public float getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(float criticalChance) {
        this.criticalChance = criticalChance;
    }

    public float getCriticalAmount() {
        return criticalAmount;
    }

    public void setCriticalAmount(float criticalAmount) {
        this.criticalAmount = criticalAmount;
    }

    public float getStatusChance() {
        return statusChance;
    }

    public void setStatusChance(float statusChance) {
        this.statusChance = statusChance;
    }

    public double getImpactDamage() {
        return impactDamage;
    }

    public void setImpactDamage(double impactDamage) {
        this.impactDamage = impactDamage;
    }

    public double getPunctureDamage() {
        return punctureDamage;
    }

    public void setPunctureDamage(double punctureDamage) {
        this.punctureDamage = punctureDamage;
    }

    public double getSlashDamage() {
        return slashDamage;
    }

    public void setSlashDamage(double slashDamage) {
        this.slashDamage = slashDamage;
    }

    public double getColdDamage() {
        return coldDamage;
    }

    public void setColdDamage(double coldDamage) {
        this.coldDamage = coldDamage;
    }

    public double getElectricityDamage() {
        return electricityDamage;
    }

    public void setElectricityDamage(double electricityDamage) {
        this.electricityDamage = electricityDamage;
    }

    public double getHeatDamage() {
        return heatDamage;
    }

    public void setHeatDamage(double heatDamage) {
        this.heatDamage = heatDamage;
    }

    public double getToxinDamage() {
        return toxinDamage;
    }

    public void setToxinDamage(double toxinDamage) {
        this.toxinDamage = toxinDamage;
    }

    public double getBlastDamage() {
        return blastDamage;
    }

    public void setBlastDamage(double blastDamage) {
        this.blastDamage = blastDamage;
    }

    public double getCorrosiveDamage() {
        return corrosiveDamage;
    }

    public void setCorrosiveDamage(double corrosiveDamage) {
        this.corrosiveDamage = corrosiveDamage;
    }

    public double getGasDamage() {
        return gasDamage;
    }

    public void setGasDamage(double gasDamage) {
        this.gasDamage = gasDamage;
    }

    public double getMagneticDamage() {
        return magneticDamage;
    }

    public void setMagneticDamage(double magneticDamage) {
        this.magneticDamage = magneticDamage;
    }

    public double getRadiationDamage() {
        return radiationDamage;
    }

    public void setRadiationDamage(double radiationDamage) {
        this.radiationDamage = radiationDamage;
    }

    public double getVirusDamage() {
        return virusDamage;
    }

    public void setVirusDamage(double virusDamage) {
        this.virusDamage = virusDamage;
    }

    @Override
    public boolean isHomingBullet() {
        return isHomingBullet;
    }

    @Override
    public void setHomingBullet(boolean homingBullet) {
        isHomingBullet = homingBullet;
    }

    @Override
    public float getStartHomingDelay() {
        return startHomingDelay;
    }

    @Override
    public void setStartHomingDelay(float startHomingDelay) {
        this.startHomingDelay = startHomingDelay;
    }

    @Override
    public boolean isElectricBullet() {
        return isElectricBullet;
    }

    @Override
    public void setElectricBullet(boolean electricBullet) {
        isElectricBullet = electricBullet;
    }

    @Override
    public float getChainRange() {
        return chainRange;
    }

    @Override
    public void setChainRange(float chainRange) {
        this.chainRange = chainRange;
    }

    @Override
    public float getMaxChainRange() {
        return maxChainRange;
    }

    @Override
    public void setMaxChainRange(float maxChainRange) {
        this.maxChainRange = maxChainRange;
    }

    @Override
    public double getChainDamage() {
        return chainDamage;
    }

    @Override
    public void setChainDamage(double chainDamage) {
        this.chainDamage = chainDamage;
    }

    @Override
    public boolean isGravityBullet() {
        return isGravityBullet;
    }

    @Override
    public void setGravityBullet(boolean gravityBullet) {
        isGravityBullet = gravityBullet;
    }

    @Override
    public float getGravityRange() {
        return gravityRange;
    }

    @Override
    public void setGravityRange(float gravityRange) {
        this.gravityRange = gravityRange;
    }

    @Override
    public float getGravityDuration() {
        return gravityDuration;
    }

    @Override
    public void setGravityDuration(float gravityDuration) {
        this.gravityDuration = gravityDuration;
    }

    @Override
    public float getGravityPower() {
        return gravityPower;
    }

    @Override
    public void setGravityPower(float gravityPower) {
        this.gravityPower = gravityPower;
    }

    @Override
    public double getGravityDamage() {
        return gravityDamage;
    }

    @Override
    public void setGravityDamage(double gravityDamage) {
        this.gravityDamage = gravityDamage;
    }

    @Override
    public boolean isReversal() {
        return isReversal;
    }

    @Override
    public void setReversal(boolean reversal) {
        isReversal = reversal;
    }

    @Override
    public boolean isExplosiveBullet() {
        return isExplosiveBullet;
    }

    @Override
    public float getExplosionRange() {
        return explosionRange;
    }

    @Override
    public void setExplosionRange(float explosionRange) {
        this.explosionRange = explosionRange;
    }

    @Override
    public double getExplosionDamage() {
        return explosionDamage;
    }

    @Override
    public void setExplosionDamage(double explosionDamage) {
        this.explosionDamage = explosionDamage;
    }

    @Override
    public float getExplosionKnockBack() {
        return explosionKnockBack;
    }

    @Override
    public void setExplosiveBullet(boolean isExplosiveBullet) {
        this.isExplosiveBullet = isExplosiveBullet;
    }

    @Override
    public void setExplosionKnockBack(float explosionKnockBack) {
        this.explosionKnockBack = explosionKnockBack;
    }


    @Override
    public boolean isStrayBullet() {
        return isStrayBullet;
    }

    @Override
    public float getStrayExplosionRange() {
        return strayRange;
    }

    @Override
    public double getStrayExplosionDamage() {
        return strayDamage;
    }

    @Override
    public float getStrayExplosionKnockBack() {
        return strayKnockBack;
    }

    @Override
    public long getStrayExplosionDelay() {
        return strayExplosionDelay;
    }

    @Override
    public void setStrayBullet(boolean isStrayBullet) {
        this.isStrayBullet = isStrayBullet;
    }

    @Override
    public void setStrayExplosionRange(float range) {
        this.strayRange = range;
    }

    @Override
    public void setStrayExplosionDamage(double damage) {
        this.strayDamage = damage;
    }

    @Override
    public void setStrayExplosionKnockBack(float knockBack) {
        this.strayKnockBack = knockBack;
    }

    @Override
    public void setStrayExplosionDelay(long strayExplosionDelay) {
        this.strayExplosionDelay = strayExplosionDelay;
    }

    @Override
    public boolean isHarpoonBullet() {
        return isHarpoonBullet;
    }

    @Override
    public void setHarpoonBullet(boolean harpoonBullet) {
        isHarpoonBullet = harpoonBullet;
    }

    @Override
    public float getHarpoonGrabRange() {
        return harpoonGrabRange;
    }

    @Override
    public void setHarpoonGrabRange(float harpoonGrabRange) {
        this.harpoonGrabRange = harpoonGrabRange;
    }

    @Override
    public float getHarpoonPullRange() {
        return harpoonPullRange;
    }

    @Override
    public void setHarpoonPullRange(float harpoonPullRange) {
        this.harpoonPullRange = harpoonPullRange;
    }

    @Override
    public double getHarpoonDamage() {
        return harpoonDamage;
    }

    @Override
    public void setHarpoonDamage(double harpoonDamage) {
        this.harpoonDamage = harpoonDamage;
    }
}
