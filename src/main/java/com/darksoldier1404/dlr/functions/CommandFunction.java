package com.darksoldier1404.dlr.functions;

import com.darksoldier1404.dlr.LegendaryRPG;
import com.darksoldier1404.dlr.commands.SpawnerCommand;
import org.bukkit.Bukkit;

import java.util.Arrays;

@SuppressWarnings("all")
public class CommandFunction {
    private static final LegendaryRPG plugin = LegendaryRPG.getInstance();

    public static void commandRegister() {
        plugin.getCommand("dlrs").setExecutor(new SpawnerCommand());
        //todo 커맨드 얼라이언스 설정법
        plugin.getCommand("dlrs").setAliases(Arrays.asList(plugin.config.getString("cmd-spawner"))).register(Bukkit.getCommandMap());
    }
}