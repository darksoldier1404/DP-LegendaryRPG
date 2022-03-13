package com.darksoldier1404.dlr.events.fire;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class GunFireEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player shooter;
    private final ItemStack gun;

    public GunFireEvent(final Player shooter, final ItemStack gun) {
        this.shooter = shooter;
        this.gun = gun;
    }

    public Player getShooter() {
        return shooter;
    }

    public ItemStack getGun() {
        return gun;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
