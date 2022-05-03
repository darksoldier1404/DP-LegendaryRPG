package com.darksoldier1404.dlr.dentity.kapality.ability;

import com.darksoldier1404.dlr.dentity.kapality.ability.obj.Ability;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityAbstract;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityCast;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class DelayAbility extends AbilityAbstract implements Ability {
    private long delay;

    public DelayAbility(long delay) {
        this.delay = delay;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    @Override
    public void cast(Player caster, AbilityCast cast, BukkitTask task) {
        try {
            synchronized (task) {
                Thread.sleep(delay*1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
