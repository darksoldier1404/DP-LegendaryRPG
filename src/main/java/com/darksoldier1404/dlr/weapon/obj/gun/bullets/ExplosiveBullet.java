package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

public interface ExplosiveBullet {
    boolean isExplosiveBullet();

    float getExplosionRange();

    double getExplosionDamage();

    float getExplosionKnockBack();

    void setExplosiveBullet(boolean isExplosiveBullet);

    void setExplosionRange(float range);

    void setExplosionDamage(double damage);

    void setExplosionKnockBack(float knockBack);

}
