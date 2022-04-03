package com.darksoldier1404.dlr.dEntity.kapality.ability;

import com.darksoldier1404.dlr.dEntity.kapality.ability.obj.Ability;
import com.darksoldier1404.dlr.dEntity.kapality.ability.obj.AbilityAbstract;
import com.darksoldier1404.dlr.dEntity.kapality.ability.obj.AbilityCast;
import com.darksoldier1404.dlr.dEntity.kapality.enums.TargetType;
import com.darksoldier1404.dlr.utils.Cone;
import com.darksoldier1404.dlr.utils.LRMobUtils;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("unused")
public class TargetAbility extends AbilityAbstract implements Ability {
    private final TargetType targetType;
    private final double range;
    private final double angle;
    private final int maxTarget;

    public TargetAbility(TargetType targetType, double range, double angle, int maxTarget) {
        this.targetType = targetType;
        this.range = range;
        this.angle = angle;
        this.maxTarget = maxTarget;
    }

    @Override
    public void cast(Player caster, AbilityCast cast, BukkitTask task) {
        switch (targetType) {
            case CIRCLE:
                caster.getNearbyEntities(range, 2, range).forEach(entity -> {
                    if (cast.getTargetList().size() >= maxTarget) return;
                    if (LRMobUtils.isLRMob(entity.getUniqueId())) {
                        cast.addTarget(entity);
                    }
                });
                return;
            case LINE:
                Cone.getEntitiesInCone(caster.getNearbyEntities(range, 2, range), caster.getLocation().toVector(), range, 5, caster.getLocation().getDirection()).forEach(entity -> {
                    if (cast.getTargetList().size() >= maxTarget) return;
                    if (LRMobUtils.isLRMob(entity.getUniqueId())) {
                        cast.addTarget(entity);
                    }
                });
                return;
            case CONE:
                Cone.getEntitiesInCone(caster.getNearbyEntities(range, 2, range), caster.getLocation().toVector(), range, angle, caster.getLocation().getDirection()).forEach(entity -> {
                    if (cast.getTargetList().size() >= maxTarget) return;
                    if (LRMobUtils.isLRMob(entity.getUniqueId())) {
                        cast.addTarget(entity);
                    }
                });
                return;
            case SPHERE:
                caster.getNearbyEntities(range, range, range).forEach(entity -> {
                    if (cast.getTargetList().size() >= maxTarget) return;
                    if (LRMobUtils.isLRMob(entity.getUniqueId())) {
                        cast.addTarget(entity);
                    }
                });
        }
    }
}
