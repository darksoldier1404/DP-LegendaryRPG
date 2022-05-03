package com.darksoldier1404.dlr.dentity.kapality.ability;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.Ability;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityAbstract;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityCast;
import org.bukkit.Bukkit;
import org.bukkit.SoundCategory;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("all")
public class SoundAbility extends AbilityAbstract implements Ability {
    private final TargetPoint targetPoint;
    private final String sound;
    private final float volume;
    private final float pitch;
    private final SoundCategory category;
    private final long delay;

    public SoundAbility(YamlConfiguration data, String key) {
        targetPoint = TargetPoint.valueOf(data.getString(key + ".TargetPoint").toUpperCase());
        sound = data.getString(key + ".SOUND");
        volume = (float) data.getDouble(key + ".VOLUME");
        pitch = (float) data.getDouble(key + ".PITCH");
        category = SoundCategory.valueOf(data.getString(key + ".CATEGORY").toUpperCase());
        delay = data.getLong(key + ".Delay");
    }

    @Override
    public void cast(Player caster, AbilityCast cast) {
        Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
            switch (targetPoint) {
                case CASTER:
                    caster.playSound(caster.getLocation(), sound, category, volume, pitch);
                    break;
                case TARGET:
                    cast.getTargetList().forEach(target -> caster.playSound(target.getLocation(), sound, category, volume, pitch));
                    break;
            }
        }, delay);
    }

    enum TargetPoint{
        CASTER,
        TARGET
    }
}
