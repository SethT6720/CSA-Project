package com.houtou.poop.Character;

public class Enemy extends Character {
    private int dmg;

    public Enemy(String name, int health, int x, int y, String coordsDescription, int dmg) {
        super(name, health, x, y, coordsDescription);
        this.dmg = dmg;
    }

    public Enemy() {
        this("new enemy", 10, 0, 0, "enemy location", 1);
    }

    public int getDmg() {
        return this.dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}
