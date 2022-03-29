package byog.Core;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class Room {
    position p;
    int LENGTH;
    int WIDTH;
    public Room(position p, int LENGTH, int WIDTH) {
        this.p = p;
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
    }
    /*get the topRight position*/
    public  position TopRight() {
        return new position(p.xPos + LENGTH, p.yPos + WIDTH);
    }

    private final static Random random = new Random(23475);

    /*get a random start position of hallway*/
    private position randomTop() {
        int sideOffset = random.nextInt(LENGTH - 2) + 1;
        return new position(p.xPos + sideOffset, p.yPos + WIDTH - 1);
    }
    private position randomLow() {
        int sideOffset = random.nextInt(LENGTH - 2) + 1;
        return new position(p.xPos + sideOffset, p.yPos);
    }
    private position randomLeft() {
        int sideOffset = random.nextInt(WIDTH - 2) + 1;
        return new position(p.xPos, p.yPos + sideOffset);
    }
    private position randomRight() {
        int sideOffset = random.nextInt(WIDTH - 2) + 1;
        return new position(p.xPos + LENGTH - 1, p.yPos + sideOffset);
    }
    position getRandom(int direction) {
        switch (direction) {
            case 0: return randomTop();
            case 1: return randomRight();
            case 2: return randomLow();
            case 3: return randomLeft();
            default: return null;
        }
    }
    /*if room is overlapped return true*/
    public boolean RoomOverlapped(TETile[][] world) {
        for (int i = 0; i < LENGTH; i += 1) {
            position temp1 = new position(i + p.xPos, p.yPos);
            position temp2 = new position(i + p.xPos, p.yPos + WIDTH - 1);
            if (temp1.Overlapped(world) || temp2.Overlapped(world)) {
                return true;
            }
        }
        for (int i = 0; i < LENGTH; i += 1) {
            position temp1 = new position(p.xPos, p.yPos + i);
            position temp2 = new position(p.xPos + LENGTH - 1, p.yPos + i);
            if (temp1.Overlapped(world) || temp2.Overlapped(world)) {
                return true;
            }
        }
        return false;
    }

    /**/
    boolean RoomOutOfDex() {
        return (p.PosOutOfDex() || TopRight().PosOutOfDex());
    }

    void drawRoom(TETile[][] world) {
        TETile tile;
        for(int i = 0; i < WIDTH; i += 1) {
            for (int j = 0; j < LENGTH; j += 1) {
                if (i == 0 || j == 0 || j == LENGTH - 1 || i == WIDTH - 1) {
                    tile = Tileset.WALL;
                } else {
                    tile = Tileset.GRASS;
                }
                world[p.xPos + j][p.yPos + i] = tile;
            }
        }
    }
}
