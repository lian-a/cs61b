public class ArrayDeque<T> implements Deque<T> {
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

    public boolean isEmpty() {
        return (size == 0);
    }
    private boolean isFull() {
        return (size == items.length);
    }
    private int plusone(int index) {
        if (index + 1 == items.length) {
            return 0;
        } else {
            return index + 1;
        }
    }
    private int minusone(int index) {
        if (index == 0) {
            return items.length - 1;
        } else {
            return index - 1;
        }
    }
    @Override
    public void addFirst(T item) {
        if (this.isFull()) {
            resize();
        }
        size = size + 1;
        items[nextFirst] = item;
        nextFirst = minusone(nextFirst);
    }

    @Override
    public void addLast(T item) {
        if (this.isFull()) {
            resize();
        }
        size += 1;
        items[nextLast] = item;
        nextLast = plusone(nextLast);
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = plusone(nextFirst);
        size -= 1;
        T x = items[nextFirst];
        if (items.length >= 16 && size < items.length / 4) {
            resize();
        }
        return x;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = minusone(nextLast);
        size -= 1;
        T x = items[nextLast];
        if (items.length >= 16 && size < items.length / 4) {
            resize();
        }
        return x;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size - 1 && size > 0; i++) {
            System.out.print(get(i) + " ");
        }
        if (size > 0) {
            System.out.println(get(size - 1));
        }
    }

    @Override
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
            temp[i] = this.get(i);
        }
        nextFirst = temp.length - 1;
        nextLast = size;
        items = temp;
    }

    @Override
    public int size() {
        if (size < 0) {
            return 0;
        }
        return size;
    }
}
