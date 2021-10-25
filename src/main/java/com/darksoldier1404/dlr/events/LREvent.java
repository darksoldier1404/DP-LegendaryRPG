package com.darksoldier1404.dlr.events;

import com.darksoldier1404.dlr.LegendaryRPG;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class LREvent implements Listener {

    @EventHandler
    public void onClickEntity(PlayerMoveEvent e) {

        Bukkit.getScheduler().runTask(LegendaryRPG.getInstance(), () -> System.out.println("asd"));

    }

    @EventHandler
    public void onRightClickEvent(PlayerInteractEvent e) {
        System.out.println(e.getAction());
    }


}
