package com.houtou.poop;

import java.util.Arrays;

public class Map {
    public Coords[][] map;

    public Map(int width, int height) {
        map = new Coords[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = new Coords(x, y, "Empty Tile", null);
            }
        }
    }

    public String toString() {
        return Arrays.deepToString(map).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
    }

}

















//k