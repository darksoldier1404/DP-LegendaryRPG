package com.darksoldier1404.dlr.commands.admin;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.dentity.mobs.LRMobImpl;
import com.darksoldier1404.dlr.loader.LRMobLoader;
import com.darksoldier1404.dlr.loader.WeaponLoader;
import com.darksoldier1404.dlr.utils.ParticleUtil;
import com.darksoldier1404.dlr.weapon.obj.gun.GunImpl;
import com.darksoldier1404.dppc.utils.ColorUtils;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("all")
public class AdminCommand implements CommandExecutor, TabCompleter {
    private final String prefix = LegendaryRPG.prefix;
    private final LegendaryRPG plugin = LegendaryRPG.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(prefix + "관리자 전용 커맨드 입니다.");
            return false;
        }
        if (args.length == 0) {
            // reload command
            sender.sendMessage(prefix + "/lra weapon reload : 모든 무기를 콘피그에서 다시 불러옵니다.");
            sender.sendMessage(prefix + "/lra weapon list : 로딩된 모든 무기의 목록을 표시합니다.");
            sender.sendMessage(prefix + "/lra weapon give <무기이름> <플레이어> : 해당 플레이어에게 무기를 지급합니다.");
            sender.sendMessage(prefix + "/lra mob spawn <몹이름> : 해당 몹을 스폰시킵니다.");
            sender.sendMessage(prefix + "/lra mob ka : 소환된 몹을 제거합니다.");
            return false;
        }
//        if(args[0].equals("tp")) {
//            if(args.length == 1) {
//                sender.sendMessage(prefix + "/lra tp <world> : 해당 월드로 이동합니다.");
//                return false;
//            }
//            if(args.length == 2) {
//                if(Bukkit.getWorld(args[1]) == null) {
//                    sender.sendMessage(prefix + "해당 월드가 존재하지 않습니다.");
//                    return false;
//                }
//                Player player = (Player) sender;
//                player.teleport(Bukkit.getWorld(args[1]).getSpawnLocation());
//                return false;
//            }
//            return false;
//        }
//        if(args[0].equals("ms")) {
//            CommandFunction.startMission((Player) sender);
//            return false;
//        }
        if (args[0].equals("test")) {
            LegendaryRPG.getInstance().getAbilities().get("TestAbility").cast((Player) sender);
            return false;
        }
        if (args[0].equals("pt")) {
            Player p = (Player) sender;
            ParticleUtil.square(p.getLocation().clone().add(10, 0, 0), p.getLocation().clone().add(0, 0, 10), p.getLocation().clone().add(-10, 0, 0), p.getLocation().clone().add(0, 0, -10), 0.1F, Particle.FLAME);
            return false;
        }
        if (args[0].equals("mob")) {
            if (args.length == 1) {
                sender.sendMessage(prefix + "/lra mob spawn <몹이름> : 해당 몹을 스폰시킵니다.");
                return false;
            }
            if (args[1].equals("reload")) {
                LRMobLoader.loadMobs();
                sender.sendMessage(prefix + "모든 몹을 콘피그에서 다시 불러왔습니다.");
                return false;
            }
            if (args[1].equals("list")) {
                plugin.getLrmobs().keySet().forEach(o -> sender.sendMessage(prefix + o));
                return false;
            }
            if (args[1].equals("ka")) {
                for (UUID uuid : plugin.getSummonedLRMobs().keySet()) {
                    plugin.getSummonedLRMobs().get(uuid).getLe().remove();
                    plugin.getSummonedLRMobs().remove(uuid);
                }
                return false;
            }
            if (args[1].equals("spawn")) {
                if (args.length == 2) {
                    sender.sendMessage(prefix + "몹 이름을 입력해주세요.");
                    return false;
                }
                if (!plugin.getLrmobs().containsKey(args[2])) {
                    sender.sendMessage(prefix + "해당 몹이 존재하지 않습니다.");
                    return false;
                }
                if (args.length == 4) {
                    for (int i = 0; i < Integer.parseInt(args[3]); i++) {
                        LRMobImpl lrm = new LRMobImpl(plugin.getRawLRMobs().get(args[2]));
                        LivingEntity le = (LivingEntity) ((Player) sender).getWorld().spawnEntity(((Player) sender).getLocation(), lrm.getEntityType());
                        lrm.setUuid(le.getUniqueId());
                        lrm.setLivingEntity(le);
                        lrm.setCurrentHealth(lrm.getDefaultHealth());
                        le.setCustomName(ColorUtils.applyColor(lrm.getDisplayName().replace("<level>", lrm.getCurrentLevel() + "") + " | &cHP: " + lrm.getCurrentHealth() + "&7/&c" + lrm.getDefaultHealth()));
                        le.setCustomNameVisible(true);
                        le.setMaxHealth(lrm.getDefaultHealth());
                        le.setHealth(lrm.getDefaultHealth());
                        le.setRemoveWhenFarAway(false);
                        le.setCanPickupItems(false);
                        plugin.getSummonedLRMobs().put(le.getUniqueId(), lrm);
                    }
                    return false;
                }
                LRMobImpl lrm = new LRMobImpl(plugin.getRawLRMobs().get(args[2]));
                LivingEntity le = (LivingEntity) ((Player) sender).getWorld().spawnEntity(((Player) sender).getLocation(), lrm.getEntityType());
                lrm.setUuid(le.getUniqueId());
                lrm.setLivingEntity(le);
                lrm.setCurrentHealth(lrm.getDefaultHealth());
                le.setCustomName(ColorUtils.applyColor(lrm.getDisplayName().replace("<level>", lrm.getCurrentLevel() + "") + " | &cHP: " + lrm.getCurrentHealth() + "&7/&c" + lrm.getDefaultHealth()));
                le.setCustomNameVisible(true);
                le.setMaxHealth(lrm.getDefaultHealth());
                le.setHealth(lrm.getDefaultHealth());
                le.setRemoveWhenFarAway(false);
                le.setCanPickupItems(false);
                plugin.getSummonedLRMobs().put(le.getUniqueId(), lrm);
            }
            return false;
        }
        if (args[0].equals("weapon")) {
            if (args.length == 1) {
                sender.sendMessage(prefix + "/lra weapon list : 로딩된 모든 무기의 목록을 표시합니다.");
                return false;
            }
            // reload
            if (args[1].equals("reload")) {
                WeaponLoader.loadGuns();
                WeaponLoader.loadMelees();
                sender.sendMessage(prefix + "모든 무기를 콘피그에서 다시 불러왔습니다.");
                return false;
            }
            if (args[1].equals("list")) {
                plugin.getWeapons().keySet().forEach(o -> sender.sendMessage(prefix + o));
                return false;
            }
            if (args[1].equals("give")) {
                if (args.length == 2) {
                    sender.sendMessage(prefix + "무기 이름을 입력해주세요.");
                    return false;
                }
                if (args.length == 3) {
                    sender.sendMessage(prefix + "무기를 지급할 플레이어를 입력해주세요.");
                    return false;
                }
                if (plugin.getWeapons().containsKey(args[2])) {
                    String type = plugin.getRawWeapons().get(args[2]).getString("WeaponType");
                    if (type.equals("GUN")) {
                        GunImpl gun = (GunImpl) plugin.getWeapons().get(args[2]);
                        ItemStack item = gun.getItemStack();
                        Bukkit.getPlayer(args[3]).getInventory().addItem(item);
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return Arrays.asList("mob", "weapon");
        }
        if (args.length == 2) {
            if (args[0].equals("weapon")) {
                return Arrays.asList("list", "give", "reload");
            }
            if (args[0].equals("mob")) {
                return Arrays.asList("spawn", "ka", "reload", "list");
            }
        }
        if (args[0].equals("mob")) {
            if (args[1].equals("spawn")) {
                if (args.length == 3) {
                    return plugin.getLrmobs().keySet().stream().toList();
                }
            }
        }
        if (args[0].equals("weapon")) {
            if (args[1].equals("give")) {
                if (args.length == 3) {
                    return plugin.getWeapons().keySet().stream().toList();
                }
            }
        }
        return null;
    }
}
