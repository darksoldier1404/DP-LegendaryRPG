package com.darksoldier1404.dlr.weapon.obj.gun.bullets;

@SuppressWarnings("all")
public interface ClusterBullet {
    boolean isClusterBullet();

    boolean isSubClusterBullet();

    float getClusterExplosionRange();

    double getClusterExplosionDamage();

    int getClusterAmount();

    double getClusterDamage();

    void setClusterBullet(boolean isClusterBullet);

    void setSubClusterBullet(boolean isSubClusterBullet);

    void setClusterExplosionRange(float clusterExplosionRange);

    void setClusterExplosionDamage(double clusterExplosionDamage);

    void setClusterAmount(int clusterAmount);

    void setClusterDamage(double clusterDamage);
}
