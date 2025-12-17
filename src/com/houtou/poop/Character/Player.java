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

    public Player(String name, int health, int x, int y, String coordsDescription) {
        super(name, health, x, y, coordsDescription);
        this.gold = 0;
    }

    public String toString() {
        return getPosition().toString();
    }

    public void unequipItem(int itemIndex) {

    }
    public void equipItem(Item item) {

    }

}
