package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class position {
    int xPos;
    int yPos;
    public position(int x, int y) {
        xPos = x;
        yPos = y;
    }
    public void Grass(TETile[][] world) {
        if (xPos != 0 && yPos != 0 && xPos != 79 && yPos != 39) {
            world[xPos][yPos] = Tileset.GRASS;
        }
    }

    public boolean PosOutOfDex() {
        return (xPos < 0 || xPos >= 80 || yPos < 0 || yPos >= 40);
    }

    public boolean Overlapped(TETile[][] world) {
        return (world[xPos][yPos] != Tileset.NOTHING);
    }
}
