package com.darksoldier1404.dlr.weapon.obj;

@SuppressWarnings("unused")
public interface Melee extends Weapon {
    byte getAttackSpeed();

    byte getRange();

    double getComboDuration();

    void setAttackSpeed(byte attackSpeed);

    void setRange(byte range);

    void setComboDuration(double comboDuration);
}
