package com.darksoldier1404.dlr.weapon.obj.gun;

import com.darksoldier1404.dlr.weapon.obj.Weapon;
import com.darksoldier1404.dlr.weapon.obj.enums.BulletType;
import com.darksoldier1404.dlr.weapon.obj.enums.TriggerType;

@SuppressWarnings("unused")
public interface Gun extends Weapon {
    TriggerType getTriggerType();

    byte getBurstAtOnce();

    int getAccuracy();

    String getAmmoType();

    float getBulletSpeed();

    BulletType getBulletType();

    float getFireRate();

    int getMagazineSize();

    int getCurrentMagazineSize();

    int getMaxAmmo();

    int getCurrentAmmo();

    float getReloadTime();

    float getMultiShot();

    byte getBulletDeletionTime();

    void setTriggerType(TriggerType triggerType);

    void setBurstAtOnce(byte burstAtOnce);

    void setAccuracy(int accuracy);

    void setBulletSpeed(float bulletSpeed);

    void setBulletType(BulletType bulletType);

    void setAmmoType(String ammoType);

    void setFireRate(float fireRate);

    void setMagazineSize(int magazineSize);

    void setCurrentMagazineSize(int currentMagazineSize);

    void setMaxAmmo(int maxAmmo);

    void setCurrentAmmo(int currentAmmo);

    void setReloadTime(float reloadTime);

    void setMultiShot(float multiShot);

    void setBulletDeletionTime(byte bulletDeletionTime);

}
