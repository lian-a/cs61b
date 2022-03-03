import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChar() {
        Character input2 = 'a';
        Character input3 = 'b';
        Character input4 = 'A';
        Character input5 = 'B';
        Character input6 = 0;
        assertFalse(offByOne.equalChars(input2, input2));
        assertTrue(offByOne.equalChars(input2, input3));
        assertTrue(offByOne.equalChars(input5, input4));
        assertFalse(offByOne.equalChars(input6, input5));
        assertFalse(offByOne.equalChars(input6, input6));

    }
}
