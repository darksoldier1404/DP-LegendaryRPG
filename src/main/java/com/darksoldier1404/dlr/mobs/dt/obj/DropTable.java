package com.darksoldier1404.dlr.mobs.dt.obj;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public interface DropTable {
    HashMap<Integer, ItemStack> getDropTable();

    void addDrop(int chance, ItemStack item);

    

}
