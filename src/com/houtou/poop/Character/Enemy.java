package com.houtou.poop.Character;

public class Enemy extends Fighter{

    public Enemy(String name, int health, int x, int y, String coordsDescription, int strength, int defense) {
        super(name, health, x, y, coordsDescription, strength, defense);
    }

    public Enemy() {
        this("new enemy", 10, 0, 0, "enemy location", 1, 1);
    }

}
