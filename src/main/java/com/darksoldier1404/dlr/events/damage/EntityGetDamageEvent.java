package com.darksoldier1404.dlr.events.damage;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.BulletHitedEvent;
import com.darksoldier1404.dlr.utils.DamageUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class EntityGetDamageEvent implements Listener {
    private final LegendaryRPG plugin = LegendaryRPG.getInstance();

    @EventHandler
    public void onEntityGetDamageByEntity(EntityDamageByEntityEvent e) {
        e.setCancelled(true);
        if (e.getEntity() instanceof Player) return;
        if (e.getEntity() instanceof LivingEntity le) {
            if (e.getDamager() instanceof Projectile ar) {
                if (ar.getShooter() != null) {
                    if (ar.getShooter() instanceof Player) {
                        if (ar instanceof Arrow a) {
                            Player p = (Player) ar.getShooter();
                            ItemStack item = p.getItemInHand();
                            Bukkit.getScheduler().runTask(plugin, () -> le.setNoDamageTicks(0));
                            DamageUtils.damage(plugin.getFBOBJ().get(ar.getUniqueId()), le);
                            plugin.getServer().getPluginManager().callEvent(new BulletHitedEvent(a, item));
                            ar.remove();
                        }
                    }
                }
            }
        }
    }
}
