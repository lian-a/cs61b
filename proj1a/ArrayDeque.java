public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }

//    public ArrayDeque(ArrayDeque other) {
//        ArrayDeque temp = new ArrayDeque();
//        temp.size = size;
//        temp.nextFirst = nextFirst;
//        temp.nextLast = nextLast;
//        System.arraycopy(items, 0, temp.items, 0, items.length);
//    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    private boolean isFull() {
        if (size == items.length) {
            return true;
        }
        return false;
    }

    public void addFirst(T item) {
        if (this.isFull()) {
            resize();
        }
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
        size = size + 1;
        items[nextFirst] = item;
        nextFirst -= 1;
    }

    public void addLast(T item) {
        if (this.isFull()) {
            resize();
        }
        if (nextLast == items.length) {
            nextLast = 0;
        }
        size += 1;
        items[nextLast] = item;
        nextLast += 1;
    }

    public T removeFirst() {
        if (!isEmpty()) {
            nextFirst += 1;
        }
        if (nextFirst == items.length) {
            nextFirst = 0;
        }
        size -= 1;
        T x = items[nextFirst];
        if (items.length >= 16 && size < items.length / 4) {
            resize();
        }
        return x;
    }

    public T removeLast() {
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast = items.length - 1;
        }
        size -= 1;
        T x = items[nextLast];
        if (items.length >= 16 && size < items.length / 4) {
            resize();
        }
        return x;
    }

    public void printDeque() {
        for (int i = 0; i < size - 1 && size > 0; i++) {
            System.out.print(get(i) + " ");
        }
        if (size > 0) {
        System.out.println(get(size - 1));
        }
    }
    public T get(int index) {
        if (index + nextFirst + 1 < items.length) {
            return  items[index + nextFirst + 1];
        } else {
            return items[index + nextFirst + 1 - items.length];
        }
    }

    private void resize() {
        T[] temp = (T[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            temp[nextLast] = this.get(i);
            nextLast += 1;
        }
        nextFirst = nextLast - size - 1;
        items = temp;
    }

    public int size() {
        if (size < 0) {
            return 0;
        }
        return size;
    }

    public static void main(String[] args) {
        ArrayDeque l = new ArrayDeque();
        l.addFirst(0);
        l.addFirst(1);

        System.out.println(l.removeFirst());
        System.out.println(l.removeFirst());

        l.printDeque();
    }
}
