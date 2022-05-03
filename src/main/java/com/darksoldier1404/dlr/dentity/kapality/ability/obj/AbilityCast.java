package com.darksoldier1404.dlr.dentity.kapality.ability.obj;

import com.darksoldier1404.dlr.LegendaryRPG;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class AbilityCast {
    private final ArrayList<Ability> abilities;
    private final ArrayList<Entity> targetList;
    private boolean isCooldown;

    public AbilityCast() {
        abilities = new ArrayList<>();
        targetList = new ArrayList<>();
        isCooldown = false;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
        LegendaryRPG.getInstance().getLogger().info("Added ability: " + ability.getClass().getName());
    }

    public void removeAbility(Ability ability) {
        abilities.remove(ability);
    }

    public void clear() {
        abilities.clear();
    }

    public void addTarget(Entity entity) {
        targetList.add(entity);
    }

    public void removeTarget(Entity entity) {
        targetList.remove(entity);
    }

    public List<Entity> getTargetList() {
        return targetList;
    }

    public void clearTarget() {
        targetList.clear();
    }

    public boolean isCooldown() {
        return isCooldown;
    }

    public void setCooldown(boolean cooldown) {
        isCooldown = cooldown;
    }

    public void cast(Player caster) {
        Bukkit.getScheduler().runTask(LegendaryRPG.getInstance(), () -> {
            for (Ability ability : abilities) {
                ability.cast(caster, this);
            }
        });
    }
}
