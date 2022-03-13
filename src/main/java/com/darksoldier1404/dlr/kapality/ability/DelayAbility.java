package com.darksoldier1404.dlr.kapality.ability;

import com.darksoldier1404.dlr.kapality.ability.obj.Ability;
import com.darksoldier1404.dlr.kapality.ability.obj.AbilityAbstract;
import com.darksoldier1404.dlr.kapality.ability.obj.AbilityCast;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class DelayAbility extends AbilityAbstract implements Ability {
    private int delay;

    public DelayAbility(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public void cast(Player caster, AbilityCast cast, BukkitTask task) {
        try {
            task.wait(delay*20L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
