package com.houtou.poop.Character;

import com.houtou.poop.Item.Item;
import com.houtou.poop.Map;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {
    public List<Item> inventory = new ArrayList<Item>();
    public List<Item> equippedItems = new ArrayList<Item>();
    public Map currentMap;
    private int gold;
    private boolean isWeaponEquipped = false;
    private boolean isArmorEquipped = false;
    private boolean isAccessoryEquipped = false;

    public Player(String name, int health, int x, int y, String coordsDescription) {
        super(name, health, x, y, coordsDescription);
        this.gold = 0;
    }

    public String toString() {
        return getPosition().toString();
    }

    public void unequipItem(String type) {
        switch (type) {

            case "weapon":
                if(!isWeaponEquipped) {
                    System.out.println("You dont have anything to unequip");
                    return;
                }

                equippedItems.remove(0);
                break;
            case "armor":
                if(!isArmorEquipped) {
                    System.out.println("You dont have anything to unequip");
                    return;
                }

                equippedItems.remove(1);
                break;
            case "accessory":
                if(!isAccessoryEquipped) {
                    System.out.println("You dont have anything to unequip");
                    return;
                }

                equippedItems.remove(2);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void equipItem(Item item) {
        switch(item.getType()) {
            case "weapon":
                if(!isWeaponEquipped) {
                    System.out.println("You already have an item equipped in that slot");
                    return;
                }
                equippedItems.add(0, item);
                isWeaponEquipped = true;
                break;
            case "armor":
                if(!isArmorEquipped) {
                    System.out.println("You already have an item equipped in that slot");
                    return;
                }
                equippedItems.add(1, item);
                isArmorEquipped = true;
                break;
            case "accessory":
                if(isAccessoryEquipped) {
                    System.out.println("You already have an item equipped in that slot");
                    return;
                }
                equippedItems.add(2, item);
                isAccessoryEquipped = true;
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

}
