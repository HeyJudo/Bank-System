public class CheckingAccount extends Account {
    private double overdraftLimit;
    private double monthlyFee;

    public CheckingAccount(String accountNumber, String accountHolderName, double Balance, double overdraftLimit, double monthlyFee) {
        super(accountNumber, accountHolderName, Balance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void applyMonthlyFee(){
        super.updateBalanceWithdraw(this.monthlyFee);
        System.out.println("Monthly Fee is now $" + this.monthlyFee);
        System.out.println("New Balance: "+ this.getBalance());
    }

    @Override
    public boolean withdraw(double amount) {
        double newBalance = this.getBalance() - amount;
        if (newBalance >= -this.getOverdraftLimit()) {
            System.out.println("Withdrawn: " + amount);
            System.out.println("Overdraft Limit: " + this.getOverdraftLimit());
            super.updateBalanceDeposit(-amount);
            System.out.println("Balance: " + this.getBalance());
            return true;
        } else return false;


    }

}
