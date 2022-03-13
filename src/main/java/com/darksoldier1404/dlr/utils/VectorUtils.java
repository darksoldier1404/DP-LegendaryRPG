package com.darksoldier1404.dlr.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;


public class VectorUtils {

    public static Vector getRandomCirclePoint(Location center, double radius) {
        double angle = Math.random() * 2.0 * Math.PI;
        double x = center.getX() + radius * Math.cos(angle);
        double z = center.getZ() + radius * Math.sin(angle);
        center.clone().add(x, 0, z);
        return center.toVector();
    }
}
