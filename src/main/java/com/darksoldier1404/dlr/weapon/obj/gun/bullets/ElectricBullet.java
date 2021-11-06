package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

public interface ElectricBullet {
    boolean isElectricBullet();

    void setElectricBullet(boolean electricBullet);

    float getChainRange();

    float getMaxChainRange();

    double getChainDamage();

    void setChainRange(float range);

    void setMaxChainRange(float range);

    void setChainDamage(double damage);

}
