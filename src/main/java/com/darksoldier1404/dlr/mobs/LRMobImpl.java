package com.darksoldier1404.dlr.mobs;

import com.darksoldier1404.dlr.weapon.obj.WarDamageableImpl;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.UUID;

@SuppressWarnings("all")
public class LRMobImpl extends WarDamageableImpl implements LRMob{
    private UUID uuid;
    private LivingEntity le;
    private EntityType entityType;
    private String name;
    private String displayName;
    private double dropExp;

    public LRMobImpl(YamlConfiguration data) {
        setEntityType(EntityType.valueOf(data.getString("EntityType")));
        setName(data.getString("Name"));
        setDisplayName(data.getString("DisplayName"));
        double health = data.getDouble("Health");
        double shield = data.getDouble("Shield");
        double armor = data.getDouble("Armor");
        double healthPerLevel = data.getDouble("HealthPerLevel");
        double shieldPerLevel = data.getDouble("ShieldPerLevel");
        double armorPerLevel = data.getDouble("ArmorPerLevel");
        setDefaultHealth(health);
        setDefaultShield(shield);
        setDefaultArmor(armor);
        setCurrentHealth(health);
        setCurrentShield(shield);
        setCurrentArmor(armor);
        setHealthPerLevel(healthPerLevel);
        setShieldPerLevel(shieldPerLevel);
        setArmorPerLevel(armorPerLevel);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LivingEntity getLivingEntity() {
        return le;
    }

    public void setLivingEntity(LivingEntity le) {
        this.le = le;
    }

    public LivingEntity getLe() {
        return le;
    }

    public void setLe(LivingEntity le) {
        this.le = le;
    }

    @Override
    public EntityType getEntityType() {
        return entityType;
    }

    @Override
    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public double getDropExp() {
        return dropExp;
    }

    public void setDropExp(double dropExp) {
        this.dropExp = dropExp;
    }
}
