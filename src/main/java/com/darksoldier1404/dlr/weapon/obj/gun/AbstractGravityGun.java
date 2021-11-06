package com.darksoldier1404.dlr.weapon.obj.gun;

import com.darksoldier1404.dlr.weapon.obj.gun.bullets.GravityBullet;
import org.bukkit.configuration.file.YamlConfiguration;

public class AbstractGravityGun extends AbstractGun implements GravityBullet {
    private float gravityRange;
    private float gravityDuration;
    private float gravityPower;
    private double gravityDamage;
    private boolean isReversal;

    public AbstractGravityGun(YamlConfiguration data) {
        super(data);
        this.gravityRange = data.getInt("gravityRange");
        this.gravityDuration = data.getInt("gravityDuration");
        this.gravityPower = data.getInt("gravityPower");
        this.isReversal = data.getBoolean("isReversal");
        this.gravityDamage = data.getDouble("gravityDamage");
    }

    @Override
    public float getGravityRange() {
        return gravityRange;
    }

    @Override
    public void setGravityRange(float gravityRange) {
        this.gravityRange = gravityRange;
    }

    @Override
    public float getGravityDuration() {
        return gravityDuration;
    }

    @Override
    public void setGravityDuration(float gravityDuration) {
        this.gravityDuration = gravityDuration;
    }

    @Override
    public float getGravityPower() {
        return gravityPower;
    }

    @Override
    public void setGravityPower(float gravityPower) {
        this.gravityPower = gravityPower;
    }

    public double getGravityDamage() {
        return gravityDamage;
    }

    public void setGravityDamage(double gravityDamage) {
        this.gravityDamage = gravityDamage;
    }

    public boolean isReversal() {
        return isReversal;
    }

    @Override
    public void setReversal(boolean reversal) {
        isReversal = reversal;
    }
}
