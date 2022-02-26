public class ArrayDeque {
    private int size;
    private int[] Items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        size = 0;
        Items = new int[8];
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque other) {
        ArrayDeque temp = new ArrayDeque();
        temp.size = size;
        temp.nextFirst = nextFirst;
        temp.nextLast = nextLast;
        System.arraycopy(Items, 0, temp.Items, 0, Items.length);
    }

    public boolean isEmpty() {
        if (nextLast - nextFirst == 1)
            return true;
        return false;
    }

    public boolean isFull() {
        if (nextFirst - nextLast == 0)
            return true;
        return false;
    }

    public void addFirst(int item) {
        if (nextFirst < 0) {
            nextFirst = Items.length - 1;
        }
        if (this.isFull()) {
            resize();
        }
        size = size + 1;
        Items[nextFirst] = item;
        nextFirst -= 1;
    }

    public void addLast(int item) {
        if (nextLast == Items.length) {
            nextLast = 0;
        }
        if (this.isFull()) {
            resize();
        }
        size += 1;
        Items[nextLast] = item;
        nextLast += 1;
    }

    public int removeFirst() {
        if (!isEmpty()) {
            nextFirst += 1;
        }
        size -= 1;
        if (Items.length >= 16 && size < Items.length / 4) {
            resize();
        }
        return Items[nextFirst - 1];
    }

    public int removeLast() {
        nextLast -= 1;
        size -= 1;
        if (Items.length >= 16 && size < Items.length / 4) {
            resize();
        }
        return Items[nextLast + 1];
    }

    public void printDeque() {
        for(int i = 0; i < size - 1; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println(get(size - 1));
    }
    public int get(int index) {
        if (index + nextFirst < Items.length) {
            return  Items[index + nextFirst + 1];
        } else {
            return Items[index + nextFirst + 1 - Items.length];
        }
    }

    public ArrayDeque resize() {
        ArrayDeque temp = new ArrayDeque();
        temp.Items = new int[size * 2];
        for(int i = 0; i < size; i++) {
           temp.addLast(this.get(i));
        }
        return temp;
    }

    public int size() {
        return size;
    }

//    public static void main(String[] args) {
//        ArrayDeque l = new ArrayDeque();
//        l.addFirst(10);
//        l.addLast(20);
//        l.printDeque();
//    }
}