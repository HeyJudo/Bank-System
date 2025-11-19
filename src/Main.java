import java.util.Scanner;

public class Main {
    private static Bank bank;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        bank = new Bank("JUDO National Bank");

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   WELCOME TO JUDO NATIONAL BANK        ║");
        System.out.println("║   Banking Management System            ║");
        System.out.println("╚════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    customerMenu();
                    break;
                case 2:
                    accountMenu();
                    break;
                case 3:
                    transactionMenu();
                    break;
                case 4:
                    viewMenu();
                    break;
                case 5:
                    bank.displayBankInfo();
                    break;
                case 6:
                    System.out.println("\n✅ Thank you for using Java National Bank!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║           MAIN MENU                    ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Customer Management                ║");
        System.out.println("║  2. Account Management                 ║");
        System.out.println("║  3. Transactions                       ║");
        System.out.println("║  4. View Information                   ║");
        System.out.println("║  5. Bank Statistics                    ║");
        System.out.println("║  6. Exit                               ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    // ========== CUSTOMER MENU ==========
    private static void customerMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║      CUSTOMER MANAGEMENT               ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Add New Customer                   ║");
        System.out.println("║  2. Remove Customer                    ║");
        System.out.println("║  3. Find Customer                      ║");
        System.out.println("║  4. View All Customers                 ║");
        System.out.println("║  5. Back to Main Menu                  ║");
        System.out.println("╚════════════════════════════════════════╝");

        int choice = getIntInput("Enter your choice: ");

        switch (choice) {
            case 1:
                addCustomer();
                break;
            case 2:
                removeCustomer();
                break;
            case 3:
                findCustomer();
                break;
            case 4:
                bank.displayAlCustomers();
                break;
            case 5:
                return;
            default:
                System.out.println("❌ Invalid choice!");
        }
    }

    private static void addCustomer() {
        System.out.println("\n--- Add New Customer ---");
        String customerId = getStringInput("Enter Customer ID: ");
        String customerName = getStringInput("Enter Customer Name: ");

        Customer customer = new Customer(customerId, customerName);
        bank.addCustomer(customer);
    }

    private static void removeCustomer() {
        System.out.println("\n--- Remove Customer ---");
        String customerId = getStringInput("Enter Customer ID to remove: ");
        bank.removeCustomer(customerId);
    }

    private static void findCustomer() {
        System.out.println("\n--- Find Customer ---");
        String customerId = getStringInput("Enter Customer ID: ");
        Customer customer = bank.getCustomer(customerId);
        if (customer != null) {
            customer.displayCustomerInfo();
        }
    }

    // ========== ACCOUNT MENU ==========
    private static void accountMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       ACCOUNT MANAGEMENT               ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Create Savings Account             ║");
        System.out.println("║  2. Create Checking Account            ║");
        System.out.println("║  3. Create Business Account            ║");
        System.out.println("║  4. Remove Account                     ║");
        System.out.println("║  5. View Account Details               ║");
        System.out.println("║  6. Back to Main Menu                  ║");
        System.out.println("╚════════════════════════════════════════╝");

        int choice = getIntInput("Enter your choice: ");

        switch (choice) {
            case 1:
                createSavingsAccount();
                break;
            case 2:
                createCheckingAccount();
                break;
            case 3:
                createBusinessAccount();
                break;
            case 4:
                removeAccount();
                break;
            case 5:
                viewAccountDetails();
                break;
            case 6:
                return;
            default:
                System.out.println("❌ Invalid choice!");
        }
    }

    private static void createSavingsAccount() {
        System.out.println("\n--- Create Savings Account ---");
        String customerId = getStringInput("Enter Customer ID: ");
        Customer customer = bank.getCustomer(customerId);

        if (customer == null) {
            System.out.println("❌ Customer not found!");
            return;
        }

        String accountNumber = getStringInput("Enter Account Number: ");
        double initialBalance = getDoubleInput("Enter Initial Balance: ");
        double interestRate = getDoubleInput("Enter Interest Rate (e.g., 0.05 for 5%): ");

        SavingsAccount account = new SavingsAccount(accountNumber, customer.getCustomerName(), initialBalance, interestRate);
        customer.addAccount(account);
        System.out.println("✅ Savings Account created successfully!");
    }

    private static void createCheckingAccount() {
        System.out.println("\n--- Create Checking Account ---");
        String customerId = getStringInput("Enter Customer ID: ");
        Customer customer = bank.getCustomer(customerId);

        if (customer == null) {
            System.out.println("❌ Customer not found!");
            return;
        }

        String accountNumber = getStringInput("Enter Account Number: ");
        double initialBalance = getDoubleInput("Enter Initial Balance: ");
        double overdraftLimit = getDoubleInput("Enter Overdraft Limit: ");
        double monthlyFee = getDoubleInput("Enter Monthly Fee: ");

        CheckingAccount account = new CheckingAccount(accountNumber, customer.getCustomerName(), initialBalance, overdraftLimit, monthlyFee);
        customer.addAccount(account);
        System.out.println("✅ Checking Account created successfully!");
    }

    private static void createBusinessAccount() {
        System.out.println("\n--- Create Business Account ---");
        String customerId = getStringInput("Enter Customer ID: ");
        Customer customer = bank.getCustomer(customerId);

        if (customer == null) {
            System.out.println("❌ Customer not found!");
            return;
        }

        String accountNumber = getStringInput("Enter Account Number: ");
        double initialBalance = getDoubleInput("Enter Initial Balance: ");
        double transactionLimit = getDoubleInput("Enter Transaction Limit: ");
        double transactionFee = getDoubleInput("Enter Transaction Fee % (e.g., 0.02 for 2%): ");

        BusinessAccount account = new BusinessAccount(accountNumber, customer.getCustomerName(), initialBalance, transactionLimit, transactionFee);
        customer.addAccount(account);
        System.out.println("✅ Business Account created successfully!");
    }

    private static void removeAccount() {
        System.out.println("\n--- Remove Account ---");
        String customerId = getStringInput("Enter Customer ID: ");
        Customer customer = bank.getCustomer(customerId);

        if (customer == null) {
            System.out.println("❌ Customer not found!");
            return;
        }

        String accountNumber = getStringInput("Enter Account Number to remove: ");
        customer.removeAccount(accountNumber);
    }

    private static void viewAccountDetails() {
        System.out.println("\n--- View Account Details ---");
        String accountNumber = getStringInput("Enter Account Number: ");
        Account account = bank.findAccountByNumber(accountNumber);

        if (account != null) {
            account.displayAccountDetails();
        }
    }

    // ========== TRANSACTION MENU ==========
    private static void transactionMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         TRANSACTIONS                   ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Deposit Money                      ║");
        System.out.println("║  2. Withdraw Money                     ║");
        System.out.println("║  3. Transfer Money                     ║");
        System.out.println("║  4. Apply Interest (Savings)           ║");
        System.out.println("║  5. Apply Monthly Fee (Checking)       ║");
        System.out.println("║  6. Apply Transaction Fee (Business)   ║");
        System.out.println("║  7. Back to Main Menu                  ║");
        System.out.println("╚════════════════════════════════════════╝");

        int choice = getIntInput("Enter your choice: ");

        switch (choice) {
            case 1:
                depositMoney();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                transferMoney();
                break;
            case 4:
                applyInterest();
                break;
            case 5:
                applyMonthlyFee();
                break;
            case 6:
                applyTransactionFee();
                break;
            case 7:
                return;
            default:
                System.out.println("❌ Invalid choice!");
        }
    }

    private static void depositMoney() {
        System.out.println("\n--- Deposit Money ---");
        String accountNumber = getStringInput("Enter Account Number: ");
        Account account = bank.findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        double amount = getDoubleInput("Enter amount to deposit: ");
        account.deposit(amount);
    }

    private static void withdrawMoney() {
        System.out.println("\n--- Withdraw Money ---");
        String accountNumber = getStringInput("Enter Account Number: ");
        Account account = bank.findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        double amount = getDoubleInput("Enter amount to withdraw: ");
        account.withdraw(amount);
    }

    private static void transferMoney() {
        System.out.println("\n--- Transfer Money ---");
        String fromAccount = getStringInput("Enter FROM Account Number: ");
        String toAccount = getStringInput("Enter TO Account Number: ");
        double amount = getDoubleInput("Enter amount to transfer: ");

        bank.transferBetweenCustomers(fromAccount, toAccount, amount);
    }

    private static void applyInterest() {
        System.out.println("\n--- Apply Interest ---");
        String accountNumber = getStringInput("Enter Savings Account Number: ");
        Account account = bank.findAccountByNumber(accountNumber);

        if (account instanceof SavingsAccount) {
            ((SavingsAccount) account).applyInterest();
        } else {
            System.out.println("❌ This is not a Savings Account!");
        }
    }

    private static void applyMonthlyFee() {
        System.out.println("\n--- Apply Monthly Fee ---");
        String accountNumber = getStringInput("Enter Checking Account Number: ");
        Account account = bank.findAccountByNumber(accountNumber);

        if (account instanceof CheckingAccount) {
            ((CheckingAccount) account).applyMonthlyFee();
        } else {
            System.out.println("❌ This is not a Checking Account!");
        }
    }

    private static void applyTransactionFee() {
        System.out.println("\n--- Apply Transaction Fee ---");
        String accountNumber = getStringInput("Enter Business Account Number: ");
        Account account = bank.findAccountByNumber(accountNumber);

        if (account instanceof BusinessAccount) {
            double transactionAmount = getDoubleInput("Enter transaction amount: ");
            ((BusinessAccount) account).applyTransactionFee(transactionAmount);
        } else {
            System.out.println("❌ This is not a Business Account!");
        }
    }

    // ========== VIEW MENU ==========
    private static void viewMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       VIEW INFORMATION                 ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. View Customer Details              ║");
        System.out.println("║  2. View All Customer Accounts         ║");
        System.out.println("║  3. View Transaction History           ║");
        System.out.println("║  4. Back to Main Menu                  ║");
        System.out.println("╚════════════════════════════════════════╝");

        int choice = getIntInput("Enter your choice: ");

        switch (choice) {
            case 1:
                viewCustomerDetails();
                break;
            case 2:
                viewCustomerAccounts();
                break;
            case 3:
                viewTransactionHistory();
                break;
            case 4:
                return;
            default:
                System.out.println("❌ Invalid choice!");
        }
    }

    private static void viewCustomerDetails() {
        System.out.println("\n--- View Customer Details ---");
        String customerId = getStringInput("Enter Customer ID: ");
        Customer customer = bank.getCustomer(customerId);

        if (customer != null) {
            customer.displayCustomerInfo();
        }
    }

    private static void viewCustomerAccounts() {
        System.out.println("\n--- View Customer Accounts ---");
        String customerId = getStringInput("Enter Customer ID: ");
        Customer customer = bank.getCustomer(customerId);

        if (customer != null) {
            customer.displayAllAccounts();
        }
    }

    private static void viewTransactionHistory() {
        System.out.println("\n--- View Transaction History ---");
        String accountNumber = getStringInput("Enter Account Number: ");
        Account account = bank.findAccountByNumber(accountNumber);

        if (account != null) {
            account.viewTransactionHistory();
        }
    }

    // ========== INPUT HELPERS ==========
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
            }
        }
    }

}