package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.weapon.obj.gun.GunImpl;
import com.darksoldier1404.dppc.utils.NBT;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("all")
public class ItemStackNBTUtil {

    @Deprecated
    public static double getTotalDamage(ItemStack item) {
        double totalDamage = 0;
        totalDamage += NBT.getDoubleTag(item, "currentImpactDamage");
        totalDamage += NBT.getDoubleTag(item, "currentPunctureDamage");
        totalDamage += NBT.getDoubleTag(item, "currentSlashDamage");
        totalDamage += NBT.getDoubleTag(item, "currentColdDamage");
        totalDamage += NBT.getDoubleTag(item, "currentElectricityDamage");
        totalDamage += NBT.getDoubleTag(item, "currentHeatDamage");
        totalDamage += NBT.getDoubleTag(item, "currentToxinDamage");
        totalDamage += NBT.getDoubleTag(item, "currentBlastDamage");
        totalDamage += NBT.getDoubleTag(item, "currentCorrosiveDamage");
        totalDamage += NBT.getDoubleTag(item, "currentGasDamage");
        totalDamage += NBT.getDoubleTag(item, "currentMagneticDamage");
        totalDamage += NBT.getDoubleTag(item, "currentRadiationDamage");
        totalDamage += NBT.getDoubleTag(item, "currentVirusDamage");
        return totalDamage;
    }
    // todo: 총알의 타입별로 nbt 설정 나누기

    public static ItemStack setNBTValues(ItemStack item, GunImpl gun) {
        item = NBT.setStringTag(item, "displayName", gun.getDisplayName());
        item = NBT.setIntTag(item, "requiredLevel", gun.getRequireMasteryRank());
        item = NBT.setStringTag(item, "material", gun.getMaterial().name());
        item = NBT.setStringTag(item, "weaponType", gun.getWeaponType().name());
        item = NBT.setFloatTag(item, "currentCriticalChance", gun.getCurrentCriticalChance());
        item = NBT.setFloatTag(item, "currentCriticalAmount", gun.getCurrentCriticalAmount());
        item = NBT.setFloatTag(item, "currentStatusChance", gun.getCurrentStatusChance());
        item = NBT.setDoubleTag(item, "currentImpactDamage", gun.getCurrentImpactDamage());
        item = NBT.setDoubleTag(item, "currentPunctureDamage", gun.getCurrentPunctureDamage());
        item = NBT.setDoubleTag(item, "currentSlashDamage", gun.getCurrentSlashDamage());
        item = NBT.setDoubleTag(item, "currentColdDamage", gun.getCurrentColdDamage());
        item = NBT.setDoubleTag(item, "currentElectricityDamage", gun.getCurrentElectricityDamage());
        item = NBT.setDoubleTag(item, "currentHeatDamage", gun.getCurrentHeatDamage());
        item = NBT.setDoubleTag(item, "currentToxinDamage", gun.getCurrentToxinDamage());
        item = NBT.setDoubleTag(item, "currentBlastDamage", gun.getCurrentBlastDamage());
        item = NBT.setDoubleTag(item, "currentCorrosiveDamage", gun.getCurrentCorrosiveDamage());
        item = NBT.setDoubleTag(item, "currentGasDamage", gun.getCurrentGasDamage());
        item = NBT.setDoubleTag(item, "currentMagneticDamage", gun.getCurrentMagneticDamage());
        item = NBT.setDoubleTag(item, "currentRadiationDamage", gun.getCurrentRadiationDamage());
        item = NBT.setDoubleTag(item, "currentVirusDamage", gun.getCurrentVirusDamage());
        item = NBT.setFloatTag(item, "defaultCriticalChance", gun.getDefaultCriticalChance());
        item = NBT.setFloatTag(item, "defaultCriticalAmount", gun.getDefaultCriticalAmount());
        item = NBT.setFloatTag(item, "defaultStatusChance", gun.getDefaultStatusChance());
        item = NBT.setDoubleTag(item, "defaultImpactDamage", gun.getDefaultImpactDamage());
        item = NBT.setDoubleTag(item, "defaultPunctureDamage", gun.getDefaultPunctureDamage());
        item = NBT.setDoubleTag(item, "defaultSlashDamage", gun.getDefaultSlashDamage());
        item = NBT.setDoubleTag(item, "defaultColdDamage", gun.getDefaultColdDamage());
        item = NBT.setDoubleTag(item, "defaultElectricityDamage", gun.getDefaultElectricityDamage());
        item = NBT.setDoubleTag(item, "defaultHeatDamage", gun.getDefaultHeatDamage());
        item = NBT.setDoubleTag(item, "defaultToxinDamage", gun.getDefaultToxinDamage());
        item = NBT.setDoubleTag(item, "defaultBlastDamage", gun.getDefaultBlastDamage());
        item = NBT.setDoubleTag(item, "defaultCorrosiveDamage", gun.getDefaultCorrosiveDamage());
        item = NBT.setDoubleTag(item, "defaultGasDamage", gun.getDefaultGasDamage());
        item = NBT.setDoubleTag(item, "defaultMagneticDamage", gun.getDefaultMagneticDamage());
        item = NBT.setDoubleTag(item, "defaultRadiationDamage", gun.getDefaultRadiationDamage());
        item = NBT.setDoubleTag(item, "defaultVirusDamage", gun.getDefaultVirusDamage());

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
        // harpoon
        item = NBT.setObjectTag(item, "isHarpoonBullet", gun.isHarpoonBullet());
        item = NBT.setFloatTag(item, "harpoonGrabRange", gun.getHarpoonGrabRange());
        item = NBT.setFloatTag(item, "harpoonPullRange", gun.getHarpoonPullRange());
        item = NBT.setDoubleTag(item, "harpoonDamage", gun.getHarpoonDamage());
        // cluster
        item = NBT.setObjectTag(item, "isClusterBullet", gun.isClusterBullet());
        item = NBT.setFloatTag(item, "clusterExplosionRange", gun.getClusterExplosionRange());
        item = NBT.setDoubleTag(item, "clusterExplosionDamage", gun.getClusterExplosionDamage());
        item = NBT.setFloatTag(item, "clusterAmount", gun.getClusterAmount());
        item = NBT.setDoubleTag(item, "clusterDamage", gun.getClusterDamage());
        // remoteExplosive
        item = NBT.setObjectTag(item, "isRemoteExplosiveBullet", gun.isRemoteExplosiveBullet());
        item = NBT.setFloatTag(item, "remoteExplosionRange", gun.getRemoteExplosionRange());
        item = NBT.setFloatTag(item, "remoteExplosiveDuration", gun.getRemoteExplosiveDuration());
        item = NBT.setDoubleTag(item, "remoteExplosionDamage", gun.getRemoteExplosionDamage());
        item = NBT.setFloatTag(item, "remoteExplosionKnockBack", gun.getRemoteExplosionKnockBack());
        return item;
    }
}
