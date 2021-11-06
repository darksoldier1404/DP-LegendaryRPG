package com.darksoldier1404.dlr.weapon.obj.enums;

public enum BulletType {
    NORMAL("일반"),
    HOMING("유도"),
    EXPLOSIVE("폭발"),
    PENETRATING("관통"),
    CHAIN("체인"),
    LASER("레이저"),

    ;

    private final String description;

    BulletType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
