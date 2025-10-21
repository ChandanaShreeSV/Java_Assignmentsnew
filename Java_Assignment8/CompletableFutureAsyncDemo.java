import java.util.*;
import java.util.concurrent.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CompletableFutureAsyncDemo {

    public static void main(String[] args) {
        System.out.println("CompletableFuture Async Demo - start: " + now());
        processTasksAsync();
        // Give async tasks time to finish before main exits (but main is not blocked doing work)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main finished: " + now());
    }

    static void processTasksAsync() {
        ExecutorService pool = Executors.newCachedThreadPool();
        Random rnd = new Random();

        // Create 5 tasks with varying delays 1-3 seconds; some will simulate failure
        for (int i = 1; i <= 5; i++) {
            final int id = i;
            CompletableFuture
                .supplyAsync(() -> {
                    log("Task " + id + " supplyAsync started");
                    int delay = 1000 + rnd.nextInt(2000); // 1000-3000 ms
                    sleep(delay);
                    // simulate failure for task 3 and 5
                    if (id == 3 || id == 5) {
                        throw new RuntimeException("simulated error in task " + id);
                    }
                    return "result-" + id + "-after-" + delay;
                }, pool)
                .thenApply(result -> {
                    log("Task " + id + " thenApply transforming");
                    return result.toUpperCase();
                })
                .exceptionally(ex -> {
                    log("Task " + id + " exceptionally handled: " + ex.getMessage());
                    return "default-" + id;
                })
                .thenAccept(finalResult -> {
                    log("Task " + id + " thenAccept consumed: " + finalResult);
                });
            // show main is not blocked
            log("Submitted task " + id + " at " + now() + " from thread " + Thread.currentThread().getName());
        }

        // we shutdown but allow tasks to finish
        pool.shutdown();
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static void log(String s) {
        System.out.println("[" + now() + "][" + Thread.currentThread().getName() + "] " + s);
    }

    static String now() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
    }
}
