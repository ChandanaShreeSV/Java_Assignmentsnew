import java.util.*;

class SharedData {
    int[] numbers;
    int[] doubled;
    int sum;
    double avg;
}
class DataLoader extends Thread {
    SharedData data;
    DataLoader(SharedData data) { this.data = data; }

        public void run() {
        System.out.println("DataLoader started");
        data.numbers = new int[10];
        Random r = new Random();
        for (int i = 0; i < 10; i++) data.numbers[i] = r.nextInt(100) + 1;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            interrupt();
        }
        System.out.println("DataLoader completed: " + Arrays.toString(data.numbers));
    }
}
class DataProcessor extends Thread {
    SharedData data;
    Thread loader;
    DataProcessor(SharedData data, Thread loader) {
        this.data = data;
        this.loader = loader;
    }
    public void run() {
        try {
            loader.join();
        } catch (InterruptedException e) {
            interrupt();
        }
        System.out.println("DataProcessor started");
        data.doubled = new int[data.numbers.length];
        for (int i = 0; i < data.numbers.length; i++)
            data.doubled[i] = data.numbers[i] * 2;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            interrupt();
        }
        System.out.println("DataProcessor completed: " + Arrays.toString(data.doubled));
    }
}
class DataSaver extends Thread {
    SharedData data;
    Thread processor;
    DataSaver(SharedData data, Thread processor) {
        this.data = data;
        this.processor = processor;
    }
    public void run() {
        try {
            processor.join();
        } catch (InterruptedException e) {
            interrupt();
        }
        System.out.println("DataSaver started");
        int sum = 0;
        for (int n : data.doubled) sum += n;
        data.sum = sum;
        data.avg = sum / (double) data.doubled.length;
        System.out.println("DataSaver completed: Sum=" + data.sum + ", Avg=" + data.avg);
    }
}
public class ThreadJoinPipeline {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        DataLoader loader = new DataLoader(data);
        DataProcessor processor = new DataProcessor(data, loader);
        DataSaver saver = new DataSaver(data, processor);

        loader.start();
        processor.start();
        saver.start();
    try {
            saver.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
         System.out.println("\nAll threads finished successfully!");
    }
}
