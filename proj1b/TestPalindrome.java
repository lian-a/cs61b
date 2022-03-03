import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
//    static OffByOne offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /*Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testisPalindrome() {
        String d1 = "o";
        String d2 = "persiflage";
        String d3 = "racecar";
        String d4 = "";
        assertTrue(palindrome.isPalindrome(d1));
        assertFalse(palindrome.isPalindrome(d2));
        assertTrue(palindrome.isPalindrome(d3));
        assertTrue(palindrome.isPalindrome(d4));
    }

    @Test
    public void testnewisPalindrome() {
        String d1 = "a";
        String d2 = "&abcab%";
        String d3 = "flake";
        String d4 = "racecar";
        assertTrue(palindrome.isPalindrome(d1, new OffByOne()));
        assertTrue(palindrome.isPalindrome(d2, new OffByOne()));
        assertTrue(palindrome.isPalindrome(d3, new OffByOne()));
        assertFalse(palindrome.isPalindrome(d4, new OffByOne()));
    }
}
