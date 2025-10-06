class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}
class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}
class BankAccount {
    private double balance = 1000;
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be > 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough balance");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ", Remaining: " + balance);
    }
     public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        try {
            acc.withdraw(200);     
            acc.withdraw(2000);    
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
      acc.withdraw(-10);//sir this is runtime exception.
    }
}
