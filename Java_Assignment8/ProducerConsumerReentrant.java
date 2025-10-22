import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ProducerConsumerReentrant {
     public static void main(String[] args) {
        DataSharing ds = new DataSharing(5); 
        Thread producer = new Thread(new Producer(ds), "Producer");
        Thread consumer = new Thread(new Consumer(ds), "Consumer");

        producer.start();
        consumer.start();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
         producer.interrupt();
        consumer.interrupt();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main: Producer and Consumer stopped.");
    }
    static class DataSharing {
        private final Deque<Integer> buffer = new ArrayDeque<>();
        private final int capacity;
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();
        private final Condition notEmpty = lock.newCondition();

        DataSharing(int capacity) {
            this.capacity = capacity;
        }
        boolean put(int value, long timeout, TimeUnit unit) throws InterruptedException {
            long nanos = unit.toNanos(timeout);
            lock.lock();
            try {
                while (buffer.size() >= capacity) {
                    if (nanos <= 0L) {
                        System.out.println(Thread.currentThread().getName() + " put timeout, buffer full.");
                        return false;
                    }
                    nanos = notFull.awaitNanos(nanos);
                }
                buffer.addLast(value);
                System.out.println(Thread.currentThread().getName() + " produced " + value + " (size=" + buffer.size() + ")");
                notEmpty.signal();
                return true;
            } finally {
                lock.unlock();
            }
        }
        Integer take(long timeout, TimeUnit unit) throws InterruptedException {
            long nanos = unit.toNanos(timeout);
            lock.lock();
            try {
                while (buffer.isEmpty()) {
                    if (nanos <= 0L) {
                        System.out.println(Thread.currentThread().getName() + " take timeout, buffer empty.");
                        return null;
                    }
                    nanos = notEmpty.awaitNanos(nanos);
                }
                Integer val = buffer.removeFirst();
                System.out.println(Thread.currentThread().getName() + " consumed " + val + " (size=" + buffer.size() + ")");
                notFull.signal();
                return val;
            } finally {
                lock.unlock();
            }
        }
    }
    static class Producer implements Runnable {
        private final DataSharing ds;
        private int counter = 1;
        private final Random rnd = new Random();

        Producer(DataSharing ds) { this.ds = ds; }
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    boolean success = ds.put(counter++, 1, TimeUnit.SECONDS);
                    
                    Thread.sleep(300 + rnd.nextInt(500));
                    if (!success) {}
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Producer exiting.");
        }
    }
     static class Consumer implements Runnable {
        private final DataSharing ds;
        private final Random rnd = new Random();
        Consumer(DataSharing ds) { this.ds = ds; }

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Integer val = ds.take(1, TimeUnit.SECONDS);
                    if (val != null) {
                        
                        Thread.sleep(400 + rnd.nextInt(400));
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Consumer exiting.");
        }
    }
}
