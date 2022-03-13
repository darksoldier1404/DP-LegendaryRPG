package com.darksoldier1404.dlr.mobs.dt;

import com.darksoldier1404.dlr.mobs.dt.obj.DropTable;
import com.darksoldier1404.dlr.mobs.dt.obj.DropTableAlreadyExists;

import java.util.HashMap;
import java.util.Map;

public final class DropTableManager {
    private static final Map<String, DropTable> dropTables = new HashMap<>();

    public static void registerDropTable(String key, DropTable dropTable) throws DropTableAlreadyExists {
        if(dropTables.containsKey(key)) {
            throw new DropTableAlreadyExists(key);
        }
        dropTables.put(key, dropTable);
    }

    public static void clearDropTable() {
        dropTables.clear();
    }

    public static DropTable getDropTable(String key) {
        return dropTables.get(key);
    }

    public static Map<String, DropTable> getDropTables() {
        return dropTables;
    }

    public static boolean isExistsDropTable(String key) {
        return dropTables.containsKey(key);
    }

    public static void removeDropTable(String key) {
        dropTables.remove(key);
    }

}
