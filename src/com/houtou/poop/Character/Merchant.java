package com.houtou.poop.Character;

import com.houtou.poop.Item.Item;

import java.util.ArrayList;
import java.util.List;

import com.houtou.poop.Coords;

public class Merchant extends Character {
    private List<Item> products;

    public Merchant(){
        super("new merchant", 10, 0, 0, "merchant location");
        this.products = new ArrayList<Item>();
    }

    public Merchant (String name, int health, int x, int y, String coordsDescription, List<Item> products) {
        super(name ,health ,x ,y, coordsDescription);
        this.products = products;
    }
}
