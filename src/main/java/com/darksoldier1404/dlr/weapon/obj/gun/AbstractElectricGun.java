package com.darksoldier1404.dlr.weapon.obj.gun;

import com.darksoldier1404.dlr.weapon.obj.gun.bullets.ElectricBullet;
import org.bukkit.configuration.file.YamlConfiguration;

public class AbstractElectricGun extends AbstractGun implements ElectricBullet {
    private float chainRange;
    private float maxChainRange;
    private double chainDamage;


    public AbstractElectricGun(YamlConfiguration data) {
        super(data);
        this.chainRange = (float) data.getDouble("chainRange");
        this.maxChainRange = (float) data.getDouble("maxChainRange");
        this.chainDamage = data.getDouble("chainDamage");
    }

    @Override
    public float getChainRange() {
        return chainRange;
    }

    @Override
    public void setChainRange(float chainRange) {
        this.chainRange = chainRange;
    }

    @Override
    public float getMaxChainRange() {
        return maxChainRange;
    }

    @Override
    public void setMaxChainRange(float maxChainRange) {
        this.maxChainRange = maxChainRange;
    }

    @Override
    public double getChainDamage() {
        return chainDamage;
    }

    @Override
    public void setChainDamage(double chainDamage) {
        this.chainDamage = chainDamage;
    }
}
