package com.houtou.poop.Location;

import com.houtou.poop.Map;

public class EnterableLocation extends Location {
    private final Map locationMap;
    private final boolean isEnterable;

    public EnterableLocation(int x, int y, String coordsDescription, String tileDescription, int mapWidth, int mapHeight) {
        super(x, y, coordsDescription, tileDescription);
        locationMap = new Map(mapWidth, mapHeight);
        getPosition().thingHere = this;
        this.isEnterable = true;
    }

    public boolean isEnterable() {
        return isEnterable;
    }

    public Map getLocationMap() {
        return locationMap;
    }

    public void enterLocation() {

    }
}
