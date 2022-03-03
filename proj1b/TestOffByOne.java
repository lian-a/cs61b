import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChar() {
        Character input1 = 'a';
        Character expected1 = 'a';
        Character expected2 = 'b';
        Character expected3 = 'c';
        assertFalse(offByOne.equalChars(input1, expected1));
        assertTrue(offByOne.equalChars(input1, expected2));
        assertFalse(offByOne.equalChars(input1, expected3));
    }
}
