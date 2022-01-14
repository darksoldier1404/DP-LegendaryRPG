package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

@SuppressWarnings("unused")
public interface StrayBullet {
    boolean isStrayBullet();

    float getStrayExplosionRange();

    double getStrayExplosionDamage();

    float getStrayExplosionKnockBack();

    long getStrayExplosionDelay();

    void setStrayBullet(boolean isStrayBullet);

    void setStrayExplosionRange(float range);

    void setStrayExplosionDamage(double damage);

    void setStrayExplosionKnockBack(float knockBack);

    void setStrayExplosionDelay(long strayExplosionDelay);
}
