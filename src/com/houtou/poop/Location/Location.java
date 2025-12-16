package com.houtou.poop.Location;

import com.houtou.poop.Coords;
import com.houtou.poop.Map;

public class Location {
    public Coords position;
    public Map locationMap;

    public Location(int x, int y, String coordsDescription, int mapWidth, int mapHeight) {
        this.locationMap = new Map(mapWidth, mapHeight);
        this.position = new Coords(x, y, coordsDescription, this.locationMap);
    }

    public Location() {
        this(0, 0, "default location", 2, 2);
    }
}
