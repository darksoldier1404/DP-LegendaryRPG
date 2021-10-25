package com.darksoldier1404.dlr.weapon.obj;

import com.darksoldier1404.dlr.weapon.obj.enums.TriggerType;

public interface Gun extends Weapon {
    TriggerType getTriggerType();

    byte getBurstAtOnce();

    int getAccuracy();

    String getAmmoType();

    float getFireRate();

    int getMagazineSize();

    int getMaxAmmo();

    byte getReloadTime();

    byte getMultiShot();

    byte getBulletDeletionTime();

}
