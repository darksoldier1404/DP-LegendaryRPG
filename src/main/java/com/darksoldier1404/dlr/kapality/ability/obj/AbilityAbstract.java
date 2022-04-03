package com.darksoldier1404.dlr.kapality.ability.obj;

import com.darksoldier1404.dlr.kapality.enums.AbilityType;

public abstract class AbilityAbstract implements Ability{
    private AbilityType abilityType;

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(AbilityType abilityType) {
        this.abilityType = abilityType;
    }
}
