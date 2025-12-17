package com.houtou.poop.Location;

import com.houtou.poop.Map;

public class EnterableLocation extends Location{
    public Map locationMap;

    public EnterableLocation(int x, int y, String coordsDescription, int mapWidth, int mapHeight) {
        super(x, y, coordsDescription);
        locationMap = new Map(mapWidth, mapHeight);
        getPosition().thingHere = this;
    }
}
