import java.util.ArrayList;
public class Customer {
    private String customerId;
    private String customerName;
    private ArrayList<Account> accounts;

    public Customer (String  customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.accounts = new ArrayList<>();
    }

    public void addAccount (Account account){
        accounts.add(account);
        System.out.println("Successfully Addded an Account");
    }
    public void removeAccount(String accountNumber){
        if(accounts.isEmpty()){
            System.out.println("There is no account registered");
            return;
        } else {
            for(Account a1: accounts){
                if(a1.getAccountNumber().equals(accountNumber)){
                    accounts.remove(a1);
                    System.out.println("Successfully Removed an Account " +  accountNumber);
                    return;
                }
            }
                System.out.println("There is no account with a number " + accountNumber);
        }
    }
    public Account getAccount (String accountNumber){
        if(accounts.isEmpty()){
            System.out.println("There is no account registered");
            return null;
        }
            for(Account a1: accounts){
                if(a1.getAccountNumber().equals(accountNumber)){
                    return a1;
                }
            }
            System.out.println("There is no account with a number " + accountNumber);
            return null;
    }
    public void displayAllAccounts(){
        System.out.println("LIST OF ALL OF YOUR ACCOUNTS");
        for(Account a1: accounts){
            a1.displayAccountDetails();
        }
    }
    public String getCustomerId(){
        return this.customerId;
    }
    public String getCustomerName(){
        return this.customerName;
    }
    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }
    public void displayCustomerInfo(){
        System.out.println("======= CUSTOMER INFO =======");
        System.out.println("Customer ID: "+ this.customerId);
        System.out.println("Customer Name: "+ this.customerName);
        System.out.println("Number of Accounts: "+ accounts.size());
        System.out.println("Accounts Owned: ");
        int count = 0;
        if(accounts.isEmpty()){
            System.out.println("There is no account registered");
        } else {
            for(Account a: accounts) {
                count++;
                System.out.printf("%d. Account Number: %s - Type: %s\n", count, a.getAccountNumber(), a.getClass().getSimpleName());
            }
        }


    }
}
