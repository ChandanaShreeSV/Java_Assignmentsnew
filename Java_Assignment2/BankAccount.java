
public class BankAccount {

    private String accountHolderName;
    private final int accountNumber; 
    private double balance;          
    private String accountType;      

   
    private static int accountCounter = 1000; 
    public static final double MIN_BALANCE = 500.00;

    
    public BankAccount() {
        this.accountHolderName = "Unnamed";
        this.balance = MIN_BALANCE;
        this.accountType = "Savings";
        this.accountNumber = ++accountCounter;
    }

    
    public BankAccount(String holderName, double openingBalance, String accountType) {
        this.accountHolderName = holderName;
        this.accountType = accountType;
        this.balance = Math.max(openingBalance, MIN_BALANCE); 
        this.accountNumber = ++accountCounter; 
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String name) {
        if (name != null && !name.isBlank()) {
            this.accountHolderName = name;
        } else {
            System.out.println("Invalid account holder name.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String type) {
        if (type.equalsIgnoreCase("Savings") || type.equalsIgnoreCase("Current")) {
            this.accountType = type;
        } else {
            System.out.println("Invalid account type. Must be 'Savings' or 'Current'.");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

 
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public final void displayAccountDetails() { 
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Type: " + accountType);
        System.out.println("Balance: " + balance);
    }

   
    public static int getTotalAccounts() {
        return accountCounter - 1000; 
    }
}
