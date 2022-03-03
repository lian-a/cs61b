public class OffByN implements CharacterComparator {

    private int distance;
    public OffByN(int N) {
        distance = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == distance || y - x == distance) {
            return true;
        } else {
            return false;
        }
    }
}
