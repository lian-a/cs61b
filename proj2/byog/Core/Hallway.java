package byog.Core;
import byog.TileEngine.TETile;

import java.util.Random;

public class Hallway {
    int length;
    position start;
    int direction;
    public Hallway(position s, int x, int di) {
        length = x;
        start = s;
        direction = di;
    }

    public static  final Random random = new Random(72382);
    public position endPosition() {
           switch (direction) {
               case 0: return new position(start.xPos, start.yPos + length - 1);
               case 1: return new position(start.xPos + length - 1, start.yPos);
               case 2: return new position(start.xPos, start.yPos - length + 1);
               case 3: return new position(start.xPos - length + 1, start.yPos);
               default: return null;
           }
    }
    public position nextRoomPos(Size s) {
        int dx = random.nextInt(s.length - 2);
        int dy = random.nextInt(s.width - 2);
        if (s.length == 3 && (direction == 0 || direction == 2)) {
            return new position(endPosition().xPos - 1, endPosition().yPos);
        } else if (s.width == 3 && (direction == 1)){
            return new position(endPosition().xPos, endPosition().yPos - 1);
        } else {
            switch (direction) {
                case 0: return new position(endPosition().xPos - dx - 1, endPosition().yPos);
                case 1: return new position(endPosition().xPos, endPosition().yPos - dy - 1);
                case 2: return new position(endPosition().xPos - dx - 1, endPosition().yPos - s.width + 1);
                default: return null;
            }
        }
    }

    private Room drawHelper() {
        switch (direction) {
            case 0: {
                position p = new position(start.xPos - 1, start.yPos);
                return new Room(p, 3, length);
            }
            case 1: {
                position p = new position(start.xPos, start.yPos - 1);
                return new Room(p, length, 3);
            }
            case 2: {
                position p = new position(endPosition().xPos - 1, endPosition().yPos);
                return new Room(p, 3, length);
            }
            case 3: {
                position p = new position(endPosition().xPos, endPosition().yPos -1);
                return new Room(p, length, 3);
            }
            default: return null;
        }
    }

    public void drawHallway(TETile[][] world) {
        drawHelper().drawRoom(world);
    }
}
