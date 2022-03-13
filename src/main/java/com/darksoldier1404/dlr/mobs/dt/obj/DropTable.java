package com.darksoldier1404.dlr.mobs.dt.obj;

import com.darksoldier1404.dppc.utils.Tuple;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unused")
public interface DropTable {
    HashMap<Integer, Tuple<Double, ItemStack>> getDropTable();

    void addDrop(int index, double chance, ItemStack item);

    void removeDrop(int index);

    void clearDropTable();

    List<ItemStack> drop(int amount);
}
