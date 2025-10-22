import java.util.concurrent.*;
import java.util.*;

public class CyclicBarrierGame {
    public static void main(String[] args) {
        final int players = 3;
        Runnable barrierAction = () -> System.out.println("All Players READY! Game starting...");

        CyclicBarrier barrier = new CyclicBarrier(players, barrierAction);
        ExecutorService pool = Executors.newFixedThreadPool(players);
        Random rnd = new Random();

        for (int i = 1; i <= players; i++) {
            final int id = i;
            pool.submit(() -> {
                try {
                    System.out.println("Player " + id + " loading game...");
                    Thread.sleep(1000 + rnd.nextInt(2000)); 
                    System.out.println("Player " + id + " LOADED, waiting for others...");
                    barrier.await();

                    System.out.println("Player " + id + " playing Round 1");
                    Thread.sleep(1500);
                    System.out.println("Player " + id + " finished Round 1, waiting...");
                    barrier.await();

                    System.out.println("Player " + id + " playing Round 2");
                    Thread.sleep(1000);
                    System.out.println("Player " + id + " completed!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (BrokenBarrierException e) {
                    System.out.println("Player " + id + " barrier broken: " + e.getMessage());
                }
            });
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        pool.shutdown();
        try {
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("CyclicBarrier game finished (barrier reused for both synchronization points).");
    }
}
