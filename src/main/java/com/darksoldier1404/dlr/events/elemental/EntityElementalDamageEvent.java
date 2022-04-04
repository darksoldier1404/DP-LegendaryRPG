package com.darksoldier1404.dlr.events.elemental;

import com.darksoldier1404.dlr.dEntity.obj.ElementalType;
import com.darksoldier1404.dlr.obj.WarDamageable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class EntityElementalDamageEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final WarDamageable entity;
    private final ElementalType type;
    private final double damage;

    public EntityElementalDamageEvent(WarDamageable entity, ElementalType type, double damage) {
        this.entity = entity;
        this.type = type;
        this.damage = damage;
    }

    public WarDamageable getEntity() {
        return entity;
    }

    public ElementalType getType() {
        return type;
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
