package com.darksoldier1404.dlr.weapon.obj;

import com.darksoldier1404.dlr.weapon.obj.enums.TriggerType;

@SuppressWarnings("unused")
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

    void setTriggerType(TriggerType triggerType);
    void setBurstAtOnce(byte burstAtOnce);
    void setAccuracy(int accuracy);
    void setAmmoType(String ammoType);
    void setFireRate(float fireRate);
    void setMagazineSize(int magazineSize);
    void setMaxAmmo(int maxAmmo);
    void setReloadTime(byte reloadTime);
    void setMultiShot(byte multiShot);
    void setBulletDeletionTime(byte bulletDeletionTime);

}
