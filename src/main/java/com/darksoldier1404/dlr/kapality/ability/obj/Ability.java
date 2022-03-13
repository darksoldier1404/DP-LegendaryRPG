package com.darksoldier1404.dlr.kapality.ability.obj;

import com.darksoldier1404.dlr.kapality.enums.AbilityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public interface Ability {
    void setAbilityType(AbilityType abilityType);

    AbilityType getAbilityType();

    void cast(Player caster, AbilityCast cast, BukkitTask task);
}
