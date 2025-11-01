abstract public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double Balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = Balance;
    }
    public void deposit (double amount){
        this.balance+= amount;
        System.out.println("Amount Deposited: "+ amount);
        System.out.println("New Balance: " + this.balance);
    }
    public boolean withdraw (double amount){
        if (amount > this.balance) {
            System.out.println("Insufficient Balance!");
            return false;
        } else {
            this.balance-=amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Balance: " + this.balance);
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
}

