package com.houtou.poop.Character;

import com.houtou.poop.Item.Item;
import com.houtou.poop.Item.Tool;
import com.houtou.poop.Map;

import java.util.ArrayList;
import java.util.List;

public class Player extends Fighter {
    public List<Tool> inventory = new ArrayList<Tool>();
    public List<Tool> equippedItems = new ArrayList<Tool>();
    public Map currentMap;
    private int gold;
    private boolean isWeaponEquipped = false;
    private boolean isArmorEquipped = false;
    private boolean isAccessoryEquipped = false;

    public Player(String name, int health, int x, int y, String coordsDescription, int strength, int defense) {
        super(name, health, x, y, coordsDescription, strength, defense);
        this.gold = 0;
        equippedItems.add(0, null);
        equippedItems.add(0, null);
        equippedItems.add(0, null);
    }

    public int getStrength() {
        if (isWeaponEquipped) {
            int modifier = equippedItems.getFirst().getStat();
            return super.getStrength() + modifier;
        }
        return super.getStrength();
    }

    public int getMaxHealth() {
        if (isAccessoryEquipped) {
            int modifier = equippedItems.get(2).getStat();
            return super.getMaxHealth() + modifier;
        }
        return super.getMaxHealth();
    }

    public void setGold(int newGold) {
        gold = newGold;
    }

    public int getGold() {
        return gold;
    }

    public int getDefense() {
        if (isArmorEquipped) {
            int modifier = equippedItems.get(1).getStat();
            return super.getDefense() + modifier;
        }
        return super.getDefense();
    }

    public String toString() {
        return getPosition().toString();
    }

    public String inventoryToString() {
        return inventory.toString().replace("[", "").replace("]", "").replace(", ", "\n\n");
    }

    public String checkEquips() {
        return equippedItems.toString().replace("[", "").replace("]", "").replace(", ", "\n\n");
    }

    public void unequipItem(String type) {
        switch (type) {

            case "weapon":
                if(!isWeaponEquipped) {
                    System.out.println("You don't have anything to unequip");
                    return;
                }
                inventory.add(equippedItems.get(0));
                equippedItems.remove(0);
                equippedItems.add(0, null);
                isWeaponEquipped = false;
                break;
            case "armor":
                if(!isArmorEquipped) {
                    System.out.println("You don't have anything to unequip");
                    return;
                }
                inventory.add(equippedItems.get(1));
                equippedItems.remove(1);
                equippedItems.add(1, null);
                isArmorEquipped = false;
                break;
            case "accessory":
                if(!isAccessoryEquipped) {
                    System.out.println("You don't have anything to unequip");
                    return;
                }
                inventory.add(equippedItems.get(1));
                equippedItems.remove(2);
                equippedItems.add(2, null);
                isAccessoryEquipped = false;
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void equipItem(Tool item) {

        if (!inventory.contains(item)) {
            return;
        }
        switch(item.getType()) {
            case "weapon":
                if(isWeaponEquipped) {
                    System.out.println("You already have an item equipped in that slot");
                    return;
                }
                equippedItems.remove(0);
                equippedItems.add(0, item);
                System.out.println("weapon equipped");
                isWeaponEquipped = true;
                break;
            case "armor":
                if(isArmorEquipped) {
                    System.out.println("You already have an item equipped in that slot");
                    return;
                }
                equippedItems.remove(1);
                equippedItems.add(1, item);
                isArmorEquipped = true;
                break;
            case "accessory":
                if(isAccessoryEquipped) {
                    System.out.println("You already have an item equipped in that slot");
                    return;
                }
                equippedItems.remove(2);
                equippedItems.add(2, item);
                isAccessoryEquipped = true;
                break;
            default:
                System.out.println("Invalid choice");
        }
        inventory.remove(item);
    }

}
