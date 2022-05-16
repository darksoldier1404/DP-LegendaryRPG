package com.darksoldier1404.dlr.dentity.kapality.ability;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.Ability;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityAbstract;
import com.darksoldier1404.dlr.dentity.kapality.ability.obj.AbilityCast;
import com.darksoldier1404.dlr.utils.ParticleUtil;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

@SuppressWarnings("all")
public class ParticleAbility extends AbilityAbstract implements Ability {
    private final CenterPoint centerPoint;
    private final ParticleCastType particleCastType;
    private final double cpox;
    private final double cpoy;
    private final double cpoz;
    private final double tpox;
    private final double tpoy;
    private final double tpoz;
    private final float speed;
    private final int count;
    private final double space;
    private final Particle particleType;
    private final long delay;
    private final double minRadius;
    private final double maxRadius;
    private final double defaultRadius;

    public ParticleAbility(YamlConfiguration data, String key) {
        centerPoint = CenterPoint.valueOf(data.getString(key + ".CenterPoint").toUpperCase());
        particleCastType = ParticleCastType.valueOf(data.getString(key + ".ParticleCastType").toUpperCase());
        cpox = data.getDouble(key + ".CPOX");
        cpoy = data.getDouble(key + ".CPOY");
        cpoz = data.getDouble(key + ".CPOZ");
        tpox = data.getDouble(key + ".TPOX");
        tpoy = data.getDouble(key + ".TPOY");
        tpoz = data.getDouble(key + ".TPOZ");
        speed = (float) data.getDouble(key + ".SPEED");
        space = data.getDouble(key + ".SPACE");
        count = data.getInt(key + ".COUNT");
        particleType = Particle.valueOf(data.getString(key + ".ParticleType").toUpperCase());
        delay = data.getLong(key + ".Delay");
        minRadius = data.getDouble(key + ".MinRadius");
        maxRadius = data.getDouble(key + ".MaxRadius");
        defaultRadius = data.getDouble(key + ".DefaultRadius");
    }

    @Override
    public void cast(Player caster, AbilityCast cast) {
        Bukkit.getScheduler().runTaskLater(LegendaryRPG.getInstance(), () -> {
            switch (particleCastType) {
                case DOT:
                    if (centerPoint == CenterPoint.CASTER) {
                        ParticleUtil.createParticle(caster, particleType, caster.getLocation().add(cpox, cpoz, cpoy), 0, 0, 0, count, speed);
                    } else {
                        cast.getTargetList().forEach(target -> ParticleUtil.createParticle(caster, particleType, target.getLocation().add(cpox, cpoz, cpoy), 0, 0, 0, count, speed));
                    }
                    break;
                case LINE:
                    if (centerPoint == CenterPoint.CONNECT) {
                        cast.getTargetList().forEach(target -> ParticleUtil.line(caster.getLocation().add(cpox, cpoy, cpoz), target.getLocation().add(tpox, tpoy, tpoz), space, particleType, 0, 0, 0, count, speed));
                    }
                    if (centerPoint == CenterPoint.CASTER) {
                        ParticleUtil.line(caster.getLocation().clone().add(cpox, cpoy, cpoz), caster.getLocation().clone().add(tpox, tpoy, tpoz), space, particleType, 0, 0, 0, count, speed);
                    }
                    break;
                case CIRCLE:
                    if (centerPoint == CenterPoint.CASTER) {
                        ParticleUtil.around(caster, minRadius, maxRadius, particleType, count, speed);
                    }
                    if (centerPoint == CenterPoint.TARGET) {
                        cast.getTargetList().forEach(target -> ParticleUtil.around(target, minRadius, maxRadius, particleType, count, speed));
                    }
                case SPHERE:
                    if (centerPoint == CenterPoint.CASTER) {
                        ParticleUtil.sphere(caster.getLocation(), defaultRadius, space, particleType, count, speed);
                    }
                    if (centerPoint == CenterPoint.TARGET) {
                        cast.getTargetList().forEach(target -> ParticleUtil.sphere(caster.getLocation(), defaultRadius, space, particleType, count, speed));
                    }
            }
        }, delay);
    }

    enum CenterPoint {
        CASTER,
        TARGET,
        CONNECT
    }

    enum ParticleCastType {
        DOT,
        LINE,
        CIRCLE,
        SPHERE,
    }
}
