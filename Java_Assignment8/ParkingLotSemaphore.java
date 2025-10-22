import java.util.concurrent.*;

public class ParkingLotSemaphore {
    public static void main(String[] args) {
        final Semaphore parking = new Semaphore(3); 
        ExecutorService pool = Executors.newFixedThreadPool(6);

        for (int i = 1; i <= 6; i++) {
            final int carId = i;
            pool.submit(() -> {
                try {
                    System.out.println("Car " + carId + " arriving...");
                    parking.acquire();
                    System.out.println("Car " + carId + " PARKED (spaces left: " + parking.availablePermits() + ")");
                    try {
                        Thread.sleep(2000); 
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Car " + carId + " leaving...");
                    parking.release();
                    System.out.println("Car " + carId + " LEFT (spaces now: " + parking.availablePermits() + ")");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
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
        }System.out.println("Parking lot simulation finished.");
    }
}
