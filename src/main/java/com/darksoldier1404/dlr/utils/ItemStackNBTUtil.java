package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.weapon.obj.AbstractGun;
import org.bukkit.inventory.ItemStack;

public class ItemStackNBTUtil {

    public static ItemStack setNBTValues(ItemStack item, AbstractGun gun) {
        item = NBT.setTag(item, "displayName", gun.getDisplayName() + "");
        item = NBT.setTag(item, "requiredLevel", gun.getRequiredLevel() + "");
        item = NBT.setTag(item, "material", gun.getMaterial() + "");
        item = NBT.setTag(item, "weaponType", gun.getWeaponType() + "");
        item = NBT.setTag(item, "criticalChance", gun.getCriticalChance() + "");
        item = NBT.setTag(item, "criticalAmount", gun.getCriticalAmount() + "");
        item = NBT.setTag(item, "statusChance", gun.getStatusChance() + "");
        item = NBT.setTag(item, "impactDamage", gun.getImpactDamage() + "");
        item = NBT.setTag(item, "punctureDamage", gun.getPunctureDamage() + "");
        item = NBT.setTag(item, "slashDamage", gun.getSlashDamage() + "");
        item = NBT.setTag(item, "coldDamage", gun.getColdDamage() + "");
        item = NBT.setTag(item, "electricityDamage", gun.getElectricityDamage() + "");
        item = NBT.setTag(item, "heatDamage", gun.getHeatDamage() + "");
        item = NBT.setTag(item, "toxinDamage", gun.getToxinDamage() + "");
        item = NBT.setTag(item, "blastDamage", gun.getBlastDamage() + "");
        item = NBT.setTag(item, "corrosiveDamage", gun.getCorrosiveDamage() + "");
        item = NBT.setTag(item, "gasDamage", gun.getGasDamage() + "");
        item = NBT.setTag(item, "magneticDamage", gun.getMagneticDamage() + "");
        item = NBT.setTag(item, "radiationDamage", gun.getRadiationDamage() + "");
        item = NBT.setTag(item, "virusDamage", gun.getVirusDamage() + "");
        item = NBT.setTag(item, "triggerType", gun.getTriggerType() + "");
        item = NBT.setTag(item, "burstAtOnce", gun.getBurstAtOnce() + "");
        item = NBT.setTag(item, "accuracy", gun.getAccuracy() + "");
        item = NBT.setTag(item, "ammoType", gun.getAmmoType() + "");
        item = NBT.setTag(item, "fireRate", gun.getFireRate() + "");
        item = NBT.setTag(item, "magazineSize", gun.getMagazineSize() + "");
        item = NBT.setTag(item, "maxAmmo", gun.getMaxAmmo() + "");
        item = NBT.setTag(item, "reloadTime", gun.getReloadTime() + "");
        item = NBT.setTag(item, "multiShot", gun.getMultiShot() + "");
        item = NBT.setTag(item, "bulletDeletionTime", gun.getBulletDeletionTime() + "");
        return item;
    }
}
