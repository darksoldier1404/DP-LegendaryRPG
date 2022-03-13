package com.darksoldier1404.dlr.events.fire;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("all")
public class BulletHitedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player shooter;
    private final ItemStack weapon;
    private final Arrow bullet;
    private final Location lastLocation;

    public BulletHitedEvent(final Arrow bullet, @Nullable final ItemStack weapon) {
        this.shooter = (Player) bullet.getShooter();
        this.bullet = bullet;
        this.lastLocation = bullet.getLocation();
        this.weapon = weapon;

    }

    public Player getShooter() {
        return shooter;
    }

    public Arrow getBullet() {
        return bullet;
    }

    @Nullable
    public ItemStack getWeapon() {
        return weapon;
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
