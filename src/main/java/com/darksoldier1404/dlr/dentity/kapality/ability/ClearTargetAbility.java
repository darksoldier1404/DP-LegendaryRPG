package com.darksoldier1404.dlr.dentity.kapality.ability;

import com.darksoldier1404.dlr.dentity.kapality.ability.obj.Ability;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityAbstract;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityCast;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class ClearTargetAbility extends AbilityAbstract implements Ability {

    @Override
    public void cast(Player caster, AbilityCast cast, BukkitTask task) {
        cast.getTargetList().clear();
    }
}
