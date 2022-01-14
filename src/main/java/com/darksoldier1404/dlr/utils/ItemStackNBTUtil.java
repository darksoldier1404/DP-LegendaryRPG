package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.weapon.obj.gun.GunImpl;
import com.darksoldier1404.duc.utils.NBT;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("all")
public class ItemStackNBTUtil {

    @Deprecated
    public static double getTotalDamage(ItemStack item) {
        double totalDamage = 0;
        totalDamage += NBT.getDoubleTag(item, "impactDamage");
        totalDamage += NBT.getDoubleTag(item, "punctureDamage");
        totalDamage += NBT.getDoubleTag(item, "slashDamage");
        totalDamage += NBT.getDoubleTag(item, "coldDamage");
        totalDamage += NBT.getDoubleTag(item, "electricityDamage");
        totalDamage += NBT.getDoubleTag(item, "heatDamage");
        totalDamage += NBT.getDoubleTag(item, "toxinDamage");
        totalDamage += NBT.getDoubleTag(item, "blastDamage");
        totalDamage += NBT.getDoubleTag(item, "corrosiveDamage");
        totalDamage += NBT.getDoubleTag(item, "gasDamage");
        totalDamage += NBT.getDoubleTag(item, "magneticDamage");
        totalDamage += NBT.getDoubleTag(item, "radiationDamage");
        totalDamage += NBT.getDoubleTag(item, "virusDamage");
        return totalDamage;
    }
    // todo: 총알의 타입별로 nbt 설정 나누기

    public static ItemStack setNBTValues(ItemStack item, GunImpl gun) {
        item = NBT.setStringTag(item, "displayName", gun.getDisplayName());
        item = NBT.setIntTag(item, "requiredLevel", gun.getRequiredLevel());
        item = NBT.setStringTag(item, "material", gun.getMaterial().name());
        item = NBT.setStringTag(item, "weaponType", gun.getWeaponType().name());
        item = NBT.setFloatTag(item, "criticalChance", gun.getCriticalChance());
        item = NBT.setFloatTag(item, "criticalAmount", gun.getCriticalAmount());
        item = NBT.setFloatTag(item, "statusChance", gun.getStatusChance());
        item = NBT.setDoubleTag(item, "impactDamage", gun.getImpactDamage());
        item = NBT.setDoubleTag(item, "punctureDamage", gun.getPunctureDamage());
        item = NBT.setDoubleTag(item, "slashDamage", gun.getSlashDamage());
        item = NBT.setDoubleTag(item, "coldDamage", gun.getColdDamage());
        item = NBT.setDoubleTag(item, "electricityDamage", gun.getElectricityDamage());
        item = NBT.setDoubleTag(item, "heatDamage", gun.getHeatDamage());
        item = NBT.setDoubleTag(item, "toxinDamage", gun.getToxinDamage());
        item = NBT.setDoubleTag(item, "blastDamage", gun.getBlastDamage());
        item = NBT.setDoubleTag(item, "corrosiveDamage", gun.getCorrosiveDamage());
        item = NBT.setDoubleTag(item, "gasDamage", gun.getGasDamage());
        item = NBT.setDoubleTag(item, "magneticDamage", gun.getMagneticDamage());
        item = NBT.setDoubleTag(item, "radiationDamage", gun.getRadiationDamage());
        item = NBT.setDoubleTag(item, "virusDamage", gun.getVirusDamage());
        item = NBT.setStringTag(item, "triggerType", gun.getTriggerType().name());
        item = NBT.setByteTag(item, "burstAtOnce", gun.getBurstAtOnce());
        item = NBT.setIntTag(item, "accuracy", gun.getAccuracy());
        item = NBT.setStringTag(item, "ammoType", gun.getAmmoType());
        item = NBT.setFloatTag(item, "bulletSpeed", gun.getBulletSpeed());
        item = NBT.setStringTag(item, "bulletType", gun.getBulletType().name());
        item = NBT.setFloatTag(item, "fireRate", gun.getFireRate());
        item = NBT.setIntTag(item, "magazineSize", gun.getMagazineSize());
        item = NBT.setIntTag(item, "currentMagazineSize", gun.getMagazineSize());
        item = NBT.setIntTag(item, "maxAmmo", gun.getMaxAmmo());
        item = NBT.setIntTag(item, "currentAmmo", gun.getMaxAmmo());
        item = NBT.setFloatTag(item, "reloadTime", gun.getReloadTime());
        item = NBT.setFloatTag(item, "multiShot", gun.getMultiShot());
        item = NBT.setByteTag(item, "bulletDeletionTime", gun.getBulletDeletionTime());
        // bullet type
        // homing
        item = NBT.setObjectTag(item, "isHomingBullet", gun.isHomingBullet());
        item = NBT.setFloatTag(item, "startHomingDelay", gun.getStartHomingDelay());
        // electric
        item = NBT.setObjectTag(item, "isElectricBullet", gun.isElectricBullet());
        item = NBT.setFloatTag(item, "chainRange", gun.getChainRange());
        item = NBT.setFloatTag(item, "maxChainRange", gun.getMaxChainRange());
        item = NBT.setDoubleTag(item, "chainDamage", gun.getChainDamage());
        // gravity
        item = NBT.setObjectTag(item, "isGravityBullet", gun.isGravityBullet());
        item = NBT.setFloatTag(item, "gravityRange", gun.getGravityRange());
        item = NBT.setFloatTag(item, "gravityDuration", gun.getGravityDuration());
        item = NBT.setFloatTag(item, "gravityPower", gun.getGravityPower());
        item = NBT.setDoubleTag(item, "gravityDamage", gun.getGravityDamage());
        item = NBT.setObjectTag(item, "isReversal", gun.isReversal());
        // explosive
        item = NBT.setObjectTag(item, "isExplosiveBullet", gun.isExplosiveBullet());
        item = NBT.setFloatTag(item, "explosionRange", gun.getExplosionRange());
        item = NBT.setDoubleTag(item, "explosionDamage", gun.getExplosionDamage());
        item = NBT.setFloatTag(item, "explosionKnockBack", gun.getExplosionKnockBack());
        // stray
        item = NBT.setObjectTag(item, "isStrayBullet", gun.isStrayBullet());
        item = NBT.setFloatTag(item, "strayRange", gun.getStrayExplosionRange());
        item = NBT.setFloatTag(item, "strayKnockBack", gun.getStrayExplosionKnockBack());
        item = NBT.setDoubleTag(item, "strayDamage", gun.getStrayExplosionDamage());
        item = NBT.setLongTag(item, "strayExplosionDelay", gun.getStrayExplosionDelay());


        return item;
    }
}
