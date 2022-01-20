package com.darksoldier1404.dlr.functions;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.commands.SpawnerCommand;
import com.darksoldier1404.dlr.commands.admin.AdminCommand;
import com.darksoldier1404.dlr.utils.VoidGenerator;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.util.UUID;

@SuppressWarnings("all")
public class CommandFunction {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();

    public static void commandRegister() {
        //todo add all admin command, spawner, mob list, weapon give command;
        plugin.getCommand("lra").setExecutor(new AdminCommand());
        plugin.getCommand("lrs").setExecutor(new SpawnerCommand());
    }

//    public static void startMission(Player p) {
//        initWorld(p.getUniqueId());
//        File a1 = new File(plugin.getDataFolder(), "a1.schem");
//        File a2 = new File(plugin.getDataFolder(), "a2.schem");
//        World w = initWorld(p.getUniqueId());
//        AtomicReference<BlockVector3> end = null;
//        try {
//            Clipboard c1 = BuiltInClipboardFormat.FAST.load(a1);
//            Clipboard c2 = BuiltInClipboardFormat.FAST.load(a2);
//            try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(BukkitAdapter.adapt(w), -1)) {
//                ClipboardHolder ch = new ClipboardHolder(c1);
//                PasteBuilder pb = ch.createPaste(editSession);
//                pb.to(BlockVector3.at(0, 64, 0));
//                pb.ignoreAirBlocks(false);
//                Operation o = pb.build();
////                c1.getRegion().forEach(b -> {
////                    if((b.getBlock(editSession.getRegionExtent()).getBlockType().getId() == "minecraft:structure_void")) {
////                        end.set(b);
////                    }
////                });
//                Operations.complete(o);
//            }
//            if(end != null) {
//                try (EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(BukkitAdapter.adapt(w), -1)) {
//                    Operation operation = new ClipboardHolder(c2)
//                            .createPaste(editSession)
//                            .to(end.get())
//                            .ignoreAirBlocks(false)
//                            .build();
//                    Operations.complete(operation);
//                    c2.getRegion().forEach(b -> {
//                        if((b.getBlock(editSession.getRegionExtent()).getBlockType().getId() == "minecraft:structure_void")) {
//                            end.set(b);
//                        }
//                    });
//                }
//            }
//            p.teleport(new Location(w, 0, c1.getOrigin().getBlockY()+1, 0));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static World initWorld(UUID uuid) {
        World w = Bukkit.getWorld("Mission-" + uuid);
        if (w == null) {
            plugin.getLogger().info(uuid + " - Mission World generating...");
            WorldCreator wc = new WorldCreator("Mission-" + uuid);
            wc.generator(new VoidGenerator());
            w = wc.createWorld();
            w.setSpawnLocation(0, 64, 0);
            w.setGameRule(GameRule.KEEP_INVENTORY, true);
            w.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            w.setGameRule(GameRule.DO_FIRE_TICK, false);
            w.setGameRule(GameRule.DISABLE_RAIDS, false);
            w.setGameRule(GameRule.DO_TRADER_SPAWNING, false);
            w.setGameRule(GameRule.DO_PATROL_SPAWNING, false);
            w.setGameRule(GameRule.DO_INSOMNIA, false);
        }
        Bukkit.getWorlds().add(w);
        return w;
    }
}