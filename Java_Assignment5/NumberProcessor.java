class NumberProcessor {
    public void processNumber(String input) {
        try {
            int num = Integer.parseInt(input);
            int result = 10 / num; 
            System.out.println("Result: " + result);
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
public static void main(String[] args) {
        NumberProcessor np = new NumberProcessor();
        np.processNumber("10");  
        np.processNumber("abc");  
        np.processNumber("0");   
    }
}
