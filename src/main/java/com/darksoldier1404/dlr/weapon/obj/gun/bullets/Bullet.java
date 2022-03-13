package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

import com.darksoldier1404.dlr.obj.WarDamageImpl;

import java.util.UUID;

@SuppressWarnings("all")
public class Bullet extends WarDamageImpl implements ElectricBullet, ExplosiveBullet, GravityBullet, HomingBullet, StrayBullet, HarpoonBullet, ClusterBullet, RemoteExplosiveBullet {
    private final UUID uuid;
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
    // cluster
    private boolean isClusterBullet;
    private boolean isSubClusterBullet;
    private float clusterExplosionRange;
    private double clusterExplosionDamage;
    private int clusterAmount;
    private double clusterDamage;
    // remoteExplosive
    private boolean isRemoteExplosiveBullet;
    private float remoteExplosionRange;
    private float remoteExplosiveDuration;
    private double remoteExplosionDamage;
    private float remoteExplosionKnockBack;

    public Bullet(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUniqueId() {
        return uuid;
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

    @Override
    public boolean isClusterBullet() {
        return isClusterBullet;
    }

    @Override
    public boolean isSubClusterBullet() {
        return isSubClusterBullet;
    }

    @Override
    public void setClusterBullet(boolean clusterBullet) {
        isClusterBullet = clusterBullet;
    }

    @Override
    public void setSubClusterBullet(boolean subClusterBullet) {
        isSubClusterBullet = subClusterBullet;
    }

    @Override
    public float getClusterExplosionRange() {
        return clusterExplosionRange;
    }

    @Override
    public void setClusterExplosionRange(float clusterExplosionRange) {
        this.clusterExplosionRange = clusterExplosionRange;
    }

    @Override
    public double getClusterExplosionDamage() {
        return clusterExplosionDamage;
    }

    @Override
    public void setClusterExplosionDamage(double clusterExplosionDamage) {
        this.clusterExplosionDamage = clusterExplosionDamage;
    }

    @Override
    public int getClusterAmount() {
        return clusterAmount;
    }

    @Override
    public void setClusterAmount(int clusterAmount) {
        this.clusterAmount = clusterAmount;
    }

    @Override
    public double getClusterDamage() {
        return clusterDamage;
    }

    @Override
    public void setClusterDamage(double clusterDamage) {
        this.clusterDamage = clusterDamage;
    }

    @Override
    public boolean isRemoteExplosiveBullet() {
        return isRemoteExplosiveBullet;
    }

    @Override
    public void setRemoteExplosiveBullet(boolean remoteExplosiveBullet) {
        isRemoteExplosiveBullet = remoteExplosiveBullet;
    }

    @Override
    public float getRemoteExplosionRange() {
        return remoteExplosionRange;
    }

    @Override
    public void setRemoteExplosionRange(float remoteExplosionRange) {
        this.remoteExplosionRange = remoteExplosionRange;
    }

    @Override
    public float getRemoteExplosiveDuration() {
        return remoteExplosiveDuration;
    }

    @Override
    public void setRemoteExplosiveDuration(float remoteExplosiveDuration) {
        this.remoteExplosiveDuration = remoteExplosiveDuration;
    }

    @Override
    public double getRemoteExplosionDamage() {
        return remoteExplosionDamage;
    }

    @Override
    public void setRemoteExplosionDamage(double remoteExplosionDamage) {
        this.remoteExplosionDamage = remoteExplosionDamage;
    }

    @Override
    public float getRemoteExplosionKnockBack() {
        return remoteExplosionKnockBack;
    }

    @Override
    public void setRemoteExplosionKnockBack(float remoteExplosionKnockBack) {
        this.remoteExplosionKnockBack = remoteExplosionKnockBack;
    }
}
