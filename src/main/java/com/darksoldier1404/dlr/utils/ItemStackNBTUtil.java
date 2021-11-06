package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.weapon.obj.gun.GunImpl;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("all")
public class ItemStackNBTUtil {

    public static double getTotalDamage(ItemStack item) {
        double totalDamage = 0;
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "impactDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "punctureDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "slashDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "coldDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "electricityDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "heatDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "toxinDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "blastDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "corrosiveDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "gasDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "magneticDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "radiationDamage").replace('"', ' ').trim());
        totalDamage += Double.parseDouble(NBT.getStringTag(item, "virusDamage").replace('"', ' ').trim());
        return totalDamage;
    }
    // todo: 총알의 타입별로 nbt 설정 나누기

    public static ItemStack setNBTValues(ItemStack item, GunImpl gun) {
        item = NBT.setTag(item, "displayName", gun.getDisplayName());
        item = NBT.setTag(item, "requiredLevel", gun.getRequiredLevel());
        item = NBT.setTag(item, "material", gun.getMaterial());
        item = NBT.setTag(item, "weaponType", gun.getWeaponType());
        item = NBT.setTag(item, "criticalChance", gun.getCriticalChance());
        item = NBT.setTag(item, "criticalAmount", gun.getCriticalAmount());
        item = NBT.setTag(item, "statusChance", gun.getStatusChance());
        item = NBT.setTag(item, "impactDamage", gun.getImpactDamage());
        item = NBT.setTag(item, "punctureDamage", gun.getPunctureDamage());
        item = NBT.setTag(item, "slashDamage", gun.getSlashDamage());
        item = NBT.setTag(item, "coldDamage", gun.getColdDamage());
        item = NBT.setTag(item, "electricityDamage", gun.getElectricityDamage());
        item = NBT.setTag(item, "heatDamage", gun.getHeatDamage());
        item = NBT.setTag(item, "toxinDamage", gun.getToxinDamage());
        item = NBT.setTag(item, "blastDamage", gun.getBlastDamage());
        item = NBT.setTag(item, "corrosiveDamage", gun.getCorrosiveDamage());
        item = NBT.setTag(item, "gasDamage", gun.getGasDamage());
        item = NBT.setTag(item, "magneticDamage", gun.getMagneticDamage());
        item = NBT.setTag(item, "radiationDamage", gun.getRadiationDamage());
        item = NBT.setTag(item, "virusDamage", gun.getVirusDamage());
        item = NBT.setTag(item, "triggerType", gun.getTriggerType());
        item = NBT.setTag(item, "burstAtOnce", gun.getBurstAtOnce());
        item = NBT.setTag(item, "accuracy", gun.getAccuracy());
        item = NBT.setTag(item, "ammoType", gun.getAmmoType());
        item = NBT.setTag(item, "bulletSpeed", gun.getBulletSpeed());
        item = NBT.setTag(item, "bulletType", gun.getBulletType());
        item = NBT.setTag(item, "fireRate", gun.getFireRate());
        item = NBT.setTag(item, "magazineSize", gun.getMagazineSize());
        item = NBT.setTag(item, "currentMagazineSize", gun.getMagazineSize());
        item = NBT.setTag(item, "maxAmmo", gun.getMaxAmmo());
        item = NBT.setTag(item, "currentAmmo", gun.getMaxAmmo());
        item = NBT.setTag(item, "reloadTime", gun.getReloadTime());
        item = NBT.setTag(item, "multiShot", gun.getMultiShot());
        item = NBT.setTag(item, "bulletDeletionTime", gun.getBulletDeletionTime());
        // bullet type
        // homing
        item = NBT.setTag(item, "isHomingBullet", gun.isHomingBullet());
        item = NBT.setTag(item, "startHomingDelay", gun.getStartHomingDelay());
        // electric
        item = NBT.setTag(item, "isElectricBullet", gun.isElectricBullet());
        item = NBT.setTag(item, "chainRange", gun.getChainRange());
        item = NBT.setTag(item, "maxChainRange", gun.getMaxChainRange());
        item = NBT.setTag(item, "chainDamage", gun.getChainDamage());
        // gravity
        item = NBT.setTag(item, "isGravityBullet", gun.isGravityBullet());
        item = NBT.setTag(item, "gravityRange", gun.getGravityRange());
        item = NBT.setTag(item, "gravityDuration", gun.getGravityDuration());
        item = NBT.setTag(item, "gravityPower", gun.getGravityPower());
        item = NBT.setTag(item, "gravityDamage", gun.getGravityDamage());
        item = NBT.setTag(item, "isReversal", gun.isReversal());
        // explosive
        item = NBT.setTag(item, "isExplosiveBullet", gun.isExplosiveBullet());
        item = NBT.setTag(item, "explosionRange", gun.getExplosionRange());
        item = NBT.setTag(item, "explosionDamage", gun.getExplosionDamage());
        item = NBT.setTag(item, "explosionKnockBack", gun.getExplosionKnockBack());



        return item;
    }
}
