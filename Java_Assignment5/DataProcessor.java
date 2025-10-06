import java.io.*;

class DataReader {
    public void read() throws IOException {
        throw new IOException("File not found");
    }
}
class DataProcessor {
    private DataReader reader = new DataReader();
    public void process1() {
        try {
            reader.read();
        } catch (IOException e) {
            System.out.println("Handled inside: " + e.getMessage());
        }
    }
     public void process2() throws IOException {
        reader.read();
    }
     public static void main(String[] args) {
        DataProcessor p = new DataProcessor();
        p.process1();
        try {
            p.process2();
        } catch (IOException e) {
            System.out.println("Handled in main: " + e.getMessage());
        }
    }
}
