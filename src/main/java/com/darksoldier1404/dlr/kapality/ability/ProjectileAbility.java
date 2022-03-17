package com.darksoldier1404.dlr.kapality.ability;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.kapality.ability.obj.Ability;
import com.darksoldier1404.dlr.kapality.ability.obj.AbilityAbstract;
import com.darksoldier1404.dlr.kapality.ability.obj.AbilityCast;
import com.darksoldier1404.dlr.kapality.enums.ProjectileType;
import org.bukkit.entity.*;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;

@SuppressWarnings("all")
public class ProjectileAbility extends AbilityAbstract implements Ability {
    private final ProjectileType type;

    public ProjectileAbility(String type) {
        try {
            this.type = ProjectileType.getByName(type);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid ProjectileType");
        }
    }

    public ProjectileType getType() {
        return type;
    }

    @Override
    public void cast(Player caster, AbilityCast cast, BukkitTask task) {
        if (type == ProjectileType.ARROW) {
            Arrow ar = caster.launchProjectile(Arrow.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Arrow"));
        }
        if (type == ProjectileType.DRAGONFIREBALL) {
            DragonFireball ar = caster.launchProjectile(DragonFireball.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "DragonFireball"));
        }
        if (type == ProjectileType.EGG) {
            Egg ar = caster.launchProjectile(Egg.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Egg"));
        }
        if (type == ProjectileType.ENDERPEARL) {
            EnderPearl ar = caster.launchProjectile(EnderPearl.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "EnderPearl"));
        }
        if (type == ProjectileType.FIREBALL) {
            Fireball ar = caster.launchProjectile(Fireball.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Fireball"));
        }
        if (type == ProjectileType.FIREWORK) {
            Firework ar = caster.launchProjectile(Firework.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Firework"));
        }
        if (type == ProjectileType.FISHHOOK) {
            FishHook ar = caster.launchProjectile(FishHook.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "FishHook"));
        }
        if (type == ProjectileType.LARGEFIREBALL) {
            LargeFireball ar = caster.launchProjectile(LargeFireball.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "LargeFireball"));
        }
        if (type == ProjectileType.LINGERINGPOTION) {
            LingeringPotion ar = caster.launchProjectile(LingeringPotion.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "LingeringPotion"));
        }
        if (type == ProjectileType.LLAMASPIT) {
            LlamaSpit ar = caster.launchProjectile(LlamaSpit.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "LlamaSpit"));
        }
        if (type == ProjectileType.SHULKERBULLET) {
            ShulkerBullet ar = caster.launchProjectile(ShulkerBullet.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "ShulkerBullet"));
        }
        if (type == ProjectileType.SIZEDFIREBALL) {
            SmallFireball ar = caster.launchProjectile(SmallFireball.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "SmallFireball"));
        }
        if(type == ProjectileType.SMALLFIREBALL) {
            SmallFireball ar = caster.launchProjectile(SmallFireball.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "SmallFireball"));
        }
        if (type == ProjectileType.SNOWBALL) {
            Snowball ar = caster.launchProjectile(Snowball.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Snowball"));
        }
        if (type == ProjectileType.SPECTRALARROW) {
            SpectralArrow ar = caster.launchProjectile(SpectralArrow.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "SpectralArrow"));
        }
        if (type == ProjectileType.SPLASHPOTION) {
            SplashPotion ar = caster.launchProjectile(SplashPotion.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "SplashPotion"));
        }
        if (type == ProjectileType.THROWABLEPROJECTILE) {
            ThrowableProjectile ar = caster.launchProjectile(ThrowableProjectile.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "ThrowableProjectile"));
        }
        if (type == ProjectileType.THROWNEXPBOTTLE) {
            ThrownExpBottle ar = caster.launchProjectile(ThrownExpBottle.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "ThrownExpBottle"));
        }
        if (type == ProjectileType.THROWNPOTION) {
            ThrownPotion ar = caster.launchProjectile(ThrownPotion.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "ThrownPotion"));
        }
        if (type == ProjectileType.TIPPEDARROW) {
            TippedArrow ar = caster.launchProjectile(TippedArrow.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "TippedArrow"));
        }
        if (type == ProjectileType.TRIDENT) {
            Trident ar = caster.launchProjectile(Trident.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "Trident"));
        }
        if (type == ProjectileType.WITHERSKULL) {
            WitherSkull ar = caster.launchProjectile(WitherSkull.class);
            ar.setMetadata("ProjectileAbilityCast", new FixedMetadataValue(LegendaryRPG.getInstance(), "WitherSkull"));
        }
    }
}
