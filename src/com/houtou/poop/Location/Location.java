package com.houtou.poop.Location;

import com.houtou.poop.Coords;

public class Location {
    private final Coords position;
    private final String description;
    private final boolean isEnterable;

    public Location(int x, int y, String coordsDescription, String tileDescription) {
        this.position = new Coords(x, y, coordsDescription, this);
        this.description = tileDescription;
        this.isEnterable = false;
    }

    public Location() {
        this(0, 0, "default location", "this is a tile");
    }

    public Coords getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnterable() {
        return isEnterable;
    }
}
