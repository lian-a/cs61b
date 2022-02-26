public class LinkedListDeque<type> {
    
    private int size;
    public IntNode sentinel;
    public IntNode last;

    private class IntNode {
        public IntNode prev;
        public IntNode next;
        public type item;

        public IntNode(IntNode pre, type ite, IntNode nex) {
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
        LinkedListDeque<type> temp = new LinkedListDeque<>();
        IntNode p = other.sentinel;
        while(p.next.item != null) {
            temp.addLast(p.next.item);
            p = p.next;
        }
        size = other.size;
    }

    public void addFirst(type item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(type item) {
        last.prev = new IntNode(last.prev, item, last);
        last.prev.prev.next = last.prev;
        size += 1;
    }

    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else {
            return false;
        }
    }

    public int size() {
        return size;
    }
    public void printDeque() {
        IntNode temp = sentinel;
        while(temp.next.item != null) {
            temp = temp.next;
            System.out.print(temp.item);
            if(temp.next.item != null) {
                System.out.print(" ");
            }else {
                System.out.println();
            }
        }
    }

    public type removeFirst() {
        size = size - 1;
        type temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return temp;
    }

    public type removeLast() {
        size = size - 1;
        type temp = last.prev.item;
        last.prev = last.prev.prev;
        last.prev.next = last;
        return temp;
    }

    public type get(int index) {
        LinkedListDeque<type> temp = new LinkedListDeque<>( this);
        while(index > 0) {
            temp.removeFirst();
            index -= 1;
        }
        return temp.sentinel.next.item;
    }


    public type helper(int i, IntNode N ) {
        if (i == 0)
            return N.item;
        else
            return helper(i - 1, N.next);
    }
    public type getRecursive(int index) {
        return helper(index, sentinel.next);
    }
}
