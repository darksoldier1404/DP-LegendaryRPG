package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dppc.utils.NBT;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class GunUtils {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();
    public static final Set<UUID> reloading = new HashSet<>();

    public static void reload(Player p, ItemStack item) { // todo 총 칸에 맞춰서 재장전 설정
        if (NBT.hasTagKey(item, "fireRate")) {
            if (reloading.contains(p.getUniqueId())) {
                reloading.remove(p.getUniqueId());
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§c§lCancel reloading"));
                return;
            }
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§c§lReloading..."));
            float reloadTime = NBT.getFloatTag(item, "reloadTime");
            int magazineSize = NBT.getIntegerTag(item, "magazineSize"); //max
            int currentMagazineSize = NBT.getIntegerTag(item, "currentMagazineSize"); //current
            int currentAmmo = NBT.getIntegerTag(item, "currentAmmo");
            reloading.add(p.getUniqueId());
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                ItemStack gun = item;
                reloading.remove(p.getUniqueId());
                gun = NBT.setIntTag(gun, "currentMagazineSize", magazineSize);
                if (currentAmmo - (magazineSize - currentMagazineSize) > 0) {
                    gun = NBT.setIntTag(gun, "currentAmmo", currentAmmo - (magazineSize - currentMagazineSize));
                } else {
                    gun = NBT.setIntTag(gun, "currentAmmo", 0);
                }
                p.getInventory().setItemInMainHand(gun);
            }, (long) (20 * reloadTime));
        }
    }
}
