package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

@SuppressWarnings("all")
public interface RemoteExplosiveBullet {
    boolean isRemoteExplosiveBullet();

    float getRemoteExplosionRange();

    double getRemoteExplosionDamage();

    float getRemoteExplosionKnockBack();

    float getRemoteExplosiveDuration();

    void setRemoteExplosiveBullet(boolean isRemoteExplosiveBullet);

    void setRemoteExplosionRange(float remoteExplosionrange);

    void setRemoteExplosionDamage(double remoteExplosiondamage);

    void setRemoteExplosionKnockBack(float remoteExplosionknockBack);

    void setRemoteExplosiveDuration(float remoteExplosiveDuration);

}
