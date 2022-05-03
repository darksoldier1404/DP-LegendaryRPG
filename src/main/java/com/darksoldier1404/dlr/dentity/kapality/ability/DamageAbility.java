package com.darksoldier1404.dlr.dentity.kapality.ability;

import com.darksoldier1404.dlr.dentity.kapality.ability.obj.Ability;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityAbstract;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityCast;
import com.darksoldier1404.dlr.dentity.obj.ElementalType;
import com.darksoldier1404.dlr.utils.DamageUtils;
import com.darksoldier1404.dlr.utils.LRMobUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class DamageAbility extends AbilityAbstract implements Ability {
    private final double damage;
    private final ElementalType elementalType;

    public DamageAbility(YamlConfiguration data, String key) {
        damage = data.getDouble(key + ".Damage");
        elementalType = ElementalType.valueOf(data.getString(key + ".ElementalType"));
    }

    @Override
    public void cast(Player caster, AbilityCast cast, BukkitTask task) {
        cast.getTargetList().forEach(target -> {
            if(LRMobUtils.isLRMob(target.getUniqueId())) {
                DamageUtils.damage(LRMobUtils.getLRMob(target.getUniqueId()), elementalType, damage);
            }
        });
    }
}
