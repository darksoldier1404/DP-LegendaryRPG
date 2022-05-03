package com.darksoldier1404.dlr.dentity.kapality.ability.obj;

import com.darksoldier1404.dlr.dentity.kapality.enums.AbilityType;
import com.darksoldier1404.dlr.weapon.obj.gun.bullets.Bullet;

import java.util.UUID;

public abstract class BulletAbilityAbstract extends Bullet implements Ability {
    private AbilityType abilityType;

    protected BulletAbilityAbstract() {
        super(UUID.randomUUID());
    }

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(AbilityType abilityType) {
        this.abilityType = abilityType;
    }



}
