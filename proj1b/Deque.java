public interface Deque<T> {

    boolean isEmpty();

    void addFirst(T item);

    void addLast(T item);

    T removeFirst();

    T removeLast();

    void printDeque();

    T get(int index);

    int size();
}
