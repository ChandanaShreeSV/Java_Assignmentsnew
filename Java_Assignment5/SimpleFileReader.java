import java.io.*;
class SimpleFileReader {
    public void readFile(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            System.out.println("File contents:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("File closed.");
                }
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
      public static void main(String[] args) {
        SimpleFileReader sfr = new SimpleFileReader();
        sfr.readFile("test.txt");     
        sfr.readFile("nofile.txt");  
    }
}
