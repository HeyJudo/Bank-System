public class BusinessAccount extends Account {
    private double transactionLimit;
    private double transactionFeePercentage;

    public BusinessAccount(String accountNumber, String accountHolderName, double Balance, double transactionLimit, double transactionFeePercentage) {
        super(accountNumber, accountHolderName, Balance);
        this.transactionLimit = transactionLimit;
        this.transactionFeePercentage = transactionFeePercentage;
    }
    public double getTransactionLimit() {
        return transactionLimit;
    }
    public double getTransactionFeePercentage() {
        return transactionFeePercentage;
    }

    public void  applyTransactionFee (double transactionAmount){
        double fee  = transactionAmount*this.transactionFeePercentage;
        super.updateBalanceWithdraw(fee);
        System.out.println("Transaction Fee is  $ " + fee);
        System.out.println("New Balance: " + this.getBalance());
    }

    @Override
    public boolean withdraw (double amount) {
        if(amount > this.transactionLimit){
            System.out.println("Amount Exceeded!");
            return false;
        } else {
            return super.withdraw(amount);
        }
    }


}
