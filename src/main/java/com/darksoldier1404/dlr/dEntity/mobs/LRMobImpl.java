package com.darksoldier1404.dlr.dEntity.mobs;

import com.darksoldier1404.dlr.obj.WarDamageableImpl;
import com.darksoldier1404.dppc.utils.ColorUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.UUID;

@SuppressWarnings("all")
public class LRMobImpl extends WarDamageableImpl implements LRMob {
    private UUID uuid;
    private LivingEntity le;
    private EntityType entityType;
    private String name;
    private String displayName;
    private double dropExp;
    private int minLevel;
    private int currentLevel;
    private int maxLevel;
    private double minDropExp;
    private double currentDropExp;
    private double dropExpPerLevel;

    public LRMobImpl(YamlConfiguration data) {
        setEntityType(EntityType.valueOf(data.getString("EntityType")));
        setName(data.getString("Name"));
        setDisplayName(data.getString("DisplayName"));
        setMinDropExp(data.getDouble("MinDropExp"));
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

    public void updateName() {
        le.setCustomName(ColorUtils.applyColor(getDisplayName().replace("<level>", getCurrentLevel() + "") + " | &cHP: " + getCurrentHealth() + "&7/&c" + getDefaultHealth()));
        le.setCustomNameVisible(true);
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

    @Override
    public int getMinLevel() {
        return minLevel;
    }

    @Override
    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    @Override
    public int getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public double getMinDropExp() {
        return minDropExp;
    }

    @Override
    public void setMinDropExp(double minDropExp) {
        this.minDropExp = minDropExp;
    }

    @Override
    public double getCurrentDropExp() {
        return currentDropExp;
    }

    @Override
    public void setCurrentDropExp(double currentDropExp) {
        this.currentDropExp = currentDropExp;
    }

    @Override
    public double getDropExpPerLevel() {
        return dropExpPerLevel;
    }

    @Override
    public void setDropExpPerLevel(double dropExpPerLevel) {
        this.dropExpPerLevel = dropExpPerLevel;
    }
}
