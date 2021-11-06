package com.darksoldier1404.dlr.events.fire;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class BulletHitedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player shooter;
    private final Arrow arrow;
    private final Location lastLocation;

    public BulletHitedEvent(final Arrow arrow) {
        this.shooter = (Player) arrow.getShooter();
        this.arrow = arrow;
        this.lastLocation = arrow.getLocation();

    }

    public Player getShooter() {
        return shooter;
    }

    public Arrow getArrow() {
        return arrow;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
