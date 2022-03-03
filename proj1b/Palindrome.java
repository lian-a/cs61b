public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> item = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            item.addLast(word.charAt(i));
        }
        return item;
    }

    /**I first solve this problem iteratively*/
    /**public boolean isPalindrome(String word) {
        Deque items = wordToDeque(word);
        int j = items.size() - 1;
        for (int i = 0; i < items.size(); i++, j-- ) {
            if (items.get(i) != items.get(j)) {
                return false;
            }
        }
        return true;
    }*/

    /**approach this method recursively*/
    private boolean helper(Deque<Character> items) {
        if (items.isEmpty() || items.size() == 1) {
            return true;
        }
        if (items.removeFirst() == items.removeLast()) {
            return helper(items);
        } else {
            return false;
        }
    }
    public boolean isPalindrome(String word) {
        Deque items = wordToDeque(word);
        return helper(items);
    }

    private boolean helper2(Deque<Character> items,CharacterComparator cc) {
        if (items.isEmpty() || items.size() == 1) {
            return true;
        }
        if (cc.equalChars(items.removeFirst(), items.removeLast())) {
            return helper2(items, cc);
        } else {
            return false;
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque items = wordToDeque(word);
        return helper2(items,cc);
    }
}
