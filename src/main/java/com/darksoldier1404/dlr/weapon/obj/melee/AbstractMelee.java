package com.darksoldier1404.dlr.weapon.obj.melee;

import com.darksoldier1404.dlr.weapon.obj.WarDamageImpl;
import com.darksoldier1404.dlr.weapon.obj.enums.WeaponType;
import org.bukkit.Material;

@SuppressWarnings("unused")
public class AbstractMelee extends WarDamageImpl implements Melee {
    //weapon
    private String displayName;
    private int requiredLevel;
    private int currentLevel;
    private int maxLevel;
    private double currentExp;
    private double maxExp;
    private Material material;
    private WeaponType weaponType;
    // melee
    private byte attackSpeed;
    private byte range;
    private double comboDuration;

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public int getRequiredLevel() {
        return requiredLevel;
    }

    @Override
    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public double getCurrentExp() {
        return currentExp;
    }

    @Override
    public void setCurrentExp(double currentExp) {
        this.currentExp = currentExp;
    }

    @Override
    public double getMaxExp() {
        return maxExp;
    }

    @Override
    public void setMaxExp(double maxExp) {
        this.maxExp = maxExp;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public byte getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public void setAttackSpeed(byte attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @Override
    public byte getRange() {
        return range;
    }

    @Override
    public void setRange(byte range) {
        this.range = range;
    }

    @Override
    public double getComboDuration() {
        return comboDuration;
    }

    @Override
    public void setComboDuration(double comboDuration) {
        this.comboDuration = comboDuration;
    }
}
