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

    public void addAccount (){

    }
}
