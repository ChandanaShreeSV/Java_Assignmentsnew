import java.util.*;
import java.util.concurrent.*;

public class ExecutorServiceComparison {
    public static void main(String[] args) {
        System.out.println("ExecutorService Performance Comparison\n");
        simulateTaskProcessing();
    }
    static void simulateTaskProcessing() {
        int totalTasks = 8;
        Random random = new Random();

        runPool("FixedThreadPool", Executors.newFixedThreadPool(4), totalTasks, random);
        runPool("CachedThreadPool", Executors.newCachedThreadPool(), totalTasks, random);
        runPool("SingleThreadExecutor", Executors.newSingleThreadExecutor(), totalTasks, random);
    }
    private static void runPool(String name, ExecutorService executor, int totalTasks, Random random) {
        System.out.println("\n--- Running " + name + " ---");
        long start = System.currentTimeMillis();
        for (int i = 1; i <= totalTasks; i++) {
            int taskId = i;
            executor.submit(() -> {
                try {
                    int delay = 500 + random.nextInt(1500);
                    System.out.println("Task " + taskId + " running in " + Thread.currentThread().getName() + " for " + delay + " ms");
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long end = System.currentTimeMillis();
        System.out.println(name + " total time: " + (end - start) + " ms");
    }
}
