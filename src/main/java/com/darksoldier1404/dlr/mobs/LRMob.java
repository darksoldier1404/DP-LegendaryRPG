package com.darksoldier1404.dlr.mobs;

import org.bukkit.entity.EntityType;
/*
Name: "Kuva"

DisplayName: "&f[ &6그리니어 &f] &f&l쿠바 렌서 &f[ &6LV.<level> &f]"
EntityType: ZOMBIE

DropTable:
  TestItem1:
    DropChance: 20
    DropSize: 1-3
  TestItem2:
    DropChance: 20
    DropSize: 1-3
  TestItem3:
    DropChance: 20
    DropSize: 1-3
  TestItem4:
    DropChance: 20
    DropSize: 1-3

Health: 350
Shield: 0
Armor: 8
Damage: 5
DropExp: 100


EntityEquipment:
  HEAD: ItemStack
  CHEST: ItemStack
  LEGS: ItemStack
  FEET: ItemStack
  RIGHT_HAND: ItemStack
  LEFT_HAND: ItemStack

 */
public interface LRMob {
    EntityType getEntityType();
    String getName();
    String getDisplayName();
    double getHealth();
    double getShield();
    double getArmor();
    double getDamage();
    double getDropExp();

}
