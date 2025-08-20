final class MathUtils {
    private MathUtils() {}
    public static int square(int n) { return n * n; }
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
}

public class Part2_MathUtils {
    public static void main(String[] args) {
        System.out.println("Square of 5: " + MathUtils.square(5));
        System.out.println("Factorial of 4: " + MathUtils.factorial(4));
        System.out.println("Is 7 prime? " + MathUtils.isPrime(7));
    }
}