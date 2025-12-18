package com.houtou.poop;

import java.util.Arrays;

import com.houtou.poop.Location.Location;

public class Map {
    private int width;
    private int height;
    public Coords[][] map;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;

        map = new Coords[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = new Coords(x, y, "Empty Tile", null);
            }
        }
    }

    public void addLocation(int x, int y, Location location) {
        map[y][x] = location.getPosition();
    }

    public String toString() {
        return Arrays.deepToString(map).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
