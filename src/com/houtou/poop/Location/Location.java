package com.houtou.poop.Location;

import com.houtou.poop.Coords;
import com.houtou.poop.Map;

public class Location {
    private Coords position;

    public Location(int x, int y, String coordsDescription) {
        this.position = new Coords(x, y, coordsDescription, null);
    }

    public Location() {
        this(0, 0, "default location");
    }

    public Coords getPosition() {
        return position;
    }
}
