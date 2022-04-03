package com.darksoldier1404.dlr.dEntity.kapality.enums;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("all")
public enum ProjectileType {
    ARROW("Arrow"),
    DRAGONFIREBALL("Dragonfireball"),
    EGG("Egg"),
    ENDERPEARL("Enderpearl"),
    FIREBALL("Fireball"),
    FIREWORK("Firework"),
    FISHHOOK("Fishhook"),
    LARGEFIREBALL("Largefireball"),
    LINGERINGPOTION("Lingeringpotion"),
    LLAMASPIT("Llamaspit"),
    SHULKERBULLET("Shulkerbullet"),
    SIZEDFIREBALL("Sizedfireball"),
    SMALLFIREBALL("Smallfireball"),
    SNOWBALL("Snowball"),
    SPECTRALARROW("Spectralarrow"),
    SPLASHPOTION("Splashpotion"),
    THROWABLEPROJECTILE("Throwableprojectile"),
    THROWNEXPBOTTLE("Thrownexpbottle"),
    THROWNPOTION("Thrownpotion"),
    TIPPEDARROW("Tippedarrow"),
    TRIDENT("Trident"),
    WITHERSKULL("Witherskull");

    private final String name;

    private ProjectileType(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public static ProjectileType getByName(final String name) {
        for (final ProjectileType type : values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }
}
