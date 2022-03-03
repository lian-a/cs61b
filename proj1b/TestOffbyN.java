import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffbyN {

    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testequalChar() {
        Character d1 = 'a';
        Character d2 = 'f';
        Character d3 = 'g';
        assertTrue(offByN.equalChars(d1, d2));
        assertFalse(offByN.equalChars(d1, d3));
    }
}
