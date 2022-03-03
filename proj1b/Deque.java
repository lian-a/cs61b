public interface Deque<T> {

    public boolean isEmpty();

    public void addFirst(T item);

    public void addLast(T item);

    public T removeFirst();

    public T removeLast();

    public void printDeque();

    public T get(int index);

    public int size();
}
