package com.darksoldier1404.dlr.events;

import net.minecraft.world.item.SpyglassItem;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class LREvent implements Listener {

    @EventHandler
    public void onInteractWithSpyGlass(PlayerInteractEvent e) {
        if(e.getItem() == null) return;
        if(e.getItem().getType() == Material.SPYGLASS) {
            e.setCancelled(true);
            System.out.println("canceled");
            CraftItemStack ci = (CraftItemStack) e.getItem();
            SpyglassItem si;
        }
    }
}
