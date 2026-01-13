package com.houtou.poop.Character;

public class Fighter extends Character {
    private int strength;
    private int defense;

    public Fighter(String name, int maxHealth, int x, int y, String coordsDescription, int strength, int defense) {
        super(name, maxHealth, x, y, coordsDescription);
        this.strength = strength;
        this.defense = defense;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }
}
