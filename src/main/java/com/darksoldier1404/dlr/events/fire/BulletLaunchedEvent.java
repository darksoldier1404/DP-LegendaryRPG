package com.darksoldier1404.dlr.events.fire;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class BulletLaunchedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player shooter;
    private final ItemStack gun;
    private final Arrow bullet;

    public BulletLaunchedEvent(final Player shooter, final ItemStack gun, final Arrow bullet) {
        this.shooter = shooter;
        this.gun = gun;
        this.bullet = bullet;
    }

    public Player getShooter() {
        return shooter;
    }

    public ItemStack getGun() {
        return gun;
    }

    public Arrow getBullet() {
        return bullet;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
