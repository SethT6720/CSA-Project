package com.houtou.poop.Character;

import com.houtou.poop.Coords;

public class Character {
    private String name;
    private int health;
    private int maxHealth;
    private Coords position;

    public Character() {
        this("new character", 10, 0, 0, "character location");
    }

    public Character(String name, int maxHealth, int x, int y, String coordsDescription) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.position = new Coords(x, y, coordsDescription, null);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Coords getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPosition(Coords position) {
        this.position = position;
    }

}
