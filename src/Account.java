import java.util.ArrayList; 
abstract public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList <Transaction> transactionsHistory;

    public Account(String accountNumber, String accountHolderName, double Balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = Balance;
        this.transactionsHistory = new ArrayList<>();
    }
    public void deposit (double amount){
        this.balance+= amount;
        System.out.println("Amount Deposited: "+ amount);
        System.out.println("New Balance: " + this.balance);
        addTransaction("DEPOSIT", amount, "Deposit to Account");
    }
    public boolean withdraw (double amount){
        if (amount > this.balance) {
            System.out.println("Insufficient Balance!");
            return false;
        } else {
            this.balance-=amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Balance: " + this.balance);
            addTransaction("WITHDRAW", amount, "Withdraw to Account");
            return true;
        }
    }
    protected void updateBalanceDeposit(double amount){
        this.balance += amount;
    }
    protected void updateBalanceWithdraw(double amount){
        this.balance -= amount;
    }
    public double getBalance (){
        return this.balance;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
    public String getAccountHolderName(){
        return this.accountHolderName;
    }
    public void displayAccountDetails(){
        System.out.println("===========================");
        System.out.println("Account Name: "+ this.accountHolderName);
        System.out.println("Account Number: "+ this.accountNumber);
        System.out.println("Account Balance: "+ this.balance);
        System.out.println("===========================");
    }
    private  void addTransaction (String transactionType, double amount, String description){
        Transaction t1 = new Transaction(transactionType, amount, description);
        this.transactionsHistory.add(t1);
    }
    public void viewTransactionHistory(){
        System.out.println("======== TRANSACTION HISTORY ========");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Name: " + this.accountHolderName);
        if(transactionsHistory.isEmpty()){
            System.out.println("No transactions have been added to this account");
        } else {
            for(Transaction t: transactionsHistory){
                t.displayTransaction();
            }
        }
        System.out.println("==========================");
    }
    public ArrayList <Transaction> getTransactionsHistory(){
        return this.transactionsHistory;
    }
    public boolean transfer (Account targetAccount, double amount){
        if(this.balance >= amount ){
            this.withdraw(amount);
            targetAccount.deposit(amount);
            addTransaction("TRANSFER", amount, "Transfer to "+ targetAccount.getAccountNumber());
            System.out.println("Successfully transferred $" + amount +" from " + this.accountNumber + " to " + targetAccount.getAccountNumber());
            return true;
        }  else {
            System.out.println("Insufficient Balance!");
            return false;
        }
    }
}

