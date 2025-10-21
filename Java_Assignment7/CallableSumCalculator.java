import java.util.*;
import java.util.concurrent.*;

public class CallableSumCalculator {

    public static void main(String[] args) {
        System.out.println("Callable Sum Calculator\n");

        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> tasks = new ArrayList<>();

        tasks.add(() -> sum(1, 100));
        tasks.add(() -> sum(101, 200));
        tasks.add(() -> sum(201, 300));
        tasks.add(() -> sum(301, 400));

        List<Future<Integer>> results = new ArrayList<>();
        for (Callable<Integer> task : tasks) {
            results.add(service.submit(task));
        }
        long fact = factorial(10);
        System.out.println("Main thread factorial(10): " + fact);
        System.out.println("Multiplication table of 5:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
        }
        int totalSum = 0;
        for (int i = 0; i < results.size(); i++) {
            try {
                int val = results.get(i).get();
                System.out.println("Worker " + (i + 1) + " result: " + val);
                totalSum += val;
            } catch (Exception e) {
                System.out.println("Error in worker " + (i + 1));
            }
        }

        long grandTotal = totalSum + fact;
        System.out.println("Grand total = " + grandTotal);
        service.shutdown();
    }
    static int sum(int a, int b) {
        int s = 0;
        for (int i = a; i <= b; i++) s += i;
        return s;
    }
    static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
