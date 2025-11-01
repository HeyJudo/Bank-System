public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super (accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }
    public void applyInterest(){
        double interest = this.getBalance()*this.interestRate;
        System.out.printf("Interest Earned: %.2f", interest);
        this.deposit(interest);
        System.out.println("New Balance: "+ this.getBalance());
    }
    public double getInterestRate() {
        return this.interestRate;
    }
}
