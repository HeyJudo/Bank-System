public class Main {
    public static void main (String[] args){
        System.out.println("========== PHASE 2: BANKING SYSTEM TEST ==========\n");
        Bank b1 = new Bank("RCBC");
        b1.displayBankInfo();

        //Customers
        Customer monique = new Customer("1001", "Princess Monique De Leon");
        Customer sean = new Customer("1002", "Sean Paul Monton");


        SavingsAccount moniqueSavings = new SavingsAccount("0100", "Monique", 1000.00, 0.05);
        CheckingAccount moniqueCheckings = new CheckingAccount("01100", "Monique", 10000.00,400, 100);

        SavingsAccount seanSavings = new SavingsAccount("01200", "Sean", 10000.00, 0.05);
        CheckingAccount seanCheckings = new CheckingAccount("012100", "Sean", 10000.00,400, 100);

        monique.addAccount(moniqueSavings);
        monique.addAccount(moniqueCheckings);
        sean.addAccount(seanSavings);
        sean.addAccount(seanCheckings);

        b1.addCustomer(sean);
        b1.addCustomer(monique);

        System.out.println("=========DISPLAY BANK INFO=========");
        b1.displayBankInfo();

        System.out.printf("=========%s ACCOUNT INFO=========\n", monique.getCustomerName());
        monique.displayCustomerInfo();

        System.out.printf("=========%s ACCOUNT INFO=========\n", sean.getCustomerName());
        sean.displayCustomerInfo();

        //DEPOSITS
        System.out.println("=========TESTING DEPOSITS=========");
        moniqueSavings.deposit(1000);

        System.out.println("\n========== TESTING WITHDRAWALS ==========");
        moniqueSavings.withdraw(500);
        seanCheckings.deposit(1000);

        //Testing Account Features
        System.out.println("\n========== TESTING ACCOUNT FEATURES ==========");
        moniqueSavings.applyInterest();
        moniqueCheckings.applyMonthlyFee();
        seanSavings.applyInterest();

        System.out.println("\n========== TESTING TRANSFER (ALICE'S ACCOUNTS) ==========");
        moniqueSavings.transfer(moniqueCheckings, 2000);

        // TEST TRANSFER BETWEEN CUSTOMERS
        System.out.println("\n========== TESTING TRANSFER (BETWEEN CUSTOMERS) ==========");
        b1.transferBetweenCustomers("01200", "012100", 200);

        //TEST TRANSACTION HISTORY
        System.out.println("\n========== MONIQUE'S SAVINGS TRANSACTION HISTORY ==========");
        moniqueSavings.viewTransactionHistory();

        System.out.println("\n========== SEAN'S SAVINGS TRANSACTION HISTORY ==========");
        seanSavings.viewTransactionHistory();

        // TEST FINDING ACCOUNT BY NUMBER
        System.out.println("\n========== TESTING FIND ACCOUNT ==========");
        Account findy = b1.findAccountByNumber("0100");
        if(findy != null){
            findy.displayAccountDetails();
        }
        // FINAL BANK STATUS
        System.out.println("\n========== FINAL BANK STATUS ==========");
        b1.displayBankInfo();
        b1.displayAlCustomers();
        System.out.println("\n========== TESTING COMPLETE! ==========");
    }
}
