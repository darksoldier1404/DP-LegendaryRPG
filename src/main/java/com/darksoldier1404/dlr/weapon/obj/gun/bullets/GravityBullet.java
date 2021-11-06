package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

public interface GravityBullet {
    boolean isGravityBullet();

    void setGravityBullet(boolean gravityBullet);

    float getGravityRange();

    float getGravityDuration();

    float getGravityPower();

    boolean isReversal();

    double getGravityDamage();

    void setGravityRange(float gravityRange);

    void setGravityDuration(float gravityDuration);

    void setGravityPower(float gravityPower);

    void setReversal(boolean reversal);

    void setGravityDamage(double gravityDamage);
}
