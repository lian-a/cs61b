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

    public ArrayDeque(ArrayDeque other) {
        ArrayDeque temp = new ArrayDeque();
        temp.size = size;
        temp.nextFirst = nextFirst;
        temp.nextLast = nextLast;
        System.arraycopy(items, 0, temp.items, 0, items.length);
    }

    public boolean isEmpty() {
        if (nextLast - nextFirst == 1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (nextFirst - nextLast == 0)
            return true;
        return false;
    }

    public void addFirst(T item) {
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
        if (this.isFull()) {
            resize();
        }
        size = size + 1;
        items[nextFirst] = item;
        nextFirst -= 1;
    }

    public void addLast(T item) {
        if (nextLast == items.length) {
            nextLast = 0;
        }
        if (this.isFull()) {
            resize();
        }
        size += 1;
        items[nextLast] = item;
        nextLast += 1;
    }

    public T removeFirst() {
        if (!isEmpty()) {
            nextFirst += 1;
        }
        size -= 1;
        if (items.length >= 16 && size < items.length / 4) {
            resize();
        }
        return items[nextFirst - 1];
    }

    public T removeLast() {
        nextLast -= 1;
        size -= 1;
        if (items.length >= 16 && size < items.length / 4) {
            resize();
        }
        return items[nextLast + 1];
    }

    public void printDeque() {
        for(int i = 0; i < size - 1; i++){
            System.out.print(get(i) + " ");
        }
        System.out.println(get(size - 1));
    }
    public T get(int index) {
        if (index + nextFirst < items.length) {
            return  items[index + nextFirst + 1];
        } else {
            return items[index + nextFirst + 1 - items.length];
        }
    }

    public ArrayDeque resize() {
        ArrayDeque temp = new ArrayDeque();
        temp.items = (T[]) new Object[size * 2];
        for(int i = 0; i < size; i++){
            temp.addLast(this.get(i));
        }
        return temp;
    }

    public int size() {
        return size;
    }

//    public static void main(String[] args) {
//        ArrayDeque l = new ArrayDeque();
//        l.addFirst("what");
//        l.addLast("is");
//        l.printDeque();
//    }
}
