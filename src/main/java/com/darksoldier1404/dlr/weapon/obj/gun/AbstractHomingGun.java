package com.darksoldier1404.dlr.weapon.obj.gun;

import com.darksoldier1404.dlr.weapon.obj.gun.bullets.HomingBullet;
import org.bukkit.configuration.file.YamlConfiguration;

public class AbstractHomingGun extends AbstractGun implements HomingBullet {
    private float startHomingDelay;
    private float explosionRange;

    public AbstractHomingGun(YamlConfiguration data) {
        super(data);
        this.startHomingDelay = data.getInt("startHomingDelay");
        this.explosionRange = data.getInt("explosionRange");
    }

    @Override
    public float getStartHomingDelay() {
        return startHomingDelay;
    }

    @Override
    public void setStartHomingDelay(float startHomingDelay) {
        this.startHomingDelay = startHomingDelay;
    }

    @Override
    public float getExplosionRange() {
        return explosionRange;
    }

    @Override
    public void setExplosionRange(float explosionRange) {
        this.explosionRange = explosionRange;
    }
}
