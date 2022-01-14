package com.darksoldier1404.dlr.events.fire;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class BulletHitedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player shooter;
    private final Arrow bullet;
    private final Location lastLocation;

    public BulletHitedEvent(final Arrow bullet) {
        this.shooter = (Player) bullet.getShooter();
        this.bullet = bullet;
        this.lastLocation = bullet.getLocation();

    }

    public Player getShooter() {
        return shooter;
    }

    public Arrow getBullet() {
        return bullet;
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
