import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        System.out.println("ThreadPoolExecutor Basic Setup\n");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()
        );
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            executor.submit(() -> {
                String tName = Thread.currentThread().getName();
                System.out.println("Task " + taskId + " is running on " + tName);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            System.out.println("After submitting task " + taskId + ": Pool Size = " +
                    executor.getPoolSize() + ", Active Threads = " + executor.getActiveCount());
        }
        new Thread(() -> {
            while (!executor.isTerminated()) {
                System.out.println("[Monitor] Active: " + executor.getActiveCount()
                        + ", PoolSize: " + executor.getPoolSize()
                        + ", Completed: " + executor.getCompletedTaskCount());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
         executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("All tasks completed....");
    }
}
