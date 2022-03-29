package byog.Core;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import org.junit.Test;
import java.util.Random;

public class MapGenerator {
    private static Random random = new Random(327357);
    private static int WIDTH = 80;
    private static int HEIGHT = 40;

    private static position[] empty = new position[100];
    private static Room[] rooms = new Room[20];
    private static Hallway[] hallways =  new Hallway[20];

    /*generate a single room*/
    private static void addRoom(TETile[][] world, position p, Size s,int k) {
        int roomLength = s.length;
        int roomWidth = s.width;
        rooms[k] = new Room(p, roomLength, roomWidth);
        if (!rooms[k].RoomOutOfDex()) {
            rooms[k].drawRoom(world);
        } else {
            rooms[k] = rooms[k - 1];
        }
    }
    private static void addHallway(TETile[][] world, position p, int k, int direction) {
        int wayLength = random.nextInt(5) + 2;
        hallways[k] = new Hallway(p, wayLength, direction);
        if (!hallways[k].endPosition().PosOutOfDex()) {
            hallways[k].drawHallway(world);
        } else {
            hallways[k] = hallways[k - 1];
        }
    }

    private static void multyRoom(TETile[][] world, int RoomNum) {
        position RandomPos = new position(5, 5);
        Size s = new Size(random.nextInt(7) + 3, random.nextInt(7) + 3);
        for (int i = 0; i < RoomNum; i += 1) {
            addRoom(world, RandomPos, s, i);
            int direction1 = random.nextInt(3);
            while (i > 0 && (direction1 - hallways[i - 1].direction == 2 || direction1 - hallways[i - 1].direction == -2)) {
                direction1 = random.nextInt(3);
            }
            RandomPos = rooms[i].getRandom(direction1);
            addHallway(world, RandomPos, i, direction1);
            s = new Size(random.nextInt(7) + 3, random.nextInt(7) + 3);
            RandomPos = hallways[i].nextRoomPos(s);
        }
    }
    public static void connect(TETile[][] world) {
        for (Hallway way : hallways) {
            if (way != null) {
                way.start.Grass(world);
                way.endPosition().Grass(world);
            }
        }
    }
    /*create an object rooms */
    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH,HEIGHT);
        TETile[][] world= new TETile[WIDTH][HEIGHT];
        for (int i = 0; i < WIDTH; i += 1) {
            for (int j = 0; j < HEIGHT; j += 1) {
                world[i][j] = Tileset.NOTHING;
            }
        }
        multyRoom(world, 6);
        connect(world);
        ter.renderFrame(world);
    }

}
