package byog.Core;

import java.util.Random;

public class Size {
    int length;
    int width;
    public Size(int x, int y) {
        length = x;
        width = y;
    }
    private static Random random = new Random(234532);
    public static Size getSize() {
        int x = random.nextInt(7) + 3;
        int y = random.nextInt(7) + 3;
        return new Size(x, y);
    }
}
