public class Main {
    public static void main (String[] args){
        System.out.println("Bank System Starting....");
        System.out.println("\n========== Testing SavingsAccount ==========\n");
        SavingsAccount a1 = new SavingsAccount("SAV001", "Alice Johnson", 1000.0, 0.05);
        a1.displayAccountDetails();
        a1.deposit(500);
        a1.applyInterest();
        a1.displayAccountDetails();
        System.out.println("\n========== Testing CheckingAccount ==========\n");
        CheckingAccount c1 = new CheckingAccount("CHK001", "Bob Smith", 500.0, 1000.0, 15.0);
        c1.displayAccountDetails();
        c1.withdraw(700);
        c1.withdraw(2000);
        c1.applyMonthlyFee();
        c1.displayAccountDetails();
        System.out.println("\n========== Testing BusinessAccount ==========\n");
        BusinessAccount b1 = new BusinessAccount("BUS001", "Tech Corp LLC", 10000.0, 5000.0, 0.02);
        b1.displayAccountDetails();
        b1.withdraw(3000);
        b1.withdraw(6000);
        b1.applyTransactionFee(3000);
        b1.displayAccountDetails();
    }
}
