package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

@SuppressWarnings("all")
public interface HomingBullet {
    boolean isHomingBullet();

    void setHomingBullet(boolean homingBullet);

    float getStartHomingDelay();

    void setStartHomingDelay(float startHomingDelay);
}
