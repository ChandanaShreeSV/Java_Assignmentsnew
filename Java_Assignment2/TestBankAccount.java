public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 2000, "Current");
        acc1.displayAccountDetails();
        acc1.deposit(500);
        acc1.withdraw(1000);

        
        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
    
}
}
