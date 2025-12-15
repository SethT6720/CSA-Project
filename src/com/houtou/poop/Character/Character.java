package com.houtou.poop.Character;

import com.houtou.poop.Coords;

public class Character {
    private String name;
    private int health;
    private Coords position;

    public Character() {
        this.name = "new character";
        this.health = 10;
        this.position = new Coords(0, 0);
    }

    public Character(String name, int health, int x, int y) {
        this.name = name;
        this.health = health;
        this.position = new Coords(x, y);
    }
}
