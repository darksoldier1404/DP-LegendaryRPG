package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

public interface HomingBullet {
    float getStartHomingDelay();

    float getExplosionRange();

    void setStartHomingDelay(float startHomingDelay);

    void setExplosionRange(float explosionRange);
}
