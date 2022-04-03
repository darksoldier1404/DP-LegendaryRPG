package com.darksoldier1404.dlr.events;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.events.fire.GunFireEvent;
import com.darksoldier1404.dlr.utils.BulletUtils;
import com.darksoldier1404.dlr.utils.GunUtils;
import com.darksoldier1404.dlr.weapon.obj.enums.BulletType;
import com.darksoldier1404.dppc.utils.NBT;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

@SuppressWarnings("all")
public class GunFireLogic implements Listener {
    private final LegendaryRPG plugin = LegendaryRPG.getInstance();
    private final Set<UUID> fired = new HashSet<>();


    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        e.setCancelled(true);
        Player p = e.getPlayer();
        GunUtils.reload(p, e.getPlayer().getItemInHand());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) { // TODO: 최적화 진행
        Bukkit.getScheduler().runTask(plugin, () -> {
            Player p = e.getPlayer();
            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                if (e.getItem() == null) return;
                ItemStack item = e.getItem();
                if (NBT.hasTagKey(item, "fireRate")) {
                    e.setCancelled(true);
                    // if while reloading return
                    if (GunUtils.reloading.contains(p.getUniqueId())) {
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§ccancel reloading"));
                        GunUtils.reloading.remove(p.getUniqueId());
                        return;
                    }
                    if (fired.contains(p.getUniqueId())) return;
                    int ammo = NBT.getIntegerTag(item, "currentMagazineSize");
                    if (ammo <= 0) {
                        GunUtils.reload(p, item);
                        return;
                    }
                    BulletType bulletType = BulletType.valueOf(NBT.getStringTag(item, "bulletType"));
                    boolean isHomingBullet = Boolean.parseBoolean(NBT.getStringTag(item, "isHomingBullet"));
                    float bulletSpeed = NBT.getFloatTag(item, "bulletSpeed");
                    float fireRate = NBT.getFloatTag(item, "fireRate");
                    float bulletDeletionTime = NBT.getFloatTag(item, "bulletDeletionTime");
                    float multiShot = NBT.getFloatTag(item, "multiShot");
                    float accuracy = NBT.getFloatTag(item, "accuracy");
                    int im = (int) multiShot;
                    float imp = multiShot - im;

                    List<LivingEntity> les = new ArrayList<>();
                    if (isHomingBullet) {
                        for (Entity ne : p.getNearbyEntities(70, 70, 70)) {
                            if (ne instanceof LivingEntity) {
                                les.add((LivingEntity) ne);
                            }
                        }
                    }
                    for (int i = 0; i < im; i++) {
                        if (isHomingBullet) {
                            BulletUtils.launchHomingProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy, les);
                            continue;
                        }
                        BulletUtils.launchProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy);
                    }
                    if (imp > 0) {
                        if (Math.random() < imp) {
                            if (isHomingBullet) {
                                BulletUtils.launchHomingProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy, les);
                            } else {
                                BulletUtils.launchProjectile(p, item, bulletSpeed, bulletDeletionTime, accuracy);
                            }
                        }
                    }
                    // after launched bullet
                    if (!((long) (20 / fireRate) == 0)) {
                        fired.add(p.getUniqueId());
                        Bukkit.getScheduler().runTaskLater(plugin, () -> fired.remove(p.getUniqueId()), (long) (20 / fireRate));
                    }
                    p.playSound(p.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 0.6F, 1.6F);
                    Bukkit.getPluginManager().callEvent(new GunFireEvent(p, item));
                    item = NBT.setIntTag(item, "currentMagazineSize", NBT.getIntegerTag(item, "currentMagazineSize") - 1);
                    p.spigot().sendMessage(ChatMessageType.SYSTEM, TextComponent.fromLegacyText("§cAmmo: " + NBT.getIntegerTag(item, "currentMagazineSize") + "/" + NBT.getIntegerTag(item, "magazineSize")));
                    p.setItemInHand(item);
                }
            }
        });
    }


}
