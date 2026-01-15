package com.houtou.poop.Location;

import com.houtou.poop.Map;

public class EnterableLocation extends Location {
    private final Map locationMap;
    private final boolean isEnterable;
    private final int enemyScale;
    private final String enemyName;

    public EnterableLocation(int x, int y, String coordsDescription, String tileDescription, int mapWidth, int mapHeight, int enemyScale, String enemyName) {
        super(x, y, coordsDescription, tileDescription);
        locationMap = new Map(mapWidth, mapHeight);
        getPosition().thingHere = this;
        this.isEnterable = true;
        this.enemyScale = enemyScale;
        this.enemyName = enemyName;
    }

    public boolean isEnterable() {
        return isEnterable;
    }

    public Map getLocationMap() {
        return locationMap;
    }

    public int getEnemyScale() {
        return enemyScale;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void enterLocation() {

    }
}
