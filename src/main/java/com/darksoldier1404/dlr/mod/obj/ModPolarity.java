package com.darksoldier1404.dlr.mod.obj;

public enum ModPolarity {
    DEPOLISON("Damage, Powers"),
    DEHEMORS("Defensive, Health, Armor"),
    ULTREMIC("Utilities, Mics"),
    STANCE("Melee Stance Polarity");


    private final String description;

    ModPolarity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
