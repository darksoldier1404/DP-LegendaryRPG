package com.darksoldier1404.dlr.mod.obj;

@SuppressWarnings("all")
public interface Mod {
    String getName();

    String getDescription();

    int getCustomModelData();

    ModType getModType();

    byte getMaxRank();

    byte getCurrentRank();

    short getMaxCapacity();

    short getMinCapacity();

    short getCurrentCapacity();

    ModPolarity getPolarity();


}
