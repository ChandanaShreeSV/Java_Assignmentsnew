import java.util.concurrent.*;
import java.util.*;

public class RaceCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(4);
        ExecutorService pool = Executors.newFixedThreadPool(5);

        Thread organizer = new Thread(() -> {
            System.out.println("Race started! Waiting for all runners...");
            try {
                latch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("ALL RUNNERS FINISHED! Race complete!");
        }, "Organizer");
        organizer.start();

        for (int i = 1; i <= 4; i++) {
            final int runnerId = i;
            pool.submit(() -> {
                System.out.println("Runner " + runnerId + " running...");
                try {
                    long sleep = (long) (1000 + Math.random() * 3000); 
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                latch.countDown();
                System.out.println("Runner " + runnerId + " FINISHED! (Remaining: " + latch.getCount() + ")");
            });
            try {
                Thread.sleep(200); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        pool.shutdown();
            try {
            if (!pool.awaitTermination(8, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
        try {
            organizer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    System.out.println("Race simulation ended.");
    }   
}
