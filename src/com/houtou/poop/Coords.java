package com.houtou.poop;

import com.houtou.poop.Location.Location;

public class Coords {
    public int x;
    public int y;
    public String description;
    public Location thingHere;

    public Coords(int x, int y, String description, Location thingHere) {
        this.x = x;
        this.y = y;
        this.description = description;
        this.thingHere = thingHere;
    }

    public boolean isTileEnterable() {
        return thingHere.isEnterable();
    }

    public String toString() {
        return String.format("(%d, %d): %s", x, y, description);
    }
}
