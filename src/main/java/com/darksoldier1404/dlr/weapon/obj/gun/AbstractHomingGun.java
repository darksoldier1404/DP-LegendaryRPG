package com.darksoldier1404.dlr.weapon.obj.gun;

import com.darksoldier1404.dlr.weapon.obj.gun.bullets.HomingBullet;
import org.bukkit.configuration.file.YamlConfiguration;

public class AbstractHomingGun extends AbstractGun implements HomingBullet {
    private boolean isHomingBullet;
    private float startHomingDelay;

    public AbstractHomingGun(YamlConfiguration data) {
        super(data);
        this.isHomingBullet = data.getBoolean("IsHomingBullet");
        this.startHomingDelay = (float) data.getDouble("StartHomingDelay");
    }

    @Override
    public boolean isHomingBullet() {
        return isHomingBullet;
    }

    @Override
    public void setHomingBullet(boolean homingBullet) {
        isHomingBullet = homingBullet;
    }

    @Override
    public float getStartHomingDelay() {
        return startHomingDelay;
    }

    @Override
    public void setStartHomingDelay(float startHomingDelay) {
        this.startHomingDelay = startHomingDelay;
    }

}
