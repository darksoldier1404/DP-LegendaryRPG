package com.darksoldier1404.dlr.functions;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.commands.SpawnerCommand;
import com.darksoldier1404.dlr.commands.admin.AdminCommand;
import org.bukkit.Bukkit;

import java.util.Arrays;

@SuppressWarnings("all")
public class CommandFunction {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();

    public static void commandRegister() {
        //todo add all admin command, spawner, mob list, weapon give command;
        plugin.getCommand("lra").setExecutor(new AdminCommand());
        plugin.getCommand("lrs").setExecutor(new SpawnerCommand());
    }
}