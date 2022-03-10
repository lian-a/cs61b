package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    @Override
    public int capacity() {
        return capacity;
    }
    @Override
    public int fillCount() {
        return fillCount;
    }
/*这三条语句可以省略*/
//    public abstract T peek();
//    public abstract T dequeue();
//    public abstract void enqueue(T x);
}
