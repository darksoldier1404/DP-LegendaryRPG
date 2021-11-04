package com.darksoldier1404.dlr.weapon.obj.gun;

import com.darksoldier1404.dlr.utils.ItemStackNBTUtil;
import com.darksoldier1404.dlr.weapon.obj.enums.BulletType;
import com.darksoldier1404.dlr.weapon.obj.enums.TriggerType;
import com.darksoldier1404.dlr.weapon.obj.enums.WeaponType;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class AbstractGun implements Gun {
    //weapon
    private String displayName;
    private int requiredLevel;
    private int currentLevel = 0;
    private int maxLevel;
    private double currentExp = 0;
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

    public AbstractGun(YamlConfiguration data) {
        this.displayName = data.getString("DisplayName");
        this.requiredLevel = data.getInt("RequiredLevel");
        this.material = Material.getMaterial(data.getString("Material"));
        this.weaponType = WeaponType.valueOf(data.getString("WeaponType"));
        this.criticalChance = (float) data.getDouble("CriticalChance");
        this.criticalAmount = (float) data.getDouble("CriticalAmount");
        this.statusChance = (float) data.getDouble("StatusChance");
        this.impactDamage = data.getDouble("Impact");
        this.punctureDamage = data.getDouble("Puncture");
        this.slashDamage = data.getDouble("Slash");
        this.coldDamage = data.getDouble("Cold");
        this.electricityDamage = data.getDouble("Electricity");
        this.heatDamage = data.getDouble("Heat");
        this.toxinDamage = data.getDouble("Toxin");
        this.blastDamage = data.getDouble("Blast");
        this.corrosiveDamage = data.getDouble("Corrosive");
        this.gasDamage = data.getDouble("Gas");
        this.magneticDamage = data.getDouble("Magnetic");
        this.radiationDamage = data.getDouble("Radiation");
        this.virusDamage = data.getDouble("Virus");
        this.triggerType = TriggerType.valueOf(data.getString("TriggerType"));
        this.burstAtOnce = (byte) data.getInt("BurstAtOnce");
        this.accuracy = data.getInt("Accuracy");
        this.ammoType = data.getString("AmmoType");
        this.bulletSpeed = (float) data.getDouble("BulletSpeed");
        this.bulletType = BulletType.valueOf(data.getString("BulletType"));
        this.fireRate = (float) data.getDouble("FireRate");
        this.magazineSize = data.getInt("MagazineSize");
        this.maxAmmo = data.getInt("MaxAmmo");
        this.reloadTime = (float) data.getDouble("ReloadTime");
        this.multiShot = (float) data.getDouble("MultiShot");
        this.bulletDeletionTime = (byte) data.getInt("BulletDeletionTime");
        currentMagazineSize = magazineSize;
    }

//    public void test() {
//        System.out.println("displayName : " + this.displayName);
//        System.out.println("requiredLevel : " + this.requiredLevel);
//        System.out.println("material : " + this.material);
//        System.out.println("weaponType : " + this.weaponType);
//        System.out.println("criticalChance : " + this.criticalChance);
//        System.out.println("criticalAmount : " + this.criticalAmount);
//        System.out.println("statusChance : " + this.statusChance);
//        System.out.println("impactDamage : " + this.impactDamage);
//        System.out.println("punctureDamage : " + this.punctureDamage);
//        System.out.println("slashDamage : " + this.slashDamage);
//        System.out.println("coldDamage : " + this.coldDamage);
//        System.out.println("electricityDamage : " + this.electricityDamage);
//        System.out.println("heatDamage : " + this.heatDamage);
//        System.out.println("toxinDamage : " + this.toxinDamage);
//        System.out.println("blastDamage : " + this.blastDamage);
//        System.out.println("corrosiveDamage : " + this.corrosiveDamage);
//        System.out.println("gasDamage : " + this.gasDamage);
//        System.out.println("magneticDamage : " + this.magneticDamage);
//        System.out.println("radiationDamage : " + this.radiationDamage);
//        System.out.println("virusDamage : " + this.virusDamage);
//        System.out.println("triggerType : " + this.triggerType);
//        System.out.println("burstAtOnce : " + this.burstAtOnce);
//        System.out.println("accuracy : " + this.accuracy);
//        System.out.println("ammoType : " + this.ammoType);
//        System.out.println("fireRate : " + this.fireRate);
//        System.out.println("magazineSize : " + this.magazineSize);
//        System.out.println("maxAmmo : " + this.maxAmmo);
//        System.out.println("reloadTime : " + this.reloadTime);
//        System.out.println("multiShot : " + this.multiShot);
//        System.out.println("bulletDeletionTime : " + this.bulletDeletionTime);
//    }


    public ItemStack getItemStack() {
        ItemStack item = new ItemStack(material);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§f[ §e주 무기 §f] §b" + displayName + " §f[ §6LV." + currentLevel + " §f]");
        List<String> lore = new ArrayList<>();
        lore.add("§f◆ §b요구 마스터리 랭크 : " + requiredLevel);
        lore.add("§7┌━━━━━━━━━━━━━━━━━━━━━━━━━┐");
        lore.add("§f▶   §b치명타 확률 : " + criticalChance + " %");
        lore.add("§f▶   §b치명타 배수 : " + criticalAmount);
        lore.add("§f▶   §b상태이상 확률 : " + statusChance + " %");
        lore.add("§7┌━━━━━━━━━━━━━━━━━━━━━━━━━┐");
        if (impactDamage != 0) {
            lore.add("§f▶   §b충격 데미지 : " + impactDamage);
        }
        if (punctureDamage != 0) {
            lore.add("§f▶   §b관통 데미지 : " + punctureDamage);
        }
        if (slashDamage != 0) {
            lore.add("§f▶   §b베기 데미지 : " + slashDamage);
        }
        lore.add("§7┌━━━━━━━━━━━━━━━━━━━━━━━━━┐");
        if (coldDamage != 0) {
            lore.add("§f▶   §b냉기 데미지 : " + coldDamage);
        }
        if (electricityDamage != 0) {
            lore.add("§f▶   §b전기 데미지 : " + electricityDamage);
        }
        if (heatDamage != 0) {
            lore.add("§f▶   §b화염 데미지 : " + heatDamage);
        }
        if (toxinDamage != 0) {
            lore.add("§f▶   §b독성 데미지 : " + toxinDamage);
        }
        if (blastDamage != 0) {
            lore.add("§f▶   §b폭발 데미지 : " + blastDamage);
        }
        if (corrosiveDamage != 0) {
            lore.add("§f▶   §b부식 데미지 : " + corrosiveDamage);
        }
        if (gasDamage != 0) {
            lore.add("§f▶   §b가스 데미지 : " + gasDamage);
        }
        if (magneticDamage != 0) {
            lore.add("§f▶   §b자성 데미지 : " + magneticDamage);
        }
        if (radiationDamage != 0) {
            lore.add("§f▶   §b방사능 데미지 : " + radiationDamage);
        }
        if (virusDamage != 0) {
            lore.add("§f▶   §b바이러스 데미지 : " + virusDamage);
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

}
