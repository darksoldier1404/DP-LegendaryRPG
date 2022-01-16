package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

@SuppressWarnings("unused")
public interface HarpoonBullet {
    boolean isHarpoonBullet();

    float getHarpoonGrabRange();

    float getHarpoonPullRange();

    double getHarpoonDamage();

    void setHarpoonBullet(boolean isHarpoonBullet);

    void setHarpoonGrabRange(float harpoonGrabRange);

    void setHarpoonPullRange(float harpoonPullRange);

    void setHarpoonDamage(double harpoonDamage);
}
