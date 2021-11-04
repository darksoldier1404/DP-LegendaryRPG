package com.darksoldier1404.dlr.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LREvent implements Listener {

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {
        if(e.getItem().hasMetadata("dc")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onOpenInventory(InventoryOpenEvent e) {
        if(e.getInventory().getType() == InventoryType.ANVIL) {
            Inventory inv = e.getInventory();
            inv.setItem(0, new ItemStack(Material.STICK));
            inv.setItem(1, new ItemStack(Material.DIAMOND));
            inv.setItem(2, new ItemStack(Material.DIAMOND_SWORD));
        }
    }

    @EventHandler
    public void test(PrepareAnvilEvent e) {
        e.setResult(new ItemStack(Material.DIAMOND_SWORD));
    }
}
