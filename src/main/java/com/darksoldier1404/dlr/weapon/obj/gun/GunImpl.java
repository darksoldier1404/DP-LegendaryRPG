package com.darksoldier1404.dlr.weapon.obj.gun;

import com.darksoldier1404.dlr.utils.ItemStackNBTUtil;
import com.darksoldier1404.dlr.obj.WarDamageImpl;
import com.darksoldier1404.dlr.weapon.obj.enums.BulletType;
import com.darksoldier1404.dlr.weapon.obj.enums.TriggerType;
import com.darksoldier1404.dlr.weapon.obj.enums.WeaponType;
import com.darksoldier1404.dlr.weapon.obj.gun.bullets.*;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class GunImpl extends WarDamageImpl implements Gun, ElectricBullet, GravityBullet, HomingBullet, ExplosiveBullet, StrayBullet, HarpoonBullet, ClusterBullet, RemoteExplosiveBullet {
    //weapon
    private String displayName;
    private int requireMasteryRank;
    private int currentLevel;
    private int maxLevel;
    private double currentExp;
    private double maxExp;
    private Material material;
    private WeaponType weaponType;
    // gun
    private TriggerType triggerType;
    private byte burstAtOnce;
    private int accuracy;
    private String ammoType;
    private float bulletSpeed;
    private BulletType bulletType;
    private float fireRate;
    private int magazineSize;
    private int currentMagazineSize;
    private int maxAmmo;
    private int currentAmmo;
    private float reloadTime;
    private float multiShot;
    private byte bulletDeletionTime;
    // bullet type
    // homing
    private boolean isHomingBullet;
    private float startHomingDelay;
    // electric
    private boolean isElectricBullet;
    private float chainRange;
    private float maxChainRange;
    private double chainDamage;
    // gravity
    private boolean isGravityBullet;
    private float gravityRange;
    private float gravityDuration;
    private float gravityPower;
    private double gravityDamage;
    private boolean isReversal;
    // explosive
    private boolean isExplosiveBullet;
    private float explosionRange;
    private double explosionDamage;
    private float explosionKnockBack;
    // Stray
    private boolean isStrayBullet;
    private float strayRange;
    private double strayDamage;
    private float strayKnockBack;
    private long strayExplosionDelay;
    // harpoon
    private boolean isHarpoonBullet;
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
    // explosive
    private boolean isRemoteExplosiveBullet;
    private float remoteExplosionRange;
    private float remoteExplosiveDuration;
    private double remoteExplosionDamage;
    private float remoteExplosionKnockBack;

    public GunImpl(YamlConfiguration data) {
        long start = System.currentTimeMillis();
        // weapon
        this.displayName = data.getString("DisplayName");
        this.requireMasteryRank = data.getInt("RequireMasteryRank");
        this.material = Material.getMaterial(data.getString("Material"));
        this.weaponType = WeaponType.valueOf(data.getString("WeaponType"));
        // WarDamage
        setDefaultCriticalChance((float) data.getDouble("DefaultCriticalChance"));
        setDefaultCriticalAmount((float) data.getDouble("DefaultCriticalAmount"));
        setDefaultStatusChance((float) data.getDouble("DefaultStatusChance"));
        setDefaultImpactDamage(data.getDouble("DefaultImpact"));
        setDefaultPunctureDamage(data.getDouble("DefaultPuncture"));
        setDefaultSlashDamage(data.getDouble("DefaultSlash"));
        setDefaultColdDamage(data.getDouble("DefaultCold"));
        setDefaultElectricityDamage(data.getDouble("DefaultElectricity"));
        setDefaultHeatDamage(data.getDouble("DefaultHeat"));
        setDefaultToxinDamage(data.getDouble("DefaultToxin"));
        setDefaultBlastDamage(data.getDouble("DefaultBlast"));
        setDefaultCorrosiveDamage(data.getDouble("DefaultCorrosive"));
        setDefaultGasDamage(data.getDouble("DefaultGas"));
        setDefaultMagneticDamage(data.getDouble("DefaultMagnetic"));
        setDefaultRadiationDamage(data.getDouble("DefaultRadiation"));
        setDefaultVirusDamage(data.getDouble("DefaultVirus"));
        initWarDamage();
        // gun
        this.triggerType = TriggerType.valueOf(data.getString("TriggerType"));
        this.burstAtOnce = (byte) data.getInt("BurstAtOnce");
        this.accuracy = data.getInt("Accuracy");
        this.ammoType = data.getString("AmmoType");
        this.bulletSpeed = (float) data.getDouble("BulletSpeed");
        this.bulletType = BulletType.valueOf(data.getString("BulletType"));
        this.fireRate = (float) data.getDouble("FireRate");
        this.magazineSize = data.getInt("MagazineSize");
        this.maxAmmo = data.getInt("MaxAmmo");
        this.currentAmmo = maxAmmo;
        this.reloadTime = (float) data.getDouble("ReloadTime");
        this.multiShot = (float) data.getDouble("MultiShot");
        this.bulletDeletionTime = (byte) data.getInt("BulletDeletionTime");
        // bullet type
        // homing
        this.isHomingBullet = data.getBoolean("IsHomingBullet");
        this.startHomingDelay = (float) data.getDouble("StartHomingDelay");
        // electric
        this.isElectricBullet = data.getBoolean("IsElectricChainBullet");
        this.chainRange = (float) data.getDouble("ChainRange");
        this.maxChainRange = (float) data.getDouble("MaxChainRange");
        this.chainDamage = data.getDouble("ChainDamage");
        // gravity
        this.isGravityBullet = data.getBoolean("IsGravityBullet");
        this.gravityRange = (float) data.getDouble("GravityRange");
        this.gravityDuration = (float) data.getDouble("GravityDuration");
        this.gravityPower = (float) data.getDouble("GravityPower");
        this.gravityDamage = data.getDouble("GravityDamage");
        this.isReversal = data.getBoolean("IsReversal");
        // explosive
        this.isExplosiveBullet = data.getBoolean("IsExplosiveBullet");
        this.explosionRange = (float) data.getDouble("ExplosionRange");
        this.explosionDamage = data.getDouble("ExplosionDamage");
        this.explosionKnockBack = (float) data.getDouble("ExplosionKnockBack");
        // stray
        this.isStrayBullet = data.getBoolean("IsStrayBullet");
        this.strayRange = (float) data.getDouble("StrayRange");
        this.strayDamage = data.getDouble("StrayDamage");
        this.strayKnockBack = (float) data.getDouble("StrayKnockBack");
        this.strayExplosionDelay = (long) data.getDouble("StrayExplosionDelay");
        // harpoon
        this.isHarpoonBullet = data.getBoolean("IsHarpoonBullet");
        this.harpoonGrabRange = (float) data.getDouble("HarpoonGrabRange");
        this.harpoonPullRange = (float) data.getDouble("HarpoonPullRange");
        this.harpoonDamage = data.getDouble("HarpoonDamage");
        // cluster
        this.isClusterBullet = data.getBoolean("IsClusterBullet");
        this.clusterExplosionRange = (float) data.getDouble("ClusterExplosionRange");
        this.clusterExplosionDamage = data.getDouble("ClusterExplosionDamage");
        this.clusterAmount = data.getInt("ClusterAmount");
        this.clusterDamage = data.getDouble("ClusterDamage");
        // Remote explosive bullet
        this.isRemoteExplosiveBullet = data.getBoolean("IsRemoteExplosiveBullet");
        this.remoteExplosionRange = (float) data.getDouble("RemoteExplosionRange");
        this.remoteExplosiveDuration = (float) data.getDouble("RemoteExplosiveDuration");
        this.remoteExplosionDamage = data.getDouble("RemoteExplosionDamage");
        this.remoteExplosionKnockBack = (float) data.getDouble("RemoteExplosionKnockBack");
        currentMagazineSize = magazineSize;
        long end = System.currentTimeMillis();
        System.out.println("GunImpl: " + (end - start));
    }

    @Override
    public GunImpl clone() throws CloneNotSupportedException {
        return (GunImpl) super.clone();
    }

    public void initWarDamage() {
        setCurrentCriticalChance(getDefaultCriticalChance());
        setCurrentCriticalAmount(getDefaultCriticalAmount());
        setCurrentImpactDamage(getDefaultImpactDamage());
        setCurrentPunctureDamage(getDefaultPunctureDamage());
        setCurrentSlashDamage(getDefaultSlashDamage());
        setCurrentBlastDamage(getDefaultBlastDamage());
        setCurrentHeatDamage(getDefaultHeatDamage());
        setCurrentToxinDamage(getDefaultToxinDamage());
        setCurrentCorrosiveDamage(getDefaultCorrosiveDamage());
        setCurrentGasDamage(getDefaultGasDamage());
        setCurrentMagneticDamage(getDefaultMagneticDamage());
        setCurrentRadiationDamage(getDefaultRadiationDamage());
        setCurrentVirusDamage(getDefaultVirusDamage());
    }

    public ItemStack getItemStack() {
        ItemStack item = new ItemStack(material);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f[ §e주 무기 §f] §b" + displayName + " §f[ §6LV." + currentLevel + " §f]");
        List<String> lore = new ArrayList<>();
        lore.add("§f◆ §b요구 마스터리 랭크 : " + requireMasteryRank);
        lore.add("§7┌━━━━━━━━━━━━━━━━━━━━━━━━━┐");
        lore.add("§f▶   §b치명타 확률 : " + getCurrentCriticalChance() + " %");
        lore.add("§f▶   §b치명타 배수 : " + getCurrentCriticalAmount());
        lore.add("§f▶   §b상태이상 확률 : " + getCurrentStatusChance() + " %");
        lore.add("§7┌━━━━━━━━━━━━━━━━━━━━━━━━━┐");
        if (getCurrentImpactDamage() != 0) {
            lore.add("§f▶   §b충격 데미지 : " + getCurrentImpactDamage());
        }
        if (getCurrentPunctureDamage() != 0) {
            lore.add("§f▶   §b관통 데미지 : " + getCurrentPunctureDamage());
        }
        if (getCurrentSlashDamage() != 0) {
            lore.add("§f▶   §b베기 데미지 : " + getCurrentSlashDamage());
        }
        lore.add("§7┌━━━━━━━━━━━━━━━━━━━━━━━━━┐");
        if (getCurrentColdDamage() != 0) {
            lore.add("§f▶   §b냉기 데미지 : " + getCurrentColdDamage());
        }
        if (getCurrentElectricityDamage() != 0) {
            lore.add("§f▶   §b전기 데미지 : " + getCurrentElectricityDamage());
        }
        if (getCurrentHeatDamage() != 0) {
            lore.add("§f▶   §b화염 데미지 : " + getCurrentHeatDamage());
        }
        if (getCurrentToxinDamage() != 0) {
            lore.add("§f▶   §b독성 데미지 : " + getCurrentToxinDamage());
        }
        if (getCurrentBlastDamage() != 0) {
            lore.add("§f▶   §b폭발 데미지 : " + getCurrentBlastDamage());
        }
        if (getCurrentCorrosiveDamage() != 0) {
            lore.add("§f▶   §b부식 데미지 : " + getCurrentCorrosiveDamage());
        }
        if (getCurrentGasDamage() != 0) {
            lore.add("§f▶   §b가스 데미지 : " + getCurrentGasDamage());
        }
        if (getCurrentMagneticDamage() != 0) {
            lore.add("§f▶   §b자성 데미지 : " + getCurrentMagneticDamage());
        }
        if (getCurrentRadiationDamage() != 0) {
            lore.add("§f▶   §b방사능 데미지 : " + getCurrentRadiationDamage());
        }
        if (getCurrentVirusDamage() != 0) {
            lore.add("§f▶   §b바이러스 데미지 : " + getCurrentVirusDamage());
        }
        lore.add("§7┌━━━━━━━━━━━━━━━━━━━━━━━━━┐");
        lore.add("§f▶   §b트리거 타입 : " + triggerType);
        if (triggerType == TriggerType.BURST) {
            lore.add("§f▶   §b연발 횟수 : " + burstAtOnce);
        }
        lore.add("§f▶   §b정확도 : " + accuracy);
        lore.add("§f▶   §b탄약 타입 : " + ammoType);
        lore.add("§f▶   §b탄속 : " + bulletSpeed);
        lore.add("§f▶   §b연사력 : " + fireRate + " FPS");
        lore.add("§f▶   §b탄창 크기 : " + magazineSize);
        if (maxAmmo != 0) {
            lore.add("§f▶   §b최대 탄약 수 : " + maxAmmo);
        }
        lore.add("§f▶   §b재장전 : " + reloadTime + " 초");
        lore.add("§f▶   §b멀티샷 : " + multiShot);
        im.setLore(lore);
        item.setItemMeta(im);
        item = ItemStackNBTUtil.setNBTValues(item, this);
        return item;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public float getStrayRange() {
        return strayRange;
    }

    public void setStrayRange(float strayRange) {
        this.strayRange = strayRange;
    }

    public double getStrayDamage() {
        return strayDamage;
    }

    public void setStrayDamage(double strayDamage) {
        this.strayDamage = strayDamage;
    }

    public float getStrayKnockBack() {
        return strayKnockBack;
    }

    public void setStrayKnockBack(float strayKnockBack) {
        this.strayKnockBack = strayKnockBack;
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
    public float getBulletSpeed() {
        return bulletSpeed;
    }

    @Override
    public void setBulletSpeed(float bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    @Override
    public BulletType getBulletType() {
        return bulletType;
    }

    @Override
    public void setBulletType(BulletType bulletType) {
        this.bulletType = bulletType;
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
    public int getCurrentMagazineSize() {
        return currentMagazineSize;
    }

    @Override
    public void setCurrentMagazineSize(int currentMagazineSize) {
        this.currentMagazineSize = currentMagazineSize;
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
    public int getCurrentAmmo() {
        return currentAmmo;
    }

    @Override
    public void setCurrentAmmo(int currentAmmo) {
        this.currentAmmo = currentAmmo;
    }

    @Override
    public float getReloadTime() {
        return reloadTime;
    }

    @Override
    public void setReloadTime(float reloadTime) {
        this.reloadTime = reloadTime;
    }

    @Override
    public float getMultiShot() {
        return multiShot;
    }

    @Override
    public void setMultiShot(float multiShot) {
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

    // bullet types

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

    public void setExplosiveBullet(boolean explosiveBullet) {
        isExplosiveBullet = explosiveBullet;
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
    public void setClusterBullet(boolean clusterBullet) {
        isClusterBullet = clusterBullet;
    }

    @Override
    public boolean isSubClusterBullet() {
        return isSubClusterBullet;
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

    public float getRemoteExplosiveDuration() {
        return remoteExplosiveDuration;
    }

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
