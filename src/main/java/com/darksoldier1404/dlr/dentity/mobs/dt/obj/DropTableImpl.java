package com.darksoldier1404.dlr.dentity.mobs.dt.obj;

import com.darksoldier1404.dppc.utils.Tuple;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unused")
public class DropTableImpl implements DropTable {
    private final HashMap<Integer, Tuple<Double, ItemStack>> drops = new HashMap<>();

    @Override
    public HashMap<Integer, Tuple<Double, ItemStack>> getDropTable() {
        return drops;
    }

    @Override
    public void addDrop(int index, double chance, ItemStack item) {
        drops.put(index, new Tuple<>(chance, item));
    }

    @Override
    public void removeDrop(int index) {
        drops.remove(index);
    }

    @Override
    public void clearDropTable() {
        drops.clear();
    }

    @Override
    public List<ItemStack> drop(int amount) { // chance is 0 ~ 100%
        List<ItemStack> drops = new ArrayList<>();
        int count = 0;
        re:
        for (int i = 0; i < amount; i++) {
            for(int j = 0; j < this.drops.size(); j++) {
                if(Math.random() * 100 < this.drops.get(j).getA()) {
                    count++;
                    drops.add(this.drops.get(j).getB());
                    if(count == amount) break re;
                }
            }
        }
        return drops;
    }
}
