import java.util.*;

public class Task6_TimeComplexityAnalyzer {
    public static void main(String[] args) {
        ComplexityAnalyzer ca = new ComplexityAnalyzer();
        int[] sizes = {1, 5, 10, 15};

        for (int n : sizes) {
            System.out.println("\n--- n = " + n + " ---");
            long start, end;

            start = System.nanoTime();
            ca.constantTime(n);
            end = System.nanoTime();
            System.out.println("O(1) Time: " + (end - start) + " ns");

            start = System.nanoTime();
            ca.logarithmicTime(n);
            end = System.nanoTime();
            System.out.println("O(log n) Time: " + (end - start) + " ns");

            start = System.nanoTime();
            ca.linearTime(n);
            end = System.nanoTime();
            System.out.println("O(n) Time: " + (end - start) + " ns");

            start = System.nanoTime();
            ca.linearithmicTime(n);
            end = System.nanoTime();
            System.out.println("O(n log n) Time: " + (end - start) + " ns");

            start = System.nanoTime();
            ca.quadraticTime(n);
            end = System.nanoTime();
            System.out.println("O(n^2) Time: " + (end - start) + " ns");
        }
    }
}

class ComplexityAnalyzer {
    public void constantTime(int n) {
        System.out.println("Hello World");
    }

    public void logarithmicTime(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i);
        Collections.binarySearch(list, n - 1);
    }

    public void linearTime(int n) {
        for (int i = 0; i < n; i++) {}
    }

    public void linearithmicTime(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = n; i > 0; i--) list.add(i);
        Collections.sort(list);
    }

    public void quadraticTime(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {}
        }
    }
}
