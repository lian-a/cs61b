public class LinkedListDeque<T> {
    
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

    public LinkedListDeque(LinkedListDeque other) {
        LinkedListDeque<T> temp = new LinkedListDeque<>();
        IntNode p = other.sentinel;
        while(p.next.item != null){
            temp.addLast(p.next.item);
            p = p.next;
        }
        size = other.size;
    }

    public void addFirst(T item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        last.prev = new IntNode(last.prev, item, last);
        last.prev.prev.next = last.prev;
        size += 1;
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }
    public void printDeque() {
        IntNode temp = sentinel;
        while(temp.next.item != null){
            temp = temp.next;
            System.out.print(temp.item);
            if(temp.next.item != null){
                System.out.print(" ");
            }else{
                System.out.println();
            }
        }
    }

    public T removeFirst() {
        size = size - 1;
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return temp;
    }

    public T removeLast() {
        size = size - 1;
        T temp = last.prev.item;
        last.prev = last.prev.prev;
        last.prev.next = last;
        return temp;
    }

    public T get(int index) {
        LinkedListDeque<T> temp = new LinkedListDeque<> (this);
        while(index > 0){
            temp.removeFirst();
            index -= 1;
        }
        return temp.sentinel.next.item;
    }


    public T helper(int i, IntNode N) {
        if (i == 0){
            return N.item;
        }else{
            return helper(i - 1, N.next);
        }
    }
    public T getRecursive(int index) {
        return helper(index, sentinel.next);
    }
}
