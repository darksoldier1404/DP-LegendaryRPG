package com.darksoldier1404.dlr.weapon.obj.melee;

import com.darksoldier1404.dlr.weapon.obj.Weapon;

@SuppressWarnings("unused")
public interface Melee extends Weapon {
    byte getAttackSpeed();

    byte getRange();

    double getComboDuration();

    void setAttackSpeed(byte attackSpeed);

    void setRange(byte range);

    void setComboDuration(double comboDuration);
}
