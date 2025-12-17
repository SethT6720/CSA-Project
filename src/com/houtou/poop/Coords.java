package com.houtou.poop;



public class Coords {
    public int x;
    public int y;
    public String description;
    public Object thingHere;

    public Coords(int x, int y, String description, Object thingHere) {
        this.x = x;
        this.y = y;
        this.description = description;
        this.thingHere = thingHere;
    }

    public boolean isSomethingHere() {
        return thingHere != null;
    }

    public String toString() {
        return String.format("(%d, %d): %s", x, y, description);
    }
}
