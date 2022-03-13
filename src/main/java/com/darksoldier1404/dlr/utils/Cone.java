package com.darksoldier1404.dlr.utils;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Cone {
 
    /** @param entities
     *            List of nearby entities
     * @param startPos
     *            starting position
     * @param direction
     *            direction of the cone
     * @return All entities inside the cone */
    public static List<Entity> getEntitiesInCone(List<Entity> entities, Vector startPos, double radius, double degrees, Vector direction) {
    	if(entities == null || entities.size() == 0) return null;
 
        List<Entity> newEntities = new ArrayList<>();        //    Returned list
        double squaredRadius = radius * radius;                     //    We don't want to use square root
 
        for (Entity e : entities) {
        	if(!(e instanceof Monster)) continue;
            Vector relativePosition = e.getLocation().toVector();                            //    Position of the entity relative to the cone origin
            relativePosition.subtract(startPos);
            if (relativePosition.lengthSquared() > squaredRadius) continue;                    //    First check : distance
            if (getAngleBetweenVectors(direction, relativePosition) > degrees) continue;    //    Second check : angle
            newEntities.add(e);                                                                //    The entity e is in the cone
        }
        return newEntities;
    }
 
    /** @param startPos
     *            starting position
     * @param radius
     *            distance cone travels
     * @param degrees
     *            angle of cone
     * @param direction
     *            direction of the cone
     * @return All block positions inside the cone */
    public static List<Vector> getPositionsInCone(Vector startPos, double radius, double degrees, Vector direction) {
 
        List<Vector> positions = new ArrayList<>();        //    Returned list
        double squaredRadius = radius * radius;                     //    We don't want to use square root
 
        for (double x=startPos.getBlockX()-radius; x<startPos.getBlockX()+radius; x++)
//            for (float y=startPos.getBlockY()-radius; y<startPos.getBlockY()+radius;)
                for (double z=startPos.getBlockZ()-radius; z<startPos.getBlockZ()+radius; z++) {
                    Vector relative = new Vector(x,startPos.getBlockY(),z);
                    relative.subtract(startPos);
                    if (relative.lengthSquared() > squaredRadius) continue;            //    First check : distance
                    if (getAngleBetweenVectors(direction, relative) > degrees) continue;    //    Second check : angle
                    positions.add(new Vector(x,startPos.getBlockY(),z));                                                //    The position v is in the cone
                }
        return positions;
    }
 
 
    public static float getAngleBetweenVectors(Vector v1, Vector v2) {
        return Math.abs((float)Math.toDegrees(v1.angle(v2)));
    }
}
