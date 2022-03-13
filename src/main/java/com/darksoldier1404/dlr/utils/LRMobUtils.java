package com.darksoldier1404.dlr.utils;

import com.darksoldier1404.dlr.LegendaryRPG;

import java.util.UUID;

public class LRMobUtils {

    public static boolean isLRMob(UUID uuid) {
        return LegendaryRPG.getInstance().getSummonedLRMobs().containsKey(uuid);
    }
}
