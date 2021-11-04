package com.darksoldier1404.dlr.events.fire;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class GunFireEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player shooter;
    private final Location from;

    public GunFireEvent(final Player shooter, final Location from) {
        this.shooter = shooter;
        this.from = from;
    }

    public Player getShooter() {
        return shooter;
    }

    public Location getFrom() {
        return from;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
