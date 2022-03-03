public class LinkedListDeque<T> implements Deque<T>{
    
    private int size;
    private IntNode sentinel;
    private IntNode last;

    private class IntNode {
        private IntNode prev;
        private IntNode next;
        private T item;

        public IntNode(IntNode pre, T ite, IntNode nex) {
            prev = pre;
            item = ite;
            next = nex;
        }
    }

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        last = new IntNode(sentinel, null, sentinel);
        sentinel.next = last;
        sentinel.prev = last;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        last.prev = new IntNode(last.prev, item, last);
        last.prev.prev.next = last.prev;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        if (size < 0) {
            return 0;
        }
        return size;
    }

    @Override
    public void printDeque() {
        IntNode temp = sentinel;
        while (temp.next.item != null) {
            temp = temp.next;
            System.out.print(temp.item);
            if (temp.next.item != null) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }

    @Override
    public T removeFirst() {
        size = size - 1;
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return temp;
    }

    @Override
    public T removeLast() {
        size = size - 1;
        T temp = last.prev.item;
        last.prev = last.prev.prev;
        last.prev.next = last;
        return temp;
    }

    @Override
    public T get(int index) {
        IntNode p = sentinel.next;
        while (index > 0) {
            p = p.next;
            index -= 1;
        }
        return p.item;
    }

    private T helper(int i, IntNode N) {
        if (i == 0) {
            return N.item;
        } else {
            return helper(i - 1, N.next);
        }
    }
    public T getRecursive(int index) {
        return helper(index, sentinel.next);
    }
}
