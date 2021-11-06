package com.darksoldier1404.dlr.events.damage;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.utils.DamageUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityGetDamageEvent implements Listener {
    private final LegendaryRPG plugin = LegendaryRPG.getInstance();

    @EventHandler
    public void onEntityGetDamageByEntity(EntityDamageByEntityEvent e) {
        e.setCancelled(true);
        if (e.getEntity() instanceof Player) return;
        if (e.getEntity() instanceof LivingEntity le) {
            Bukkit.getScheduler().runTask(plugin, () -> le.setNoDamageTicks(0));
            if (e.getDamager() instanceof Arrow ar) {
                DamageUtils.damage(ar, le);
            }
        }
    }



}
