import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {

    AtomicInteger size = new AtomicInteger(0);
    volatile int capacity;

    LinkedList<Integer> queue;

    static ReentrantLock lock = new ReentrantLock();

    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size.get() >= capacity) {
                producer.await();
            }
            queue.addFirst(element);
            size.incrementAndGet();
            consumer.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size.get() == 0) {
                consumer.await();
            }
            int lastValue = queue.getLast();
            queue.removeLast();
            size.decrementAndGet();
            producer.signal();
            return lastValue;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return size.get();
        } finally {
            lock.unlock();
        }
    }

}