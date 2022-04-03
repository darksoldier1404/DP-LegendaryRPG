package com.darksoldier1404.dlr.kapality.ability;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.kapality.ability.obj.Ability;
import com.darksoldier1404.dlr.kapality.ability.obj.AbilityCast;
import com.darksoldier1404.dlr.kapality.ability.obj.BulletAbilityAbstract;
import com.darksoldier1404.dlr.kapality.enums.ProjectileType;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("all")
public class ProjectileAbility extends BulletAbilityAbstract implements Ability {
    private final ProjectileType type;

    public ProjectileAbility(YamlConfiguration data, String key) {
        try {
            this.type = ProjectileType.getByName(data.getString(key + ".ProjectileType"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid ProjectileType");
        }
        Bukkit.getScheduler().runTask(LegendaryRPG.getInstance(), () -> {
//            setCriticalChance(NBT.getDoubleTag(item, "currentCriticalChance"));
//            setCriticalAmount(NBT.getDoubleTag(item, "currentCriticalAmount"));
//            setImpactDamage(NBT.getDoubleTag(item, "currentImpactDamage"));
//            setPunctureDamage(NBT.getDoubleTag(item, "currentPunctureDamage"));
//            setSlashDamage(NBT.getDoubleTag(item, "currentSlashDamage"));
//            setColdDamage(NBT.getDoubleTag(item, "currentColdDamage"));
//            setElectricityDamage(NBT.getDoubleTag(item, "currentElectricityDamage"));
//            setHeatDamage(NBT.getDoubleTag(item, "currentHeatDamage"));
//            setToxinDamage(NBT.getDoubleTag(item, "currentToxinDamage"));
//            setBlastDamage(NBT.getDoubleTag(item, "currentBlastDamage"));
//            setCorrosiveDamage(NBT.getDoubleTag(item, "currentCorrosiveDamage"));
//            setGasDamage(NBT.getDoubleTag(item, "currentGasDamage"));
//            setMagneticDamage(NBT.getDoubleTag(item, "currentMagneticDamage"));
//            setRadiationDamage(NBT.getDoubleTag(item, "currentRadiationDamage"));
//            setVirusDamage(NBT.getDoubleTag(item, "currentVirusDamage"));
            // bullet type
            // homing
            if (data.getBoolean(key + ".IsHomingBullet")) {
                setHomingBullet(true);
                setStartHomingDelay((float) data.getDouble(key + ".StartHomingDelay"));
            }
            // electric
            if (data.getBoolean(key + ".IsElectricBullet")) {
                setElectricBullet(true);
                setChainRange((float) data.getDouble(key + ".ChainRange"));
                setMaxChainRange((float) data.getDouble(key + ".MaxChainRange"));
                setChainDamage(data.getDouble(key + ".ChainDamage"));
            }
            // gravity
            if (data.getBoolean(key + ".IsGravityBullet")) {
                setGravityBullet(true);
                setGravityRange((float) data.getDouble(key + ".GravityRange"));
                setGravityDuration((float) data.getDouble(key + ".GravityDuration"));
                setGravityPower((float) data.getDouble(key + ".GravityPower"));
                setGravityDamage(data.getDouble(key + ".GravityDamage"));
                setReversal(data.getBoolean(key + ".IsReversal"));
            }
            // explosive
            if (data.getBoolean(key + ".IsExplosiveBullet")) {
                setExplosiveBullet(true);
                setExplosionRange((float) data.getDouble(key + ".ExplosionRange"));
                setExplosionDamage(data.getDouble(key + ".ExplosionDamage"));
                setExplosionKnockBack((float) data.getDouble(key + ".ExplosionKnockBack"));
            }
            // stray
            if (data.getBoolean(key + ".IsStrayBullet")) {
                setStrayBullet(true);
                setStrayExplosionRange((float) data.getDouble(key + ".StrayRange"));
                setStrayExplosionDamage(data.getDouble(key + ".StrayDamage"));
                setStrayExplosionKnockBack((float) data.getDouble(key + ".StrayKnockBack"));
                setStrayExplosionDelay(data.getLong(key + ".StrayExplosionDelay"));
            }
            // harpoon
            if (data.getBoolean(key + ".IsHarpoonBullet")) {
                setHarpoonBullet(true);
                setHarpoonGrabRange((float) data.getDouble(key + ".HarpoonGrabRange"));
                setHarpoonPullRange((float) data.getDouble(key + ".HarpoonPullRange"));
                setHarpoonDamage(data.getDouble(key + ".HarpoonDamage"));
            }
            // cluster
            if (data.getBoolean(key + ".IsClusterBullet")) {
                setClusterBullet(true);
                setClusterExplosionRange((float) data.getDouble(key + ".ClusterExplosionRange"));
                setClusterExplosionDamage(data.getDouble(key + ".ClusterExplosionDamage"));
                setClusterAmount(data.getInt(key + ".ClusterAmount"));
                setClusterDamage(data.getDouble(key + ".ClusterDamage"));
            }
            // remoteExplosive
            if (data.getBoolean(key + ".IsRemoteExplosiveBullet")) {
                setRemoteExplosiveBullet(true);
                setRemoteExplosionRange((float) data.getDouble(key + ".RemoteExplosionRange"));
                setRemoteExplosiveDuration((float) data.getDouble(key + ".RemoteExplosiveDuration"));
                setRemoteExplosionDamage(data.getDouble(key + ".RemoteExplosionDamage"));
                setRemoteExplosionKnockBack((float) data.getDouble(key + ".RemoteExplosionKnockBack"));
            }
            LegendaryRPG.getInstance().getFBOBJ().put(getUniqueId(), this);
        });
    }

    public ProjectileType getType() {
        return type;
    }

    @Override
    public void cast(Player caster, AbilityCast cast, BukkitTask task) {
        Projectile ar;
        switch (type) {
            case ARROW:
                ar = caster.launchProjectile(Arrow.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Arrow"));
                break;
            case DRAGONFIREBALL:
                ar = caster.launchProjectile(DragonFireball.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "DragonFireball"));
                break;
            case EGG:
                ar = caster.launchProjectile(Egg.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Egg"));
                break;

            case ENDERPEARL:
                ar = caster.launchProjectile(EnderPearl.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "EnderPearl"));
                break;
            case FIREBALL:
                ar = caster.launchProjectile(Fireball.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Fireball"));
                break;
            case FIREWORK:
                ar = caster.launchProjectile(Firework.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Firework"));
                break;
            case FISHHOOK:
                ar = caster.launchProjectile(FishHook.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "FishHook"));
                break;
            case LARGEFIREBALL:
                ar = caster.launchProjectile(LargeFireball.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "LargeFireball"));
                break;
            case LINGERINGPOTION:
                ar = caster.launchProjectile(LingeringPotion.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "LingeringPotion"));
                break;
            case LLAMASPIT:
                ar = caster.launchProjectile(LlamaSpit.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "LlamaSpit"));
                break;
            case SHULKERBULLET:
                ar = caster.launchProjectile(ShulkerBullet.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "ShulkerBullet"));
                break;
            case SIZEDFIREBALL:
                ar = caster.launchProjectile(SmallFireball.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "SmallFireball"));
                break;
            case SMALLFIREBALL:
                ar = caster.launchProjectile(SmallFireball.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "SmallFireball"));
                break;
            case SNOWBALL:
                ar = caster.launchProjectile(Snowball.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Snowball"));
                break;
            case SPECTRALARROW:
                ar = caster.launchProjectile(SpectralArrow.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "SpectralArrow"));
                break;
            case SPLASHPOTION:
                ar = caster.launchProjectile(SplashPotion.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "SplashPotion"));
                break;
            case THROWABLEPROJECTILE:
                ar = caster.launchProjectile(ThrowableProjectile.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "ThrowableProjectile"));
                break;
            case THROWNEXPBOTTLE:
                ar = caster.launchProjectile(ThrownExpBottle.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "ThrownExpBottle"));
                break;
            case THROWNPOTION:
                ar = caster.launchProjectile(ThrownPotion.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "ThrownPotion"));
                break;
            case TIPPEDARROW:
                ar = caster.launchProjectile(TippedArrow.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "TippedArrow"));
                break;
            case TRIDENT:
                ar = caster.launchProjectile(Trident.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Trident"));
                break;
            case WITHERSKULL:
                ar = caster.launchProjectile(WitherSkull.class);
                ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "WitherSkull"));
                break;
        }
    }
}
